package com.EnjoyVideoClub.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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

        regresarAlMenuPrincipal();
        mostrarFechaFinal();
        alquilar();
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
                            "\nNO EXCEDER EL LÍMITE.");
                } else {
                    throw new RuntimeException("Los datos no han sido validados.");
                }
            }
        });
    }
}
