package com.EnjoyVideoClub.Model;

import com.EnjoyVideoClub.Controller.Constantes;
import java.util.ArrayList;
import java.util.Date;

public class Videojuego extends Multimedia {
    private ArrayList<PlataformaVideojuego> plataformas;
    private PlataformaVideojuego plataforma;

    public Videojuego() {
        super();
        setPlataforma(Constantes.PLATAFORMA_DEFAULT);
        plataformas.add(getPlataforma());
    }

    public Videojuego(String titulo, String dev, FormatoMultimedia formato, Date date, PlataformaVideojuego plataforma) {
        super(titulo, dev, formato, date);
        setPlataforma(plataforma);
        plataformas.add(getPlataforma());
    }

    public void setPlataforma(PlataformaVideojuego plataforma) {
        this.plataforma = plataforma;
    }

    public PlataformaVideojuego getPlataforma() {
        return plataforma;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  Plataforma: " + getPlataforma();
    }
}
