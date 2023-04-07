package com.EnjoyVideoClub.Controller;

import java.util.Date;

public class Socio {
    private String NIF;
    private String nombre;
    private Date fechaNac;
    private String poblacion;
    public Socio() {
        setNIF(Constantes.defaultNIF);
        setNombre(Constantes.defaultNombre);
        setPoblacion(Constantes.defaultPoblacion);
        setFechaNac(Constantes.defaultFechaNac);
    }
    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

}
