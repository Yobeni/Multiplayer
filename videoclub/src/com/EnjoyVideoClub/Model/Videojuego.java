package com.EnjoyVideoClub.Model;

import com.EnjoyVideoClub.Controller.Constantes;

import java.util.ArrayList;
import java.util.Date;

public class Videojuego extends Multimedia {
    private ArrayList<PlataformaVideojuego> plataformas = new ArrayList<>();
    public static ArrayList<Videojuego> videojuegosCreados = new ArrayList<>();
    private int duracion;


    public Videojuego() {
        super();
        setDuracion(Constantes.DURACION_VIDEOJUEGO_DEFAULT);
    }

    public Videojuego(String titulo, String dev, FormatoMultimedia formato, Date date, int duracion) {
        super(titulo, dev, formato, date);
        setDuracion(duracion);
    }

    public ArrayList<PlataformaVideojuego> getPlataformas() {
        return plataformas;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion >= 0) {
            this.duracion = duracion;
        } else {
            throw new RuntimeException("La duración no puede ser menor o igual a las 0 horas");
        }
    }

    public void añadirPlataformas(PlataformaVideojuego plataformaVideojuego) {
        plataformas.add(plataformaVideojuego);
    }

    public String recorrerPlataformas(ArrayList<PlataformaVideojuego> plataformas) {
        String info = "\n";
        for (PlataformaVideojuego plataforma : plataformas) {
            info += "  - " + plataforma.toString() + "\n";
        }
        return info;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Plataformas: " + recorrerPlataformas(plataformas);
    }
}
