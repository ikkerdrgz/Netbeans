/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ruleta;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
    
    JLabel usuarios = new JLabel();
    JTextField usuario = new JTextField();
    JLabel contraseñas = new JLabel();
    JPasswordField contraseña = new JPasswordField();
    
    JButton darAlta = new JButton();
    JButton entrar = new JButton();
    
    public Ventana() {
        frame.setVisible(true);
        frame.setTitle("Ruleta");
        frame.setBounds(550, 200, 500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        frame.add(panel);
        
        Label();
        Botones(usuario, contraseña);
        fondoPantalla();
        panel.updateUI();
    }
    
    public void Label() {
        usuarios.setText("Usuario");
        usuarios.setBounds(165, 70, 150, 25);
        usuarios.setOpaque(true);
        usuarios.setHorizontalAlignment(SwingConstants.CENTER);
        usuario.setBounds(165, 100, 150, 25);
        
        contraseñas.setText("Contraseña");
        contraseñas.setBounds(165, 220, 150, 25);
        contraseñas.setOpaque(true);
        contraseñas.setHorizontalAlignment(SwingConstants.CENTER);
        contraseña.setBounds(165, 250, 150, 25);
        
        
        panel.add(usuarios);
        panel.add(usuario);
        panel.add(contraseñas);
        panel.add(contraseña);
    }
    
    public void Botones(JTextField usuario2, JPasswordField contraseña2) {
        darAlta.setText("Nuevo Usuario");
        darAlta.setBounds(90, 350, 150, 25);
        darAlta.setHorizontalAlignment(SwingConstants.CENTER);
        
        entrar.setText("Entrar Al Juego");
        entrar.setBounds(250, 350, 150, 25);
        entrar.setHorizontalAlignment(SwingConstants.CENTER);
        
        ActionListener elegir1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana2 ventana2 = new Ventana2();
            }
        };
        darAlta.addActionListener(elegir1);
        
        ActionListener elegir2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana3 ventana3 = new Ventana3();
            }
        };
        entrar.addActionListener(elegir2);
        
        panel.add(darAlta);
        panel.add(entrar);
    }
    
    public void fondoPantalla(){
        JLabel fondo = new JLabel();
        
        fondo.setBounds(0, 0, 500, 500);
        ImageIcon imagen = new ImageIcon("Imagenes/casino6.jpg");
        fondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT)));
        
        panel.add(fondo);
    }
}