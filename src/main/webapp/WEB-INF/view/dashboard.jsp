<%--
  Created by IntelliJ IDEA.
  User: MIRMDKAWSUR
  Date: 7/19/2022
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/external.css">
</head>
<body>
<h1 id="i1">Welcome to Dashboard!</h1>

<%--<form action="process/v1" method="post">
    Please enter your name: <input type="text" name="fullname">
    <input type="submit" name="submit">
</form>--%>

<form action="process/v2" method="post">
    Please enter your name: <input type="text" name="fullname">
    <input type="submit" name="submit">
</form>

</body>
</html>
