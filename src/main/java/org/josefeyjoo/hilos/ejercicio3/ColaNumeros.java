package org.josefeyjoo.hilos.ejercicio3;

import java.util.LinkedList;

public class ColaNumeros {
    private LinkedList<Integer> lista = new LinkedList<Integer>();
    private int capacidadMaxima;

    public ColaNumeros() {
    }

    public ColaNumeros(int capacidadMaxima) {
        this.lista = new LinkedList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    public LinkedList<Integer> getLista() {
        return lista;
    }

    public void setLista(LinkedList<Integer> lista) {
        this.lista = lista;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    @Override
    public String toString() {
        return lista.toString();
    }

    public void aniadir(int valor){
        if (lista.size() < capacidadMaxima){
            lista.addFirst(valor);
        } else {
            lista.addFirst(valor);
            lista.removeLast();
        }

    }

    public int obtener(){
        int valor = lista.get(0);
        lista.remove(0);
        return valor;
    }
}
