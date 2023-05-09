package com.EnjoyVideoClub.Controller;

import com.EnjoyVideoClub.Model.*;
import com.EnjoyVideoClub.Views.CrearVideojuegoGUI;

import java.awt.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("CLASE PRINCIPAL");
        ArrayList<Multimedia> listaMultimedia = new ArrayList<Multimedia>();
        listaMultimedia.add(crearVideojuego());
        listaMultimedia.add(creaPelicula());

        for (int i = 0;i<listaMultimedia.size();i++){
            System.out.println(listaMultimedia.get(i).toString());
        }

        new CrearVideojuegoGUI();
    }

    public static Videojuego crearVideojuego(){
        Date  d = new Date(12/32/2423);

        Videojuego v = new Videojuego("Tetris", "Pepe", FormatoMultimedia.CD,d);
        v.añadirPlataformas(PlataformaVideojuego.PC);
        v.añadirPlataformas(PlataformaVideojuego.PS5);

        return v;
    }

    public static Pelicula creaPelicula(){
        Date  d = new Date(12/32/2423);

        Pelicula p = new Pelicula("Los minions","Dory",FormatoMultimedia.CD,d,120,"Juan","Pedro");

        return p;
    }

    public static Disco creaDisco(){
        return null;
    }
}
