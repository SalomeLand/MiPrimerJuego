package Juego.Interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Juego.Conexion.BdJugador.ConexionJugador;
import Juego.Mejoras.MejorarMetralleta;
import Juego.Modificaciones.Boton;

public class Inicio extends JFrame{
    
    private Boton btnEspad,btnArma,btnArmeria,btnMetralleta,btnEspada;
    private JLabel lblNivelJugador;
    private JPanel panel;

    public Inicio(){
        ConexionJugador.traerNivel();
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
        btnArmeria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                btnEspada.setVisible(true);
                btnMetralleta.setVisible(true);
            }
        });

        btnMetralleta.addActionListener(e->{
            new MejorarMetralleta();
        });
    }

    public void componentes(){
        btnEspad = new Boton("Espada",10f);
        btnEspad.setBounds(50,20,150,50);
        panel.add(btnEspad);
        
        btnArma =  new Boton("Metralleta",10);
        btnArma.setBounds(50, 80, 150, 50);
        panel.add(btnArma);
        
        lblNivelJugador = new JLabel(""+ConexionJugador.nivelJugador);
        lblNivelJugador.setBounds(10, 10, 20, 10);
        lblNivelJugador.setForeground(Color.white);
        panel.add(lblNivelJugador);

        btnEspada = new Boton("Espada",7f);
        btnEspada.setBounds(220,100,100,40);
        btnEspada.setVisible(false);
        panel.add(btnEspada);

        btnMetralleta = new Boton("Metralleta", 7f);
        btnMetralleta.setBounds(320, 100, 110, 40);
        btnMetralleta.setVisible(false);
        panel.add(btnMetralleta);

        btnArmeria = new Boton("Armeria",10f);
        btnArmeria.setBounds(250,45,150,50);
        panel.add(btnArmeria);
    }

    /*public static void main(String[] args) {
        new Inicio();
    }-*/
}
