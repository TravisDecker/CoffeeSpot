<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>CoffeeSpot</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<h1>CoffeeSpot</h1>
<h2>Create a Post</h2>
<form:form action="/auth/coffeepost" method="POST" modelAttribute="coffeePostDto">

    <form:label path="body">CoffeePost</form:label>
    <form:input path="body"/><br><br>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Submit">
</form:form>

<h2>Feed</h2>
<table>
    <c:forEach var="post" items="${feedPosts}">
        <tr>
            <th><c:out value="${post.user.username}"/></th>
        </tr>
        <tr>
            <td><c:out value="${post.postBody}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>