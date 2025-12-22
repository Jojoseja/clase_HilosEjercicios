package org.josefeyjoo.hilos.ejerciciosok.ejercicio3;

public class Sala {
    private String nombre;
    private int capacidad;
    private boolean reservado = false;

    public Sala(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public boolean intenarReservar(int capaciadad){
        if (capaciadad <= this.capacidad){
            return true;
        } else {
            return false;
        }
    }

    public void liberarSala(){
        this.reservado = false;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                ", reservado=" + reservado +
                '}';
    }

    // Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
}
