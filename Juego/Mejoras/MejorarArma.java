package Juego.Mejoras;

import javax.swing.*;

import Juego.Modificaciones.Boton;

public class MejorarArma extends JFrame{
    
    private Boton boton;
    private JPanel panel;

    public void MejorarArma(){
        panel = new JPanel();
        setSize(500,400);

        componentes();
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void componentes(){
        boton = new Boton("Aumentar el daño +20", 10f);
        boton.setBounds(200, 200, 1500, 30);


        panel.add(boton);
    }
}
