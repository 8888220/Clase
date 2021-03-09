<%-- 
    Document   : insertarvalores
    Created on : Mar 9, 2021, 10:42:47 AM
    Author     : Drosselmeyer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Importacion de librerias de Java-->
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<!--Importacion de clases del proyecto-->
<%@page import="sv.edu.udb.www.clases.Usuario"%>
<%@page import="sv.edu.udb.www.modelo.Leer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar datos</title>
    </head>
    <body>
        <center>
            <h1>Insertar valores</h1>
            <form action="controladores/insertarcontrolador.jsp">
                Id:     <input type="text" name="id"><br>
                Nombre: <input type="text" name="nombre"><br>
                Correo: <input type="text" name="email"><br>
                Celular:<input type="text" name="celular"><br>
                <input type="submit" value="Insertar">
            </form>
            
            <hr>
            
            <%
                Leer leerUsuarios = new Leer();
                List<Usuario> list = leerUsuarios.getUsuarios();
                Iterator<Usuario> it_list = list.iterator();
            %>
            
            <table border="1">
                
                <%
                    while(it_list.hasNext()){
                        Usuario user = new Usuario();
                        user=it_list.next();
                %>
                <tr>
                    <td><%=user.getId() %></td>
                    <td><%=user.getNombre() %></td>
                    <td><%=user.getEmail() %></td>
                    <td><%=user.getCelular() %></td>
                    <td>
                        <a href="editarvalores.jsp?id=<%=user.getId()%>">Editar</a>
                    </td>
                    <td>
                        <a href="controladores/eliminarcontrolador.jsp?id=<%=user.getId()%>">Eliminar</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            
        <center>
    </body>
</html>
