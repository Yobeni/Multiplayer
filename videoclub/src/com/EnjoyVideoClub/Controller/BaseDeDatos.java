package com.EnjoyVideoClub.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDeDatos {
    public static Connection connection = null;
    public static final String USER = "postgres";
    public static final String PASSWORD = "Intpl_1023";
    public static final String URL = "jdbc:postgresql://localhost:5432/";
    public static final String BASE_DE_DATOS = "Proyecto Programación - CinePlus Videoclub";
    public static final String DRIVER = "org.postgresql.Driver";

    public void cargarBaseDeDatos() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + BASE_DE_DATOS, USER, PASSWORD);
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
}
