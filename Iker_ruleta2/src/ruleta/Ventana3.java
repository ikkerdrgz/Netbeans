/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ruleta;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author FP
 */
public class Ventana3 {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    
    JLabel dineros = new JLabel();
    JTextField dinero = new JTextField();
    JLabel apostarLabel = new JLabel();
    JTextField apostar = new JTextField();
    
    ButtonGroup modoJuego = new ButtonGroup();
    JRadioButton verde = new JRadioButton();
    JRadioButton rojo = new JRadioButton();
    JRadioButton negro = new JRadioButton();
    JRadioButton primeraDoc = new JRadioButton();
    JRadioButton segundaDoc = new JRadioButton();
    JRadioButton terceraDoc = new JRadioButton();
    JRadioButton exacto = new JRadioButton();
    
    JLabel ingresar = new JLabel();
    JTextField numeroMio = new JTextField();
    JTextField numero = new JTextField();
    JButton inicio = new JButton();
    JCheckBox check1 = new JCheckBox();
    JButton salir = new JButton();
    
    public Ventana3() {
        frame.setVisible(true);
        frame.setTitle("Ruleta");
        frame.setBounds(500, 200, 500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        frame.add(panel);
        
        Botones();
        fondoPantalla();
        panel.updateUI();
    }
    
    public void Botones() {
        dineros.setText("Dinero");
        dineros.setBounds(300, 20, 150, 25);
        dineros.setOpaque(true);
        dineros.setHorizontalAlignment(SwingConstants.CENTER);
        dinero.setBounds(300, 50, 150, 25);
        dinero.setHorizontalAlignment(SwingConstants.CENTER);
        
        apostarLabel.setText("Apuesta");
        apostarLabel.setBounds(300, 100, 150, 25);
        apostarLabel.setOpaque(true);
        apostarLabel.setHorizontalAlignment(SwingConstants.CENTER);
        apostar.setBounds(300, 130, 150, 25);
        apostar.setHorizontalAlignment(SwingConstants.CENTER);
        
        inicio.setText("Inicio juego");
        inicio.setBounds(300, 400, 150, 25);
        inicio.setOpaque(true);
        inicio.setHorizontalAlignment(SwingConstants.CENTER);
        
        verde.setText("Verde");
        verde.setBounds(30,30,150,30);
        rojo.setText("Rojo");
        rojo.setBounds(30,60,150,30);
        negro.setText("Rojo");
        negro.setBounds(30,90,150,30);
        primeraDoc.setText("Primera docena");
        primeraDoc.setBounds(30,120,150,30);
        segundaDoc.setText("Segunda docena");
        segundaDoc.setBounds(30,150,150,30);
        terceraDoc.setText("Tercera docena");
        terceraDoc.setBounds(30,180,150,30);
        exacto.setText("Por numero exacto");
        exacto.setBounds(30,210,150,30);
        
        ingresar.setText("Ingrese su numero");
        ingresar.setBounds(30, 370, 50, 25);
        ingresar.setBackground(Color.white);
        ingresar.setOpaque(true);
        numeroMio.setBounds(30, 300, 50, 25);
        numero.setBounds(30, 350, 50, 25);
        
        check1.setText("Confirmar la apuesta");
        check1.setBackground(Color.white);
        check1.setBounds(30, 400, 150, 30);
        
        modoJuego.add(verde);
        modoJuego.add(rojo);
        modoJuego.add(negro);
        modoJuego.add(primeraDoc);
        modoJuego.add(segundaDoc);
        modoJuego.add(terceraDoc);
        modoJuego.add(exacto);
        
        ActionListener elegir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!check1.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "No has seleccionado la casilla de terminar el examen");
                } else {
                    if (modoJuego.getSelection() == null) {
                        JOptionPane.showMessageDialog(frame, "Elige un modo de juego");
                    } else {
                        if (verde.isSelected() || rojo.isSelected() || negro.isSelected()) {
                            int num = (int) (Math.random()*37);
                            numero.setText(Integer.toString(num));
                            if (num == 0) {
                                numero.setBackground(Color.green);
                                numero.setOpaque(true);
                                int dineroo = Integer.parseInt(dinero.getText());
                                dinero.setText(Integer.toString(dineroo*2));
                                JOptionPane.showMessageDialog(frame, "Has ganado por acertar verde");
                            } else if (num % 2 == 0) {
                                numero.setBackground(Color.red);
                                numero.setOpaque(true);
                                int dineroo = Integer.parseInt(dinero.getText());
                                dinero.setText(Integer.toString(dineroo*2));
                                JOptionPane.showMessageDialog(frame, "Has ganado por acertar rojo");
                            } else if (num % 2 == 1) {
                                numero.setBackground(Color.black);
                                numero.setForeground(Color.white);
                                numero.setOpaque(true);
                                int dineroo = Integer.parseInt(dinero.getText());
                                dinero.setText(Integer.toString(dineroo*2));
                                JOptionPane.showMessageDialog(frame, "Has ganado por acertar negro");
                            }
                        }
                    }
                }
            }
        };
        inicio.addActionListener(elegir);
        
        panel.add(ingresar);
        panel.add(numeroMio);
        panel.add(numero);
        panel.add(check1);
        panel.add(inicio);
        panel.add(verde);
        panel.add(rojo);
        panel.add(negro);
        panel.add(primeraDoc);
        panel.add(segundaDoc);
        panel.add(terceraDoc);
        panel.add(exacto);
        panel.add(dineros);
        panel.add(dinero);
        panel.add(apostarLabel);
        panel.add(apostar);
    }
    
    public void fondoPantalla(){
        JLabel fondo = new JLabel();
        
        fondo.setBounds(0, 0, 500, 500);
        ImageIcon imagen = new ImageIcon("Imagenes/ruleta3.jpg");
        fondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT)));
        
        panel.add(fondo);
    }
}
