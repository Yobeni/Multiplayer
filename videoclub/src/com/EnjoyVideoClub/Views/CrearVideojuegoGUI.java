package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CrearVideojuegoGUI extends JFrame {
    private JPanel CrearVideojuegoPanel;
    private JLabel tituloLbl;
    private JLabel tituloVideojuegoLbl;
    private JLabel desarrolladorLbl;
    private JLabel formatoLbl;
    private JLabel fechaLbl;
    private JLabel plataformaLbl;
    private JTextField tituloTxtField;
    private JTextField desarrolladorTxtField;
    private JTextField fechaTxtField;
    private JRadioButton ps5RadioBtn;
    private JRadioButton xboxRadioBtn;
    private JRadioButton switchRadioBtn;
    private JRadioButton pcRadioBtn;
    private JButton crearBtn;
    private JComboBox formatoComboBox;
    private JButton restablecerBtn;
    private JLabel lblPollo;

    public CrearVideojuegoGUI() {
        this.setContentPane(CrearVideojuegoPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 500);

        this.setLocationRelativeTo(null);
        this.setTitle("Añadir videojuego");
        this.setVisible(true);

        tituloLbl.setFont(new Font("Verdana", Font.BOLD, 20));

        formatoComboBox.addItem(FormatoMultimedia.CD);
        formatoComboBox.addItem(FormatoMultimedia.DVD);
        formatoComboBox.addItem(FormatoMultimedia.BLURAY);
        formatoComboBox.addItem(FormatoMultimedia.ARCHIVO);

        crearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Videojuego> videojuegosCreados = new ArrayList<>();

                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha = formato.parse(fechaTxtField.getText());

                    Videojuego videojuego = new Videojuego(tituloTxtField.getText(),
                            desarrolladorTxtField.getText(),
                            (FormatoMultimedia) formatoComboBox.getSelectedItem(), fecha);

                    if (ps5RadioBtn.isSelected()) {
                        PlataformaVideojuego ps5 = PlataformaVideojuego.PS5;
                        videojuego.añadirPlataformas(ps5);
                    }
                    if (xboxRadioBtn.isSelected()) {
                        PlataformaVideojuego xbox = PlataformaVideojuego.XBOX;
                        videojuego.añadirPlataformas(xbox);
                    }
                    if (switchRadioBtn.isSelected()) {
                        PlataformaVideojuego nintendo = PlataformaVideojuego.SWITCH;
                        videojuego.añadirPlataformas(nintendo);
                    }
                    if (pcRadioBtn.isSelected()) {
                        PlataformaVideojuego pc = PlataformaVideojuego.PC;
                        videojuego.añadirPlataformas(pc);
                    }
                    videojuegosCreados.add(videojuego);
                    JOptionPane.showMessageDialog(null, videojuego);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        restablecerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tituloTxtField.setText("");
                desarrolladorTxtField.setText("");
                fechaTxtField.setText("");
                pcRadioBtn.setSelected(false);
                ps5RadioBtn.setSelected(false);
                xboxRadioBtn.setSelected(false);
                switchRadioBtn.setSelected(false);
                formatoComboBox.setSelectedIndex(0);
            }
        });
    }
}
