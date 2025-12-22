package org.josefeyjoo.hilos.ejerciciosok.ejercicio1;

import java.util.ArrayList;
import java.util.Random;

public class Escritor extends Thread {
    static private int contador = 1;
    int id;
    ArrayList<Integer> buffer = new ArrayList<>();

    public Escritor(ArrayList<Integer> buffer) {
        this.buffer = buffer;
        this.id = contador;
        contador++;
    }

    private void escribirArray(){
        int numero = buffer.get(0);
        for (int i = 0; i < buffer.size(); i++){
            buffer.set(i, numero+1);
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        int timing = random.nextInt(2,4);
        while (true){
            synchronized (buffer){
                try {
                    buffer.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("El hilo escritor: " + id + " va a escribir los numeros, el inicial era: " + buffer.get(0));
                escribirArray();
                System.out.println("El hilo escritor: " + id + " ha escrito el numero " + buffer.get(0));
                buffer.notifyAll();
                //Sleep FUERA del synchronized
                try {
                    sleep(timing * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                buffer.notifyAll();
            }
        }
    }
}
