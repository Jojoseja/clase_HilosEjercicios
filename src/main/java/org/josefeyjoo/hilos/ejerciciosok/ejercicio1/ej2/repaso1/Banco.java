package org.josefeyjoo.hilos.ejerciciosok.ejercicio1.ej2.repaso1;

public class Banco {
    public static void main(String[] args) throws InterruptedException {
        Cuenta cuenta001 = new Cuenta(1000);
        Cliente cli001 = new Cliente("Carlos", cuenta001, 55);
        Cliente cli002 = new Cliente("Bea", cuenta001, 25);

        Thread hilo1 = new Thread(cli001, "Carlos");
        Thread hilo2 = new Thread(cli002, "Bea");

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();
    }
}
