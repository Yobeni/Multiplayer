package com.EnjoyVideoClub.Model;

import com.EnjoyVideoClub.Controller.Constantes;

import java.util.ArrayList;
import java.util.Date;

public class Cancion extends Multimedia{
    private ArrayList<String> colaboradores;
    private double duracion;
    public static ArrayList<Cancion> cancionesCreadas = new ArrayList<>();

    public Cancion() {
        super();
        this.colaboradores = Constantes.COLABORADORES_DEFAULT;
        this.duracion = Constantes.DURACION_DEFAULT;
    }

    public Cancion(String titulo, String nombreAutor, FormatoMultimedia formato, Date año, ArrayList<String> colaboradores, double duracion) {
        super(titulo, nombreAutor, formato, año);
        this.colaboradores = colaboradores;
        setDuracion(duracion);
    }

    public ArrayList<String> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(ArrayList<String> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        if (duracion >= 0){
            this.duracion = duracion;
        } else{
            throw new RuntimeException("La duración no puede ser negativa");
        }
    }

    public String mostrarColaboradores(){
        String infoColaboradores="-- COLABORADORES DE LA CANCIÓN --\n";
        for (String colaborador : this.colaboradores) {
            infoColaboradores += colaborador + "\n";
        }
        return infoColaboradores;
    }

    @Override
    public String toString() {
        return (super.toString()+"\n--- DATOS DE LA CANCIÓN ---" +
                "\n Duración de la canción: " + getDuracion() +
                "\n  " + mostrarColaboradores());
    }
}
