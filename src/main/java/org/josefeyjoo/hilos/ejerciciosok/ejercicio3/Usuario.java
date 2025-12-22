package org.josefeyjoo.hilos.ejerciciosok.ejercicio3;

public class Usuario implements Runnable{
    private String nombre;
    private int numeroIntentos;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public int randomHora(){
        return (int) (Math.random() * 23);
    }

    public int randomGente(){
        return (int) (Math.random() * 50);
    }

    @Override
    public void run() {

    }

    // Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroIntentos() {
        return numeroIntentos;
    }

    public void setNumeroIntentos(int numeroIntentos) {
        this.numeroIntentos = numeroIntentos;
    }
}
