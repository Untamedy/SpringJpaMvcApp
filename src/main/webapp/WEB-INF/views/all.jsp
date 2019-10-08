<%-- 
    Document   : all
    Created on : Oct 5, 2019, 4:50:43 PM
    Author     : YBolshakova
--%>

<%@page import="java.util.List"%>
<%@page import="com.springApp.entities.Photo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your photo</title>
    </head>
    <body>
        <form action="delete" method="post">
            <%
                out.println("<table  border = \"1\">");
                out.println("<tr>"
                        + "<th> Photo </th>"
                        + "<th>Photo ID</th> "
                        + "<th> </th> "
                        + "</tr> ");
                List<Photo> allphotos = (List<Photo>) request.getAttribute("photos");
                if (!allphotos.isEmpty()) {
                    for (Photo p : allphotos) {
                        out.println("<tr>");
                        out.println("<td>" + p.getName() + "</td>");
                        out.println("<td>" + p.getId() + "</td>");
                        out.println("<td> <input type=\"checkbox\" name=\"photos\" value=\"" + p.getId() + "\"" + "</td>");
                        out.println("</tr>");

                    }
                } else {
                    out.println("<h1>" + "Sorry, we don't have any information yet" + "</h1>");
                }
                out.println("<input type = \"submit\" value = \"Delete marked\" />");

            %>
            <br>
            <br>


        </form>
    </body>
</html>
