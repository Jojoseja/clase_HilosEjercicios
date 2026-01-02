package org.josefeyjoo.hilos.ejerciciosok.ejercicio2.repaso1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] array = crearArray();
        ArrayList<Thread> listaThreads = new ArrayList<>();
        Buscador bus001 = new Buscador(1, 1, array);
        Buscador bus002 = new Buscador(2, randomNum(), array);
        Buscador bus003 = new Buscador(3, randomNum(), array);
        Buscador bus004 = new Buscador(4, randomNum(), array);

        Thread hilo1 = new Thread(bus001);
        Thread hilo2 = new Thread(bus002);
        Thread hilo3 = new Thread(bus003);
        Thread hilo4 = new Thread(bus004);

        listaThreads.add(hilo1);
        listaThreads.add(hilo2);
        listaThreads.add(hilo3);
        listaThreads.add(hilo4);

        for (Thread hilo : listaThreads) hilo.start();
        for (Thread hilo : listaThreads) hilo.join();
    }
    public static int[] crearArray() {
        int[] tabla = new int[1000000];
        int posicion = (int) (Math.random() * 1000000);
        for (int i = 0; i < tabla.length; i++) {
            if (i == posicion)
                tabla[i] = 1;
            else
                tabla[i] = 0;
        }
        return tabla;
    }

    public static int randomNum(){
        Random rand = new Random();
        return rand.nextInt(0, 1_000_000);
    }
}
