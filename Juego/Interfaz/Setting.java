package Juego.Interfaz;

import java.awt.Color;

import javax.swing.*;

import Juego.Modificaciones.Boton;

public class Setting extends JPanel{
    
    private JPanel panel;
    private Boton btnMenu,btnRegreso;

    public Setting(){
        componentes();
        setBackground(Color.orange);
        setBounds(200,200,400,200);
        setFocusable(false);
        setVisible(true);
    }


    public void componentes(){
        btnMenu = new Boton("Ir al menu",10);
        btnMenu.setBounds(50,100,150,50);
        add(btnMenu);

        btnRegreso = new Boton("Regresar",10);
        btnRegreso.setBounds(200, 100, 150, 50);
        add(btnRegreso);
        btnRegreso.addActionListener(e->{
            setVisible(false);
        });
    }

}
