<%-- 
    Document   : register
    Created on : 01/10/2022, 05:10:23 PM
    Author     : NModem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User register form</title>
    </head>
    <body>
        <h1>Complete the fields</h1>
        
        <form action="<%= request.getContextPath()%>/UserServlet" method="post">
            <table style="width:80%">
        <tr>
            <td>Nombre</td>
            <td><input type="text" name="alu_nombre" /></td>
        </tr>
        <tr>
            <td>Usuario</td>
            <td><input type="text" name="alu_usuario" /></td>
        </tr>
        <tr>
            <td>Contraseña</td>
            <td><input type="password" name="alu_password" /></td>
        </tr>
        <tr>
            <td>Direccion</td>
            <td><input type="text" name="alu_direccion" /></td>
        </tr>
        <tr>
            <td>Telefono</td>
            <td><input type="text" name="alu_telefono" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="alu_email" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Register" /></td>
        </tr>
    </table>
        </form>
    </body>
</html>
