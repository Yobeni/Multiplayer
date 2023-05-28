package com.EnjoyVideoClub.Controller;

import com.EnjoyVideoClub.Model.*;

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
    public static final String PASSWORD = "1234";
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

    public static void cargarSociosDeLaBaseDeDatos(ArrayList<Socio> socios) {
        String consulta = "SELECT * FROM socios";
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + BASE_DE_DATOS, USER, PASSWORD);
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(consulta);
                while (resultSet.next()) {
                    String nif = resultSet.getString("nif");
                    String nombre = resultSet.getString("nombre");
                    String apellidos = resultSet.getString("apellidos");
                    String fechaNac = resultSet.getString("fechanac");
                    String poblacion = resultSet.getString("poblacion");
                    int deuda = resultSet.getInt("dinerodeuda");
                    Date fechaNacimiento = formatearFecha(fechaNac);

                    Socio socio = new Socio(nif, nombre, fechaNacimiento, poblacion, apellidos);
                    socio.setDineroDeuda(deuda);
                    socios.add(socio);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cargarAlquileresDeLaBaseDeDatos(ArrayList<Alquiler> alquileres) {
        String consulta = "SELECT * FROM alquileres";
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + BASE_DE_DATOS, USER, PASSWORD);
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(consulta);
                while (resultSet.next()) {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaInicio = formato.parse(resultSet.getString("fecha_inicio"));
                    Date fechaFin = formato.parse(resultSet.getString("fecha_fin"));
                    String nif = resultSet.getString("nif_socio");
                    Multimedia multimedia = comprobarMultimedia(resultSet.getString("tipo_mult"));
                    int precio = Integer.parseInt(resultSet.getString("precio").substring(0, 1));
                    String titulo = resultSet.getString("titulo_mult");

                    Alquiler alquiler = new Alquiler(fechaInicio, fechaFin, nif, multimedia, titulo, precio);
                    Principal.alquileres.add(alquiler);
                }
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

    public static Multimedia comprobarMultimedia(String multimedia) {
        return switch (multimedia) {
            case "Película" -> new Pelicula();
            case "Videojuego" -> new Videojuego();
            default -> null;
        };
    }
}
