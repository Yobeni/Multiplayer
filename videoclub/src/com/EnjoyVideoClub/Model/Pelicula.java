package com.EnjoyVideoClub.Model;

import java.util.Date;

public class Pelicula extends Multimedia{
    private double duracionPelicula;
    private String actorPrincipaL;
    private String actrizPrincipal;
    private String tipo;

    public double DURACION_DEFAULT = 0;
    public String ACTOR_DEFAULT = "";
    public String ACTRIZ_DEFAULT = "";

    Pelicula(){
        super();
        duracionPelicula = DURACION_DEFAULT;
        actorPrincipaL = ACTOR_DEFAULT;
        actrizPrincipal = ACTRIZ_DEFAULT;
        comprobarTipo();
    }

    Pelicula(String titulo, String dev, FormatoMultimedia formato, Date date, double duracionPelicula, String actorPrincipaL, String actrizPrincipal){
        super(titulo, dev, formato, date);
        setDuracionPelicula(duracionPelicula);
        setActorPrincipaL(actorPrincipaL);
        setActrizPrincipal(actrizPrincipal);
        comprobarTipo();
    }

    public double getDuracionPelicula() {
        return duracionPelicula;
    }
    public void setDuracionPelicula(double duracionPelicula) {
        if (duracionPelicula > 0){
            this.duracionPelicula = duracionPelicula;
        } else{
            throw new RuntimeException("La duración debe ser mayor que 0");
        }
    }

    public String getActorPrincipaL() {
        return actorPrincipaL;
    }
    public void setActorPrincipaL(String actorPrincipaL) {
        this.actorPrincipaL = actorPrincipaL;
    }

    public String getActrizPrincipal() {
        return actrizPrincipal;
    }
    public void setActrizPrincipal(String actrizPrincipal) {
        this.actrizPrincipal = actrizPrincipal;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }

    public void comprobarTipo(){
        if(duracionPelicula <= 30){
            setTipo("Cortometraje");
        } else {
            setTipo("Largometraje");
        }
    }

    @Override
    public String toString() {
        String s = super.toString() + "Duracion de la pelicula: " + getDuracionPelicula() + "\nActor principal: "
                + getActorPrincipaL() + "\nActriz principal: " + getActrizPrincipal();
        return s;
    }
}
