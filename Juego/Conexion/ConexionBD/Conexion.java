package Juego.Conexion.ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public static String servidor;
    public static  String database;
    public static  String usuario;
    public static  String contraseña;
    public static String error = "";
    public static boolean estatus = false;
    
    public static Connection getConexion(){
        String conexionUrl = "jdbc:sqlserver://localhost:1433;"
                + "database=juegoZombie;"
                + "user=IRVIN;"
                + "password=123;"
                + "loginTimeout=10;"
                + "trustServerCertificate=True";
        try{
            Connection con = DriverManager.getConnection(conexionUrl);
            estatus =true;
            System.out.println("Conectado");
            return con;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            error =e.getMessage();
            estatus = false;
            return null;
        }
    }
}
