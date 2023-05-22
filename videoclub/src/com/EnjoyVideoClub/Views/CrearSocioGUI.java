package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Model.Socio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrearSocioGUI extends JFrame {

    private JPanel Jpanel1;
    private JLabel tituloLbl;
    private JLabel tituloPeliculaLbl;
    private JTextField NombreDeSocio;
    private JLabel directorLbl;
    private JTextField ApellidosSocio;
    private JButton button1;
    private JLabel lblNif;
    private JTextField NifTxtBox;
    private JTextField fechaTxtBox;
    private JTextField PoblacionTxtBox;
    private JButton regresarBtn;
    private JButton AñadirBtn;

    public CrearSocioGUI() {
        AñadirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM");
                Date fecha;
                String nif,nombre,apellidos, poblacion;

                try {
                     fecha = formato.parse(fechaTxtBox.getText());
                     nif = NifTxtBox.getText();
                     nombre = NombreDeSocio.getText();
                     apellidos = ApellidosSocio.getText();
                     poblacion = PoblacionTxtBox.getText();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                Socio socio = new Socio(nif,nombre,fecha,poblacion,apellidos);

            }
        });
    }
}
