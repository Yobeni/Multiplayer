package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.BaseDeDatos;
import com.EnjoyVideoClub.Controller.Principal;
import com.EnjoyVideoClub.Model.Socio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CrearSocioGUI extends VentanaMainGUI {

    private JPanel Jpanel1;
    private JLabel tituloLbl;
    private JLabel tituloPeliculaLbl;
    private JTextField NombreDeSocio;
    private JLabel directorLbl;
    private JTextField ApellidosSocio;
    private JButton btnPollo;
    private JLabel lblNif;
    private JTextField NifTxtBox;
    private JTextField fechaTxtBox;
    private JTextField PoblacionTxtBox;
    private JButton regresarBtn;
    private JButton AñadirBtn;
    private JButton restablecerBtn;

    public CrearSocioGUI() {
        this.setContentPane(Jpanel1);
        this.setVisible(true);
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        tituloLbl.setFont(new Font("Georgia", Font.BOLD, 30));

        regresarBtn.setBackground(new Color(250, 149, 18));
        restablecerBtn.setBackground(new Color(250, 149, 18));
        AñadirBtn.setBackground(new Color(250, 149, 18));
        restablecerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NombreDeSocio.setText("");
                ApellidosSocio.setText("");
                NifTxtBox.setText("");
                fechaTxtBox.setText("");
                PoblacionTxtBox.setText("");
            }
        });
        AñadirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean comp =false;
                    if (!NombreDeSocio.equals("")&&!fechaTxtBox.equals("")&&!ApellidosSocio.equals("")&&!PoblacionTxtBox.equals("")&&!NifTxtBox.equals("")){
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");

                        Date fecha = formato.parse(fechaTxtBox.getText());
                        String nif;

                             nif = NifTxtBox.getText();
                            for (Socio socio: Socio.arrayListSocio) {
                                if (nif.equals(socio.getNIF())) {
                                    JOptionPane.showMessageDialog(null,"Este socio ya esta registrado!");
                                    comp = true;
                                } else {
                                    comp=false;
                                }
                            }



                        String nombre = NombreDeSocio.getText();
                        String apellidos = ApellidosSocio.getText();
                        String poblacion = PoblacionTxtBox.getText();
                        Date comprobacion = new Date(01/01/2005);
                        comprobacion = formato.parse("01/01/2005");

                        if (fecha.before(comprobacion) && comp==false) {
                            Socio socio = new Socio(nif,nombre,fecha,poblacion,apellidos);
                            Socio.arrayListSocio.add(socio);
                            String consulta = "Insert into socio values (" + "'" + socio.getNIF() + "', " +
                                    "'" + socio.getNombre() + "', " + "'" + socio.getApellidos() + "', " +
                                    "'" + socio.getFechaNac() + "', " + "'" + socio.getPoblacion() + "', " + "'" + socio.getDineroDeuda()  + "')";
                            BaseDeDatos.agregarMultimedia(consulta);
                            JOptionPane.showMessageDialog(null, socio);
                        } else if (!fecha.before(comprobacion) && comp==false){
                            JOptionPane.showMessageDialog(null,"Es menor de edad!");
                        }

                        Socio socio = new Socio(nif,nombre,fecha,poblacion,apellidos);
                        //Socio.arrayListSocio.add(socio);
                        Principal.socios.add(socio);
                        String consulta = "Insert into socios values (" + "'" + socio.getNIF() + "', " +
                                "'" + socio.getNombre() + "', " + "'" + socio.getApellidos() + "', " +
                                "'" + socio.getFechaNac() + "', " + "'" + socio.getPoblacion() + "', " + "'" + socio.getDineroDeuda()  + "')";
                        BaseDeDatos.agregarMultimedia(consulta);
                    }
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                    throw new RuntimeException(ex);
                }
            }
        });
        regresarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new altasGUI();
                dispose();
            }
        });
        restablecerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                restablecerBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                restablecerBtn.setBackground(new Color(250, 149, 18));
            }
        });
        AñadirBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                AñadirBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                AñadirBtn.setBackground(new Color(250, 149, 18));
            }
        });
        regresarBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                regresarBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                regresarBtn.setBackground(new Color(250, 149, 18));
            }
        });
        btnPollo.setBorderPainted(false);
        btnPollo.setContentAreaFilled(false);
        btnPollo.setFocusPainted(false);
        btnPollo.setBorder(new EmptyBorder(5,10,5,10));
        btnPollo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaMainGUI();
                dispose();
            }
        });
    }
}
