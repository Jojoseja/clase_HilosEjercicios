package org.josefeyjoo.hilos.ejerciciosok.ejercicio4.ej1;

import java.util.Random;

public class Monstruo extends Thread{
    int galletasComer;
    Almacen almacen;
    int id;

    public Monstruo(Almacen almacen, int id) {
        Random rand = new Random();
        this.galletasComer = rand.nextInt(1,11);
        this.almacen = almacen;
        this.id = id;
    }

    public void comer(){
        if (galletasComer >= almacen.galletas){
            almacen.galletas = 0;
            System.out.printf("El monstruo %d se ha comido las galletas que quedaban \n", id);
        } else if (galletasComer < almacen.galletas){
            almacen.galletas -= galletasComer;
            System.out.printf("El monstruo %d se ha comido %d galletas, quedan %d en el almacen \n", id, galletasComer, almacen.galletas);
        } else if (almacen.galletas == 0){
            System.out.printf("El monstruo %d ha intentado comer, pero mo quedan galletas! \n", id);
        }
    }

    @Override
    public void run() {
        try {
            while (almacen.capo){
                Thread.sleep((long) (Math.random()*1000));
                synchronized (almacen){
                    while (almacen.galletas == 0){
                        almacen.wait();
                    }
                    comer();
                    almacen.notify();

                }
            }
            Thread.sleep((long) (Math.random()*1000));
        }  catch (Exception e){
            System.out.println("Error");
        }
    }
}
