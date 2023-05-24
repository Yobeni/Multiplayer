package com.EnjoyVideoClub.Controller;

import com.EnjoyVideoClub.Model.FormatoMultimedia;
import com.EnjoyVideoClub.Model.Multimedia;
import com.EnjoyVideoClub.Model.Pelicula;
import com.EnjoyVideoClub.Model.Videojuego;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class BaseDeDatos {
    public static Connection connection = null;
    public static final String USER = "postgres";
    public static final String PASSWORD = "Qerrassa";
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
                    int duracion = resultSet.getInt("duracion");

                    FormatoMultimedia formato = comprobarFormatoMultimedia(formatoString);
                    Date fecha = formatearFecha(fechaString);
                    Videojuego videojuego = new Videojuego(titulo, desarrollador, formato, fecha, duracion);
                    multimedias.add(videojuego);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cargarPeliculasDeLaBaseDeDatos(ArrayList<Multimedia> multimedias) {
        String consulta = "SELECT * FROM pelicula";
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + BASE_DE_DATOS, USER, PASSWORD);
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(consulta);
                while (resultSet.next()) {
                    String titulo = resultSet.getString("titulo");
                    String director = resultSet.getString("director");
                    String formatoString = resultSet.getString("formato");
                    String fechaString = resultSet.getString("fecha");
                    int duracion = resultSet.getInt("duracion");
                    String actorPrincipal = resultSet.getString("actor_p");
                    String actrizPrincipal = resultSet.getString("actriz_p");

                    Date fecha = formatearFecha(fechaString);
                    FormatoMultimedia formato = comprobarFormatoMultimedia(formatoString);

                    Pelicula pelicula = new Pelicula(titulo, director, formato, fecha, duracion,actorPrincipal,
                            actrizPrincipal);
                    multimedias.add(pelicula);
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
            DateFormat formato = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            Date date = formato.parse(fecha);
            return date;
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
