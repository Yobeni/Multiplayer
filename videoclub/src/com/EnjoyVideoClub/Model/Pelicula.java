package com.EnjoyVideoClub.Model;

import java.util.Date;

public class Pelicula extends Multimedia{
    private double duracionPelicula;
    private String actorPrincipaL;
    private String actrizPrincipal;

    public double DURACION_DEFAULT = 0;
    public String ACTOR_DEFAULT = "";
    public String ACTRIZ_DEFAULT = "";

    Pelicula(){
        super();
        duracionPelicula = DURACION_DEFAULT;
        actorPrincipaL = ACTOR_DEFAULT;
        actrizPrincipal = ACTRIZ_DEFAULT;
    }

    Pelicula(String titulo, String dev, FormatoMultimedia formato, Date date, double duracionPelicula, String actorPrincipaL, String actrizPrincipal){
        super(titulo, dev, formato, date);
        setDuracionPelicula(duracionPelicula);
        setActorPrincipaL(actorPrincipaL);
        setActrizPrincipal(actrizPrincipal);
    }

    public double getDuracionPelicula() {
        return duracionPelicula;
    }
    public void setDuracionPelicula(double duracionPelicula) {
        this.duracionPelicula = duracionPelicula;
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

    @Override
    public String toString() {
        String s = super.toString() + "Duracion de la pelicula: " + getDuracionPelicula() + "\nActor principal: "
                + getActorPrincipaL() + "\nActriz principal: " + getActrizPrincipal();
        return s;
    }
}
