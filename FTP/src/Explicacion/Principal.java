/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Explicacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 *
 * @author FP
 */
public class Principal {
    public static void main(String[] args) throws IOException {
        FTPClient ftp = new FTPClient();
        ftp.connect("vbo.damiansu.com", 21);
        boolean login = ftp.login("alumno", "fp.2023");
        if (!login) {
            System.out.println("Conexion incorrecta");
            System.out.println(ftp.getReplyString());
        } else {
            ftp.setFileType(ftp.BINARY_FILE_TYPE);
            System.out.println("Estamos dentro");
            FTPFile[] ficheros = ftp.listFiles();
            System.out.println("Nº de ficheros " + ficheros.length);
            File f = new File("C:\\Users\\FP\\Desktop\\IMG_1459.png");
            if (f.exists()) {
                System.out.println("Vamos a subir el fichero");
                FileInputStream fsubida = new FileInputStream(f);
                ftp.storeFile("gato culiao.png", fsubida);
            }
            System.out.println("--------Como ha quedado--------");
            infoCarpeta(ficheros);
            
            FileOutputStream fbajada = new FileOutputStream("IMG_1459.png");
            ftp.retrieveFile("gato culiao.png", fbajada);
        }
        ftp.logout();
    }

    private static void infoCarpeta(FTPFile[] ficheros) {
        for (int i = 0; i < ficheros.length; i++) {
            if (ficheros[i].isFile()) {
                System.out.println("Fichero: " + ficheros[i].getName());
            } else if (ficheros[i].isDirectory()) {
                System.out.println("Directorio: " + ficheros[i].getName());
            } else {
                System.out.println("Otra cosa: " + ficheros[i].getName());
            }
        }
    }
}
