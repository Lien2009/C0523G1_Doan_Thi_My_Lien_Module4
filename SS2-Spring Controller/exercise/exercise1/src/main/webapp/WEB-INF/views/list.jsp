<%--
  Created by IntelliJ IDEA.
  User: mylie
  Date: 9/15/2023
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiment</h1>
<form action="/condiment" method="post">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce<br>
    <input type="checkbox" name="condiment" value="Tomato">Tomato<br>
    <input type="checkbox" name="condiment" value="Mustard">Mustard<br>
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts<br>
    <button>Save</button>
</form>
<h2>Bạn đã chọn các gia vị mix Sandwwich:</h2>
<c:forEach var="c" items="${condiment}">
    ${c} <br>
</c:forEach>
</body>
</html>
