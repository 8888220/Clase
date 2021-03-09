<%-- 
    Document   : editar.jsp
    Created on : Mar 9, 2021, 11:01:41 AM
    Author     : Drosselmeyer
--%>
<%@page import="sv.edu.udb.www.clases.Usuario"%>
<%@page import="sv.edu.udb.www.modelo.Actualizar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            Actualizar objActualizar = new Actualizar();
            Usuario objUser = objActualizar.obtenerUsuario(id);
        %>
        
        <center>
            <form action="controladores/editarcontrolador.jsp">
                Id:     <input type="text" name="id" value=<%=objUser.getId()%>><br>
                Nombre: <input type="text" name="nombre" value=<%=objUser.getNombre()%>><br>
                Correo: <input type="text" name="email" value=<%=objUser.getEmail()%>><br>
                Celular:<input type="text" name="celular" value=<%=objUser.getCelular()%>><br>
                <input type="submit" value="Edit">
            </form>
        </center>
    </body>
</html>
