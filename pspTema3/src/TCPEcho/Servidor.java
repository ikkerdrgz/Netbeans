/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCPEcho;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciando...");
        
        while (true){
            Socket cliente = new Socket();
            cliente = servidor.accept();
            HiloServidor hilo = new HiloServidor(cliente);
            hilo.start();
        }
    }
}
