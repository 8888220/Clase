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
import java.util.ArrayList;
import java.util.List;

import sv.edu.udb.www.conexion.Conexion;
import sv.edu.udb.www.clases.Usuario;
/**
 *
 * @author Drosselmeyer
 */
public class Leer {
    
    private Conexion objConn = new Conexion();
    private Connection con = objConn.getConexion();
    private PreparedStatement ps = null;
    private ResultSet rs=null;
    private List listadoUsuarios = new ArrayList();
    private String query = null;
    
    public List getUsuarios(){
        
        try {
            query = "select * from usuario";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Usuario user = new Usuario();
                
                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setEmail(rs.getString("email"));
                user.setCelular(rs.getString("celular"));
                
                listadoUsuarios.add(user);
            }
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return listadoUsuarios;
                
    }
    
}
