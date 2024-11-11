/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCPFormas;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class TCPObjetosServidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int numeroPuerto = 6000;
        
        try (ServerSocket servidor = new ServerSocket(numeroPuerto)) {
            System.out.println("SOY EL SERVIDOR");
            System.out.println("Esperando al cliente...");
            
            try (Socket cliente = servidor.accept();
                ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
                ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream())) {
                
                Object objetoRecibido = inObjeto.readObject();
                
                double area = 0;
                double perimetro = 0;
                
                if (objetoRecibido instanceof Circulo circulo) {
                    area = circulo.calcularArea();
                    perimetro = circulo.calcularPerimetro();
                    System.out.println("Recibido un Circulo con radio: " + circulo.getRadio());
                } else if (objetoRecibido instanceof Cuadrado cuadrado) {
                    area = cuadrado.calcularArea();
                    perimetro = cuadrado.calcularPerimetro();
                    System.out.println("Recibido un Cuadrado con lado: " + cuadrado.getLado());
                } else if (objetoRecibido instanceof Rectangulo rectangulo) {
                    area = rectangulo.calcularArea();
                    perimetro = rectangulo.calcularPerimetro();
                    System.out.println("Recibido un Rectangulo con lado: " + rectangulo.getLado() + " y alto: " + rectangulo.getAltura());
                }
                outObjeto.writeDouble(area);
                outObjeto.writeDouble(perimetro);
                
                outObjeto.close();
                inObjeto.close();
                cliente.close();
                servidor.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            
        }
    }
}
