/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author FP
 */
public class Ventana {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JRadioButton radio1 = new JRadioButton();
    JRadioButton radio2 = new JRadioButton();
    JRadioButton radio3 = new JRadioButton();
    JCheckBox check1 = new JCheckBox();
    JCheckBox check2 = new JCheckBox();
    
    JComboBox<String> combo;
    
    public Ventana() {
        frame.setVisible(true);
        
        frame.setTitle("Java Swing");
        
        frame.setSize(500, 500);
        frame.setResizable(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLocation(100,100);
        
        Panel();
        Radio();
        Check();
        ComboBox();
        BotonElegir();
        panel.updateUI();
    }
    
    public void Panel () {
        panel.setBackground(Color.CYAN);
        
        panel.setLayout(null); 
        
        frame.add(panel);
    }
    
    public void Radio () {
        ButtonGroup grupo1 = new ButtonGroup();
        radio1.setText("Opcion 1");
        radio1.setBounds(50, 40, 100, 30);
        radio2.setText("Opcion 2");
        radio2.setBounds(50, 70, 100, 30);
        radio3.setText("Opcion 3");
        radio3.setBounds(50, 100, 100, 30);
        grupo1.add(radio1);
        grupo1.add(radio2);
        grupo1.add(radio3);
        
        panel.add(radio1);
        panel.add(radio2);
        panel.add(radio3);
    }
    
    public void Check() {
        check1.setBounds(50, 150, 100, 30);
        check1.setText("Check 1");
        check2.setBounds(50, 190, 100, 30);
        check2.setText("Check 2");
        
        panel.add(check1);
        panel.add(check2);
    }
    
    public void ComboBox() {
        String [] paises = {"Elige un pais", "Espa?a", "Portugal", "Francia", "Andorra", "Marruecos", "Sahara"};
        combo = new JComboBox<>(paises);
        combo.setBounds(50, 230, 100, 30);
        panel.add(combo);
    }
    
    public void BotonElegir () {
        JButton boton = new JButton("Mostrar"); //Al poner un string construyo el boton con el nombre
        boton.setBounds(50, 270, 100, 40);
        boton.setBackground(Color.yellow);
        
        JTextArea area = new JTextArea();
        area.setBounds(170, 50, 230, 260);
        area.setEditable(false); //Para que no se pueda escribir en el area de texto
        
        ActionListener seleccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radio1.isSelected()) {
                    area.append("Ha seleccionado la opcion 1\n");
                }
                if (radio2.isSelected()) {
                    area.append("Ha seleccionado la opcion 2\n");
                }
                if (radio3.isSelected()) {
                    area.append("Ha seleccionado la opcion 3\n");
                }
                if (check1.isSelected()) {
                    area.append("Ha seleccionado la check 1\n");
                }
                if (check2.isSelected()) {
                    area.append("Ha seleccionado la check 2\n");
                }
                area.append((String)combo.getSelectedItem() + "\n");
            }
        };
        boton.addActionListener(seleccion);
        
        panel.add(area);
        panel.add(boton);
    } 
}
