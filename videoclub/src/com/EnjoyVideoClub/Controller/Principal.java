package com.EnjoyVideoClub.Controller;
import com.EnjoyVideoClub.Views.VentanaMainGUI;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        try {
            new VentanaMainGUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        System.out.println("Ya tenemos ventana main de GUI");
    }
}
