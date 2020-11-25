<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<html>

<head>
    <title>CoffeeSpot Users</title>
</head>

<body>
<h1>Looking though users for ${username}!</h1>
<table>
    <tr>
        <th>Username</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th></th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user.userName}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><form:form action="/auth/search" method="post">
                <input type="hidden" name="username" value="${user.userName}">
                <input type="submit" value="Follow User">
            </form:form></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>