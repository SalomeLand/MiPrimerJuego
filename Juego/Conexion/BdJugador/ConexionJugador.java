package Juego.Conexion.BdJugador;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Juego.Conexion.ConexionBD.Conexion;

public class ConexionJugador {
    
    public static int nivelJugador,puntosJugador,jugadorID;
    public static String nombreJugador;
    public static Connection con = Conexion.getConexion();

    public static int nivelMetralleta,dañoMetralleta,velocidadMetralleta;

    public static void traerNivel(){
        try{
            String consulta = "select jugadorID,nivel,puntos from jugadores where jugadorID = ?";
            PreparedStatement sql = con.prepareStatement(consulta);
            sql.setInt(1, jugadorID);
            ResultSet res = sql.executeQuery();

            if (res.next()) {
                nivelJugador = res.getInt("nivel");
                puntosJugador = res.getInt("puntos");
                System.out.println(puntosJugador);
                System.out.println(nivelJugador);
            } else {
                System.out.println("Jugador no encontrado.");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void actualizarArma(int daño, int velocidad,int puntos){
        try{
            String consulta = "update jugadorArmas set daño = ?, velocidad = ? where armaid = 1";
            PreparedStatement sql = con.prepareStatement(consulta);
            sql.setInt(1, daño);
            sql.setInt(2, velocidad);
            sql.executeUpdate();

            consulta = "update jugadores set puntos = ? where JugadorID = "+jugadorID;
            sql = con.prepareStatement(consulta);
            sql.setInt(1, puntos);
            sql.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void actualizarJugador(int nivel,int puntos){
        try{
            String consulta = "update jugadores set nivel = ?,puntos = ? where jugadorID = ?";
            PreparedStatement sql = con.prepareStatement(consulta);
            sql.setInt(1,nivel);
            sql.setInt(2,puntos);
            sql.setInt(3,jugadorID);
            sql.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void traerMetralleta(){
        try{
            String consulta = "select ja.nivel, ja.Daño, ja.velocidad " + //
                                "from Armas a " + //
                                "inner join JugadorArmas ja on a.ArmaID = ja.ArmaID " + //
                                "inner join Jugadores j on j.JugadorID = ja.JugadorID " + //
                                "where j.JugadorID = ? and a.nombre = 'metralleta'";
            PreparedStatement sql = con.prepareStatement(consulta);
            sql.setInt(1,jugadorID);
            ResultSet res = sql.executeQuery();
            
            if (res.next()) {
                nivelMetralleta = res.getInt("nivel");
                dañoMetralleta = res.getInt("daño");
                velocidadMetralleta= res.getInt("velocidad");
            } else {
                System.out.println("Jugador no encontrado.");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
