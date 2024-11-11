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
import java.net.Socket;

/**
 *
 * @author FP
 */
public class Cliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;
        Socket cliente = new Socket(host, puerto);
        
        //CREO FLUJO DE SALIDA Y ENTRADA AL SERVIDOR
        //DataOutputStream fsalida = new DataOutputStream (cliente.getOutputStream());
        //DataInputStream fentrada = new DataInputStream(cliente.getInputStream());
        //ENVIO UN SALUDO AL SERVIDOR
        
        //FLUJO PARA ENTRADA ESTANDAR
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cadena, eco = "";
        
        DataOutputStream fsalida = null;
        DataInputStream fentrada = null;
        
        do {
            fsalida = new DataOutputStream (cliente.getOutputStream());
            fentrada = new DataInputStream(cliente.getInputStream());
            System.out.println("Introduce cadena: ");
            cadena = in.readLine();
            fsalida.writeUTF(cadena); //ENVIO CADENA AL SERVIDOR
            eco = fentrada.readUTF(); //RECIBO CADENA DEL SERVIDOR
            System.out.println("--> ECO: " + eco);
        } while (!cadena.trim().equals("*"));
        
        fsalida.close();
        fentrada.close();
        in.close();
        System.out.println("Fin del envio...");
    }
}
