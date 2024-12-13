/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCPFormas;

import java.io.Serializable;

/**
 *
 * @author FP
 */
public class Circulo implements Serializable {
    double radio;
    
    public Circulo(double radio) {
        this.radio = radio;
    }
    
    public Circulo() {super();}
    
    public double getRadio() {
        return radio;
    }
    
    public void setRadio(double radio) {
        this.radio = radio;
    }

    double calcularPerimetro() {
        return radio * 2;
    }

    double calcularArea() {
        return radio * 3;
    }
}
