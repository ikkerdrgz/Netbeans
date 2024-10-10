/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escribir2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author FP
 */
public class Principal2 {
    public static void main(String[] args) {
        String miUsuario, miContrase�a, elServidor;
        Integer elPuerto;
        Properties configuracion = new Properties();
        try {
            configuracion.load(new FileInputStream("config.pass"));
            miUsuario = configuracion.getProperty("user");
            miContrase�a = configuracion.getProperty("password");
            elServidor = configuracion.getProperty("server");
            elPuerto = Integer.valueOf(configuracion.getProperty("port"));
            System.out.println(miUsuario);
            System.out.println(miContrase�a);
            System.out.println(elServidor);
            System.out.println(elPuerto);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
