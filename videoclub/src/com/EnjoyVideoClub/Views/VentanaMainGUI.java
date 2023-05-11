package com.EnjoyVideoClub.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMainGUI extends JFrame {
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
    }
}
