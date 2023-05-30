package com.EnjoyVideoClub.Views;

import com.EnjoyVideoClub.Controller.BaseDeDatos;
import com.EnjoyVideoClub.Controller.Principal;
import com.EnjoyVideoClub.Model.Socio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class pagarDeuda extends VentanaMainGUI{
    private JPanel panelDeuda;
    private JTextField nifTF;
    private JPasswordField passwdTF;
    private JTextField deudaTF;
    private JButton btnPollo;
    private JButton btnValidar;
    private JButton btnRegresar;
    private JButton btnPagar;
    private JLabel tituloLbl;
    private JLabel nifLbl;
    private JLabel passwdLbl;
    private JLabel deudaLbl;
    public boolean validado = false;

    public pagarDeuda() {
        Color backgroundColor = new Color(255, 222, 89);
        this.setContentPane(panelDeuda);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setBackground(backgroundColor);

        this.setLocationRelativeTo(null);
        this.setTitle("CinePlus");
        agregarmenu();
        this.setVisible(true);
        botonPollo();
        btnValidar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!nifTF.getText().equals("")&&!passwdTF.getPassword().equals("")){
                        String pass = String.valueOf(passwdTF.getPassword());
                        for (Socio soc : Principal.socios){
                            if (soc.getNIF().equals(nifTF.getText())&&soc.getPasswd().equals(pass)){
                                validado = true;
                                deudaTF.setText(soc.getDineroDeuda() + "€");
                            }else{
                                System.out.println("El NIF o la contraseña són incorrectos");
                            }
                        }
                    } else {
                        throw new RuntimeException("No pueden haber campos vacios");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validado){
                    for (Socio soc : Principal.socios) {
                        if (nifTF.getText().equals(soc.getNIF())){
                            soc.setDineroDeuda(0);
                            String consultaUpdate = "UPDATE socios SET dinerodeuda = 0 WHERE nif = '" + soc.getNIF() + "';";
                            BaseDeDatos.agregarMultimedia(consultaUpdate);
                        }
                    }
                }
            }
        });

        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaMainGUI();
                dispose();
            }
        });
    }

    public void botonPollo(){
        btnPollo.setBorderPainted(false);
        btnPollo.setContentAreaFilled(false);
        btnPollo.setFocusPainted(false);
        btnPollo.setBorder(new EmptyBorder(5,10,5,10));
        panelDeuda.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        btnPollo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaMainGUI();
                dispose();
            }
        });
    }
}
