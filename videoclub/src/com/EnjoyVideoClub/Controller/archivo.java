package com.EnjoyVideoClub.Controller;

import java.io.File;
import java.io.IOException;

public class archivo {
    public static File f = new File("Log.txt");

    public static void crearFile() {
        try {
            if (archivo.f.createNewFile()) {
                System.out.println("El archivo Log.txt se ha creado correctamente.");
            } else {
                String ruta = String.valueOf(f.getAbsoluteFile());
                System.out.println("El archivo Log.txt ya existe.Está en: " + ruta);
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo Log.txt: " + e.getMessage());
        }
    }
}
