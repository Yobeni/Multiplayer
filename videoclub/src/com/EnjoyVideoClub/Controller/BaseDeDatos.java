package com.EnjoyVideoClub.Controller;

import com.EnjoyVideoClub.Model.FormatoMultimedia;
import com.EnjoyVideoClub.Model.Multimedia;
import com.EnjoyVideoClub.Model.Videojuego;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BaseDeDatos {
    public static Connection connection = null;
    public static final String USER = "postgres";
    public static final String PASSWORD = "Intpl_1023";
    public static final String URL = "jdbc:postgresql://localhost:5432/";
    public static final String BASE_DE_DATOS = "Proyecto Programación - CinePlus Videoclub";
    public static final String DRIVER = "org.postgresql.Driver";

    public static void cargarVideojuegosDeLaBaseDeDatos(ArrayList<Multimedia> multimedias) {
        String consulta = "SELECT * FROM videojuego";
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + BASE_DE_DATOS, USER, PASSWORD);
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(consulta);
                while (resultSet.next()) {
                    String titulo = resultSet.getString("titulo");
                    String desarrollador = resultSet.getString("desarrollador");
                    String formatoString = resultSet.getString("formato");
                    String fechaString = resultSet.getString("fecha");
                    String plataformas = resultSet.getString("plataformas");

                    Date fecha = formatearFecha(fechaString);
                    FormatoMultimedia formato = comprobarFormatoMultimedia(formatoString);

                    Videojuego videojuego = new Videojuego(titulo, desarrollador, formato, fecha);
                    multimedias.add(videojuego);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void agregarMultimedia(String consulta) {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + BASE_DE_DATOS, USER, PASSWORD);
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(consulta);
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Date formatearFecha(String fecha) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat();
            return formato.parse(fecha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static FormatoMultimedia comprobarFormatoMultimedia(String formato) {
        return switch (formato) {
            case "CD" -> FormatoMultimedia.CD;
            case "DVD" -> FormatoMultimedia.DVD;
            case "BLURAY" -> FormatoMultimedia.BLURAY;
            case "ARCHIVO" -> FormatoMultimedia.ARCHIVO;
            default -> null;
        };
    }
}
