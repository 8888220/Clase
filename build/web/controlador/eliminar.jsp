<%-- 
    Document   : eliminar
    Created on : Mar 9, 2021, 11:11:10 AM
    Author     : Drosselmeyer
--%>
<%@page import="sv.edu.udb.www.modelo.Eliminar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            
            Eliminar objEliminar = new Eliminar();
            
            objEliminar.borrarUsuario(id);
        %>
    </body>
    
       
    <script>
        windows.location.href="http:localhost:8080/Clase8/insertarvalores.jsp"
    </script>
</html>
