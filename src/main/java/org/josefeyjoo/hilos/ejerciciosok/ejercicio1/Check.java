package org.josefeyjoo.hilos.ejerciciosok.ejercicio1;

import java.util.ArrayList;

public class Check {
    public static void main(String[] args) {
        //Buffer
        ArrayList<Integer> buffer = new ArrayList<>();
        for (int i = 0; i < 10000; i++){
            buffer.add(0);
        }
        ArrayList<Thread> hilos = new ArrayList<>();

        for (int i = 1; i < 4; i++){
            Lector le = new Lector(buffer);
            hilos.add(le);
            if (i == 1){
                Escritor es = new Escritor(buffer);
                hilos.add(es);
            }
        }
        for (Thread hilo: hilos){
            hilo.start();
        }
    }
}
