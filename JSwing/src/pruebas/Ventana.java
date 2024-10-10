/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.BoxLayout;
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
    JFrame frame = new JFrame(); //Objeto tipo JFrame
    JPanel panel = new JPanel(); //Objeto tipo JPanel
    //JLabel etiqueta = new JLabel(); //Objeto tipo JLabel
    JTextField cajaTexto = new JTextField(); //Objeto tipo JTextField;
    JTextArea areaTexto = new JTextArea();
    
    public Ventana() {
        frame.setVisible(true); //Para que la ventana sea visible
        
        frame.setTitle("Java Swing");
        
        frame.setSize(500, 500); //Para elegir el tamaño de la pantalla
        frame.setResizable(true); //Para permitir (o no) que se cambie el tamaño de la pantalla
        
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Pantalla completa
        
        //frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //No hace nada al darle a la X
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cierra al darle a la X (defecto)
        //frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //Minimiza al darle a la X
        //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Elimina al darle a la X
        
        frame.setLocation(100,100); //Cambiar la posición inicial de la pantalla
        
        frame.getContentPane().setBackground(Color.green);
        
        Panel(); //Llama al metodo Panel
        Etiqueta(); //LLama al metodo Etiqueta
        CajaTexto(); //Llama al metodo CajaTexto
        Boton(); //Llama al metodo Boton
        Boton2(); //Llama al metodo Boton2
        AreaTexto();
        FondoPantalla(); //Llama al metodo FondoPantalla
        
        panel.updateUI(); //Actualiza el panel
    }
    
    public void FondoPantalla(){
        JLabel fondo = new JLabel();
        
        fondo.setBounds(0, 0, 500, 500);
        //fondo.setOpaque(true);
        //fondo.setBackground(Color.blue);
        ImageIcon imagen = new ImageIcon("Imagenes/perro.jpg");
        fondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT)));
        
        panel.add(fondo);
    }
    
    public void Panel () {
        panel.setBackground(Color.red); //Para cambiar el color del panel de la ventana
        //panel.setMaximumSize(new Dimension(500, 500)); //Tamaño maximo del panel
        //panel.setMinimumSize(new Dimension (200, 100)); //Tamaño minimo del panel
        
        //Para posicionar otros elementos en el panel
        //panel.setLayout(new FlowLayout()); //Alineamiento a la izquierda
        //panel.setLayout(new BorderLayout()); //Cinco zonas (Norte, Sur, Este, Oeste, Centro
        //panel.setLayout(new GridLayout()); //Cuadricula predefinida
        //panel.setLayout(new GridBagLayout()); //Una cuadricula flexible
        //panel.setLayout(new BoxLayout(panel, 0)); //Por coordenadas
        panel.setLayout(null); 
        
        frame.add(panel); //Para añadir un elemento a otro. En este caso, el panel sobre la ventana
    }
    
    public void Etiqueta() {
        JLabel etiqueta = new JLabel(); //Objeto tipo JLabel
        etiqueta.setBounds(50, 60, 100, 50); //Para añadir coordenadas (los 2 primeros) y dimensiones (los 2 ultimos);
        //etiqueta.setSize(100, 50); //Para darle tamaño
        etiqueta.setText("Nombre: ");
        
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); //Para centrar el texto
        
        etiqueta.setOpaque(true); //Para que la etiqueta no sea transparente
        etiqueta.setForeground(Color.blue); //Cambiar el color del TEXTO
        etiqueta.setBackground(Color.yellow); //Cambiar el color del fondo
        
        etiqueta.setFont(new Font("Ink Free", Font.BOLD , 20)); //Cambiar fuente
        
        panel.add(etiqueta);
    }
    
    public void CajaTexto() {
        cajaTexto.setBounds(160, 60, 280, 50);
        
        cajaTexto.setHorizontalAlignment(SwingConstants.CENTER);
        
        cajaTexto.setForeground(Color.blue);
        cajaTexto.setBackground(Color.white);
        
        cajaTexto.setFont(new Font ("Ink Free", Font.BOLD, 20));
        
        panel.add(cajaTexto);
    }
    
    public void Boton() {
        JButton boton = new JButton(); //Objeto tipo JButton;
        
        ImageIcon imagenBoton = new ImageIcon("Imagenes/perro.jpg");
        
        boton.setBounds(50, 150, 100, 100);
        //boton.setText("Alt + F4");
        
        boton.setIcon(new ImageIcon(imagenBoton.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_DEFAULT)));
        
        //boton.setHorizontalAlignment(SwingConstants.LEFT);
        //boton.setForeground(Color.blue);
        //boton.setBackground(Color.yellow);
        //boton.setFont(new Font ("Italic", Font.BOLD, 20));
        
        JLabel respuesta = new JLabel();
        panel.add(respuesta);
        
        ActionListener pulsar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                respuesta.setBounds(50, 210, 100, 100);
                respuesta.setText("Estas supenso " + cajaTexto.getText()+ "!!");
                
                respuesta.setForeground(Color.white);
                boton.setFont(new Font ("Times New Roman", Font.BOLD, 18));
                
                //Excepcion por defecto throw new UnsupportedOperationException("Not supported yet.");
                System.out.println(areaTexto.getText());
            }
        };
        boton.addActionListener(pulsar); //se activa al hacer click en el boton
        cajaTexto.addActionListener(pulsar); //se activa al darle a enter en el cuadro de texto
        
        panel.add(boton);
    }
    
    public void Boton2() {
        JButton boton2 = new JButton(); //Objeto tipo JButton;
        
        
        boton2.setBounds(50, 270, 100, 50);
        //boton.setText("Alt + F4");
        
        //boton.setHorizontalAlignment(SwingConstants.LEFT);
        boton2.setForeground(Color.blue);
        boton2.setBackground(Color.yellow);
        boton2.setFont(new Font ("Italic", Font.BOLD, 20));
        
        JLabel respuesta = new JLabel();
        panel.add(respuesta);
        
        ActionListener pulsar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(areaTexto.getText());
            }
        };
        boton2.addActionListener(pulsar); //se activa al hacer click en el boton
        cajaTexto.addActionListener(pulsar); //se activa al darle a enter en el cuadro de texto
        
        panel.add(boton2);
    }
    
    public void AreaTexto() {
        areaTexto.setBounds(160, 270, 200, 50);
        areaTexto.setBackground(Color.white);
        areaTexto.setForeground(Color.black);
        areaTexto.setFont(new Font("Arial", Font.PLAIN,12));
        
        panel.add(areaTexto);
    }
}
