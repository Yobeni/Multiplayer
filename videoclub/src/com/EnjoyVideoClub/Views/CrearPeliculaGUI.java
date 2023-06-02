package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.BaseDeDatos;
import com.EnjoyVideoClub.Controller.Principal;
import com.EnjoyVideoClub.Model.FormatoMultimedia;
import com.EnjoyVideoClub.Model.Pelicula;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrearPeliculaGUI extends VentanaMainGUI{
    private JPanel CrearPeliculaPanel;
    private JTextField tituloTfield;
    private JTextField directorTfield;
    private JTextField FechaTfield;
    private JTextField ActorTfield;
    private JTextField ActrizTfield;
    private JButton restablecerBtn;
    private JButton añadirBtn;
    private JLabel tituloLbl;
    private JLabel tituloPeliculaLbl;
    private JLabel directorLbl;
    private JLabel formatoLbl;
    private JComboBox FormatoCbo;
    private JLabel fechaLbl;
    private JLabel durecionLbl;
    private JLabel actorLbl;
    private JLabel actrizLbl;
    private JButton retrocederBtn;

    private JButton btnPollo;
    private JSpinner duracionSpinn;

    public CrearPeliculaGUI() {
        this.setContentPane(CrearPeliculaPanel);
        this.setVisible(true);
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        FormatoCbo.addItem(FormatoMultimedia.CD);
        FormatoCbo.addItem(FormatoMultimedia.DVD);
        FormatoCbo.addItem(FormatoMultimedia.BLURAY);
        FormatoCbo.addItem(FormatoMultimedia.ARCHIVO);
        FormatoCbo.setEditable(false);

        btnPollo.setBounds(10,10,10,10);

        retrocederBtn.setBackground(new Color(250, 149, 18));
        añadirBtn.setBackground(new Color(250, 149, 18));
        restablecerBtn.setBackground(new Color(250, 149, 18));

        tituloLbl.setFont(new Font("Georgia", Font.BOLD, 30));

        polloBoton();
        retrocederBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new altasGUI();
                dispose();
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
        restablecerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tituloTfield.setText("");
                directorTfield.setText("");
                FormatoCbo.setSelectedIndex(0);
                FechaTfield.setText("");
                ActorTfield.setText("");
                ActrizTfield.setText("");
                duracionSpinn.setValue(0);
            }
        });

        retrocederBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                retrocederBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                retrocederBtn.setBackground(new Color(250, 149, 18));
            }
        });

        añadirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (!tituloTfield.getText().equals("") && !directorTfield.getText().equals("") &&
                            !ActorTfield.getText().equals("") && !ActrizTfield.getText().equals("")){

                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = formato.parse(FechaTfield.getText());

                        int importeIneger = Integer.parseInt(duracionSpinn.getValue().toString());

                        Pelicula pelicula = new Pelicula(tituloTfield.getText(),directorTfield.getText(),
                                (FormatoMultimedia) FormatoCbo.getSelectedItem()
                                ,fecha, importeIneger, ActorTfield.getText(),ActrizTfield.getText());

                        String consulta = "Insert into pelicula values (" + "'" + pelicula.getTitulo() + "', " +
                                "'" + pelicula.getNombreAutor() + "', " + "'" + pelicula.getFormato() + "', " +
                                "'" + pelicula.getAño() + "', " + pelicula.getDuracionPelicula() + ", '" +
                                pelicula.getActorPrincipaL() + "', '" + pelicula.getActrizPrincipal() + "')";
                        BaseDeDatos.agregarMultimedia(consulta);

                        Principal.multimedias.add(pelicula);
                        JOptionPane.showMessageDialog(null, pelicula);
                    }
                }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        añadirBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                añadirBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                añadirBtn.setBackground(new Color(250, 149, 18));
            }
        });
    }

    public void polloBoton(){
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
