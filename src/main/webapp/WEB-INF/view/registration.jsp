<%--
  Created by IntelliJ IDEA.
  User: MIRMDKAWSUR
  Date: 7/24/2022
  Time: 8:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<h1>Registration Form</h1>

<form:form action="register" modelAttribute="user">
    <label for="firstname">First Name:</label>
    <form:input path="firstname" id="firstname"/>
    <form:errors path="firstname"/>

    <br><br>

    <label for="lastname">Last Name:</label>
    <form:input path="lastname" id="lastname"/>
    <form:errors path="lastname"/>

    <br><br>

    <label id="gender">Gender:</label>
    <br>

    <form:radiobutton path="gender" value="MALE" id="male"/>
    <label for="male">Male</label>
    <form:radiobutton path="gender" value="FEMALE" id="female"/>
    <label for="female">Female</label>

    <form:errors path="gender"/>

    <br><br>

    <label for="country">Country:</label>
    <form:select path="country" id="country">
        <form:options items="${countries}" itemValue="id" itemLabel="name"/>
    </form:select>
    <form:errors path="country"/>

    <br><br>
    <%--
        Operating Systems:

        Linux <form:checkbox path="operatingSystems" value="Linux"/>
        Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
        MS Windows <form:checkbox path="operatingSystems" value="MS Window"/>--%>

    <input type="submit">

</form:form>

</body>
</html>
