package org.josefeyjoo.hilos.ejerciciosok.ejercicio4.ej1.repaso2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Thread> listaTheads = new ArrayList<>();

        Almacen almacen = new Almacen();

        Almacenero alma = new Almacenero(1, true, almacen);
        Thread hilo1 = new Thread(alma);
        listaTheads.add(hilo1);

        for (int i = 2; i < 5; i++){
            Monstruo mons = new Monstruo(i, almacen);
            listaTheads.add(new Thread(mons));
        }

        for (Thread hilo : listaTheads){
            hilo.start();
        }

    }
}
