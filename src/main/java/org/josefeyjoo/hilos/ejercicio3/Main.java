package org.josefeyjoo.hilos.ejercicio3;

public class Main extends Thread {
    public static void main(String[] args) throws InterruptedException {
        ColaNumeros lista =  new ColaNumeros(5);
        GeneradorNumeros gn1 =  new GeneradorNumeros(lista);
        GeneradorNumeros gn2 =  new GeneradorNumeros(lista);
        GeneradorNumeros gn3 =  new GeneradorNumeros(lista);

        CalculadoraFactorial cf = new  CalculadoraFactorial(lista);
        gn1.start();
        gn2.start();
        gn3.start();
        cf.start();

        while(true){
            Thread.sleep(1000);
        }
    }
}
