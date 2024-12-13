/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author FP
 */
public class HashMD5 implements Serializable{
    String cadena;
    
    public HashMD5(String cadena) {
        this.cadena = cadena;
    }
    
    public String getCadena() {
        return cadena;
    }
    
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    String calculaHashMD5(String algorithm) {
        try {
            // Crear una instancia de MessageDigest con el algoritmo especificado
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            // Calcular el hash (se obtiene en forma de bytes)
            byte[] hashBytes = messageDigest.digest(cadena.getBytes());

            // Convertir los bytes del hash a formato hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                // Formatear cada byte como un valor hexadecimal de dos dí­gitos
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // Retornar el hash en formato hexadecimal
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Manejo de excepción en caso de algoritmo inválido
            System.err.println("Error: Algoritmo no válido - " + algorithm);
            return null;
        }
    }
}
