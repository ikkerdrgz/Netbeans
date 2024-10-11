/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filosofos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author FP
 */
public class Filosofo extends Thread{
    private Semaphore tenedorIzquierdo, tenedorDerecho;
    private int id;

    public Filosofo(Semaphore tenedorIzquierdo, Semaphore tenedorDerecho, int id) {
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorDerecho = tenedorDerecho;
        this.id = id;
    }
    
    public void run() {
        try {
            while(true) {
                //Filosofo piensa
                System.out.println("Filosofo " + id + " esta pensando.");
                //Filosofo intenta adquirir el tenedor izquierdo
                tenedorIzquierdo.acquire();
                System.out.println("Filosofo " + id + " ha tomado " + "el tenedor izquierdo.");
                //Filosofo intenta adquirir el tenedor derecho
                tenedorDerecho.acquire();
                System.out.println("Filosofo " + id + " ha tomado " + "el tenedor derecho.");
                //Filosofo suelta el tenedor derecho
                System.out.println("Filosofo " + id + " esta comiendo.");
                tenedorIzquierdo.release();
                System.out.println("Filosofo " + id + " ha soltado " + "el tenedor izquierdo.");
                //Filosofo suelta el tenedor derecho
                tenedorDerecho.release();
                System.out.println("Filosofo " + id + " ha soltado " + "el tenedor derecho.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
