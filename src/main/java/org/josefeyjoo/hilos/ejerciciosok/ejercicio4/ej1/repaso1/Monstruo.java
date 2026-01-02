package org.josefeyjoo.hilos.ejerciciosok.ejercicio4.ej1.repaso1;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Monstruo implements Runnable{
    int id;
    int galletasComer;
    Almacen almacen;

    public Monstruo(int id, Almacen almacen) {
        this.id = id;
        Random rand = new Random();
        this.galletasComer = rand.nextInt(1, 11);
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (almacen) {
                if (!almacen.activo && almacen.numeroGalletas==0){
                    break;
                }
                else if (almacen.numeroGalletas >= galletasComer) {
                    almacen.numeroGalletas -= galletasComer;
                    System.out.printf("El monstruo %d se ha comido %d galletas, quedan %d en el almacen \n", this.id, this.galletasComer, almacen.numeroGalletas);
                    almacen.notifyAll();
                } else if (almacen.numeroGalletas != 0){
                    System.out.printf("El monstruo %d se ha comido las galletas que quedaban \n", this.id);
                    almacen.numeroGalletas = 0;
                    almacen.notifyAll();
                } else {
                    System.out.printf("No quedan galletas en almacen, el monstruo %d no puede comer \n", this.id);
                    try {
                        almacen.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
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
}
