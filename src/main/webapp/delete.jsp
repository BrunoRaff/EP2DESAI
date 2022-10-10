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
        <title>User Delete form</title>
    </head>
    <body>
        <h1>Complete the fields</h1>
        
        <form action="<%= request.getContextPath()%>/UserDeleteServlet" method="post">
            <table style="width:80%">
        <tr>
            <td>ID</td>
            <td><input type="text" name="alu_id" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Delete" /></td>
        </tr>
    </table>
        </form>
    </body>
</html>
