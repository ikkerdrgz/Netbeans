/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rifa;

/**
 *
 * @author FP
 */
public class Juego {
    int [] carton = new int[5];
    
    public String jugar() {
        String frase = " ";
        
        return frase;
    }
    
    public int[] cartonAleatorio() {
        System.out.print("Numeros aleatorios: ");
        for (int i = 0; i < carton.length; i++) {
            carton[i] = (int)(Math.random()*100+1);
            System.out.print(carton[i] + " ");
        }
        
        return carton;
    }
}
