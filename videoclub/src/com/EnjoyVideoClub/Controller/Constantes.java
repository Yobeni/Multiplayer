
package com.EnjoyVideoClub.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.EnjoyVideoClub.Model.Cancion;
import com.EnjoyVideoClub.Model.FormatoMultimedia;
import com.EnjoyVideoClub.Model.PlataformaVideojuego;

public class Constantes {
    //
    public static final String NIF_DEFAULT = "";
    public static final String NOMBRE_DEFAULT = "";
    public static final String POBLACION_DEFAULT = "";
    public static final Date FECHA_NACIMIENTO_DEFAULT = new Date(2005 - 1 - 1);
    public static final String TITULO_DEFAULT = "";
    public static final Date FECHA_PUBLICACION_DEFAULT = new Date(2000);
    public static final FormatoMultimedia FORMATO_DEFAULT = FormatoMultimedia.CD;
    public static final PlataformaVideojuego PLATAFORMA_DEFAULT = PlataformaVideojuego.PC;

    public static final String[] COLABORADORES_DEFAULT ={};
    public static final double DURACION_DEFAULT = 0.00;
    public static final ArrayList<Cancion> CANCIONES_DEFAULT= null;

}
