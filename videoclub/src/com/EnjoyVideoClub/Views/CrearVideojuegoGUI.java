package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.BaseDeDatos;
import com.EnjoyVideoClub.Controller.Principal;
import com.EnjoyVideoClub.Model.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CrearVideojuegoGUI extends VentanaMainGUI {
    private JPanel CrearVideojuegoPanel;
    private JLabel tituloLbl;
    private JLabel tituloVideojuegoLbl;
    private JLabel desarrolladorLbl;
    private JLabel formatoLbl;
    private JLabel fechaLbl;
    private JLabel plataformaLbl;
    private JTextField tituloTxtField;
    private JTextField desarrolladorTxtField;
    private JTextField fechaTxtField;
    private JRadioButton ps5RadioBtn;
    private JRadioButton xboxRadioBtn;
    private JRadioButton switchRadioBtn;
    private JRadioButton pcRadioBtn;
    private JButton crearBtn;
    private JComboBox formatoComboBox;
    private JButton restablecerBtn;
    private JLabel lblPollo;
    private JButton regresarAlMenúDeButton;
    private JButton btnPollo;
    private JLabel duracionLbl;
    private JTextField duracionTxtField;

    public CrearVideojuegoGUI() {
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
        duracionTxtField.setBackground(new Color(240, 217, 117));
        tituloLbl.setFont(new Font("Georgia", Font.BOLD, 30));

        crearBtn.setBackground(new Color(250, 149, 18));
        regresarAlMenúDeButton.setBackground(new Color(250, 149, 18));
        restablecerBtn.setBackground(new Color(250, 149, 18));

        ps5RadioBtn.setBackground(backgroundColor);
        pcRadioBtn.setBackground(backgroundColor);
        xboxRadioBtn.setBackground(backgroundColor);
        switchRadioBtn.setBackground(backgroundColor);

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

                    String titulo = tituloTxtField.getText();
                    String desarrollador = desarrolladorTxtField.getText();
                    FormatoMultimedia formatoMultimedia = (FormatoMultimedia) formatoComboBox.getSelectedItem();
                    Date fecha = formato.parse(fechaTxtField.getText());
                    int duracion = Integer.parseInt(duracionTxtField.getText());

                    Videojuego videojuego = new Videojuego(titulo, desarrollador, formatoMultimedia, fecha, duracion);

                    if (ps5RadioBtn.isSelected()) {
                        PlataformaVideojuego ps5 = PlataformaVideojuego.PS5;
                        videojuego.añadirPlataformas(ps5);
                    }
                    if (xboxRadioBtn.isSelected()) {
                        PlataformaVideojuego xbox = PlataformaVideojuego.XBOX;
                        videojuego.añadirPlataformas(xbox);
                    }
                    if (switchRadioBtn.isSelected()) {
                        PlataformaVideojuego nintendo = PlataformaVideojuego.SWITCH;
                        videojuego.añadirPlataformas(nintendo);
                    }
                    if (pcRadioBtn.isSelected()) {
                        PlataformaVideojuego pc = PlataformaVideojuego.PC;
                        videojuego.añadirPlataformas(pc);
                    }

                    if (videojuego.getPlataformas().size() != 0 && !videojuego.getTitulo().equals("") &&
                            !videojuego.getNombreAutor().equals("")) {
                        Principal.multimedias.add(videojuego);
                        int dur = Integer.parseInt(duracionTxtField.getText());
                        String consulta = "Insert into videojuego values (" + "'" + videojuego.getTitulo() + "', " +
                                "'" + videojuego.getNombreAutor() + "', " + "'" + videojuego.getFormato() + "', " +
                                "'" + videojuego.getAño() + "', " + "'" + videojuego.getPlataformas() + "', " + dur + ")";
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
                pcRadioBtn.setSelected(false);
                ps5RadioBtn.setSelected(false);
                xboxRadioBtn.setSelected(false);
                switchRadioBtn.setSelected(false);
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
                new VentanaMainGUI();
                dispose();
            }
        });
    }
}


