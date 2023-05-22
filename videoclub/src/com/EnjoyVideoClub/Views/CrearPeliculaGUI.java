package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.BaseDeDatos;
import com.EnjoyVideoClub.Model.FormatoMultimedia;
import com.EnjoyVideoClub.Model.Pelicula;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CrearPeliculaGUI extends JFrame{
    private JPanel CrearPeliculaPanel;
    private JTextField tituloTfield;
    private JTextField directorTfield;
    private JTextField FechaTfield;
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


        ArrayList<Pelicula> peliculasCreadas = new ArrayList<>();

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
               duracionSpin.setValue(0);
                ActorTfield.setText("");
                ActrizTfield.setText("");
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

                        peliculasCreadas.add(pelicula);
                        JOptionPane.showMessageDialog(null, pelicula);
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
}
