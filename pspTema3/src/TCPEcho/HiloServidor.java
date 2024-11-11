/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCPEcho;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FP
 */
public class HiloServidor extends Thread{
    DataInputStream fentrada;
    DataOutputStream fsalida;
    Socket socket = null;
    
    public HiloServidor(Socket s) throws IOException {
        this.socket = s;
        //Se crean los FLUJOS DE ENTRADA Y DE SALIDA DEL CLIENTE
        fsalida = new DataOutputStream(socket.getOutputStream());
        fentrada = new DataInputStream(socket.getInputStream());
    }
    
    @Override
    public void run() {
        String cadena = "";
        System.out.println("COMUNICO CON: " + socket.toString());
        while (!cadena.trim().equals("*")) {
            try {
                cadena = fentrada.readUTF();
                System.out.println(socket.toString() + ": \t" + cadena.trim());
                fsalida.writeUTF(cadena.trim().toUpperCase());
            } catch (IOException ex) {
                //System.out.println(ex.getMessage());
            }
        }
        System.out.println("FIN CON: " + socket.toString());
        
        try {
            fsalida.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fentrada.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
