/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatTCP;

import java.net.Socket;

/**
 *
 * @author FP
 */
public class ComunHilos {
    int CONEXIONES; //Nº de conexiones totales, ocupadas en el array
    int ACTUALES; //Nº maximo de conexiones actuales
    int MAXIMO; //Maximo de conexiones permitidas
    Socket tabla[] = new Socket[MAXIMO]; //Sockets conectados
    String mensajes; //MENSAJES DEL CHAT
    
    public ComunHilos(int CONEXIONES, int ACTUALES, int MAXIMO, Socket[] tabla) {
        this.CONEXIONES = CONEXIONES;
        this.ACTUALES = ACTUALES;
        this.MAXIMO = MAXIMO;
        this.tabla = tabla;
        mensajes = "";
    }
    
    public int getMAXIMO() {
        return MAXIMO;
    }
    
    public void setMAXIMO(int MAXIMO) {
        this.MAXIMO = MAXIMO;
    }
    
    public int getCONEXIONES() {
        return CONEXIONES;
    }
    
    public synchronized void setCONEXIONES(int CONEXIONES) {
        this.CONEXIONES = CONEXIONES;
    }
    
    public int getACTUALES() {
        return ACTUALES;
    }
    
    public synchronized void setACTUALES(int ACTUALES) {
        this.ACTUALES = ACTUALES;
    }
    
    public String getMensajes() {
        return mensajes;
    }
    
    public synchronized void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }
    
    public synchronized void addTabla(Socket s, int i) {
        tabla[i] = s;
    }
    
    public Socket getElementoTabla(int i) {
        return tabla[i];
    }
}
