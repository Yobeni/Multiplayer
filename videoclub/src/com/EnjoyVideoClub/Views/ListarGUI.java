package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.Principal;
import com.EnjoyVideoClub.Model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class ListarGUI extends VentanaMainGUI {
    private JButton polloBtn;
    private JPanel panel1;
    private JLabel titleLbl;
    private JComboBox listadosComboBox;
    private JLabel listarPorLbl;
    private JTextArea infoTxtArea;
    private JButton regresarBtn;
    private JButton listarBtn;

    public ListarGUI() {
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Cine Plus - Listar.");
        this.setVisible(true);

        agregarmenu();
        añadirOpcionesYColores();
        generarListado();
        regresarAlMenuPrincipal();
    }

    public void generarListado() {
        listarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (listadosComboBox.getSelectedIndex()) {
                    case 0 -> listarTodasLasMultimedias();
                    case 1 -> listarPeliculasOrdenadasPorTitulo();
                    case 3 -> listarVideojuegosOrdenadosPorAño();
                    case 4 -> {
                        String nif = JOptionPane.showInputDialog("Introduzca el NIF del socio que desea consultar");
                        listarAlquileresActualesDeUnSocio(nif);
                    }
                    case 5 -> listarSociosConRecargosPendientes();
                }
            }
        });
    }

    public void listarTodasLasMultimedias() {
        String peliculas = "Películas.";
        String videojuegos = "Videojuegos.";
        for (Multimedia multimedia : Principal.multimedias) {
            if (multimedia instanceof Pelicula) {
                peliculas += "\n- " + multimedia.getTitulo();
            } else if (multimedia instanceof Videojuego) {
                videojuegos += "\n- " + multimedia.getTitulo();
            }
        }
        infoTxtArea.setText(peliculas + "\n\n" + videojuegos);
    }

    public void listarAlquileresActualesDeUnSocio(String nif) {
        String info = "Socio: " + nif;
        for (Alquiler alquiler : Principal.alquileres) {
            if (alquiler.getNifSocio().equals(nif)) {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String fechaInicio = formato.format(alquiler.getFechaInicio());
                String fechaFin = formato.format(alquiler.getFechaFin());
                info += "\n\nFecha de inicio del alquiler: " + fechaInicio +
                        "\nFecha de devolución: " + fechaFin + "\n" +
                        "Título de la multimedia alquilada: " + alquiler.getTituloMultimedia() +
                        "\nTipo de la multimedia alquilada: " + alquiler.getTipoMultimedia().getClass().getSimpleName();
                infoTxtArea.setText(info);
            } else {
                infoTxtArea.setText("El socio especificado no tiene alquieres iniciados, o bien, no existe en la base " +
                        "de datos");
            }
        }
    }

    public void listarSociosConRecargosPendientes() {
        String info = "";
        for (Socio socio : Principal.socios) {
            if (socio.getDineroDeuda() > 0) {
                info += "Nombre: " + socio.getNombre() + "\nNIF: " + socio.getNIF() + "\nDeuda: " +
                        socio.getDineroDeuda() + "\n\n";
                infoTxtArea.setText(info);
            } else {
                infoTxtArea.setText("No hay socios con recargos pendientes...");
            }
        }
    }

    public void listarPeliculasOrdenadasPorTitulo() {
        Collections.sort(Principal.multimedias, new Comparator<Multimedia>() {
            @Override
            public int compare(Multimedia o1, Multimedia o2) {
                return o1.getTitulo().compareTo(o2.getTitulo());
            }
        });
        String info = "";
        for (Multimedia multimedia : Principal.multimedias) {
            if (multimedia instanceof Pelicula) {
                info += "- " + multimedia.getTitulo() + "\n";
            }
        }
        infoTxtArea.setText(info);
    }

    public void listarVideojuegosOrdenadosPorAño() {
        Collections.sort(Principal.multimedias, new Comparator<Multimedia>() {
            @Override
            public int compare(Multimedia o1, Multimedia o2) {
                return o1.getAño().compareTo(o2.getAño());
            }
        });
        String info = "";
        for (Multimedia multimedia : Principal.multimedias) {
            if (multimedia instanceof Videojuego) {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String fecha = formato.format(multimedia.getAño());
                info += "> Título: " + multimedia.getTitulo() + "\n  Fecha de publicación: " + fecha + "\n\n";
            }
        }
        infoTxtArea.setText(info);
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

    public void añadirOpcionesYColores() {
        listadosComboBox.addItem("Listado de todos los objetos multimedia");
        listadosComboBox.addItem("Listado de todas las películas ordenadas por título");
        listadosComboBox.addItem("Listado de todas las canciones de un disco por duración");
        listadosComboBox.addItem("Listado de todos los videojuegos ordenados por año");
        listadosComboBox.addItem("Listado de los alquileres actuales de un socio");
        listadosComboBox.addItem("Listado de los socios con recargos pendientes");

        infoTxtArea.setEditable(false);

        polloBtn.setBorderPainted(false);
        polloBtn.setContentAreaFilled(false);
        polloBtn.setFocusPainted(false);
        polloBtn.setBorder(new EmptyBorder(5, 10, 5, 10));
        polloBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaMainGUI();
                dispose();
            }
        });

        Color amarillo = new Color(240, 217, 117);
        Color naranja = new Color(250, 149, 18);
        Color naranjaOscuro = new Color(253, 84, 27);

        infoTxtArea.setBackground(amarillo);
        regresarBtn.setBackground(naranja);
        listarBtn.setBackground(naranja);
        listadosComboBox.setBackground(amarillo);
        listadosComboBox.setEditable(false);

        regresarBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                regresarBtn.setBackground(naranjaOscuro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                regresarBtn.setBackground(naranja);
            }
        });
        listarBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                listarBtn.setBackground(naranjaOscuro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                listarBtn.setBackground(naranja);
            }
        });
    }
}
