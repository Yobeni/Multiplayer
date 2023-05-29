package com.EnjoyVideoClub.Model;

import com.EnjoyVideoClub.Controller.Constantes;

import java.util.ArrayList;
import java.util.Date;

public class Pelicula extends Multimedia{
    private int duracionPelicula;
    private String actorPrincipaL;
    private String actrizPrincipal;

    public Pelicula(){
        super();
        duracionPelicula = Constantes.DURACION_DEFAULT_PELICULA;
        actorPrincipaL = Constantes.ACTOR_DEFAULT;
        actrizPrincipal = Constantes.ACTRIZ_DEFAULT;
    }

    public Pelicula(String titulo, String dev, FormatoMultimedia formato, Date date, int duracionPelicula, String actorPrincipaL, String actrizPrincipal){
        super(titulo, dev, formato, date);
        setDuracionPelicula(duracionPelicula);
        setActorPrincipaL(actorPrincipaL);
        setActrizPrincipal(actrizPrincipal);
    }

    public int getDuracionPelicula() {
        return duracionPelicula;
    }
    public void setDuracionPelicula(int duracionPelicula) {
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


    @Override
    public String toString() {
        String s = super.toString() + "\n Duracion de la pelicula: " + getDuracionPelicula() + "\n Actor principal: "
                + getActorPrincipaL() + "\n Actriz principal: " + getActrizPrincipal();
        return s;
    }
}
