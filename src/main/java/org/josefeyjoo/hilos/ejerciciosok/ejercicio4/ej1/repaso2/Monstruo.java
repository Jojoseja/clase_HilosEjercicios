package org.josefeyjoo.hilos.ejerciciosok.ejercicio4.ej1.repaso2;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Monstruo implements Runnable{
    int id;
    //Representa la cantidad de galletas que se come;
    int bocado;
    Almacen almacen;
    boolean activo;

    public Monstruo(int id, Almacen almacen) {
        this.id = id;
        Random rand = new Random();
        //Comerá entre 1 y 10 galletas (inclusives)
        this.bocado = rand.nextInt(1, 11);
        this.activo = true;
        this.almacen = almacen;
    }

    public void comer(){
        if (almacen.numeroGalletas == 0){
            System.out.printf("El monstruo %d no puede comer porque no que quedan galletas! \n", this.id );
        } else {
            if (almacen.numeroGalletas >= this.bocado){
                almacen.numeroGalletas -= this.bocado;
                System.out.printf("El monstruo %d se ha comido %d galletas del almacen, quedan %d \n", this.id, this.bocado, almacen.numeroGalletas);
            } else {
                almacen.numeroGalletas = 0;
                System.out.printf("El monstruo %d se ha comido las galletas que quedaban! \n", this.id);
            }
        }
    }

    @Override
    public void run() {
        while (this.activo){
            synchronized (almacen){
                if (almacen.numeroReposiciones == 10 && almacen.numeroGalletas == 0){
                    this.activo = false;
                    System.out.printf("El monstruo %d se va a dormir \n", this.id);
                    almacen.notifyAll();
                    //TEST: Eliminar este break
                    //break;
                } else {
                    if (almacen.numeroGalletas != 0){
                        comer();
                        almacen.notifyAll();
                    } else {
                        try {
                            //TEST: DO REMOVE LATER
                            //almacen.notify();
                            almacen.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            try {
                sleep(new Random().nextInt(200, 1200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
