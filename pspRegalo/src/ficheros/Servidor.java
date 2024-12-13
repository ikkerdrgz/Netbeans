/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class Servidor {
    public static void main(String[] args) {
        int puerto = 4444;
        
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("SOY EL SERVIDOR");
            System.out.println("Esperando al cliente...");
            
            try (Socket cliente = servidor.accept();
                ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
                ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream())) {
                
                Object objetoRecibido = inObjeto.readObject();
                
                
                if (objetoRecibido instanceof HashMD5 MD5) {
                    outObjeto.writeObject("MD5: " + MD5.calculaHashMD5("MD5"));
                } else if (objetoRecibido instanceof HashSHA1 SHA1) {
                    outObjeto.writeObject("SHA-512: " + SHA1.calculaHashSAH1("SHA-512"));
                } else if (objetoRecibido instanceof HashSHA512 SHA512) {
                    outObjeto.writeObject("SHA-1: " + SHA512.calculaHashSHA512("SHA-1"));
                }
                
                outObjeto.close();
                inObjeto.close();
                cliente.close();
                servidor.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            
        }
    }
}
