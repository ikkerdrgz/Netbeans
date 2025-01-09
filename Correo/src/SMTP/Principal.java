/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SMTP;

import java.io.IOException;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;

/**
 *
 * @author FP
 */
public class Principal {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        //Datos del servidor + correo
        String server = "mail.damiansu.com";
        int port = 25;
        String user = "hola@mariobros.damiansu.com";
        String pass = "1234";
        
        //Configuracion del mensaje de correo
        String from = "hola@mariobros.damiansu.com";
        String to = "alumno@mariobros.damiansu.com";
        String subject = "Iker";
        String message = "impepinable";
        
        //Preguntar si hay server SMTP
        AuthenticatingSMTPClient cliente = new AuthenticatingSMTPClient();
        cliente.connect(server, port);
        System.out.println(cliente.getReplyCode() + " " + cliente.getReplyString());
        
        //Nos conectamos con usuario y contraseña
        if (cliente.auth(AuthenticatingSMTPClient.AUTH_METHOD.CRAM_MD5, user, pass)) {
            System.out.println("Login correcto");
            
            //preparamos el correo
            cliente.setSender(from);
            cliente.addRecipient(to);
            
            //contenido del correo Writer
            Writer contenido = cliente.sendMessageData();
            contenido.write("Subject: " + subject);
            contenido.write("From: " + from);
            contenido.write("To: " + to);
            contenido.write("\n");
            contenido.write(message);
            contenido.write("\n");
            contenido.close();
            cliente.completePendingCommand();
            System.out.println("");
        } else {
            System.out.println("Login incorrecto");
        }
        
        //Cerrar server
        cliente.logout();
        cliente.disconnect();
    }
}
