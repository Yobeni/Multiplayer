package com.EnjoyVideoClub.Views;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CrearPeliculaGUI {
    private JPanel CrearPeliculaPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton restablecerBtn;
    private JButton añadirBtn;
    private JLabel tituloLbl;
    private JLabel tituloPeliculaLbl;
    private JLabel directorLbl;
    private JLabel formatoLbl;
    private JComboBox comboBox1;
    private JLabel fechaLbl;
    private JLabel durecionLbl;
    private JLabel actorLbl;
    private JLabel actrizLbl;

    public CrearPeliculaGUI() {
        CrearPeliculaPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
    }
}
