package com.EnjoyVideoClub.Model;

import com.EnjoyVideoClub.Controller.Constantes;
import java.util.Date;

@SuppressWarnings("ALL")

/**
 * @author: Cristian Rodriguez.
 * Clase Multimedia.
 */
public class Multimedia {
    private String titulo;
    private String nombreAutor;
    private FormatoMultimedia formato;
    private Date año;

    /**
     * Cosntructor por defecto de la clase. Utiliza las variables por defecto creadas en la clase "Constantes".
     */
    public Multimedia() {
        setTitulo(Constantes.TITULO_DEFAULT);
        setNombreAutor(Constantes.NOMBRE_DEFAULT);
        setFormato(Constantes.FORMATO_DEFAULT);
        setAño(Constantes.FECHA_PUBLICACION_DEFAULT);
    }

    /**
     * Constructor con parámetros de la clase.
     * @param titulo. String que define el título del objeto Multimedia a crear.
     * @param nombreAutor. String el cual define el nombre del autor/director del objeto a crear.
     * @param formato. Instancia de la clase enum "FormatoMultimedia", la cual define el tipo de formato que el objeto
     *                 tendrá dentro de las opciones posibles.
     * @param año. Objeto tipo Date que define el año de la publicación del objeto Multimedia.
     */
    public Multimedia(String titulo, String nombreAutor, FormatoMultimedia formato, Date año) {
        setTitulo(titulo);
        setNombreAutor(nombreAutor);
        setFormato(formato);
        setAño(año);
    }

    /**
     * Método setter del título.
     * @param titulo. Recibe un parámetro de una varuable tipo String, el cuál será el valor para la variable título
     *                de la clase.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método getter del título.
     * @return El valor depositado en la variable de instancia "título".
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método setter del nombre del autor/director.
     * @param nombreAutor. Variable de tipo String que será depositado en la variable de instancia nombreAutor de ésta
     *                     clase.
     */
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    /**
     * Método getter del nombre del autor/director.
     * @return Valor que contiene la variable "nombreAutor".
     */
    public String getNombreAutor() {
        return nombreAutor;
    }

    /**
     * Método setter de la variable formato.
     * @param formato. Objeto de la clase enum, el cuál será el formato de reproducción de un objeto de la clase
     *                 Multimedia.
     */
    public void setFormato(FormatoMultimedia formato) {
        this.formato = formato;
    }

    /**
     * Método getter del formato.
     * @return El tipo de formato del objeto Multimedia.
     */
    public FormatoMultimedia getFormato() {
        return formato;
    }

    /**
     * Método setter de la fecha de publicación.
     * @param año. Objeto de tipo Date, el cuál será usado para indicar la fecha en la que se publicó la Multimedia
     *             creada.
     */
    public void setAño(Date año) {
        this.año = año;
    }

    /**
     * Método getter del año de publicación.
     * @return Fecha de publicación del objeto Multimedia.
     */
    public Date getAño() {
        return año;
    }

    /**
     * Sobreescritura del método toString. Con éste método se podrá visualizar la información de un objeto Multimedia.
     * @return String que contiene la información de un objeto Multimedia, de forma clara y fácil de leer.
     */
    @Override
    public String toString() {
        return "--- DATOS DE LA MULTIMEDIA ---" +
                "\n Tipo: " + getClass().getSimpleName() +
                "\n Titulo: " + getTitulo() +
                "\n Nombre del autor/director: " + getNombreAutor() +
                "\n Formato: " + getFormato() +
                "\n Fecha de publicacion: " + getAño();
    }

    /**
     * Sobrecarga del método equals. Con éste método se podrán comparar dos objetos.
     * @param titulo. Compara el título pasado por parámetro con el titulo del objeto.
     * @param nombreAutor. Compara el nombre del autor pasado por parámetro con el nombre del autor del objeto.
     * @return True en caso de que tanto el nombre del autor como el título coincidan con los del objeto. False en caso
     *         contrario.
     */
    public boolean equals(String titulo, String nombreAutor) {
        return this.getNombreAutor().equals(nombreAutor) && this.getTitulo().equals(titulo);
    }
}
