package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.Principal;
import com.EnjoyVideoClub.Model.Multimedia;
import com.EnjoyVideoClub.Model.Pelicula;
import com.EnjoyVideoClub.Model.Videojuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AlquilarGUI extends VentanaMainGUI {
    private JPanel panel1;
    private JLabel alquilarTitleLbl;
    private JLabel tipoLbl;
    private JLabel nombreLbl;
    private JLabel añoLbl;
    private JLabel duracionLbl;
    private JLabel precioLbl;
    private JComboBox tipoComboBox;
    private JComboBox nombreComboBox;
    private JTextField añoTextField;
    private JTextField duraciónTxtField;
    private JTextField precioTxtField;
    private JButton regresarBtn;
    private JButton alquilarBtn;
    private JLabel polloLbl;
    private JLabel fechaInicioLbl;
    private JLabel fechaFinLbl;
    private JTextField fechaInicioTxt;
    private JTextField fechaFinTxt;
    private JButton validarBtn;
    int precioBase = 4;

    public AlquilarGUI() {
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Cine Plus - Alquilar multimedia.");
        this.setVisible(true);

        agregarmenu();

        tipoComboBox.setEditable(false);
        nombreComboBox.setEditable(false);
        añoTextField.setEditable(false);
        duraciónTxtField.setEditable(false);
        precioTxtField.setEditable(false);
        fechaFinTxt.setEditable(false);

        tipoComboBox.addItem("Película");
        tipoComboBox.addItem("Videojuego");
        tipoComboBox.addItem("Disco");

        colores();
        regresarAlMenuPrincipal();
        mostrarFechaFinal();
        alquilar();
        mostrarDatosMultimediasDependiendoDelTipo();
        hoverBotones();
    }

    public void mostrarFechaFinal() {
        validarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fechaInicioTxt.getText().equals("")) {
                        throw new RuntimeException("El campo de la fecha de inicio no puede estar vacío");
                    }
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaInicio = formato.parse(fechaInicioTxt.getText());
                    Date fechaFin = sumarDias(fechaInicio, 3);
                    String fechaFinString = formato.format(fechaFin);
                    fechaFinTxt.setText(fechaFinString);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public Date sumarDias(Date fechaInicio, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    public void regresarAlMenuPrincipal() {
        regresarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaMainGUI();
                dispose();
            }
        });
    }

    public void alquilar() {
        alquilarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!fechaInicioTxt.getText().equals("") && !fechaFinTxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Alquiler realizado!" +
                            "\nFecha de inicio: " + fechaInicioTxt.getText() +
                            "\nFecha de finalización: " + fechaFinTxt.getText() +
                            "\nPrecio del alquiler: " + precioTxtField.getText() +
                            "\nNO EXCEDER EL LÍMITE.");
                } else {
                    throw new RuntimeException("Los datos no han sido validados.");
                }
            }
        });
    }

    public void mostrarDatosMultimediasDependiendoDelTipo() {
        ArrayList<Integer> duracionesPeliculas = new ArrayList<>();
        ArrayList<Integer> duracionesJuegos = new ArrayList<>();
        ArrayList<Integer> añosPeliculas = new ArrayList<>();
        ArrayList<Integer> añosJuegos = new ArrayList<>();

        tipoComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                nombreComboBox.removeAllItems();
                duracionesPeliculas.clear();
                duracionesJuegos.clear();
                añosPeliculas.clear();
                añosJuegos.clear();

                int selectedIndex = tipoComboBox.getSelectedIndex();
                if (selectedIndex == 0) {
                    for (Multimedia multimedia : Principal.multimedias) {
                        if (multimedia instanceof Pelicula) {
                            nombreComboBox.addItem(multimedia.getTitulo());
                            int duracion = ((Pelicula) multimedia).getDuracionPelicula();
                            duracionesPeliculas.add(duracion);
                            String fechaVersion1 = multimedia.getAño() + "";
                            String fecha = fechaVersion1.substring(24).trim();
                            int año = Integer.parseInt(fecha);
                            añosPeliculas.add(año);
                        }
                    }
                } else if (selectedIndex == 1) {
                    for (Multimedia multimedia : Principal.multimedias) {
                        if (multimedia instanceof Videojuego) {
                            nombreComboBox.addItem(multimedia.getTitulo());
                            int duracion = ((Videojuego) multimedia).getDuracion();
                            duracionesJuegos.add(duracion);
                            String fechaVersion1 = multimedia.getAño() + "";
                            String fecha = fechaVersion1.substring(24).trim();
                            int año = Integer.parseInt(fecha);
                            añosJuegos.add(año);
                        }
                    }
                }
            }
        });

        nombreComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int selectedIndex = nombreComboBox.getSelectedIndex();
                if (tipoComboBox.getSelectedIndex() == 0 && selectedIndex >= 0 && selectedIndex < duracionesPeliculas.size()) {
                    duraciónTxtField.setText(duracionesPeliculas.get(selectedIndex) + " minutos");
                    añoTextField.setText(añosPeliculas.get(selectedIndex) + "");
                    if (añosPeliculas.get(selectedIndex) < 2012) {
                        precioTxtField.setText("3.00 €");
                    } else {
                        precioTxtField.setText("4.00 €");
                    }
                } else if (tipoComboBox.getSelectedIndex() == 1 && selectedIndex >= 0 && selectedIndex < duracionesJuegos.size()) {
                    duraciónTxtField.setText(duracionesJuegos.get(selectedIndex) + " horas");
                    añoTextField.setText(añosJuegos.get(selectedIndex) + "");
                    if (añosJuegos.get(selectedIndex) < 2010) {
                        precioTxtField.setText("3.00 €");
                    } else {
                        precioTxtField.setText("4.00 €");
                    }
                }
            }
        });
    }

    public void hoverBotones() {
        regresarBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                regresarBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                regresarBtn.setBackground(new Color(250, 149, 18));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                regresarBtn.setBackground(new Color(253, 84, 27));
            }
        });

        alquilarBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                alquilarBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                alquilarBtn.setBackground(new Color(250, 149, 18));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                alquilarBtn.setBackground(new Color(253, 84, 27));
            }
        });

        validarBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                validarBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                validarBtn.setBackground(new Color(250, 149, 18));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                validarBtn.setBackground(new Color(253, 84, 27));
            }
        });
    }

    public void colores() {
        Color amarillo = new Color(240, 217, 117);
        Color naranja = new Color(250, 149, 18);
        // Colores campos de texto.
        tipoComboBox.setBackground(amarillo);
        nombreComboBox.setBackground(amarillo);
        añoTextField.setBackground(amarillo);
        duraciónTxtField.setBackground(amarillo);
        precioTxtField.setBackground(amarillo);
        fechaInicioTxt.setBackground(amarillo);
        fechaFinTxt.setBackground(amarillo);

        // Colores botones.
        validarBtn.setBackground(naranja);
        regresarBtn.setBackground(naranja);
        alquilarBtn.setBackground(naranja);
    }
}
