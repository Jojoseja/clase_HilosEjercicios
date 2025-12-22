package org.josefeyjoo.hilos.ejerciciosejemplos.relevos;

public class Corredor extends Thread {
    int id;
    private static final Object lock = new Object();

    public Corredor(int id) {
        this.id = id;
    }


    public void run() {
        synchronized (Corredor.lock) {
            try {
                System.out.println("El corredor " + this.id + " ha cogido el testigo");
                Thread.sleep(1000);
                System.out.println("El corredor " + this.id + " ha dejado de correr");
                lock.notifyAll();
            } catch (InterruptedException e) {
                System.err.println("El corredor " + this.id + " ha sufrido un error! :" + e.getMessage());
            }
        }
    }
}
