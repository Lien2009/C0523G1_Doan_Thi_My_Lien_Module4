<%--
  Created by IntelliJ IDEA.
  User: mylie
  Date: 9/15/2023
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Caculator</h1>
<form action="/calculate" method="post">
    <input type="number" name="x" id="x">
    <input type="number" name="y" id="y"><br><br>
    <button value='+' name="calculate">Addition</button>
    <button value='-' name="calculate">Subtraction</button>
    <button value='*' name="calculate">Multiplication</button>
    <button value='/' name="calculate">Division</button>
</form>
<h2>${message}</h2>
<h2>Result: ${result}</h2>
</body>
</html>
