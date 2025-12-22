package org.josefeyjoo.hilos.ejerciciosok.ejercicio4.ej1;

public class Reponedor extends Thread{
    Almacen almacen;
    int contador = 0;

    public Reponedor(Almacen almacen) {
        this.almacen = almacen;
    }

    public void reponer(){
        contador++;
        System.out.printf("El reponedor ha repuesto 10 galletas, lleva %d reposiciones \n", contador );
        almacen.galletas = 10;
        if (contador==10){
            almacen.capo = false;
        }
    }

    @Override
    public void run() {
        try {
            while (almacen.capo){
                Thread.sleep((long) (Math.random()*1000));
                synchronized (almacen){
                    while (almacen.galletas != 0) {
                        almacen.wait();
                        System.out.println("El almacen no esta vacio");
                    }
                    reponer();
                    almacen.notifyAll();

                    System.out.println("Se duerme el reponedor");

                }
                Thread.sleep((long) (Math.random()*1000));
            }


        } catch (InterruptedException e){
            System.out.println("");
        }
    }
}
