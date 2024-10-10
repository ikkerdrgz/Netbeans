/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rifa;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author FP
 */
public class Ventana {
    JFrame ventana = new JFrame();
    JPanel panel = new JPanel();
    JTextField num1 = new JTextField();
    JTextField num2 = new JTextField();
    JTextField num3 = new JTextField();
    JTextField num4 = new JTextField();
    JTextField num5 = new JTextField();
    JButton botonAleatorio = new JButton();
    JButton botonAmano = new JButton();
    JButton botonEmpezar = new JButton();
    JLabel numerosPremiados = new JLabel();
    JLabel bote = new JLabel();
    JLabel numeroJugadores = new JLabel();
    JLabel tuCarton = new JLabel();
    JLabel tuPremio = new JLabel();
    JLabel mostrarCarton = new JLabel();
    JLabel mostrarJugadores = new JLabel();
    JLabel mostrarBote = new JLabel();
    JLabel mostrarNumerosPremiados = new JLabel();
    JLabel mostrarTuPremio = new JLabel();
    Juego juego = new Juego();
    int [] carton = new int[5];
    int [] carton2 = new int[5];
    int jugadores;
    
    public Ventana() {
        ventana.setVisible(true);
        ventana.setTitle("RIFA");
        ventana.setSize(600, 700);
        ventana.setResizable(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocation(100,100);
        cajaTexto();
        Panel();
        botonAleatorio();
        botonAmano();
        botonEmpezar();
        tuCarton();
        numeroJugadores();
        bote();
        numerosPremiados();
        tuPremio();
        mostrarCarton();
        mostrarJugadores();
        mostrarBote();
        mostrarNumerosPremiados();
        mostrarTuPremio();
        fondoPantalla();
        panel.updateUI();
    }
    
    public void Panel() {
        panel.setBackground(Color.red);
        panel.setLayout(null); 
        ventana.add(panel);
    }
    
    public void cajaTexto() {   
        JLabel numero1 = new JLabel();
        JLabel numero2 = new JLabel();
        JLabel numero3 = new JLabel();
        JLabel numero4 = new JLabel();
        JLabel numero5 = new JLabel();
        
        numero1.setText("Nº 1");
        numero2.setText("Nº 2");
        numero3.setText("Nº 3");
        numero4.setText("Nº 4");
        numero5.setText("Nº 5");
        
        num1.setBounds(80, 75, 40, 40);
        num2.setBounds(180, 75, 40, 40);
        num3.setBounds(280, 75, 40, 40);
        num4.setBounds(380, 75, 40, 40);
        num5.setBounds(480, 75, 40, 40);
        
        numero1.setBounds(50, 75, 40, 40);
        numero2.setBounds(150, 75, 40, 40);
        numero3.setBounds(250, 75,40, 40);
        numero4.setBounds(350, 75, 40, 40);
        numero5.setBounds(450, 75, 40, 40);
        
        num1.setHorizontalAlignment(SwingConstants.CENTER);
        num2.setHorizontalAlignment(SwingConstants.CENTER);
        num3.setHorizontalAlignment(SwingConstants.CENTER);
        num4.setHorizontalAlignment(SwingConstants.CENTER);
        num5.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel.add(num1);
        panel.add(num2);
        panel.add(num3);
        panel.add(num4);
        panel.add(num5);
        
        panel.add(numero1);
        panel.add(numero2);
        panel.add(numero3);
        panel.add(numero4);
        panel.add(numero5);
    }
    
    public void botonAleatorio() {
        botonAleatorio.setText("crear numeros aleatorios");
        botonAleatorio.setBounds(200, 150, 200, 40);
        botonAleatorio.setHorizontalAlignment(SwingConstants.CENTER);
        botonAleatorio.setForeground(Color.black);
        botonAleatorio.setBackground(Color.white);
        botonAleatorio.setFont(new Font ("Italic", Font.BOLD, 13));
        
        ActionListener pulsar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int [] carton = new int[5];
                while ((carton[0] == carton[1]) || (carton[0] == carton[2]) || (carton[0] == carton[3]) || (carton[0] == carton[4]) || (carton[1] == carton[2]) || (carton[1] == carton[3]) || (carton[1] == carton[4]) || (carton[2] == carton[3]) || (carton[2] == carton[4]) || (carton[3] == carton[4])) {
                    for (int i = 0; i < carton.length; i++) {
                        carton[i] = (int)(Math.random()*100+1);
                    }
                    num1.setText(Integer.toString(carton[0]));
                    num2.setText(Integer.toString(carton[1]));
                    num3.setText(Integer.toString(carton[2]));
                    num4.setText(Integer.toString(carton[3]));
                    num5.setText(Integer.toString(carton[4]));
                }
            }
        };
        botonAleatorio.addActionListener(pulsar);
        panel.add(botonAleatorio);
    }
    
    public void botonAmano() {
        botonAmano.setText("elegir numeros");
        botonAmano.setBounds(40, 150, 150, 40);
        botonAmano.setHorizontalAlignment(SwingConstants.CENTER);
        botonAmano.setForeground(Color.black);
        botonAmano.setBackground(Color.white);
        botonAmano.setFont(new Font ("Italic", Font.BOLD, 13));
        
        ActionListener pulsar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1.setText("");
                num2.setText("");
                num3.setText("");
                num4.setText("");
                num5.setText("");
            }
        };
        botonAmano.addActionListener(pulsar);
        
        panel.add(botonAmano);
    }
    
    public void tuCarton() {
        tuCarton.setText("Tu carton");
        tuCarton.setBounds(100, 230, 150, 40);
        tuCarton.setHorizontalAlignment(SwingConstants.CENTER);
        tuCarton.setOpaque(false);
        tuCarton.setForeground(Color.black);
        tuCarton.setFont(new Font("Italic", Font.BOLD , 13));
        panel.add(tuCarton);
    }
    
    public void numeroJugadores() {
        numeroJugadores.setText("Numero jugadores");
        numeroJugadores.setBounds(100, 310, 150, 40);
        numeroJugadores.setHorizontalAlignment(SwingConstants.CENTER);
        numeroJugadores.setOpaque(false);
        numeroJugadores.setForeground(Color.black);
        numeroJugadores.setFont(new Font("Italic", Font.BOLD , 13));
        panel.add(numeroJugadores);
    }
    
    public void bote() {
        bote.setText("Bote");
        bote.setBounds(100, 390, 150, 40);
        bote.setHorizontalAlignment(SwingConstants.CENTER);
        bote.setOpaque(false);
        bote.setForeground(Color.black);
        bote.setFont(new Font("Italic", Font.BOLD , 13));
        panel.add(bote);
    }
    
    public void numerosPremiados() {
        numerosPremiados.setText("Numeros premiados");
        numerosPremiados.setBounds(100, 470, 150, 40);
        numerosPremiados.setHorizontalAlignment(SwingConstants.CENTER);
        numerosPremiados.setOpaque(false);
        numerosPremiados.setForeground(Color.black);
        numerosPremiados.setFont(new Font("Italic", Font.BOLD , 13));
        panel.add(numerosPremiados);
    }
    
    public void tuPremio() {
        tuPremio.setText("Tu premio");
        tuPremio.setBounds(100, 550, 150, 40);
        tuPremio.setHorizontalAlignment(SwingConstants.CENTER);
        tuPremio.setOpaque(false);
        tuPremio.setForeground(Color.black);
        tuPremio.setFont(new Font("Italic", Font.BOLD , 13));
        panel.add(tuPremio);
    }
    
    public void botonEmpezar() {
        botonEmpezar.setText("empezar");
        botonEmpezar.setBounds(410, 150, 150, 40);
        botonEmpezar.setHorizontalAlignment(SwingConstants.CENTER);
        botonEmpezar.setForeground(Color.black);
        botonEmpezar.setBackground(Color.white);
        botonEmpezar.setFont(new Font ("Italic", Font.BOLD, 13));
        
        ActionListener pulsar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int aciertosMios = 0;
                int aciertosDemas = 0;
                mostrarCarton.setText(num1.getText() + "  " + num2.getText() + "  " + num3.getText() + "  " + num4.getText() + "  " + num5.getText());
                int jugadores = (int) (Math.random()*10)+5;
                mostrarJugadores.setText(Integer.toString(jugadores));
                mostrarBote.setText(Integer.toString(jugadores * 10));
                int [] carton2 = new int[5];
                while ((carton2[0] == carton2[1]) || (carton2[0] == carton2[2]) || (carton2[0] == carton2[3]) || (carton2[0] == carton2[4]) || (carton2[1] == carton2[2]) || (carton2[1] == carton2[3]) || (carton2[1] == carton2[4]) || (carton2[2] == carton2[3]) || (carton2[2] == carton2[4]) || (carton2[3] == carton2[4])) {
                    for (int i = 0; i < carton2.length; i++) {
                        carton2[i] = (int)(Math.random()*100+1);
                    }
                }
                String num = String.valueOf(carton2[0]) + "  " + String.valueOf(carton2[1]) + "  " + String.valueOf(carton2[2]) + "  " + String.valueOf(carton2[3]) + "  " + String.valueOf(carton2[4]);
                mostrarNumerosPremiados.setText(num);
                carton[0] = Integer.parseInt(num1.getText());
                carton[1] = Integer.parseInt(num2.getText());
                carton[2] = Integer.parseInt(num3.getText());
                carton[3] = Integer.parseInt(num4.getText());
                carton[4] = Integer.parseInt(num5.getText());
                for (int i = 0; i < carton.length; i++) {
                    for (int j = 0; j < carton2.length; j++) {
                        if (carton[i] == carton2[j]) {
                            aciertosMios++;
                        }
                    }
                }
                int [] cartonDemas = new int[jugadores*5];
                for (int i = 0; i < cartonDemas.length; i++) {
                    cartonDemas[i] = (int)(Math.random()*100+1);
                }
                
                for (int i = 0; i < cartonDemas.length; i++) {
                    for (int j = 0; j < carton2.length; j++) {
                        if (cartonDemas[i] == carton2[j]) {
                            aciertosDemas++;
                        }
                    }
                }
                int operacion = 0;
                if (aciertosDemas + aciertosMios != 0) {
                    operacion = (int) (aciertosMios * (jugadores * 10)) / (aciertosDemas + aciertosMios);
                }
                mostrarTuPremio.setText(Integer.toString(operacion));
            }
        };
        botonEmpezar.addActionListener(pulsar);
        panel.add(botonEmpezar);
    }
    
    public void mostrarCarton(){
        mostrarCarton.setBounds(350, 230, 150, 40);
        mostrarCarton.setHorizontalAlignment(SwingConstants.CENTER);
        mostrarCarton.setOpaque(false);
        mostrarCarton.setForeground(Color.black);
        mostrarCarton.setFont(new Font("Italic", Font.BOLD , 13));
        panel.add(mostrarCarton);
    }
    
    public void mostrarJugadores(){
        mostrarJugadores.setBounds(350, 310, 150, 40);
        mostrarJugadores.setHorizontalAlignment(SwingConstants.CENTER);
        mostrarJugadores.setOpaque(false);
        mostrarJugadores.setForeground(Color.black);
        mostrarJugadores.setFont(new Font("Italic", Font.BOLD , 13));
        panel.add(mostrarJugadores);
    }
    
    public void mostrarBote(){
        mostrarBote.setBounds(350, 390, 150, 40);
        mostrarBote.setHorizontalAlignment(SwingConstants.CENTER);
        mostrarBote.setOpaque(false);
        mostrarBote.setForeground(Color.black);
        mostrarBote.setFont(new Font("Italic", Font.BOLD , 13));
        panel.add(mostrarBote);
    }
    
    public void mostrarNumerosPremiados(){
        mostrarNumerosPremiados.setBounds(350, 470, 150, 40);
        mostrarNumerosPremiados.setHorizontalAlignment(SwingConstants.CENTER);
        mostrarNumerosPremiados.setOpaque(false);
        mostrarNumerosPremiados.setForeground(Color.black);
        mostrarNumerosPremiados.setFont(new Font("Italic", Font.BOLD , 13));
        panel.add(mostrarNumerosPremiados);
    }
    
    public void mostrarTuPremio(){
        mostrarTuPremio.setBounds(350, 550, 150, 40);
        mostrarTuPremio.setHorizontalAlignment(SwingConstants.CENTER);
        mostrarTuPremio.setOpaque(false);
        mostrarTuPremio.setForeground(Color.black);
        mostrarTuPremio.setFont(new Font("Italic", Font.BOLD , 13));
        panel.add(mostrarTuPremio);
    }
    
    public void fondoPantalla(){
        JLabel fondo = new JLabel();
        
        fondo.setBounds(0, 0, 600, 700);
        //fondo.setOpaque(true);
        //fondo.setBackground(Color.blue);
        ImageIcon imagen = new ImageIcon("Imagenes/fondo.png");
        fondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT)));
        
        panel.add(fondo);
    }
}