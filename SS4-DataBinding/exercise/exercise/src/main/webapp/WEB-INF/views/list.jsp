<%--
  Created by IntelliJ IDEA.
  User: mylie
  Date: 9/18/2023
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        .bold {
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Settings</h1>
<table>
    <form:form modelAttribute="email" action="/email/update" method="post">
        <tr>
            <td class="bold">Languages</td>
            <td><form:select path="language" items="${languages}"/></td>
        </tr>
        <tr>
            <td class="bold">Page Size:</td>
            <td><form:select path="page" items="${sizes}"/> emails per page</td>
        </tr>
        <tr>
            <td class="bold">Spams filter:</td>
            <td><form:checkbox path="spam" value="true"/> Enable spams filter</td>
        </tr>
        <tr>
            <td class="bold">Signature:</td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td>
                <form:button>Update</form:button>
            </td>
            <td>
                <form:button type="button">Close</form:button>
            </td>
        </tr>
    </form:form>
</table>
<c:if test="${mess != null}">
    ${mess}
</c:if>
</body>
</html>
