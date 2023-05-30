package com.EnjoyVideoClub.Views;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        titleLbl.setFont(new Font("Georgia", Font.BOLD, 30));

        agregarmenu();
        mouseHover();

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
        devolverMultimediaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new devolverGUI();
                dispose();
            }
        });
    }

    public void agregarmenu() {
        JMenuBar barra = new JMenuBar();
        Color g2 = new Color(253, 85, 27);
        Color g = new Color(0, 0, 0);
        barra.setBackground(g);


        JMenu s = new JMenu("\uD83D\uDD25");
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
        JMenuItem deuda = new JMenuItem("Pagar deuda");
        barra.add(archivo);
        barra.add(socios);
        archivo.add(guardar);
        archivo.add(salir);
        socios.add(darAlta);
        socios.add(darBaja);
        socios.add(deuda);
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
        darBaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new eliminarSocio();
                dispose();
            }
        });

        deuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new pagarDeuda();
                dispose();
            }
        });

       s.addMenuListener(new MenuListener() {
           @Override
           public void menuSelected(MenuEvent e) {
               JOptionPane.showMessageDialog(null,"hola");
           }

           @Override
           public void menuDeselected(MenuEvent e) {

           }

           @Override
           public void menuCanceled(MenuEvent e) {

           }
       });
    }

    public void mouseHover() {
        Color naranja = new Color(250, 149, 18);
        Color naranjaOscuro = new Color(253, 84, 27);

        darDeAltaButton.setBackground(naranja);
        alquilarMultimediaButton.setBackground(naranja);
        devolverMultimediaButton.setBackground(naranja);
        listarButton.setBackground(naranja);
        salirButton.setBackground(naranja);

        darDeAltaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                darDeAltaButton.setBackground(naranjaOscuro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                darDeAltaButton.setBackground(naranja);
            }
        });
        alquilarMultimediaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                alquilarMultimediaButton.setBackground(naranjaOscuro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                alquilarMultimediaButton.setBackground(naranja);
            }
        });
        devolverMultimediaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                devolverMultimediaButton.setBackground(naranjaOscuro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                devolverMultimediaButton.setBackground(naranja);
            }
        });
        listarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                listarButton.setBackground(naranjaOscuro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                listarButton.setBackground(naranja);
            }
        });
        salirButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                salirButton.setBackground(naranjaOscuro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                salirButton.setBackground(naranja);
            }
        });
    }
}
