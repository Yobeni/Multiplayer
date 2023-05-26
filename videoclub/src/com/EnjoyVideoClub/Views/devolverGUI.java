package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.Principal;
import com.EnjoyVideoClub.Model.Alquiler;
import com.EnjoyVideoClub.Model.Multimedia;
import com.EnjoyVideoClub.Model.Pelicula;
import com.EnjoyVideoClub.Model.Videojuego;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class devolverGUI extends VentanaMainGUI {
    private JTextField nombreTF;
    private JPanel panel1;
    private JTextField alquilerTF;
    private JComboBox TtipoCBO;
    private JTextField textField3;
    private JLabel lblNombre;
    private JLabel lblFechaAlquiler;
    private JLabel lblTipo;
    private JLabel lblSocio;
    private JLabel lblPrecio;
    private JButton regresarBtn;
    private JButton devolverBtn;
    private JButton btnValidar;
    private JButton btnPollo;
    private JLabel lblDevolber;
    private JTextField devolucionTF;
    private JTextField nifTf;
    private JLabel lbldevolucion;
    private JComboBox tituloCBO;

    public devolverGUI() {
        Color backgroundColor = new Color(255, 222, 89);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 500);

        this.setLocationRelativeTo(null);
        this.setTitle("CinePlus");
        agregarmenu();
        this.setVisible(true);

        fechaActual();
        mostrarDatosMultimediasDependiendoDelTipo();

        TtipoCBO.addItem("Pelicula");
        TtipoCBO.addItem("Videojuego");
        TtipoCBO.addItem("Canción");

        btnPollo.setBorderPainted(false);
        btnPollo.setContentAreaFilled(false);
        btnPollo.setFocusPainted(false);
        btnPollo.setBorder(new EmptyBorder(5,10,5,10));
        panel1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        btnPollo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaMainGUI();
                dispose();
            }
        });
        btnValidar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        regresarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaMainGUI();
                dispose();
            }
        });
    }

    public void fechaActual(){
        Date fecha = new Date();
        try{
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fechaString = formato.format(fecha);
            devolucionTF.setText(fechaString);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void mostrarDatosMultimediasDependiendoDelTipo() {
        ArrayList<Date> alquilerDates = new ArrayList<>();


        TtipoCBO.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                tituloCBO.removeAllItems();
                alquilerDates.clear();

                int selectedIndex = TtipoCBO.getSelectedIndex();
                if (selectedIndex == 0) {
                    for (Alquiler alq : Principal.alquileres) {
                        if (alq.getTipoMultimedia() instanceof Pelicula) {
                            tituloCBO.addItem(alq.getTituloMultimedia());
                            alquilerDates.add(alq.getFechaInicio());
                        }
                    }
                } else if (selectedIndex == 1) {
                    for (Alquiler alq : Principal.alquileres) {
                        if (alq.getTipoMultimedia() instanceof Videojuego) {
                            tituloCBO.addItem(alq.getTituloMultimedia());
                            alquilerDates.add(alq.getFechaInicio());
                        }
                    }
                }
            }
        });

        tituloCBO.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int selectedIndex = tituloCBO.getSelectedIndex();
                if (TtipoCBO.getSelectedIndex() == 0 && selectedIndex >= 0 && selectedIndex < alquilerDates.size()) {
                    try{
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        String fechaString = formato.format(alquilerDates.get(selectedIndex));
                        alquilerTF.setText(fechaString);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                } else if (TtipoCBO.getSelectedIndex() == 1 && selectedIndex >= 0 && selectedIndex < alquilerDates.size()) {
                    try {
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        String fechaString = formato.format(alquilerDates.get(selectedIndex));
                        alquilerTF.setText(fechaString);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}

