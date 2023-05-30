package com.EnjoyVideoClub.Controller;
import com.EnjoyVideoClub.Model.Multimedia;
import com.EnjoyVideoClub.Views.VentanaMainGUI;

import javax.swing.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        try {
            ArrayList<Multimedia> multimedias = new ArrayList<>();
            BaseDeDatos.cargarVideojuegosDeLaBaseDeDatos(multimedias);
            for (Multimedia multimedia : multimedias) {
                System.out.println(multimedia);
            }

            new VentanaMainGUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        System.out.println("Ya tenemos ventana main de GUI");
    }
}
