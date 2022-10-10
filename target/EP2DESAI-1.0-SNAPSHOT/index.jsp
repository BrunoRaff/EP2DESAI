<%-- 
    Document   : index
    Created on : 09/10/2022, 02:21:38 PM
    Author     : NModem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menu Principal</h1>
        <ol>
            <li><a href="<%= request.getContextPath()%>/UserServlet">Añadir Usuario</a></li>
            <li><a href="<%= request.getContextPath()%>/UserUpdateServlet">Editar Usuario</a> </li>
            <li><a href="<%= request.getContextPath()%>/UserDeleteServlet">Eliminar Usuario</a> </li>
        </ol>
    </body>
</html>
