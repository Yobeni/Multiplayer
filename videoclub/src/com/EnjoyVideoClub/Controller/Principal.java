package com.EnjoyVideoClub.Controller;

import com.EnjoyVideoClub.Model.Alquiler;
import com.EnjoyVideoClub.Model.Multimedia;
import com.EnjoyVideoClub.Model.Socio;
import com.EnjoyVideoClub.Views.VentanaMainGUI;

import javax.swing.*;
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
            archivo.crearFile();
            new VentanaMainGUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
