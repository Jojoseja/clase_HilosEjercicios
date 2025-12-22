package org.josefeyjoo.hilos.ejerciciosok.ejercicio3;

public class Reserva {
    private Usuario usuario;
    private Sala sala;
    private int horaInicio;
    private int horaFinal;

    public Reserva() {
    }

    public Reserva(Usuario usuario, Sala sala, int horaInicio, int horaFinal) {
        this.usuario = usuario;
        this.sala = sala;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }


    // Getter & Setter and toString

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) throws HoraNoValida{
        if (horaFinal <= horaInicio || horaInicio >= 23 || 0 > horaInicio){
            throw new HoraNoValida("La hora de inicio no es valida");
        } else {
            this.horaInicio = horaInicio;
        }
    }

    public int getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(int horaFinal) throws HoraNoValida {
        if (horaInicio >= horaFinal || horaFinal > 23 || 0 >= horaFinal){
            throw new HoraNoValida("La hora final no es valida");
        } else {
            this.horaFinal = horaFinal;
        }
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "usuario=" + usuario +
                ", sala=" + sala +
                ", horaInicio=" + horaInicio +
                ", horaFinal=" + horaFinal +
                '}';
    }
}
