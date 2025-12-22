package org.josefeyjoo.hilos.ejerciciosok.ejercicio2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] arrayNumeros = GeneradorArray.generarArray();
        ArrayList<Buscadores> listaBuscadores = new ArrayList<>();

        for (int i = 1; i<5;i++){
            listaBuscadores.add(new Buscadores(i, arrayNumeros));
        }
        for (Buscadores bu: listaBuscadores){
            bu.start();
        }
        for (Buscadores bu: listaBuscadores){
            bu.join();
        }

        if (Buscadores.encontrado){
            System.out.printf("El ganador es el Hilo %d encontrando el 1 en la posición %d", Buscadores.ganador, Buscadores.posicionEncontrada);
        }
    }
}
