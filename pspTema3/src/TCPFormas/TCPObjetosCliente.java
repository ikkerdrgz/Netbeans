/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCPFormas;

import TCPObjetos.Persona;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class TCPObjetosCliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "localhost";
        int puerto = 6000;
        
        System.out.println("PROGRAMA CLIENTE INICIADO...");
        
        try (Socket cliente = new Socket(host, puerto);
            ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream inObjecto = new ObjectInputStream(cliente.getInputStream())) {
            
            Circulo cir = new Circulo (10);
            outObjeto.writeObject(cir);
            System.out.println("Objeto enviado al servidor: " + cir.getClass().getSimpleName());
        }
    }
}
