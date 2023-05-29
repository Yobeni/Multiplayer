package com.EnjoyVideoClub.Views;


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
    private JTextField txtField1;
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

                boolean bool = false;
                ArrayList<Socio> socios = new ArrayList<>();
                BaseDeDatos.cargarSociosDeLaBaseDeDatos(socios);

                if (socios.size() <= 0) {
                    JOptionPane.showMessageDialog(null, "No tiene ningún socio registrado");
                } else {
                    for (int i = 0; i < socios.size() && !bool; i++) {
                        String nifSeleccionado = txtField1.getText();
                        if (socios.get(i).getNIF().equals(nifSeleccionado)) {
                            bool = true;
                            if (bool) {
                                int option = JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar?", "Confirmación", JOptionPane.YES_NO_OPTION);
                                if (option == JOptionPane.YES_OPTION) {
                                    String eliminar = "DELETE FROM socios WHERE nif = '" + socios.get(i).getNIF() + "'";
                                    BaseDeDatos.eliminarSocio(eliminar);
                                    socios.remove(i);
                                    JOptionPane.showMessageDialog(null, "¡Socio eliminado!");
                                } else if (option == JOptionPane.NO_OPTION) {
                                    bool = false;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error, vuelva a introducir el NIF");
                            bool = false;
                        }

                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        AceptarBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                AceptarBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                AceptarBtn.setBackground(new Color(250, 149, 18));
            }
        });
        AceptarBtn.setBackground(new Color(250, 149, 18));
    }
}
