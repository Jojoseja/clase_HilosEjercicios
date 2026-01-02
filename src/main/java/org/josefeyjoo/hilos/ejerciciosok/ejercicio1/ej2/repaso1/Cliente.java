package org.josefeyjoo.hilos.ejerciciosok.ejercicio1.ej2.repaso1;

import static java.lang.Thread.sleep;

public class Cliente implements Runnable{
    //Atributos por defecto
    String nombre;
    Cuenta cuenta;
    //Cantidad que va a retirar cada vez
    int cantidad;
    //Total de cantidad retirada
    int total;

    public Cliente(String nombre, Cuenta cuenta, int cantidad) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (cuenta){
                if (!cuenta.comprobarCantidad(cantidad)) {
                    cuenta.notifyAll();
                    System.out.println("Cosorro");
                    return;
                } else {
                    cuenta.restarSaldo(cantidad);
                    cuenta.notifyAll();
                    try {
                        cuenta.wait(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


            }
            try {
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
