/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class ServidorLocal {
    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando en el puerto: " + servidor.getLocalPort());
        
        Socket cliente1 = servidor.accept();//Esperando a un cliente
        //Se realizan las acciones con el cliente
        
        System.out.println("Cliente 1 conectado y terminado");
        
        Socket cliente2 = servidor.accept();//Esperando a otro cliente
        //Se realizan las acciones con otro cliente
        
        System.out.println("Cliente 2 conectado y terminado");
        
        servidor.close();
        System.out.println("Servidor terminado");
    }
}
