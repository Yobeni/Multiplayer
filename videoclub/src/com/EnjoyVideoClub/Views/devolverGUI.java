package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.Principal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.SimpleDateFormat;
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
                    int errores = 0;
                    if (!nombreTF.equals("")&&!nifTf.equals("")){
                        for (int i = 0;i< Principal.multimedias.size();i++){
                            if (!Principal.multimedias.get(i).getTitulo().equals(nombreTF)){
                                errores++;
                                throw new RuntimeException("No pueden haber campos vacios.");
                            }

                        }
                    }else {
                        throw new RuntimeException("No pueden haber campos vacios.");
                    }

                    if (errores == 0){
                        for (int i = 0;i<Principal.multimedias.size();i++){
                            if (Principal.multimedias.get(i).getTitulo().equals(nombreTF)){
                                alquilerTF.setText(Principal.multimedias.get(i).getAño().toString());
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Los datos son correctos");
                    }
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
}
