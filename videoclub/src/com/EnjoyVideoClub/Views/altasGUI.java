package com.EnjoyVideoClub.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class altasGUI extends VentanaMainGUI{
    private JPanel panel1;
    private JLabel titleLbl;
    private JLabel descripLbl;
    private JButton altaSocioBtn;
    private JButton altaPeliBtn;
    private JButton altaJuegoBtn;
    private JButton altaCancionBtn;
    private JButton atrasBtn;

    public altasGUI() {
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Cine Plus Videoclub - Menú de altas");
        this.setVisible(true);

        agregarmenu();
        altaJuegoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CrearVideojuegoGUI();
                dispose();
            }
        });

        altaPeliBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CrearPeliculaGUI();
                dispose();
            }
        });

        atrasBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaMainGUI();
                dispose();
            }
        });
        altaCancionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CrearDiscoGUI();
                dispose();
            }
        });
    }

}
