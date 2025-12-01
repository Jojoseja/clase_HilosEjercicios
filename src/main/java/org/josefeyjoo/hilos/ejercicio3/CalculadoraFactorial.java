package org.josefeyjoo.hilos.ejercicio3;

import java.util.Random;

public class CalculadoraFactorial extends Thread{
    ColaNumeros lista =  new ColaNumeros();
    public CalculadoraFactorial() {}

    public CalculadoraFactorial(ColaNumeros lista) {
        this.lista = lista;
    }

    public int returnFactorial(int valor){
        int total = 1;
        for (int i = 1; i <= valor; i++) {
            total *= i;
        }
        return total;
    }

    @Override
    public void run() {
        while (true){
            Random random = new Random();
            int timing = random.nextInt(1,3);
            try {
                synchronized (lista){
                    while (lista.getLista().isEmpty()){
                        System.out.println("Esperando");
                        lista.wait();
                    }
                    int valor = lista.obtener();
                    System.out.println("El factorial de " + valor + " es " + returnFactorial(valor));
                    lista.notifyAll();
                }
                Thread.sleep(timing * 1000);
                System.out.println("Calculadora: Durmiendo durante : " + timing + " segundos" );
            } catch ( Exception e ) {
                System.out.println(e.getMessage());
            }
        }
    }
}
