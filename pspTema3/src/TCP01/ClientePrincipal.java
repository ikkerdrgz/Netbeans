/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP01;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class ClientePrincipal {
    public static void main(String[] args) throws IOException {
        while(true) {
            String host = "10.1.9.112";
            int puerto = 6000; //Puerto remoto

            //Abrir socket
            Socket cliente = new Socket(host, puerto);

            InetAddress i = cliente.getInetAddress();
            System.out.println("Puerto local (Cliente): " + cliente.getLocalPort());
            System.out.println("Puerto remoto (Servidor): " + cliente.getPort());
            System.out.println("Puerto Host/ip (Cliente): " + cliente.getInetAddress());
            System.out.println("Host remoto (Servidor): " + i.getHostName().toString());
            System.out.println("IP Host Remoto (Servidor): " + i.getHostAddress().toString());
        }
    }
}
