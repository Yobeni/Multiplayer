package com.EnjoyVideoClub.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class
VentanaMainGUI extends JFrame {
    private JPanel panel1;
    private JLabel titleLbl;
    private JButton darDeAltaButton;
    private JButton alquilarMultimediaButton;
    private JButton devolverMultimediaButton;
    private JButton listarButton;
    private JButton salirButton;

    public VentanaMainGUI() {
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Cine Plus Videoclub - Menú Principal");
        this.setVisible(true);

        this.setBackground(new Color(255, 222, 89));

        agregarmenu();

        darDeAltaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new altasGUI();
                dispose();
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        alquilarMultimediaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AlquilarGUI();
                dispose();
            }
        });
    }

    public void agregarmenu() {
        JMenuBar barra = new JMenuBar();
        Color g2 = new Color(253, 85, 27);
        Color g = new Color(0, 0, 0);
        barra.setBackground(g);


        JMenuItem s = new JMenu("\uD83D\uDD25");
        s.setForeground(g2);
        barra.add(s);
        Font font = s.getFont().deriveFont(18f);
        s.setFont(font);

        JMenu archivo = new JMenu("Archivo");
        archivo.setForeground(Color.orange);
        JMenu socios = new JMenu("Socios");
        socios.setForeground(g2);
        JMenuItem salir = new JMenuItem("Salir");
        JMenuItem guardar = new JMenuItem("Guardar archivo");
        JMenuItem darAlta = new JMenuItem("Dar de Alta");
        JMenuItem darBaja = new JMenuItem("Dar de Baja");
        barra.add(archivo);
        barra.add(socios);
        archivo.add(guardar);
        archivo.add(salir);
        socios.add(darAlta);
        socios.add(darBaja);
        setJMenuBar(barra);


        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        darAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CrearSocioGUI();
                dispose();
            }
        });

        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new altasGUI();
                dispose();
            }
        });
    }
}
