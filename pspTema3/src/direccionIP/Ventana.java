/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package direccionIP;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author FP
 */
public class Ventana {
    
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    
    JLabel texto = new JLabel("Escriba su direccion ip");
    JTextField direccion = new JTextField();
    JButton empezar = new JButton();
    JTextArea area = new JTextArea();
    
    
    public Ventana() {
        frame.setVisible(true);
        frame.setBounds(550, 200, 500, 700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        frame.add(panel);
        
        Boton();
        Escribir();
        Salida();
        panel.updateUI();
    }
    
    public void Boton() {
        empezar.setText("ENVIAR");
        empezar.setBounds(175, 230, 150, 50);
        empezar.setBackground(Color.BLACK);
        empezar.setForeground(Color.WHITE);
        
        ActionListener seleccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InetAddress dir = null;

                try {
                    area.append("===========================\n");
                    area.append("SALIDA PARA LOCALHOST\n");
                    dir = InetAddress.getByName("localhost");
                    pruebaMetodos(dir);

                    area.append("===========================\n");
                    area.append("SALIDA PARA LOCALHOST\n");
                    dir = InetAddress.getByName("google.es");
                    pruebaMetodos(dir);
                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }
            }
        };
        
        empezar.addActionListener(seleccion);
        panel.add(empezar);
    }
    
    public void Texto() {
        texto.setBounds(175, 50, 150, 50);
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel.add(texto);
    }
    
    public void Escribir() {
        direccion.setBounds(175, 120, 150, 50);
        
        panel.add(direccion);
    }
    
    public void pruebaMetodos(InetAddress dir) {
        area.append("Metodo getLocalHost(): " + dir + "\n");
        InetAddress dir2;
        try {
            dir2 = InetAddress.getLocalHost();
            area.append("Metodo getLocalHost(): " + dir2 + "\n");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        area.append("Metodo getHostName(): " + dir.getHostName() + "\n");
        area.append("Metodo getHostAddress(): " + dir.getHostAddress() + "\n");
        area.append("Metodo toString(): " + dir.toString() + "\n");
        area.append("Metodo getCannonicalHostName(): " + dir.getCanonicalHostName() + "\n");
    }
    public void Salida() {
        area.setBounds(50, 330, 400, 300);
        area.setEditable(false);
        
        panel.add(area);
    }
}
