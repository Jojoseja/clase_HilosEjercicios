package org.josefeyjoo.hilos.ejerciciosok.ejercicio1;

import java.util.ArrayList;
import java.util.Random;

public class Lector extends Thread{
    static private int contador = 1;
    int id;
    ArrayList<Integer> buffer = new ArrayList<>();;

    public Lector(ArrayList<Integer> buffer) {
        this.buffer = buffer;
        this.id = contador;
        contador++;
    }

    private boolean leerArray(){
        int leido = buffer.get(0);
        for (int numero : buffer){
            if (!(leido ==numero)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        Random random = new Random();
        int timing = random.nextInt(2,4);
        while (true) {
            //Objeto sincronizado buffer (es importante introducir en todos la misma referencia (el mismo ArrayList))
            synchronized (buffer) {
                System.out.println("El hilo lector " + id + " va a leer");
                if (leerArray()) {
                    System.out.println("Se ha leido correctamente el numero " + buffer.get(0));
                } else {
                    System.out.println("Ha ocurrido un problema");
                }
                //Una vez terminada la lectura notifica a todos los hilos
                buffer.notifyAll();
            }
            //Sleep FUERA del synchronized
            try {
                sleep(timing * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
