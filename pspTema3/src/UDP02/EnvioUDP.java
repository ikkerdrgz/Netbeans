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
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author FP
 */
public class EnvioUDP {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket clienteSocket = new DatagramSocket();
        
        //datos del servidor al que enviar el mensaje
        InetAddress IPServidor = InetAddress.getLocalHost();
        int puerto = 12345; //puerto por el que escucha
        
        //introducir datos por teclado
        System.out.println("Introduce el mensaje: ");
        String cadena = sc.nextLine();
        
        byte[] enviados = new byte[1024];
        enviados = cadena.getBytes();
        
        //enviando datagrama al servidor
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
        clienteSocket.send(envio);
        
        //recibiendo datagrama del servidor
        byte[] recibidos = new byte[2];
        DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length, IPServidor, puerto);
        System.out.println("Esperando datagrama...");
        
        //obtener el numero de caracteres
        byte[] hh = recibo.getData();
        int numero = hh[0];
        System.out.println("Recibo N de caracteres que son a --> " + numero);
        
        clienteSocket.close(); //cerrar el socket
    }
}
