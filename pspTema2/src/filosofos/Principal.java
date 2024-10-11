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
public class Principal {
    public static void main(String[] args) {
        final int numFilosofos = 5;
        Semaphore[] tenedores = new Semaphore[numFilosofos];
        Filosofo[] filosofos = new Filosofo[numFilosofos];
        //Inicializar los tenedores
        for (int i = 0; i < numFilosofos; i++) {
            tenedores[i] = new Semaphore(1);
        }
        //Crear e iniciar los filósofos
        for (int i = 0; i < numFilosofos; i++) {
            Semaphore tenedorIzquierdo = tenedores[i];
            Semaphore tenedorDerecho = tenedores[(i + 1) % numFilosofos];
            //El tenedor derecho es el siguiente tenedor
            filosofos[i] = new Filosofo(tenedorIzquierdo, tenedorDerecho, i);
            filosofos[i].start();
        }
    }
}
