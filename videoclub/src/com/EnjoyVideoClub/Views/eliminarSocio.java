package com.EnjoyVideoClub.Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eliminarSocio extends VentanaMainGUI{
    private JButton btnPollo;
    private JLabel tituloLbl;
    private JTextField txtField1;
    private JButton AceptarBtn;
    private JLabel lbl1;
    private JPanel Jpanel1;

    public eliminarSocio() {
        this.setContentPane(Jpanel1);
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
    }
}
