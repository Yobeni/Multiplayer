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
    private JLabel importeLbl;
    private JSpinner importeSpin;
    public boolean validado = false;

    public pagarDeuda() {
        Color backgroundColor = new Color(255, 222, 89);
        this.setContentPane(panelDeuda);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setBackground(backgroundColor);
        tituloLbl.setFont(new Font("Georgia", Font.BOLD, 30));

        this.setLocationRelativeTo(null);
        this.setTitle("CinePlus");
        agregarmenu();
        this.setVisible(true);
        botonPollo();

        SpinnerNumberModel n = new SpinnerNumberModel();
        n.setMinimum(0);
        importeSpin.setModel(n);
        btnValidar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!nifTF.getText().equals("")&&!passwdTF.getPassword().equals("")){
                        String pass = String.valueOf(passwdTF.getPassword());
                        int contador = 0;
                        for (Socio soc : Principal.socios){
                            contador++;
                            if (soc.getNIF().equals(nifTF.getText())&&soc.getPasswd().equals(pass)){
                                validado = true;
                                deudaTF.setText(soc.getDineroDeuda() + "€");
                                break;
                            }else if (contador == Principal.socios.size()){
                                throw new RuntimeException("El NIF o la contraseña no son correctos");
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
                        int importeIneger = Integer.parseInt(importeSpin.getValue().toString());
                        if (nifTF.getText().equals(soc.getNIF())&&soc.getDineroDeuda()>=importeIneger){
                            soc.setDineroDeuda(soc.getDineroDeuda() - importeIneger);
                            String consultaUpdate = "UPDATE socios SET dinerodeuda = dinerodeuda - " +
                                    importeIneger +" WHERE nif = '" + soc.getNIF() + "';";
                            BaseDeDatos.agregarMultimedia(consultaUpdate);
                            JOptionPane.showMessageDialog(null,"Se han pagado " +
                                    importeIneger + "€ de tu deuda");
                        } else if(!nifTF.getText().equals(soc.getNIF())) {
                            JOptionPane.showMessageDialog(null,"El NIF introducido no pertenece a ningún socio");
                        } else{
                            JOptionPane.showMessageDialog(null,"El importe no puede ser mayor que la deuda");
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
