/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Drosselmeyer
 */
public class Conexion{
    
    //Propiedades
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/";
    String db = "usuarios?useSSL=false";
    String user = "root";
    String pass = "123456";
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url+db,user,pass);
        }catch(ClassNotFoundException | SQLException e){
                System.out.println(e);
        }
        return conn;
    }
    
}
