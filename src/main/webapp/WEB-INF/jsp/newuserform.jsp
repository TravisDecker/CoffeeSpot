<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>CoffeeSpot Signup</title>
</head>

<body>
<h1>Signup for CoffeeSpot!</h1>
<p>The site is currently under construction, stay tuned for updates.</p>


<form:form action="/user/create" method="POST" modelAttribute="userCreationDTO">
    <form:label path="firstName">First Name:</form:label>
    <form:input path="firstName"/><br><br>

    <form:label path="lastName">Last Name:</form:label>
    <form:input path="lastName"/><br><br>

    <form:label path="username">Username:</form:label>
    <form:input path="username"/><br><br>

    <form:label path="email">Email Address:</form:label>
    <form:input path="email"/><br><br>

    <form:label path="password">Password:</form:label>
    <form:input path="password"/><br><br>

    <form:label path="password">Password:</form:label>
    <form:input path="password"/><br><br>

    <input type="submit" value="Submit">
</form:form>

</body>

</html>