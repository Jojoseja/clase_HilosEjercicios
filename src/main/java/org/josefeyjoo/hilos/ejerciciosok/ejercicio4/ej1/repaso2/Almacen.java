package org.josefeyjoo.hilos.ejerciciosok.ejercicio4.ej1.repaso2;

//Objeto compartido que actuará de "Lock"
public class Almacen {
    //Numero galletas actuales, max=10
    int numeroGalletas;
    //Numero de reposiciones, max=10
    int numeroReposiciones;

    public Almacen() {
        this.numeroGalletas = 10;
        this.numeroReposiciones = 0;
    }
}
