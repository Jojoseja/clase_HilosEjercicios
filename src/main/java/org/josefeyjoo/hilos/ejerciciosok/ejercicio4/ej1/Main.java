package org.josefeyjoo.hilos.ejerciciosok.ejercicio4.ej1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> listaThread= new ArrayList<>();
        Almacen almacen = new Almacen();

        Reponedor repo01 = new Reponedor(almacen);
        listaThread.add(repo01);

        for (int i = 1; i<4;i++){
            listaThread.add(new Monstruo(almacen, i));
        }

        for (Thread hilo: listaThread){
            hilo.start();
        }
    }
}
