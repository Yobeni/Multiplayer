package com.EnjoyVideoClub.Model;

import java.util.ArrayList;
import java.util.Date;

public class Videojuego extends Multimedia {
    private ArrayList<PlataformaVideojuego> plataformas = new ArrayList<>();
    public static ArrayList<Videojuego> videojuegosCreados = new ArrayList<>();


    public Videojuego() {
        super();
    }

    public Videojuego(String titulo, String dev, FormatoMultimedia formato, Date date) {
        super(titulo, dev, formato, date);
    }

    public ArrayList<PlataformaVideojuego> getPlataformas() {
        return plataformas;
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
