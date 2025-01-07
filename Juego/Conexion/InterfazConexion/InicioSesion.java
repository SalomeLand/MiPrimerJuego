
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

import Juego.Conexion.BdJugador.ConexionJugador;
import Juego.Conexion.ConexionBD.Conexion;
import Juego.Interfaz.Inicio;
import Juego.Modificaciones.Boton;

public class InicioSesion  extends JFrame{

    private CajaTexto cajaUsuario,cajaContraseña;
    private JLabel lblUsuario,lblContraseña;
    private JPanel panel;
    private Boton btnInicio,btnRegistro;

    public InicioSesion(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.orange);
        setSize(500, 300);


        componentes();
        listener();
        add(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void listener(){

        btnInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Conexion.usuario = cajaUsuario.getText();
                Conexion.contraseña = cajaContraseña.getText();
                try{
                    CallableStatement procedimiento = Conexion.getConexion().prepareCall("{call sp_existeUsuario(?,?,?)}");
                    procedimiento.setString(1, cajaUsuario.getText());
                    procedimiento.setString(2, cajaContraseña.getText());
                    procedimiento.registerOutParameter(3, java.sql.Types.INTEGER);
                    procedimiento.execute();
                    int jugadorID = procedimiento.getInt(3);
                    ConexionJugador.jugadorID = jugadorID;
                    new Inicio();
                    dispose();
                }catch(SQLServerException ex){
                    System.out.println(ex.getMessage());
                }catch(SQLException w){
                    System.out.println(w.getStackTrace());
                }
            }
        });

        btnRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Registro();
                dispose();
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

        btnInicio = new Boton("Iniciar",11f);
        btnInicio.setBounds(80, 170, 150, 50);

        btnRegistro = new Boton("Registrarse",11f);
        btnRegistro.setBounds(250, 170, 150, 50);
        
        panel.add(btnRegistro);
        panel.add(btnInicio);
        panel.add(cajaContraseña);
        panel.add(cajaUsuario);
        panel.add(lblUsuario);
        panel.add(lblContraseña);
    }
}
