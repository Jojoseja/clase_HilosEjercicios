package org.josefeyjoo.hilos.ejerciciosok.ejercicio1.ej1.repaso1;

import static java.lang.Thread.sleep;

public class Escritor implements Runnable{
    int id;
    int[] buffer = new int[0];
    int currentValue = 1;

    public Escritor(int id, int[] buffer) {
        this.id = id;
        this.buffer = buffer;
        this.currentValue = buffer[0];
    }

    @Override
    public void run() {
        while (true) {
            System.out.printf("El valor actual es %d \n",currentValue);
            loop1:{
                for (int i = 0; i < buffer.length; i++) buffer[i] = currentValue;
                currentValue++;
                System.out.printf("El valor ha incrementado a %d \n", currentValue);
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
