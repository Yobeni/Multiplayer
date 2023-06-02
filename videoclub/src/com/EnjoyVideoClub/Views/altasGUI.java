package com.EnjoyVideoClub.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class altasGUI extends VentanaMainGUI{
    private JPanel panel1;
    private JLabel titleLbl;
    private JLabel descripLbl;

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
        colores();
        nuevasVentanas();
    }

    public void colores() {
        Color naranja = new Color(250, 149, 18);
        Color naranjaOscuro = new Color(253, 84, 27);

        altaJuegoBtn.setBackground(naranja);
        altaPeliBtn.setBackground(naranja);
        altaCancionBtn.setBackground(naranja);
        atrasBtn.setBackground(naranja);

        altaJuegoBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                altaJuegoBtn.setBackground(naranjaOscuro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                altaJuegoBtn.setBackground(naranja);
            }
        });

        altaPeliBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                altaPeliBtn.setBackground(naranjaOscuro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                altaPeliBtn.setBackground(naranja);
            }
        });

        altaCancionBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                altaCancionBtn.setBackground(naranjaOscuro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                altaCancionBtn.setBackground(naranja);
            }
        });

        atrasBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                atrasBtn.setBackground(naranjaOscuro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                atrasBtn.setBackground(naranja);
            }
        });
    }

    public void nuevasVentanas() {
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
