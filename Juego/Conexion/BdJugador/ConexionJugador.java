package Juego.Conexion.BdJugador;

import java.sql.Connection;

import Juego.Conexion.ConexionBD.Conexion;

public class ConexionJugador {
    
    private Connection con;

    public ConexionJugador(String nombreUsuario, String contraseña){
        con = Conexion.getConexion();
    }
}
