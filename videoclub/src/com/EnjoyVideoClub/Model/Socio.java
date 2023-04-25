package com.EnjoyVideoClub.Model;

import com.EnjoyVideoClub.Controller.Constantes;
import com.EnjoyVideoClub.Model.Multimedia;

import java.util.ArrayList;
import java.util.Date;

public class Socio {
    private String NIF;
    private String nombre;
    private Date fechaNac;
    private String poblacion;

    private int dineroDeuda;
    public Socio() {
        setNIF(Constantes.NIF_DEFAULT);
        setNombre(Constantes.NOMBRE_DEFAULT);
        setPoblacion(Constantes.POBLACION_DEFAULT);
        setFechaNac(Constantes.FECHA_NACIMIENTO_DEFAULT);

    }
    public Socio(String NIF,String nombre,Date fechaNac,String poblacion) {
        setNIF(NIF);
        setFechaNac(fechaNac);
        setPoblacion(poblacion);
        setNombre(nombre);
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
    public int getDineroDeuda() {
        return dineroDeuda;
    }

    public void setDineroDeuda(int dineroDeuda) {
        this.dineroDeuda = dineroDeuda;
    }
    public boolean mayorDeEdad(int edad) {
        boolean comp = false;
        if (edad<18) {
            comp = false;
        } else {
            comp = true;
        }
        return comp;
    }
    public void alquilar(Multimedia multimedia, ArrayList<Multimedia> multimediaAlquilado) throws Exception{
        if (getDineroDeuda()<0) {
            throw new Exception("No puede alquilar si tiene deudas!");
        } else {
            multimediaAlquilado.add(multimedia);
        }
    }
    public void devolver(Multimedia multimedia,ArrayList<Multimedia> multimediaAlquilado) {
        for (int i = 0; i < multimediaAlquilado.size(); i++) {
            if (multimediaAlquilado.get(i).equals(multimedia)) {
                multimediaAlquilado.remove(i);
            }
        }
    }

    public void pagarRecargo(int dineroDeuda) {
        if (getDineroDeuda()<0) {
            System.out.println("No tiene ningún deuda");
        } else {
            setDineroDeuda(dineroDeuda-getDineroDeuda());
        }
    }

    @Override
    public String toString() {
        return "------------------\nNIF: " + getNIF() + "\nNombre: " + getNombre()
                +"\nPoblación: " + getPoblacion() + "\nFecha Nacimiento: "
                + getFechaNac() + "\nDinero deuda: " + getDineroDeuda()
                + "\n------------------";
    }
}
