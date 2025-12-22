package org.josefeyjoo.hilos.ejerciciosok.ejercicio3;

import java.util.ArrayList;

public class Ejercicio3Main {
    public static void main(String[] args) {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Sala> listaSalas = new ArrayList<>();

        //Usuarios
        Usuario usu01 = new Usuario("Alberto");
        listaUsuarios.add(usu01);
        Usuario usu02 = new Usuario("Beatriz");
        listaUsuarios.add(usu02);
        Usuario usu03 = new Usuario("Carlos");
        listaUsuarios.add(usu03);

        //Salas
        Sala sala01 = new Sala("Principal", 40);
        listaSalas.add(sala01);


    }
}
