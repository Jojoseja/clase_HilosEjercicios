package org.josefeyjoo.hilos.ejerciciosok.ejercicio4.ej1.repaso2;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Almacenero implements Runnable{
    int id;
    //Pasará a false cuando el almacén llegue a 10 reposiciones
    boolean activo;

    //Objeto Lock compartido con los monstruos
    Almacen almacen;

    public Almacenero(int id, boolean activo, Almacen almacen) {
        this.id = id;
        this.activo = activo;
        this.almacen = almacen;
    }

    public void reponer(){
        //Repone las galletas
        this.almacen.numeroGalletas = 10;
        //Aumenta el numero de reposiciones en 1 más
        this.almacen.numeroReposiciones++;
    }

    @Override
    public void run() {
        while (this.activo){
            synchronized (almacen){
                // Caso 1: El almacen ya ha repuesto 10 veces - se desactiva el almacenero
                if (almacen.numeroReposiciones == 10){
                    System.out.printf("El almacenero ha repuesto 10 veces, se va a dormir \n");
                    this.activo = false;
                    almacen.notifyAll();
                    //TEST: Eliminar este break
                    break;
                }
                // Caso 2: El almacen NO ha repuesto 10 veces y el numero de galletas es 0 - se repone
                else if (almacen.numeroGalletas == 0){
                    reponer();
                    System.out.printf("El almacenero ha repuesto las galletas, lleva %d reposiciones \n", almacen.numeroReposiciones);
                    almacen.notifyAll();
                }
                // Caso 3: El almacén NO ha repuesto 10 veces y el numero de galletas NO es 0, se pasa
                else {
                    try {
                        almacen.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
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
