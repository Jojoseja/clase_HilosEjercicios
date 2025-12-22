package org.josefeyjoo.hilos.ejercicio3;

import java.util.Random;

public class GeneradorNumeros extends Thread {
    private ColaNumeros lista;

    public GeneradorNumeros(ColaNumeros lista) {
        this.lista = lista;
    }

    public int randomNum(){
        Random rand = new Random();
        return rand.nextInt(1,11);
    }

    @Override
    public void run() {
        while (true) {
            Random random = new Random();
            int timing = random.nextInt(2,4);
            try {
                synchronized (lista) {
                    lista.aniadir(this.randomNum());
                    System.out.println(lista.toString());
                    lista.notifyAll();
                }
                Thread.sleep(timing * 1000);
                System.out.println("GeneradorNumeros: Durmiendo durante : " + timing + " segundos" );
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
