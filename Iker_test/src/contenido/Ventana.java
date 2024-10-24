/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author FP
 */
public class Ventana {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    
    JButton empezar = new JButton();
    JButton verNota = new JButton();
    
    
    
    public Ventana() {
        frame.setVisible(true);
        frame.setTitle("Test Hollow Knight");
        frame.setBounds(550, 200, 500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        frame.add(panel);
        
        Boton();
        FondoPantalla();
        panel.updateUI();
    }
    
    public void Boton() {
        empezar.setText("EMPEZAR");
        empezar.setBounds(175, 230, 150, 50);
        empezar.setBackground(Color.BLACK);
        empezar.setForeground(Color.WHITE);
        
        ActionListener seleccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana2 ventana2 = new Ventana2();
            }
        };
        
        empezar.addActionListener(seleccion);
        panel.add(empezar);
    }
    
    public void FondoPantalla(){
        JLabel fondo = new JLabel();
        
        fondo.setBounds(0, 0, 500, 500);
        ImageIcon imagen = new ImageIcon("fondo.png");
        fondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT)));
        
        panel.add(fondo);
    }
}
