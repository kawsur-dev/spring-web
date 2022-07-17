<%--
  Created by IntelliJ IDEA.
  User: MIRMDKAWSUR
  Date: 7/17/2022
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<form action="registration_action.jsp" method="post">

    First Name: <input type="text" name="firstname">
    <br><br>

    Last Name: <input type="text" name="lastname">
    <br><br>

    Gender: <input type="radio" name="gender" value="male">Male
    <input type="radio" name="gender" value="female">Female
    <br><br>

    Language: <input type="checkbox" name="lan" value="Bangla">Bangla
    <input type="checkbox" name="lan" value="English">English
    <input type="checkbox" name="lan" value="French">French
    <br><br>

    Country: <select name="country">
        <option value="bd">Bangladesh</option>
        <option value="usa">United States of America</option>
    </select>
    <br><br>

    <input type="submit" name="submit">
</form>

</body>
</html>
