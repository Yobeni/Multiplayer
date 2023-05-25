package com.EnjoyVideoClub.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alquiler {
    private Date fechaInicio;
    private Date fechaFin;
    private String nifSocio;
    private Multimedia tipoMultimedia;
    private String tituloMultimedia;
    private int precio;

    public Alquiler(Date fechaInicio, Date fechaFin, String nifSocio, Multimedia tipo, String titulo, int precio) {
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setNifSocio(nifSocio);
        setTipoMultimedia(tipo);
        setTituloMultimedia(titulo);
        setPrecio(precio);
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getNifSocio() {
        return nifSocio;
    }
    public void setNifSocio(String nifSocio) {
        this.nifSocio = nifSocio;
    }
    public Multimedia getTipoMultimedia() {
        return tipoMultimedia;
    }
    public void setTipoMultimedia(Multimedia tipoMultimedia) {
        this.tipoMultimedia = tipoMultimedia;
    }
    public String getTituloMultimedia() {
        return tituloMultimedia;
    }
    public void setTituloMultimedia(String tituloMultimedia) {
        this.tituloMultimedia = tituloMultimedia;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            throw new RuntimeException("El precio no puede ser menor que 0.");
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaInicio = formato.format(getFechaInicio());
        String fechaFin = formato.format(getFechaFin());
        return "--- DATOS DEL ALQUILER ---" +
                "\n > Tipo de multimedia: " + getTipoMultimedia().getClass().getSimpleName() +
                "\n > Título de la multimedia: " + getTituloMultimedia() +
                "\n > NIF del Socio que realiza el alquiler: " + getNifSocio() +
                "\n > Precio del alquiler: " + getPrecio() + ".00 €" +
                "\n > Fecha de inicio: " + fechaInicio +
                "\n > Fecha de finalización: " + fechaFin +
                "\n--- NO EXCEDER EL TIEMPO LÍMITE DEL ALQUILER ---" +
                "\n                 CinePlus Videoclub                  ";
    }
}
