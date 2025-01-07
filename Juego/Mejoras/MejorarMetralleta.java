package Juego.Mejoras;

import java.awt.event.ActionListener;

import javax.swing.*;

import Juego.Conexion.BdJugador.ConexionJugador;
import Juego.Modificaciones.Boton;

public class MejorarMetralleta extends JFrame{
    
    private Boton btnRegresar,btnAumentarDaño,btnAumentarVelocidad;
    private JPanel panel;
    private JLabel lblPuntos;

    public MejorarMetralleta(){
        ConexionJugador.traerMetralleta();
        panel = new JPanel();
        panel.setLayout(null);
        setSize(400,300);

        componentes();
        listener();
        add(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void listener(){
        ActionListener action = e->{
            if (ConexionJugador.puntosJugador > 0) {
                if (e.getSource() == btnAumentarDaño) {
                    ConexionJugador.dañoMetralleta += 20;
                    ConexionJugador.puntosJugador -= 1;
                }else if(e.getSource() == btnAumentarVelocidad){
                    ConexionJugador.puntosJugador -= 1;
                    ConexionJugador.velocidadMetralleta += 2;
                }
                lblPuntos.setText("Puntos : "+ConexionJugador.puntosJugador);
            }
        };
        btnAumentarDaño.addActionListener(action);
        btnAumentarVelocidad.addActionListener(action);

        btnRegresar.addActionListener(e->{
            ConexionJugador.actualizarArma(ConexionJugador.dañoMetralleta, ConexionJugador.velocidadMetralleta,ConexionJugador.puntosJugador);
            dispose();
        });
    }

    public void componentes(){
        lblPuntos = new JLabel("Puntos : "+ConexionJugador.puntosJugador);
        lblPuntos.setBounds(10, 10, 100, 20);

        btnAumentarDaño = new Boton("Daño", 12f);
        btnAumentarDaño.setBounds(100, 50, 200, 50);

        btnAumentarVelocidad = new Boton("Velocidad", 12f);
        btnAumentarVelocidad.setBounds(100, 120, 200, 50);

        btnRegresar = new Boton("Regresar", 12);
        btnRegresar.setBounds(100,200,200,50);

        panel.add(btnRegresar);
        panel.add(btnAumentarVelocidad);
        panel.add(btnAumentarDaño);
        panel.add(lblPuntos);
    }
}
