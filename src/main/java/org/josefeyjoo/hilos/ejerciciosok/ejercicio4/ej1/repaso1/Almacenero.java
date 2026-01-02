package org.josefeyjoo.hilos.ejerciciosok.ejercicio4.ej1.repaso1;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Almacenero implements Runnable{
    int id;
    int reposiciones = 0;
    Almacen almacen;

    public Almacenero(int id, Almacen almacen) {
        this.id = id;
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (almacen) {
                if (this.reposiciones == 10){
                    almacen.activo = false;
                    System.out.println("El almacenero se va a dormir!");
                    break;
                }
                else if (almacen.numeroGalletas == 0){
                    reposiciones++;
                    System.out.printf("El almacenero ha repuesto las galletas, lleva %d reposiciones \n", this.reposiciones);
                    almacen.numeroGalletas = 10;
                    almacen.notifyAll();
                } else {
                    try {
                        almacen.wait(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        try {
            Random rand = new Random();
            int num = rand.nextInt(1, 4);
            sleep(num * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
