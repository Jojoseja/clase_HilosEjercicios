package org.josefeyjoo.hilos.ejerciciosejemplos.relevos;

import java.util.ArrayList;

public class Relevos {
    public static void main(String[] args) throws InterruptedException {
        //Lista Corredores
        ArrayList<Corredor> corredores = new ArrayList<>();

        //Bucle para crear los corredores
        for (int i = 0; i < 4; i++){
            corredores.add(new Corredor(i+1));
        }

        //Iniciar los hilos
        for (Corredor corredor : corredores) {
            corredor.start();
        }

        //"Obliga a los hilos a terminar para continuar el proceso"
        for (Corredor corredor : corredores) {
            corredor.join();
        }

        System.out.println("La carrera ha terminado");
    }
}


