package org.josefeyjoo.hilos.ejerciciosok.ejercicio2.repaso1;

public class Buscador implements Runnable{
    int id;
    int posicion;
    int posicionActual;
    int[] array;
    static volatile boolean encontrado = false;


    public Buscador(int id, int posicion, int[] array) {
        this.id = id;
        this.posicion = posicion;
        this.array = array;
    }

    @Override
    public void run() {
        while(!encontrado){
            if (encontrado){
                return;
            }
            if (array[posicionActual]!=1) {
                posicionActual++;
            } else {
                encontrado = !encontrado;
                System.out.printf("El hilo %d ha encontrado el numero en la posicion: %d \n", id, posicionActual);
                return;
            }
        }
    }
}
