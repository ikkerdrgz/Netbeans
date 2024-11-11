/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author FP
 */
public class EnvioUDP {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        int port = 12345; //puerto por el que escucha
        InetAddress destino = InetAddress.getLocalHost(); //IP host local
        //un host concreto
        //InetAddress destino = InetAddress.getByName("15.52.24.63");
        
        byte [] mensaje = new byte[1024];
        String saludo = "Enviando saludos!!!";
        mensaje = saludo.getBytes(); //codificarlo a bytes para enviarlo
        
        //construyo el datagrama a enviar
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
        DatagramSocket socket = new DatagramSocket(34567);
        System.out.println("Enviando datagrama de longitud: " + mensaje.length);
        System.out.println("Host destino: " + destino.getCanonicalHostName());
        System.out.println("IP destino: " + destino.getHostAddress());
        System.out.println("Puerto local del socket: " + socket.getLocalPort());
        System.out.println("Puerto al que envio: " + envio.getPort());
        
        //envia datagrama
        socket.send(envio);
    }
}
