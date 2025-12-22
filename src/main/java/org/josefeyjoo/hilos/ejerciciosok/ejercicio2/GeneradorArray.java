package org.josefeyjoo.hilos.ejerciciosok.ejercicio2;

public class GeneradorArray {

    public static int[] generarArray(){
        int[] tabla = new int[1000000];
        int posicion = (int) (Math.random() * 1000000);
        System.out.printf("La posición del 1 es: %d \n", posicion);
        for (int i=0;i<tabla.length;i++) {
            if (i==posicion)
                tabla[i]=1;
            else
                tabla[i]=0;
        }
        return tabla;
    }
}
