package org.josefeyjoo.hilos.ejerciciosok.ejercicio1.ej1.repaso1;

import static java.lang.Thread.sleep;

public class Lector implements Runnable{
    int id;
    int[] buffer = new int[0];
    int currentValue;

    public Lector(int id, int[] buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            loop1:{
            currentValue = buffer [0];
                for (int num : buffer) {
                    System.out.printf("El numero leído es %d \n", num);
                    if (num!=currentValue) {
                        System.out.println("Se ha sobreescrito el número");
                        break loop1;
                    }
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
