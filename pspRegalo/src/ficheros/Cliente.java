/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "localhost";
        int puerto = 4444;
        
        try (Socket cliente = new Socket(host, puerto);
            ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream inObjecto = new ObjectInputStream(cliente.getInputStream())) {
            
            HashMD5 MD5 = new HashMD5("HastaElFinalVamosReal");
            outObjeto.writeObject(MD5);
            System.out.println("Objeto enviado al servidor: " + MD5.getClass().getSimpleName());
            
            Object objetoRecibido = inObjecto.readObject();
            System.out.println(objetoRecibido);
        }
    }
}
