<%-- 
    Document   : statistic
    Created on : Aug 20, 2019, 8:11:22 PM
    Author     : YBolshakova
--%>


<%@page import="com.springApp.entities.Photo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dishes:</title>
    </head>
    <body>
        <h1>This is the list of dishes:</h1>
    </body>
    <ul>
        <%
            List<Photo> photos = (List<Photo>) request.getAttribute("photo");           
            if (!photos.isEmpty()) {
                for (Photo p : photos) {

                    out.println("<h1>" + p.toString() + "</h1>");

                }
            } else {
                out.println("<h1>" + "Sorry, we don't have any information yet" + "</h1>");
            }

        %>
        <div>
            <button onclick="location.href = 'index.jsp'">Back to main</button>
        </div>
    </ul>
</html>
