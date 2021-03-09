/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sv.edu.udb.www.conexion.Conexion;
import sv.edu.udb.www.clases.Usuario;
/**
 *
 * @author Drosselmeyer
 */
public class Agregar {
    
    private Conexion objConn = new Conexion();
    private Connection conexion = objConn.getConexion();
    private PreparedStatement ps = null;
    private String query = null;
    
    public void agregarValores(Usuario user){
        
        query = "INSERT INTO usuario (id, nombre, email, celular)"
                + "VALUES(?,?,?,?)";
    
        
        try {
            ps = conexion.prepareStatement(query);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getNombre());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getCelular());

            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
}
