package com.EnjoyVideoClub.Model;

import com.EnjoyVideoClub.Controller.Constantes;
import java.util.ArrayList;
import java.util.Date;

public class Videojuego extends Multimedia {
    private ArrayList<PlataformaVideojuego> plataformas = new ArrayList<>();

    public Videojuego() {
        super();
    }

    public Videojuego(String titulo, String dev, FormatoMultimedia formato, Date date) {
        super(titulo, dev, formato, date);
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
