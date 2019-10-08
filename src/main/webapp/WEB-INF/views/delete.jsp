<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Photo list</title>
</head>
<body>
<form action="delete" method="post">
    <input type="submit" value="Delete marked">
    <table border="1">
        <tr>
            <th>Photo</th><th>Photo ID</th>
        </tr>
        <c:forEach items="${photos}" var="p">
            <tr>                
                <td>${p}</td>
                <td>
                    <input type="checkbox" name="photos" value="${p}">
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
<br>
<br>
<a href="/photo/all">To all</a>
</body>
</html>
