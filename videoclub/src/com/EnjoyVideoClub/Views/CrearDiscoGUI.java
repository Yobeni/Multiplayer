package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.BaseDeDatos;
import com.EnjoyVideoClub.Model.Disco;
import com.EnjoyVideoClub.Model.FormatoMultimedia;
import com.EnjoyVideoClub.Model.PlataformaVideojuego;
import com.EnjoyVideoClub.Model.Videojuego;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
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
    private JTextArea txtAreaCanciones;

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

                    Videojuego videojuego = new Videojuego(tituloTxtField.getText(),
                            desarrolladorTxtField.getText(),
                            (FormatoMultimedia) formatoComboBox.getSelectedItem(), fecha);


                    if (videojuego.getPlataformas().size() != 0 && !videojuego.getTitulo().equals("") &&
                            !videojuego.getNombreAutor().equals("")) {
                        Videojuego.videojuegosCreados.add(videojuego);
                        String consulta = "Insert into videojuego values (" + "'" + videojuego.getTitulo() + "', " +
                                "'" + videojuego.getNombreAutor() + "', " + "'" + videojuego.getFormato() + "', " +
                                "'" + videojuego.getAño() + "', " + "'" + videojuego.getPlataformas() + "')";
                        BaseDeDatos.agregarMultimedia(consulta);
                        JOptionPane.showMessageDialog(null, videojuego);
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
                CrearCancionGUI c =new CrearCancionGUI();

            }
        });
    }
}
