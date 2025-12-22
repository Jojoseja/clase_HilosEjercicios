package org.josefeyjoo.hilos.ejerciciosok.ejercicio3;

import java.util.ArrayList;

public class SistemaReservas {
    ArrayList<Reserva> listaReservas = new ArrayList<>();


    public synchronized void reservarSala(Usuario usu, Sala sala){
        int genteReservar = usu.randomGente();
        if (sala.intenarReservar(genteReservar)){
            Reserva res = new Reserva();
            res.setUsuario(usu);
            res.setSala(sala);
            while (true) {
                try {
                    res.setHoraInicio(usu.randomHora());
                    res.setHoraInicio(usu.randomHora());
                    break;
                } catch (HoraNoValida e){
                    System.out.println("El usuario: " + usu.getNombre() + " no sabe de horas");
                }
            }
            sala.setReservado(true);
            listaReservas.add(res);
        } else {
            System.out.println("El usuario: " + usu.getNombre() + " no ha podido reservar la sala: " + sala.getNombre());
        }
    }
}
