package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.BaseDeDatos;
import com.EnjoyVideoClub.Model.FormatoMultimedia;
import com.EnjoyVideoClub.Model.Pelicula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrearPeliculaGUI extends VentanaMainGUI{
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
    private JSpinner duracionSpin;

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

        SpinnerModel value = new SpinnerNumberModel(0, 0, null, 1);
        duracionSpin.setModel(value);

        retrocederBtn.setBackground(new Color(250, 149, 18));
        añadirBtn.setBackground(new Color(250, 149, 18));
        restablecerBtn.setBackground(new Color(250, 149, 18));

        tituloLbl.setFont(new Font("Georgia", Font.BOLD, 30));
        agregarmenu();

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

        retrocederBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                retrocederBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                retrocederBtn.setBackground(new Color(250, 149, 18));
            }
        });

        añadirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (!tituloTfield.equals("")&&!directorTfield.equals("")&&!ActorTfield.equals("")&&!ActrizTfield.equals("")){
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = formato.parse(FechaTfield.getText());

                        Pelicula pelicula = new Pelicula(tituloTfield.getText(),directorTfield.getText(),
                                (FormatoMultimedia) FormatoCbo.getSelectedItem()
                                ,fecha, (Integer) duracionSpin.getValue(),ActorTfield.getText(),ActrizTfield.getText());

                        String consulta = "Insert into pelicula values (" + "'" + pelicula.getTitulo() + "', " +
                                "'" + pelicula.getNombreAutor() + "', " + "'" + pelicula.getFormato() + "', " +
                                "'" + pelicula.getAño() + "', " + pelicula.getDuracionPelicula() + ", '" +
                                pelicula.getActorPrincipaL() + "', '" + pelicula.getActrizPrincipal() + "')";
                        BaseDeDatos.agregarMultimedia(consulta);

                        Pelicula.listaPeliculas.add(pelicula);
                        JOptionPane.showMessageDialog(null, pelicula);
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        añadirBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                añadirBtn.setBackground(new Color(253, 84, 27));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                añadirBtn.setBackground(new Color(250, 149, 18));
            }
        });
    }
}
