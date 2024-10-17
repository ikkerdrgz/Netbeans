/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartasEmparejadas;

import java.util.ArrayList;
import javax.swing.JTextArea;


/**
 *
 * @author FP
 */
public class Cartas {
    private int id;
    String reverso;
    String cara;
    
    public Cartas() {
    }
    
    public Cartas(int id, String reverso, String cara) {
        this.id = id;
        this.reverso = reverso;
        this.cara = cara;
    }
}
