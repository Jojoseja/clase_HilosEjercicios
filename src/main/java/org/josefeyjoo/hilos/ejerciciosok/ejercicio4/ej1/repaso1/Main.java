package org.josefeyjoo.hilos.ejerciciosok.ejercicio4.ej1.repaso1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> hilos = new ArrayList<>();
        Almacen alm = new Almacen();

        Almacenero almacenero001 = new Almacenero(1, alm);
        Monstruo monstruo001 = new Monstruo(2, alm);
        Monstruo monstruo002 = new Monstruo(3, alm);
        Monstruo monstruo003 = new Monstruo(4, alm);

        Thread hilo1 = new Thread(almacenero001);
        Thread hilo2 = new Thread(monstruo001);
        Thread hilo3 = new Thread(monstruo002);
        Thread hilo4 = new Thread(monstruo003);

        hilos.add(hilo1);
        hilos.add(hilo2);
        hilos.add(hilo3);
        hilos.add(hilo4);


        for (Thread hilo : hilos) hilo.start();
        for (Thread hilo : hilos) hilo.join();

        System.out.printf("Se han comido todas las galletas! \n");
    }
}
