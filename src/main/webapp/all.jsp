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
        <ul>
            <%
                List<Photo> allphotos = (List<Photo>) request.getAttribute("list");
                if (!allphotos.isEmpty()) {
                    for (Photo p : allphotos) {
                        out.println("<br>");
                        String name = "<a href='getPhoto?id=" + p.getId() + "'>" + "Photo " + p.getName() + "</a>";
                        out.println(" <form action = \"delete\this\" method = \"POST\" target = \"_blank\">");
                        out.println("<input type = \"checkbox\" name = photoId  checked = \"checked\" /> + name");
                        out.println("<br>");
                        out.println("<input type = \"submit\" value = \"Delete Photos\" />");

                    }
                } else {
                    out.println("<h1>" + "Sorry, we don't have any information yet" + "</h1>");
                }

            %>
            <br>
            <br>

        </ul>

    </body>
</html>
