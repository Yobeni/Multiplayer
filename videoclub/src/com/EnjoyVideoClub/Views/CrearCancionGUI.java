package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.BaseDeDatos;
import com.EnjoyVideoClub.Controller.Constantes;
import com.EnjoyVideoClub.Model.Cancion;
import com.EnjoyVideoClub.Model.FormatoMultimedia;
import com.EnjoyVideoClub.Model.Videojuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CrearCancionGUI extends VentanaMainGUI{


    private JPanel CrearVideojuegoPanel;
    private JLabel tituloLbl;
    private JLabel tituloVideojuegoLbl;
    private JLabel desarrolladorLbl;
    private JLabel formatoLbl;
    private JLabel fechaLbl;
    private JTextField tituloTxtField;
    private JTextField desarrolladorTxtField;
    private JTextField fechaTxtField;
    private JComboBox formatoComboBox;
    private JButton crearBtn;
    private JButton restablecerBtn;
    private JLabel lblPollo;
    private JButton regresarAlMenúDeButton;
    private JLabel LblColaboradores;
    private JTextField colaboradoresTextField1;
    private JTextField duracionTextField;

    private JButton btnPollo;
    private Cancion cancionEnviada;




    public CrearCancionGUI(CrearDiscoGUI c) {
        Color backgroundColor = new Color(255, 222, 89);
        this.setContentPane(CrearVideojuegoPanel);
        this.setSize(500, 350);
        this.setResizable(true);
        this.setPreferredSize(new Dimension(500,200));
        this.setLocationRelativeTo(null);
        this.setTitle("CinePlus");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.setVisible(true);

        tituloTxtField.setBackground(new Color(240, 217, 117));
        desarrolladorTxtField.setBackground(new Color(240, 217, 117));
        fechaTxtField.setBackground(new Color(240, 217, 117));
        formatoComboBox.setBackground(new Color(240, 217, 117));
        tituloLbl.setFont(new Font("Georgia", Font.BOLD, 30));
        colaboradoresTextField1.setBackground(new Color(240, 217, 117));
        duracionTextField.setBackground(new Color(240,217,117));

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
                    double duracionDouble = Double.parseDouble(duracionTextField.getText());


                    if (!tituloTxtField.equals("")&&!duracionTextField.equals("")&&!fechaTxtField.equals("")&&!desarrolladorTxtField.equals("")) {

                        Cancion cancion = new Cancion(tituloTxtField.getText(),
                                desarrolladorTxtField.getText(),
                                (FormatoMultimedia) formatoComboBox.getSelectedItem(), fecha,separarNombres(colaboradoresTextField1.getText()),duracionDouble);

                        Cancion.cancionesCreadas.add(cancion);

                        c.rellenarTextArea();


                        String consulta = "Insert into cancion values (" + "'" + cancion.getTitulo() + "', " +
                                "'" + cancion.getNombreAutor() + "', " + "'" + cancion.getFormato() + "', " +
                                "'" + cancion.getAño() + "', " + "'" + cancion.getColaboradores() + "', " + "'" + cancion.getDuracion() + "', " + "')";
                        BaseDeDatos.agregarMultimedia(consulta);
                        JOptionPane.showMessageDialog(null, cancion);
                        dispose();

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
                dispose();
            }
        });

    }


    private static ArrayList<String> separarNombres(String texto){
        ArrayList<String> nombres = new ArrayList<>();
        String [] nombresArray = texto.split("/");
        for (String nombre : nombresArray) {
            nombres.add(nombre.trim());
        }
        return nombres;
    }

}
