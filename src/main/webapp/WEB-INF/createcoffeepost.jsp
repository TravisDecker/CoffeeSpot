<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>CoffeePost</title>
    <link rel="stylesheet" href="/styles.css">
</head>

<body>


<form:form action="/auth/coffeepost" method="POST" modelAttribute="coffeePostDto">

    <form:label path="body">CoffeePost</form:label>
    <form:input path="body"/><br><br>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Submit">
</form:form>

</body>

</html>