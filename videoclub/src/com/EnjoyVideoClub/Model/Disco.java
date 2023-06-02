package com.EnjoyVideoClub.Model;

import com.EnjoyVideoClub.Controller.Constantes;

import java.util.ArrayList;
import java.util.Date;

public class Disco extends Multimedia{
    private double duracionTotal;
    private ArrayList<Cancion> canciones;

    public static ArrayList<Disco> discosCreados = new ArrayList<>();

    public Disco() {
        super();
        this.duracionTotal = Constantes.DURACION_DEFAULT;
        this.canciones = Constantes.CANCIONES_DEFAULT;
    }

    public Disco(String titulo, String nombreAutor, FormatoMultimedia formato, Date año, double duracion, ArrayList<Cancion> canciones) {
        super(titulo, nombreAutor, formato, año);
        setDuracionTotal(duracion);
        setCanciones(canciones);
    }

    public double getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(double duracionTotal) {
        if (duracionTotal >= 0){
            this.duracionTotal = duracionTotal;
        } else{
            throw new RuntimeException("La duración no puede ser negativa");
        }
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public String mostrarCanciones(){
        String infoCanciones="\n-- CANCIONES DEL DISCO --\n";

        for (int i = 0;i< this.canciones.size();i++){
            infoCanciones+=canciones.get(i).getTitulo()+"\n";
        }
        return infoCanciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return (super.toString()+"\n--- DATOS DEL DISCO ---" +
                "\n Duración total del disco: " + getDuracionTotal() +
                "\n Canciones: " + mostrarCanciones());
    }
}
