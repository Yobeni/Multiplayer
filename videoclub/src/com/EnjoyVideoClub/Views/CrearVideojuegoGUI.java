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
    private JButton regresarAlMenúDeButton;

    public CrearVideojuegoGUI() {
        Color backgroundColor = new Color(255, 222, 89);
        this.setContentPane(CrearVideojuegoPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 500);

        this.setLocationRelativeTo(null);
        this.setTitle("CinePlus");
        agregarmenu();
        this.setVisible(true);

        ArrayList<Videojuego> videojuegosCreados = new ArrayList<>();


        tituloTxtField.setBackground(new Color(240, 217, 117));
        desarrolladorTxtField.setBackground(new Color(240, 217, 117));
        fechaTxtField.setBackground(new Color(240, 217, 117));
        formatoComboBox.setBackground(new Color(240, 217, 117));
        tituloLbl.setFont(new Font("Georgia", Font.BOLD, 30));

        crearBtn.setBackground(new Color(250, 149, 18));
        regresarAlMenúDeButton.setBackground(new Color(250, 149, 18));
        restablecerBtn.setBackground(new Color(250, 149, 18));

        ps5RadioBtn.setBackground(backgroundColor);
        pcRadioBtn.setBackground(backgroundColor);
        xboxRadioBtn.setBackground(backgroundColor);
        switchRadioBtn.setBackground(backgroundColor);

        formatoComboBox.addItem(FormatoMultimedia.CD);
        formatoComboBox.addItem(FormatoMultimedia.DVD);
        formatoComboBox.addItem(FormatoMultimedia.BLURAY);
        formatoComboBox.addItem(FormatoMultimedia.ARCHIVO);
        formatoComboBox.setEditable(false);

        crearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
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

                    if (videojuego.getPlataformas().size() != 0 && !videojuego.getTitulo().equals("") &&
                            !videojuego.getNombreAutor().equals("")) {
                        videojuegosCreados.add(videojuego);
                        JOptionPane.showMessageDialog(null, videojuego);
                    } else {
                        throw new RuntimeException("Todos los campos deben estar llenos");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
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

        crearBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                crearBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                crearBtn.setBackground(new Color(250, 149, 18));
            }
        });

        regresarAlMenúDeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                regresarAlMenúDeButton.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                regresarAlMenúDeButton.setBackground(new Color(250, 149, 18));
            }
        });

        restablecerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                restablecerBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                restablecerBtn.setBackground(new Color(250, 149, 18));
            }
        });

        regresarAlMenúDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new altasGUI();
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


        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new altasGUI();
                dispose();
            }
        });
    }
}


