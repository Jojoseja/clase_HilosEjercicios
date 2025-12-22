package org.josefeyjoo.hilos.ejerciciosok.ejercicio2;

import java.util.Random;

public class Buscadores extends Thread{
    int id;
    int[] arrayNumeros;
    static int posicionEncontrada;
    static volatile boolean encontrado = false;
    static int ganador;

    public Buscadores(int id, int[] arrayNumeros) {
        this.id = id;
        this.arrayNumeros = arrayNumeros;
    }

    public int numeroAleatorio(){
        Random rand = new Random();
        return rand.nextInt(0,1000000);
    }

    @Override
    public void run() {
        int randomStart = numeroAleatorio();
        System.out.printf("El Hilo %d ha empezado en la posicion: %d \n", id, randomStart);
        while (!encontrado){
            for (int i = randomStart; i < arrayNumeros.length && !encontrado; i++){
                if (arrayNumeros[i]==1){
                    encontrado = !encontrado;
                    System.out.printf("El Hilo %d ha encontrado el 1 en la posición: %d\n", id, i);
                    posicionEncontrada = i;
                    ganador = this.id;
                    break;
                }
            }
        }
        return;
    }
}
