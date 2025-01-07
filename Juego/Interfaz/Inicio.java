package Juego.Interfaz;

import java.awt.Color;

import javax.swing.*;

import Juego.Modificaciones.Boton;

public class Inicio extends JFrame{
    
    private Boton btnEspada,btnArma;
    private JPanel panel;

    public Inicio(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        componentes();
        listener();
        add(panel);
        setSize( 500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void listener(){
        btnEspada.addActionListener(e->{
            new Juego(1);
            setVisible(false);
        });
        btnArma.addActionListener(e->{
            new Juego(2);
            setVisible(false);
        });
    }

    public void componentes(){
        btnEspada = new Boton("Espada",10f);
        btnEspada.setBounds(50,20,150,50);
        panel.add(btnEspada);

        btnArma =  new Boton("Metralleta",10);
        btnArma.setBounds(50, 80, 150, 50);
        panel.add(btnArma);
    }

    /*public static void main(String[] args) {
        new Inicio();
    }-*/
}
