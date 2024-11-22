/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class HiloServidorChat extends Thread{
    DataInputStream fentrada;
    Socket socket = null;
    ComunHilos comun;
    
    public HiloServidorChat(Socket s, ComunHilos comun) {
        this.socket = s;
        this.comun = comun;
        try {
            //CREO EL FLUJO DE ENTRADA PARA LEER LOS MENSAJES
            fentrada = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("ERROR DE E/S");
            e.printStackTrace();
        }
    }
    
    //ENVIA LOS MENSAJES DEL CHAT A LOS CLIENTES
    private void enviarMensajesATodos (String texto) {
        int i;
        //recorremos tabla de sockets para enviarles los mensajes
        for (i = 0; i < comun.getCONEXIONES(); i++) {
            Socket s1 = comun.getElementoTabla(i);
            if (!s1.isClosed()) {
                try{
                    DataOutputStream fsalida2 = new DataOutputStream(s1.getOutputStream());
                    fsalida2.writeUTF(texto);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void run() {
        System.out.println("Numero de conexiones actuales: " + comun.getACTUALES());
        
        //NADA MAS CONECTARSE LE ENVIO TODOS LOS MENSAJES
        String texto = comun.getMensajes();
        enviarMensajesATodos(texto);
        
        while (true) {
            String cadena = " ";
            try {
                cadena = fentrada.readUTF();
                if (cadena.trim().equals("*")){//CLIENTE DESCONECTA
                    comun.setACTUALES(comun.getACTUALES()-1);
                    System.out.println("Numero maximo de conexiones actuales" + comun.getACTUALES());
                    break;
                }
                comun.setMensajes(comun.getMensajes() + cadena + "\n");
                enviarMensajesATodos(comun.getMensajes());
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
