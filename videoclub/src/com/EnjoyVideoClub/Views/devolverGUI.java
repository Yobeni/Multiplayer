package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.BaseDeDatos;

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
    private JTextField textField2;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JLabel lblNombre;
    private JLabel lblFechaAlquiler;
    private JLabel lblTipo;
    private JLabel lblSocio;
    private JLabel lblPrecio;
    private JButton button1;
    private JButton button2;
    private JButton btnValidar;
    private JButton btnPollo;
    private JLabel lblDevolber;
    private JTextField devolucionTF;
    private JTextField textField5;
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
