package com.EnjoyVideoClub.Controller;

import com.EnjoyVideoClub.Model.Alquiler;
import com.EnjoyVideoClub.Model.Multimedia;
import com.EnjoyVideoClub.Model.Socio;
import com.EnjoyVideoClub.Views.VentanaMainGUI;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {
    public static ArrayList<Multimedia> multimedias = new ArrayList<>();
    public static ArrayList<Socio> socios = new ArrayList<>();
    public static ArrayList<Alquiler> alquileres = new ArrayList<>();

    public static void main(String[] args) {
        try {
            BaseDeDatos.cargarVideojuegosDeLaBaseDeDatos(multimedias);
            BaseDeDatos.cargarPeliculasDeLaBaseDeDatos(multimedias);
            BaseDeDatos.cargarDiscosDeLaBaseDeDatos(multimedias);
            BaseDeDatos.cargarSociosDeLaBaseDeDatos(socios);
            BaseDeDatos.cargarAlquileresDeLaBaseDeDatos(alquileres);
            for (Socio socio : socios) {
                System.out.println(socio);
            }

            for (Alquiler alquiler : alquileres) {
                System.out.println(alquiler);
            }
            new VentanaMainGUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        archivo.crearFile();
    }
}
