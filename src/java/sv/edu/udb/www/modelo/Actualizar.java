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
public class Actualizar {
    
    private Conexion objConn = new Conexion();
    private Connection conexion = objConn.getConexion();
    private PreparedStatement ps = null;
    private String query = null;
    private ResultSet rs=null;
    
    public Usuario obtenerUsuario(int id){
        Usuario actUser = new Usuario();
        
        try {
            String query = "select * from usuario where id=?";
            ps= conexion.prepareStatement(query);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                actUser.setId(rs.getInt("id"));
                actUser.setNombre(rs.getString("nombre"));
                actUser.setEmail(rs.getString("email"));
                actUser.setCelular(rs.getString("celular"));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        ps = null;
        return actUser;
        
    }
    
    public void actualizarUsuario(Usuario user){
        
        try {
            String query = "UPDATE usuario SET nombre=?, email=?, celular=? where id=?";
            
            ps = conexion.prepareStatement(query);
            
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCelular());
            ps.setInt(4, user.getId());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
}
