/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author FP
 */
public class ReciboUDP {
    public static void main(String[] args) throws SocketException, IOException {
        //asocio el socket al puerto 12345
        DatagramSocket socket = new DatagramSocket(12345);
        
        //esperando datagrama
        System.out.println("Servidor esperando datagrama...");
        DatagramPacket recibo;
        
        byte[] buffer = new byte[1024];
        recibo = new DatagramPacket(buffer, buffer.length);
        socket.receive(recibo);
        
        String mensaje = new String(recibo.getData()).trim();
        System.out.println("Servudor recibe: " + mensaje);
        
        //contar el mumero de letras a
        int contador = 0;
        for (int i = 0; i < mensaje.length(); i++) {
            if (mensaje.charAt(i) == 'a') {
                contador++;
            }
        }
        
        InetAddress IPOrigen = recibo.getAddress();
        int puerto = recibo.getPort();
        
        //enviando datagrama al cliente
        System.out.println("Enviando numero de apariciones de la letra a -> " + contador);
        byte b = (byte) contador; //paso entero a byte
        byte[] enviados = new byte [1024];
        enviados[0] = b;
        
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
        socket.send(envio);
        
        System.out.println("Cerrando conexion...");
        socket.close();
    }
}
