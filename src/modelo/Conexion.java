package modelo;

//si wa a usar DB, usar DB con XAAMP puerto 3306 MYSQL; 80,443 APACHE

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private String base = "clavistel";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection con = null;

    public Connection getConexion(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection(this.url,this.user,this.password);        
    }catch(SQLException e) {
        System.err.println(e);        
    }catch (ClassNotFoundException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE , null, ex);
    }
    return con;
  }  
}









