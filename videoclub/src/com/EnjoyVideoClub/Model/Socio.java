package com.EnjoyVideoClub.Model;

import com.EnjoyVideoClub.Controller.Constantes;

import java.text.SimpleDateFormat;
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
    private String passwd;

    /*
    Constructor por defecto de la clase Socio. Los constantes que usa viene de la clase Constantes.
     */
    public Socio() {
        setNIF(Constantes.NIF_DEFAULT);
        setNombre(Constantes.NOMBRE_DEFAULT);
        setPoblacion(Constantes.POBLACION_DEFAULT);
        setFechaNac(Constantes.FECHA_NACIMIENTO_DEFAULT);
        setApellidos(Constantes.APELLIDOS_DEFAULT);
        setPasswd(Constantes.PASSWD_DEFAULT);
    }

    /**
     * @param NIF       String que define el NIF del socio.
     * @param nombre    String que define el nombre del socio.
     * @param fechaNac  Date que define el fecha de nacionmiento del socio.
     * @param poblacion String que define la población del socio.
     * @param apellidos String que define los apellidos del socio.
     * @param passwd    String que define la contraseña del socio
     */
    public Socio(String NIF, String nombre, Date fechaNac, String poblacion, String apellidos, String passwd) {
        setNIF(NIF);
        setFechaNac(fechaNac);
        setPoblacion(poblacion);
        setNombre(nombre);
        setApellidos(apellidos);
        setPasswd(passwd);
    }

    /**
     * Getter que retorna el NIF del socio.
     *
     * @return El método retorna el el String NIF.
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * Método setter de NIF del Socio.
     *
     * @param NIF. Variable de tipo String que actualiza el valor del NIF de la clase socio.
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    /**
     * Getter que retorna el nombre del socio.
     *
     * @return El método retorna un String
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }


    public void alquilar(Multimedia multimedia, ArrayList<Multimedia> multimediaAlquilado) throws Exception {
        if (getDineroDeuda() < 0) {
            throw new Exception("No puede alquilar si tiene deudas!");
        } else {
            multimediaAlquilado.add(multimedia);
        }
    }

    public void devolver(Multimedia multimedia, ArrayList<Multimedia> multimediaAlquilado) {
        for (int i = 0; i < multimediaAlquilado.size(); i++) {
            if (multimediaAlquilado.get(i).equals(multimedia)) {
                multimediaAlquilado.remove(i);
            }
        }
    }

    public void pagarRecargo(int dineroDeuda) {
        if (getDineroDeuda() < 0) {
            System.out.println("No tiene ningún deuda");
        } else {
            setDineroDeuda(dineroDeuda - getDineroDeuda());
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        String fecha = format.format(getFechaNac());
        return "---SOCIO---\nNIF: " + getNIF() + "\nNombre: " + getNombre()
                + "\nApellidos: " + getApellidos() + "\nPoblación: " + getPoblacion() + "\nFecha Nacimiento: "
                + fecha + "\nDinero deuda: " + getDineroDeuda()
                + "\n------------------";
    }

    public boolean equals(String nif) {
        return this.NIF.equals(nif);
    }
}
