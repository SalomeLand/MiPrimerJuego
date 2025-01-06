package Juego.Interfaz;

import java.awt.Color;

import javax.swing.*;

import Juego.Modificaciones.Boton;

public class PasarNivel extends JPanel {

    private JFrame frame;
    private Boton btnIrAlMenu;

    public PasarNivel(){
        setLayout(null);
        setBackground(Color.orange);
        componentes();
        listener();
        frame = new JFrame();
        frame.setSize(400, 200);
        frame.add(this);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
    }
    public JFrame getJFrame(){
        return frame;
    }

    public void listener(){
        btnIrAlMenu.addActionListener(e ->{
            Inicio inicio = new Inicio();
            inicio.setVisible(true);
            frame.setVisible(false);
        });
    }

    public void componentes(){
        btnIrAlMenu = new Boton("Regresar");
        btnIrAlMenu.setBounds(50,20,150,50);
        add(btnIrAlMenu);
    }
}
