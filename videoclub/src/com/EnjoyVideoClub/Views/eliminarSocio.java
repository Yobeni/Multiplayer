package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Model.Socio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class eliminarSocio extends VentanaMainGUI{
    private JButton btnPollo;
    private JLabel tituloLbl;
    private JTextField txtField1;
    private JButton AceptarBtn;
    private JLabel lbl1;
    private JPanel devolverPanel;

    public eliminarSocio() {
        this.setContentPane(devolverPanel);
        this.setVisible(true);
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        tituloLbl.setFont(new Font("Georgia", Font.BOLD, 30));
        btnPollo.setBorderPainted(false);
        btnPollo.setContentAreaFilled(false);
        btnPollo.setFocusPainted(false);
        btnPollo.setBorder(new EmptyBorder(5,10,5,10));

        btnPollo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new altasGUI();
                dispose();
            }
        });
        AceptarBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Socio obj1 = new Socio();
                ArrayList <Socio> arrayListSocio = obj1.getArrayListSocio();
                Boolean bool = false;
                String nombreSeleccionado = txtField1.getText();
                for (int i = 0;i<arrayListSocio.size();i++) {
                   if (arrayListSocio.get(i).getNIF().equals(nombreSeleccionado) ) {
                       bool = true;
                       arrayListSocio.remove(i);
                   }
                }
                if (bool) {
                    int option = JOptionPane.showConfirmDialog(null,"Seguro que quiere eliminar?","Confirmación",JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        System.out.println("hola");
                    }
                }

            }
        });
    }
}
