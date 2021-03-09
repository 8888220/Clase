/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sv.edu.udb.www.conexion.Conexion;
import sv.edu.udb.www.clases.Usuario;

/**
 *
 * @author Drosselmeyer
 */
public class Eliminar {
    
    private Conexion objConn = new Conexion();
    private Connection conexion = objConn.getConexion();
    private PreparedStatement ps = null;
    private String query = null;
    
    public void borrarUsuario(int id){
        try {
            String query = "DELETE from usuario where id=?";
            
            ps=conexion.prepareStatement(query);
            
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
