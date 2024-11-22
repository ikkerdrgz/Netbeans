/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class ServidorChat {
    static final int MAXIMO = 10; //MAXIMO DE CONEXIONES PERMITIDAS
    public static void main(String[] args) throws IOException {
        int puerto = 44444;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor iniciado...");
        
        Socket tabla[] = new Socket[MAXIMO]; //control de clientes
        ComunHilos comun = new ComunHilos(0, 0, MAXIMO,tabla);
        
        while(comun.getCONEXIONES() < MAXIMO) {
            Socket socket = new Socket();
            socket = servidor.accept();
            
            //OBJETO COMPARTIDO POR LOS HILOS
            comun.addTabla(socket, comun.getCONEXIONES());
            comun.setACTUALES(comun.getACTUALES());
            comun.setCONEXIONES(comun.getCONEXIONES());
            
            HiloServidorChat hilo = new HiloServidorChat(socket, comun);
            hilo.start();
        }
        servidor.close();
    }
}
