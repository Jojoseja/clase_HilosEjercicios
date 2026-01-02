package org.josefeyjoo.hilos.ejerciciosok.ejercicio1.ej1.repaso1;

import java.util.Arrays;

public class Check {
    public static void main(String[] args) {
        int arraySize = 10;
        int[] buffer = new int[arraySize];
        int defaultValue = 0;
        Arrays.fill(buffer, defaultValue);

        Lector lec = new Lector(1, buffer);
        Escritor esc = new Escritor(1, buffer);

        Thread hilo1 = new Thread(lec,  "Lector");
        Thread hilo2 = new Thread(esc, "Escritor");

        hilo1.start();
        hilo2.start();
    }
}
