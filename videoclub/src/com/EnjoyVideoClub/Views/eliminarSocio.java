package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Model.Socio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class eliminarSocio extends VentanaMainGUI {
    private JButton btnPollo;
    private JLabel tituloLbl;
    private JTextField txtField1;
    private JButton AceptarBtn;
    private JLabel lbl1;
    private JPanel devolverPanel;

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
                new altasGUI();
                dispose();
            }
        });
        AceptarBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean bool = false;
                if (Socio.arrayListSocio.size() <= 0) {
                    JOptionPane.showMessageDialog(null, "No tiene ningún socio registrado");
                }
                for (int i = 0; i < Socio.arrayListSocio.size() && bool == false; i++) {
                    String nombreSeleccionado = txtField1.getText();
                    if (Socio.arrayListSocio.get(i).getNIF().equals(nombreSeleccionado)) {
                        bool = true;
                        if (bool) {
                            int option = JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar?", "Confirmación", JOptionPane.YES_NO_OPTION);
                            if (option == JOptionPane.YES_OPTION) {
                                String eliminar = "Delete from socio where name like " + "'" + Socio.arrayListSocio.get(i).getNIF() + "'";
                                Socio.arrayListSocio.remove(i);
                                JOptionPane.showMessageDialog(null, "Eliminado!");
                            } else if (option == JOptionPane.NO_OPTION) {
                                bool = false;

                            }

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Error, vuelve a introducir el NIF");
                        bool = false;
                    }

                }
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

        });
    }
}
