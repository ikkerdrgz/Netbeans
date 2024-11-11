/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ruleta;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author FP
 */
public class Ventana2 {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    
    JLabel usuarios = new JLabel();
    JTextField usuario = new JTextField();
    JLabel contraseñas = new JLabel();
    JPasswordField contraseña = new JPasswordField();
    JLabel edades = new JLabel();
    JTextField edad = new JTextField();
    JLabel dineros = new JLabel();
    JTextField dinero = new JTextField();
    
    JButton validar = new JButton();
    
    public Ventana2() {
        frame.setVisible(true);
        frame.setTitle("Ruleta");
        frame.setBounds(600, 200, 400, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        frame.add(panel);
        
        Label();
        Botones();
        fondoPantalla();
        panel.updateUI();
    }
    
    public void Label() {
        usuarios.setText("Usuario");
        usuarios.setBounds(20, 50, 150, 25);
        usuarios.setOpaque(true);
        usuarios.setHorizontalAlignment(SwingConstants.CENTER);
        usuario.setBounds(190, 50, 150, 25);
        
        contraseñas.setText("Contraseña");
        contraseñas.setBounds(20, 100, 150, 20);
        contraseñas.setOpaque(true);
        contraseñas.setHorizontalAlignment(SwingConstants.CENTER);
        contraseña.setBounds(190, 100, 150, 25);
        
        edades.setText("Edad");
        edades.setBounds(20, 150, 150, 25);
        edades.setOpaque(true);
        edades.setHorizontalAlignment(SwingConstants.CENTER);
        edad.setBounds(190, 150, 150, 25);
        
        dineros.setText("Dinero");
        dineros.setBounds(20, 200, 150, 25);
        dineros.setOpaque(true);
        dineros.setHorizontalAlignment(SwingConstants.CENTER);
        dinero.setBounds(190, 200, 150, 25);
        
        
        panel.add(usuarios);
        panel.add(usuario);
        panel.add(contraseñas);
        panel.add(contraseña);
        panel.add(edades);
        panel.add(edad);
        panel.add(dineros);
        panel.add(dinero);
    }
    
    public void Botones() {
        validar.setText("Nuevo Usuario");
        validar.setBounds(120, 280, 150, 25);
        validar.setHorizontalAlignment(SwingConstants.CENTER);
        
        ActionListener elegir1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(edad.getText()) < 18) {
                    JOptionPane.showMessageDialog(frame, "No puedes ser menor de edad");
                } else {
                    Ventana ventana = new Ventana();
                    ventana.Botones(usuario, contraseña);
                }
            }
        };
        validar.addActionListener(elegir1);
        
        panel.add(validar);
    }
    
    public void fondoPantalla(){
        JLabel fondo = new JLabel();
        
        fondo.setBounds(0, 0, 500, 500);
        ImageIcon imagen = new ImageIcon("Imagenes/casino7.jpg");
        fondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT)));
        
        panel.add(fondo);
    }
}
