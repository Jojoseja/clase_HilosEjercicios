package org.josefeyjoo.hilos.ejerciciosok.ejercicio1.ej2.repaso1;

public class Cuenta {
    //Atributos Ejercicio
    int saldo;
    int numeroReintegros = 0;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    //Metodos por defecto
    public int devolverSaldo(){
        System.out.printf("El saldo es de: %d \n", saldo);
        return this.saldo;
    }

    public void restarSaldo(int cantidad){
        if (comprobarCantidad(cantidad)){
            System.out.printf("El saldo es de: %d, al restarle %d el saldo queda en: %d \n", saldo, cantidad, saldo-cantidad);
            this.saldo = saldo-cantidad;
            this.numeroReintegros++;
            System.out.printf("La cantidad de reintegros de esta cuenta es de: %d \n", numeroReintegros);
        } else {
            System.out.println("No hay suficente dinero en la cuenta");
        }
    }

    public boolean comprobarCantidad(int cantidad){
        return cantidad <= saldo;
    }
}
