package Juego.Conexion.InterfazConexion;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import Juego.Conexion.ConexionBD.Conexion;
import Juego.Modificaciones.Boton;

public class Registro  extends JFrame{

    private CajaTexto cajaUsuario,cajaContraseña;
    private JLabel lblUsuario,lblContraseña;
    private JPanel panel;
    private Boton btnRegistro;

    public Registro(){
        panel = new JPanel();
        panel.setLayout(null);
        setSize(500, 300);


        componentes();
        listener();
        add(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void listener(){
        btnRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (cajaUsuario.getText().length() > 2 && cajaContraseña.getText().length() > 2) {
                    try{
                        CallableStatement procedimiento = Conexion.getConexion().prepareCall("{call sp_registrarUsuario(?,?)}");
                        procedimiento.setString(1, cajaUsuario.getText());
                        procedimiento.setString(2, cajaContraseña.getText());
                        procedimiento.execute();
                        new InicioSesion();
                        dispose();
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });

    }

    public void componentes(){
        
        lblUsuario = new JLabel("Usuario :");
        lblUsuario.setBounds(50,60, 157, 20);
        lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
        
        cajaUsuario = new CajaTexto(Color.blue);
        cajaUsuario.setBounds(221, 55, 200, 30);
        
        lblContraseña = new JLabel("Contraseña : ");
        lblContraseña.setBounds(50, 100, 170, 20);
        lblContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
        
        cajaContraseña =  new CajaTexto(Color.blue);
        cajaContraseña.setBounds(221, 95, 200, 30);

        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("PressStart2P-Regular.ttf")).deriveFont(12f); 
            lblUsuario.setFont(customFont);
            lblContraseña.setFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();

        }

        btnRegistro = new Boton("Registrarse",14f);
        btnRegistro.setBounds(140, 170, 200, 60);
        
        panel.add(btnRegistro);
        panel.add(cajaContraseña);
        panel.add(cajaUsuario);
        panel.add(lblUsuario);
        panel.add(lblContraseña);
    }
}

