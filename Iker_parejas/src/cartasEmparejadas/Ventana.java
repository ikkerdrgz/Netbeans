/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartasEmparejadas;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
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
    
    JTextArea area = new JTextArea();
    
    ArrayList<Cartas> baraja = new ArrayList<>();
    
    public Ventana() {
        frame.setVisible(true);
        frame.setTitle("Test Hollow Knight");
        frame.setBounds(500, 200, 900, 700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        frame.add(panel);
        
        FondoPantalla();
        panel.updateUI();
    }
    
    public void FondoPantalla(){
        JLabel fondo = new JLabel();
        
        fondo.setBounds(0, 0, 500, 500);
        ImageIcon imagen = new ImageIcon("");
        fondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT)));
        
        panel.add(fondo);
    }
    
    public void CrearBaraja() {
        for (int i = 0; i < 6; i++) {
            if (i < 2) {
                baraja.add(new Cartas(i,"/Imagenes/reverso.jpg", "/Imagenes/bart.png"));
            }
            if (i > 1 && i < 4) {
                baraja.add(new Cartas(i,"/Imagenes/reverso.jpg", "/Imagenes/homer.png"));
            }
            if (i > 3) {
                baraja.add(new Cartas(i,"/Imagenes/reverso.jpg", "/Imagenes/marge.png"));
            }
        }
        
        JLabel carta1 = new JLabel();
        
        ImageIcon imagen = new ImageIcon(baraja.get(0).cara);
        
        carta1.setBounds(50, 50, 100, 150);
        carta1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta1.getWidth(), carta1.getHeight(), Image.SCALE_DEFAULT)));
        carta1.setOpaque(true);
        panel.add(carta1);
    }
}
