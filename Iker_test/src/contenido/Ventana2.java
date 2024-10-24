/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;

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
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

/**
 *
 * @author FP
 */
public class Ventana2 {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    boolean casilla = false;
    boolean preguntas = false;
    
    JLabel pregunta1 = new JLabel();
    JRadioButton opcion11 = new JRadioButton();
    JRadioButton opcion12 = new JRadioButton();
    JRadioButton opcion13 = new JRadioButton();
    ButtonGroup grupo1 = new ButtonGroup();
    
    JLabel pregunta2 = new JLabel();
    JRadioButton opcion21 = new JRadioButton();
    JRadioButton opcion22 = new JRadioButton();
    JRadioButton opcion23 = new JRadioButton();
    ButtonGroup grupo2 = new ButtonGroup();
    
    JLabel pregunta3 = new JLabel();
    JRadioButton opcion31 = new JRadioButton();
    JRadioButton opcion32 = new JRadioButton();
    JRadioButton opcion33 = new JRadioButton();
    ButtonGroup grupo3 = new ButtonGroup();
    
    JLabel pregunta4 = new JLabel();
    JRadioButton opcion41 = new JRadioButton();
    JRadioButton opcion42 = new JRadioButton();
    JRadioButton opcion43 = new JRadioButton();
    ButtonGroup grupo4 = new ButtonGroup();
    
    JLabel pregunta5 = new JLabel();
    JRadioButton opcion51 = new JRadioButton();
    JRadioButton opcion52 = new JRadioButton();
    JRadioButton opcion53 = new JRadioButton();
    ButtonGroup grupo5 = new ButtonGroup();
    
    JLabel pregunta6 = new JLabel();
    JRadioButton opcion61 = new JRadioButton();
    JRadioButton opcion62 = new JRadioButton();
    JRadioButton opcion63 = new JRadioButton();
    ButtonGroup grupo6 = new ButtonGroup();
    
    JLabel pregunta7 = new JLabel();
    JRadioButton opcion71 = new JRadioButton();
    JRadioButton opcion72 = new JRadioButton();
    JRadioButton opcion73 = new JRadioButton();
    ButtonGroup grupo7 = new ButtonGroup();
    
    JLabel pregunta8 = new JLabel();
    JRadioButton opcion81 = new JRadioButton();
    JRadioButton opcion82 = new JRadioButton();
    JRadioButton opcion83 = new JRadioButton();
    ButtonGroup grupo8 = new ButtonGroup();
    
    JLabel pregunta9 = new JLabel();
    JRadioButton opcion91 = new JRadioButton();
    JRadioButton opcion92 = new JRadioButton();
    JRadioButton opcion93 = new JRadioButton();
    ButtonGroup grupo9 = new ButtonGroup();
    
    JLabel pregunta10 = new JLabel();
    JRadioButton opcion101 = new JRadioButton();
    JRadioButton opcion102 = new JRadioButton();
    JRadioButton opcion103 = new JRadioButton();
    ButtonGroup grupo10= new ButtonGroup();
    
    JCheckBox check1 = new JCheckBox();
    JButton terminar = new JButton();
    int contador = 0;
    ;
    
    public Ventana2(){
        frame.setVisible(true);        
        frame.setTitle("Test Hollow Knight");
        frame.setBounds(350, 100, 900, 670);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setBackground(Color.LIGHT_GRAY);  
        panel.setLayout(null);
        frame.add(panel);
        
        Botones();
        Check();
        Terminar();
        FondoPantalla();
        panel.updateUI();
    }
    
    public void Botones(){
        pregunta1.setText("1. ¿Cuantos finales hay en el juego?");
        pregunta1.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta1.setBounds(20,30,250,30);
        pregunta1.setForeground(Color.black);
        opcion11.setText("4");
        opcion12.setText("3");
        opcion13.setText("5");
        opcion11.setBounds(120,60,50,30);
        opcion12.setBounds(120,90, 50,30);
        opcion13.setBounds(120,120,50,30);
        
        pregunta2.setText("2. ¿Cuantos amuletos hay en el juego?");
        pregunta2.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta2.setBounds(315,30,250,30);
        pregunta2.setForeground(Color.black);
        opcion21.setText("41");
        opcion22.setText("47");
        opcion23.setText("45");
        opcion21.setBounds(410,60,50,30);
        opcion22.setBounds(410,90,50,30);
        opcion23.setBounds(410,120,50,30);
        
        pregunta3.setText("3. ¿Cuantos jefes podemos matar en el juego?");
        pregunta3.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta3.setBounds(580,30,300,30);
        pregunta3.setForeground(Color.black);
        opcion31.setText("52");
        opcion32.setText("47");
        opcion33.setText("50");
        opcion31.setBounds(700,60,50,30);
        opcion32.setBounds(700,90, 50,30);
        opcion33.setBounds(700,120,50,30);
        
        pregunta4.setText("4. ¿Primera zona a la cual podemos acceder?");
        pregunta4.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta4.setBounds(20, 180, 260, 30);
        pregunta4.setForeground(Color.black);
        opcion41.setText("Cruces olvidados");
        opcion42.setText("Bocasucia");
        opcion43.setText("Ciudad de lagrimas");
        opcion41.setBounds(90,210,135,30);
        opcion42.setBounds(90,240,135,30);
        opcion43.setBounds(90,270,135,30);
        
        pregunta5.setText("5. ¿Cual es la desarolladora del juego?");
        pregunta5.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta5.setBounds(315,180,250,30);
        pregunta5.setForeground(Color.black);
        opcion51.setText("Ubisoft");
        opcion52.setText("Nintendo");
        opcion53.setText("Team cherry");
        opcion51.setBounds(375,210,100,30);
        opcion52.setBounds(375,240,100,30);
        opcion53.setBounds(375,270,100,30);
        
        pregunta6.setText("6. ¿Donde se encuentra el palacio blanco?");
        pregunta6.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta6.setBounds(580,180,300,30);
        pregunta6.setForeground(Color.black);
        opcion61.setText("Cuenca antigua");
        opcion62.setText("Nido profundo");
        opcion63.setText("En el fin del reino");
        opcion61.setBounds(670,210,122,30);
        opcion62.setBounds(670,240, 122,30);
        opcion63.setBounds(670,270,122,30);
        
        pregunta7.setText("7. ¿Veces que podemos mejorar el aguijon?");
        pregunta7.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta7.setBounds(20,330,270,30);
        pregunta7.setForeground(Color.black);
        opcion71.setText("4");
        opcion72.setText("3");
        opcion73.setText("6");
        opcion71.setBounds(120,360,50,30);
        opcion72.setBounds(120,390,50,30);
        opcion73.setBounds(120,420,50,30);
        
        pregunta8.setText("8. ¿Cuantos maestros existes?");
        pregunta8.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta8.setBounds(315,330,250,30);
        pregunta8.setForeground(Color.black);
        opcion81.setText("6");
        opcion82.setText("5");
        opcion83.setText("3");
        opcion81.setBounds(405,360,50,30);
        opcion82.setBounds(405,390, 50,30);
        opcion83.setBounds(405,420,50,30);
        
        pregunta9.setText("9. ¿Con cuantos DLC cuenta el juego?");
        pregunta9.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta9.setBounds(600,330,250,30);
        pregunta9.setForeground(Color.black);
        opcion91.setText("5");
        opcion92.setText("4");
        opcion93.setText("2");
        opcion91.setBounds(700,360,50,30);
        opcion92.setBounds(700,390, 50,30);
        opcion93.setBounds(700,420,50,30);
        
        pregunta10.setText("10. ¿Zona que no es obligatoria para conseguir alguno de los finales?");
        pregunta10.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta10.setBounds(230,480,400,30);
        pregunta10.setForeground(Color.black);
        opcion101.setText("Cuenca antigua");
        opcion102.setText("Jardines de la Reina");
        opcion103.setText("El abismo");
        opcion101.setBounds(375,510,140,30);
        opcion102.setBounds(375,540,140,30);
        opcion103.setBounds(375,570,140,30);
        
        grupo1.add(opcion11);
        grupo1.add(opcion12);
        grupo1.add(opcion13);
        grupo2.add(opcion21);
        grupo2.add(opcion22);
        grupo2.add(opcion23);
        grupo3.add(opcion31);
        grupo3.add(opcion32);
        grupo3.add(opcion33);
        grupo4.add(opcion41);
        grupo4.add(opcion42);
        grupo4.add(opcion43);
        grupo5.add(opcion51);
        grupo5.add(opcion52);
        grupo5.add(opcion53);
        grupo6.add(opcion61);
        grupo6.add(opcion62);
        grupo6.add(opcion63);
        grupo7.add(opcion71);
        grupo7.add(opcion72);
        grupo7.add(opcion73);
        grupo8.add(opcion81);
        grupo8.add(opcion82);
        grupo8.add(opcion83);
        grupo9.add(opcion91);
        grupo9.add(opcion92);
        grupo9.add(opcion93);
        grupo10.add(opcion101);
        grupo10.add(opcion102);
        grupo10.add(opcion103);
        
        panel.add(pregunta1);
        panel.add(pregunta2);
        panel.add(pregunta3);
        panel.add(pregunta4);
        panel.add(pregunta5);
        panel.add(pregunta6);
        panel.add(pregunta7);
        panel.add(pregunta8);
        panel.add(pregunta9);
        panel.add(pregunta10);
        
        panel.add(opcion11);
        panel.add(opcion12);
        panel.add(opcion13);
        panel.add(opcion21);
        panel.add(opcion22);
        panel.add(opcion23);
        panel.add(opcion31);
        panel.add(opcion32);
        panel.add(opcion33);
        panel.add(opcion41);
        panel.add(opcion42);
        panel.add(opcion43);
        panel.add(opcion51);
        panel.add(opcion52);
        panel.add(opcion53);
        panel.add(opcion61);
        panel.add(opcion62);
        panel.add(opcion63);
        panel.add(opcion71);
        panel.add(opcion72);
        panel.add(opcion73);
        panel.add(opcion81);
        panel.add(opcion82);
        panel.add(opcion83);
        panel.add(opcion91);
        panel.add(opcion92);
        panel.add(opcion93);
        panel.add(opcion101);
        panel.add(opcion102);
        panel.add(opcion103);
    }
    
    public void Check() {
        check1.setText("Quiero entregar mi examen");
        check1.setBackground(Color.white);
        check1.setBounds(35, 530, 200, 30);
        
        panel.add(check1);
    }
    
    public void Terminar() {
        terminar.setText("TERMINAR EXAMEN");
        terminar.setBounds(640, 530, 200, 30);
        terminar.setBackground(Color.BLACK);
        terminar.setForeground(Color.WHITE);
        
        ActionListener seleccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (casilla == true && preguntas == true) {
                    if (opcion11.isSelected()) {
                        contador++;
                    }
                    if (opcion23.isSelected()) {
                        contador++;
                    }
                    if (opcion32.isSelected()) {
                        contador++;
                    }
                    if (opcion42.isSelected()) {
                        contador++;
                    }
                    if (opcion53.isSelected()) {
                        contador++;
                    }
                    if (opcion61.isSelected()) {
                        contador++;
                    }
                    if (opcion71.isSelected()) {
                        contador++;
                    }
                    if (opcion83.isSelected()) {
                        contador++;
                    }
                    if (opcion92.isSelected()) {
                        contador++;
                    }
                    if (opcion102.isSelected()) {
                        contador++;
                    }
                    JOptionPane.showMessageDialog(frame, "Tu nota es " + contador + "/10");
                    frame.dispose();
                } else {
                    if (!check1.isSelected()) {
                        JOptionPane.showMessageDialog(frame, "No has seleccionado la casilla de terminar el examen");
                    } else {
                        casilla = true;
                    }
                    if (grupo1.getSelection() == null || grupo2.getSelection() == null || grupo3.getSelection() == null || grupo4.getSelection() == null || grupo5.getSelection() == null ||  grupo6.getSelection() == null || grupo7.getSelection() == null || grupo8.getSelection() == null || grupo9.getSelection() == null || grupo10.getSelection() == null) {
                        JOptionPane.showMessageDialog(frame, "No has contestado todas las preguntas");
                    } else {
                        preguntas = true;
                    }
                }
            }
        };
        terminar.addActionListener(seleccion);
        panel.add(terminar);
    }
    
    public void FondoPantalla(){
        JLabel fondo = new JLabel();
        
        fondo.setBounds(0, 0, 900, 670);
        ImageIcon imagen = new ImageIcon("fondo2.png");
        fondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT)));
        
        panel.add(fondo);
    }
}
