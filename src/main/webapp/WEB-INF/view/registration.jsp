<%--
  Created by IntelliJ IDEA.
  User: MIRMDKAWSUR
  Date: 7/24/2022
  Time: 8:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<h1>Registration Form</h1>

<form:form action="register" modelAttribute="user">
    First Name: <form:input path="firstname" />
    <form:errors path="firstname"/>

    <br><br>

    Last Name: <form:input path="lastname" />
    <form:errors path="lastname"/>

    <br><br>

    <input type="submit">

</form:form>

</body>
</html>
