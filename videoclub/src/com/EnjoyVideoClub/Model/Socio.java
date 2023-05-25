package com.EnjoyVideoClub.Model;

import com.EnjoyVideoClub.Controller.Constantes;

import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("ALL")

/**
 * @author : Haida Li
 */
public class Socio {
    private String NIF;
    private String nombre;
    private String apellidos;
    private Date fechaNac;
    private String poblacion;
    private int dineroDeuda;

    public static ArrayList <Socio> arrayListSocio = new ArrayList<>();
    /*
    Constructor por defecto de la clase Socio. Los constantes que usa viene de la clase Constantes.
     */
    public Socio() {
        setNIF(Constantes.NIF_DEFAULT);
        setNombre(Constantes.NOMBRE_DEFAULT);
        setPoblacion(Constantes.POBLACION_DEFAULT);
        setFechaNac(Constantes.FECHA_NACIMIENTO_DEFAULT);
        setApellidos(Constantes.APELLIDOS_DEFAULT);
    }

    /**
     *
     * @param NIF String que define el NIF del socio.
     * @param nombre String que define el nombre del socio.
     * @param fechaNac Date que define el fecha de nacionmiento del socio.
     * @param poblacion String que define la población del socio.
     * @param apellidos String que define los apellidos del socio.
     */
    public Socio(String NIF,String nombre,Date fechaNac,String poblacion,String apellidos) {
        setNIF(NIF);
        setFechaNac(fechaNac);
        setPoblacion(poblacion);
        setNombre(nombre);
        setApellidos(apellidos);
    }

    /**
     * Getter que retorna el NIF del socio.
     * @return El método retorna el el String NIF.
     */
    public String getNIF() {
        return NIF;
    }
    /**
     * Método setter de NIF del Socio.
     * @param NIF. Variable de tipo String que actualiza el valor del NIF de la clase socio.
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }
    /**
     * Getter que retorna el nombre del socio.
     * @return  El método retorna un String
     */
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
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDineroDeuda(int dineroDeuda) {
        this.dineroDeuda = dineroDeuda;
    }
    public ArrayList<Socio> getArrayListSocio() {
        return arrayListSocio;
    }

    public void setArrayListSocio(ArrayList<Socio> arrayListSocio) {
        this.arrayListSocio = arrayListSocio;
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

    public boolean equals(String nif) {
        return this.NIF.equals(nif);
    }
}
