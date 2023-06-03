package com.EnjoyVideoClub.Views;


import com.EnjoyVideoClub.Controller.BaseDeDatos;
import com.EnjoyVideoClub.Controller.Principal;


import com.EnjoyVideoClub.Controller.BaseDeDatos;


import com.EnjoyVideoClub.Model.Socio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class eliminarSocio extends VentanaMainGUI {
    private JButton btnPollo;
    private JLabel tituloLbl;
    private JTextField nifTF;
    private JButton AceptarBtn;
    private JLabel lbl1;
    private JPanel devolverPanel;
    private JLabel passwdLbl;
    private JPasswordField passwdTF;

    public eliminarSocio() {
        this.setContentPane(devolverPanel);
        this.setVisible(true);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        tituloLbl.setFont(new Font("Georgia", Font.BOLD, 30));
        btnPollo.setBorderPainted(false);
        btnPollo.setContentAreaFilled(false);
        btnPollo.setFocusPainted(false);
        btnPollo.setBorder(new EmptyBorder(5, 10, 5, 10));

        btnPollo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaMainGUI();
                dispose();
            }
        });
        AceptarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    boolean encontrado = false;
                    String nifSeleccionado = nifTF.getText();
                    String contraseña = String.valueOf(passwdTF.getPassword());
                    for (Socio socio : Principal.socios) {
                        if (socio.getNIF().equals(nifSeleccionado) && socio.getPasswd().equals(contraseña)) {
                            encontrado = true;
                            int option = JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar?", "Confirmación", JOptionPane.YES_NO_OPTION);
                            if (option == JOptionPane.YES_OPTION) {
                                Principal.socios.remove(socio);
                                String consulta = "DELETE FROM socios WHERE nif = '" + nifTF.getText() + "';";
                                BaseDeDatos.eliminarSocio(consulta);
                                JOptionPane.showMessageDialog(null,"El socio se eliminó correctamente");
                            }
                        }
                    }
                    if (!encontrado) {
                        throw new RuntimeException("El NIF o la contraseña no es correcto");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

    }
}
