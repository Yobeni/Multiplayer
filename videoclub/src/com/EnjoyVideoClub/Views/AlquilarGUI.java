package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.BaseDeDatos;
import com.EnjoyVideoClub.Controller.Principal;
import com.EnjoyVideoClub.Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JLabel nifSocioLbl;
    private JTextField nifSocioTxt;

    public AlquilarGUI() {
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Cine Plus - Alquilar multimedia.");
        this.setVisible(true);

        alquilarTitleLbl.setFont(new Font("Georgia", Font.BOLD, 30));
        agregarmenu();

        tipoComboBox.setEditable(false);
        nombreComboBox.setEditable(false);
        añoTextField.setEditable(false);
        duraciónTxtField.setEditable(false);
        precioTxtField.setEditable(false);
        fechaFinTxt.setEditable(false);
        fechaInicioTxt.setEditable(false);

        tipoComboBox.addItem("Película");
        tipoComboBox.addItem("Videojuego");
        tipoComboBox.addItem("Disco");

        mostrarFechaDeHoy();
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

                    // Comprueba que el socio existe.
                    if (!comprobarQueElSocioExiste()) {
                        throw new RuntimeException("El socio no está registrado en la base de datos");
                    }
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
        String tipoMult = "";
        switch (tipoComboBox.getSelectedIndex()) {
            case 0 -> tipoMult = "Película";
            case 1 -> tipoMult = "Videojuego";
            case 2 -> tipoMult = "Disco";
        }
        String finalTipoMult = tipoMult;
        alquilarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!comprobarQueElSocioExiste()) {
                    throw new RuntimeException("No existe el socio registrado en la base de datos");
                }

                if (!fechaInicioTxt.getText().equals("") && !fechaFinTxt.getText().equals("") &&
                        comprobarQueElSocioExiste() && comprobarQueElSocioNoTieneRecargosPendientes()) {
                    String consulta = "INSERT INTO alquileres VALUES ('" + fechaInicioTxt.getText() + "', '"
                            + fechaFinTxt.getText() + "', '" + nifSocioTxt.getText() + "', '" +
                            tipoComboBox.getSelectedItem().toString() + "', '" +
                            precioTxtField.getText() + "', '" + nombreComboBox.getSelectedItem().toString() + "')";
                    //BaseDeDatos.agregarMultimedia(consulta);
                    crearAlquiler();
                } else {
                    throw new RuntimeException("No es posible realizar el alquiler dado que los datos no han sido " +
                            "validados, o bien el socio no existe en la base de datos.");
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

    public void mostrarFechaDeHoy() {
        Date fecha = new Date();
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fechaString = formato.format(fecha);
            fechaInicioTxt.setText(fechaString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearAlquiler() {
        try {
            Multimedia multimedia = null;
            switch (tipoComboBox.getSelectedIndex()) {
                case 0 -> multimedia = new Pelicula();
                case 1 -> multimedia = new Videojuego();
            }
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaInicio = formato.parse(fechaInicioTxt.getText());
            Date fechaFin = formato.parse(fechaFinTxt.getText());
            String nifSocio = nifSocioTxt.getText();
            String titulo = nombreComboBox.getSelectedItem().toString();
            int precio = Integer.parseInt(precioTxtField.getText().substring(0, 1));
            Alquiler alquiler = new Alquiler(fechaInicio, fechaFin, nifSocio, multimedia, titulo, precio);
            JOptionPane.showMessageDialog(null, alquiler);
            Principal.alquileres.add(alquiler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean comprobarQueElSocioNoTieneRecargosPendientes() {
        for (Socio socio : Principal.socios) {
            if (socio.getDineroDeuda() > 0) {
                throw new RuntimeException("No es posible alquilar dado que el socio cuenta con recargos pendientes");
            }
        }
        return true;
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
        nifSocioTxt.setBackground(amarillo);

        // Colores botones.
        validarBtn.setBackground(naranja);
        regresarBtn.setBackground(naranja);
        alquilarBtn.setBackground(naranja);
    }

    public boolean comprobarQueElSocioExiste() {
        for (Socio socio : Principal.socios) {
            if (socio.equals(nifSocioTxt.getText())) {
                return true;
            }
        }
        return false;
    }
}
