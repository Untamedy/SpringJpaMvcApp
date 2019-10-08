<%-- 
    Document   : viewPhoto
    Created on : Oct 8, 2019, 4:14:31 PM
    Author     : YBolshakova
--%>

<%@page import="com.springApp.entities.Photo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Photo view</title>
    </head>
    <body>
        <h1>Your photo</h1>
        <%
            String path =(String) request.getAttribute("path");
            out.println("<img src=\""+ path + "\" width=\"100\" height=\"100\">");
        
        %>
        
        <br>
        <br>
        
         <button onclick="location.href = 'all'">Back</button>
    </body>
</html>
