package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.BaseDeDatos;
import com.EnjoyVideoClub.Controller.Principal;
import com.EnjoyVideoClub.Model.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CrearDiscoGUI extends VentanaMainGUI {
    private JPanel CrearVideojuegoPanel;
    private JLabel tituloLbl;
    private JLabel tituloVideojuegoLbl;
    private JLabel desarrolladorLbl;
    private JLabel formatoLbl;
    private JLabel fechaLbl;
    private JLabel CancionesLbl;
    private JTextField tituloTxtField;
    private JTextField desarrolladorTxtField;
    private JTextField fechaTxtField;
    private JComboBox formatoComboBox;
    private JButton crearBtn;
    private JButton restablecerBtn;
    private JLabel lblPollo;
    private JButton regresarAlMenúDeButton;
    private JButton btnPollo;
    private JButton añadirCancionButton;
    public JTextArea txtAreaCanciones;
    private JButton cargarCancionesButton;

    public ArrayList<Cancion> cancionesMomentaneas;



    public CrearDiscoGUI() {
        Color backgroundColor = new Color(255, 222, 89);
        this.setContentPane(CrearVideojuegoPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 500);

        this.setLocationRelativeTo(null);
        this.setTitle("CinePlus");
        agregarmenu();

        this.setVisible(true);

        tituloTxtField.setBackground(new Color(240, 217, 117));
        desarrolladorTxtField.setBackground(new Color(240, 217, 117));
        fechaTxtField.setBackground(new Color(240, 217, 117));
        formatoComboBox.setBackground(new Color(240, 217, 117));
        tituloLbl.setFont(new Font("Georgia", Font.BOLD, 30));

        crearBtn.setBackground(new Color(250, 149, 18));
        regresarAlMenúDeButton.setBackground(new Color(250, 149, 18));
        restablecerBtn.setBackground(new Color(250, 149, 18));
        añadirCancionButton.setBackground(new Color(250, 149, 18));
        txtAreaCanciones.setEditable(false);
        Color amarillo = new Color(240, 217, 117);
        txtAreaCanciones.setBackground(amarillo);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        // Establecer el borde al JTextArea
        txtAreaCanciones.setBorder(border);


        formatoComboBox.addItem(FormatoMultimedia.CD);
        formatoComboBox.addItem(FormatoMultimedia.DVD);
        formatoComboBox.addItem(FormatoMultimedia.BLURAY);
        formatoComboBox.addItem(FormatoMultimedia.ARCHIVO);
        formatoComboBox.setEditable(false);

        crearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha = formato.parse(fechaTxtField.getText());
                    double duracionTotal=0;
                    cancionesMomentaneas = Cancion.cancionesCreadas;
                    for(Cancion aux : Cancion.cancionesCreadas){
                        duracionTotal+=aux.getDuracion();
                    }
                    Disco disco = new Disco(tituloTxtField.getText(),
                            desarrolladorTxtField.getText(),
                            (FormatoMultimedia) formatoComboBox.getSelectedItem(), fecha,duracionTotal,cancionesMomentaneas);


                    if (!tituloTxtField.equals("")&&!fechaTxtField.equals("")
                            &&!desarrolladorTxtField.equals("")) {
                        Disco.discosCreados.add(disco);

                        String insert = String.format("insert into disco values ('%s', '%s', '%s', '%s', %f)",
                                disco.getTitulo(),
                                disco.getNombreAutor(),
                                disco.getFormato(),
                                disco.getAño(),
                                disco.getDuracionTotal()
                        );

                        String consulta = "INSERT INTO disco VALUES ('" + disco.getTitulo() + "', '" +
                                disco.getNombreAutor() + "', '" + disco.getFormato() + "', '" + disco.getAño() +
                                "', " + disco.getDuracionTotal() + ")";

                        String update = String.format("update cancion set titulo_disco = '%s' where autor = '%s' and" +
                                " fecha = '%s'",
                                disco.getTitulo(),
                                disco.getNombreAutor(),
                                disco.getAño());
                        BaseDeDatos.agregarMultimedia(consulta);
                        BaseDeDatos.agregarMultimedia(update);
                        Principal.multimedias.add(disco);
                        JOptionPane.showMessageDialog(null, disco);
                    } else {
                        throw new RuntimeException("Todos los campos deben estar llenos");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        restablecerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tituloTxtField.setText("");
                desarrolladorTxtField.setText("");
                fechaTxtField.setText("");
                formatoComboBox.setSelectedIndex(0);
            }
        });

        crearBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                crearBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                crearBtn.setBackground(new Color(250, 149, 18));
            }
        });

        regresarAlMenúDeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                regresarAlMenúDeButton.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                regresarAlMenúDeButton.setBackground(new Color(250, 149, 18));
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

        regresarAlMenúDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new altasGUI();
                dispose();
            }
        });

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

        añadirCancionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearCancionGUI c =new CrearCancionGUI(CrearDiscoGUI.this);
            }
        });

    }

    public void rellenarTextArea(){
        String texto="";
        for(Cancion c: Cancion.cancionesCreadas){
            texto+=c.getTitulo()+"\n";
        }
        txtAreaCanciones.setText(texto);
    }

}
