/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author FP
 */
public class Main {
    private static void procesarLineaConfiguracion(String linea) {
        String[] partes = linea.split("=");
        if (partes.length == 2) {
            String parte1 = partes[0].trim();
            String parte2 = partes[1].trim();
            if(!parte1.contains("#")){
                System.out.println(parte1 + " es igual a "+ parte2);
            }
        } 
    }

    public static void main(String[] args) {
        String archivoConfiguracion = "paths-debian.conf";
        try ( BufferedReader lector
                = new BufferedReader(
                        new FileReader(archivoConfiguracion))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                procesarLineaConfiguracion(linea);
            }
        } catch (IOException e) {
            System.err.println("Error..." + e.getMessage());
        }
    }
}
