package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Model.FormatoMultimedia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CrearPeliculaGUI extends JFrame{
    private JPanel CrearPeliculaPanel;
    private JTextField tituloTfield;
    private JTextField directorTfield;
    private JTextField FechaTfield;
    private JTextField DurecionTfield;
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
    private JLabel lblPollo;

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

        CrearPeliculaPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        retrocederBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new altasGUI();
                dispose();
            }
        });
        restablecerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tituloTfield.setText("");
                directorTfield.setText("");
                FormatoCbo.setSelectedIndex(0);
                FechaTfield.setText("");
                DurecionTfield.setText("");
                ActorTfield.setText("");
                ActrizTfield.setText("");
            }
        });
    }
}
