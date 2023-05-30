package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.BaseDeDatos;
import com.EnjoyVideoClub.Controller.Principal;
import com.EnjoyVideoClub.Model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class devolverGUI extends VentanaMainGUI {
    private JTextField nombreTF;
    private JPanel panel1;
    private JTextField alquilerTF;
    private JComboBox TtipoCBO;
    private JTextField precioTF;
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

    public boolean validado = false;

    public devolverGUI() {
        Color backgroundColor = new Color(255, 222, 89);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setBackground(backgroundColor);

        this.setLocationRelativeTo(null);
        this.setTitle("CinePlus");
        agregarmenu();
        this.setVisible(true);

        fechaActual();
        mostrarDatosMultimediasDependiendoDelTipo();
        hoverBotones();

        TtipoCBO.addItem("Pelicula");
        TtipoCBO.addItem("Videojuego");
        TtipoCBO.addItem("Canción");

        botonPollo();
        btnValidar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!nifTf.getText().equals("")){
                        if (comprobarQueElSocioExiste()){
                            validado = true;
                            precioTF.setText(calcularPrecio() + "€");
                        } else {
                            precioTF.setText("");
                            validado = false;
                            throw new RuntimeException("El socio introducido no existe");
                        }
                    } else {
                        precioTF.setText("");
                        validado = false;
                        throw new RuntimeException("Debe introducir el nif del socio");
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

        devolverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (validado){
                       int option = JOptionPane.showConfirmDialog(null, "Seguro que quiere devolver?", "Confirmación", JOptionPane.YES_NO_OPTION);
                       if (option == JOptionPane.YES_OPTION) {
                            for (Socio soc : Principal.socios){
                                System.out.println(soc.getNIF());
                                System.out.println(nifTf.getText());
                                if (soc.getNIF().equals(nifTf.getText())){
                                    String consulta = "DELETE FROM alquileres WHERE titulo_mult = '" +
                                            tituloCBO.getSelectedItem() + "'; UPDATE socios SET dinerodeuda = dinerodeuda + " +
                                            calcularPrecio() + " WHERE nif = '" + soc.getNIF() + "';";
                                    soc.setDineroDeuda(calcularPrecio() + soc.getDineroDeuda());
                                    BaseDeDatos.agregarMultimedia(consulta);
                                    devolverMultimedia();
                                }
                            }
                        }
                    } else {
                        System.out.println("hola");
                    }
                }catch (Exception ex){
                    //JOptionPane.showMessageDialog(null, ex.getMessage());
                    ex.printStackTrace();
                }
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
                            validado = false;
                        }
                    }
                } else if (selectedIndex == 1) {
                    for (Alquiler alq : Principal.alquileres) {
                        if (alq.getTipoMultimedia() instanceof Videojuego) {
                            tituloCBO.addItem(alq.getTituloMultimedia());
                            alquilerDates.add(alq.getFechaInicio());
                            validado = false;
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
                        validado = false;
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                } else if (TtipoCBO.getSelectedIndex() == 1 && selectedIndex >= 0 && selectedIndex < alquilerDates.size()) {
                    try {
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        String fechaString = formato.format(alquilerDates.get(selectedIndex));
                        alquilerTF.setText(fechaString);
                        validado = false;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public boolean comprobarQueElSocioExiste() {
        for (Socio socio : Principal.socios) {
            if (socio.equals(nifTf.getText())) {
                return true;
            }
        }
        return false;
    }

    public void hoverBotones() {
        regresarBtn.setBackground(new Color(250, 149, 18));
        devolverBtn.setBackground(new Color(250, 149, 18));
        btnValidar.setBackground(new Color(250, 149, 18));
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

        devolverBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                devolverBtn.setBackground(new Color(253, 84, 27));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                devolverBtn.setBackground(new Color(250, 149, 18));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                devolverBtn.setBackground(new Color(253, 84, 27));
            }
        });

       btnValidar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnValidar.setBackground(new Color(253, 84, 27));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnValidar.setBackground(new Color(250, 149, 18));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                btnValidar.setBackground(new Color(253, 84, 27));
            }
        });
    }

    public void devolverMultimedia(){
        for (Alquiler alq : Principal.alquileres){
            if (alq.getTituloMultimedia().equals(tituloCBO.getSelectedItem())){
                Principal.alquileres.remove(alq);
            }
        }
    }

    public void botonPollo(){
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
    }

    public int calcularPrecio(){
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaInicio = formato.parse(alquilerTF.getText());
            Date fechaFinal = formato.parse(devolucionTF.getText());

            long dias = ChronoUnit.DAYS.between(fechaInicio.toInstant(), fechaFinal.toInstant());

            if (dias <= 3) {
                for (Alquiler alq : Principal.alquileres) {
                    if (alq.getTituloMultimedia().equals(tituloCBO.getSelectedItem())) {
                        return alq.getPrecio();
                    }
                }
            } else {
                dias = dias - 3;
                long incremetnoPrecio = dias * 2;
                for (Alquiler alq : Principal.alquileres) {
                    if (alq.getTituloMultimedia().equals(tituloCBO.getSelectedItem())) {
                        return (int) (alq.getPrecio() + incremetnoPrecio);
                    }
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 23;
    }
}

