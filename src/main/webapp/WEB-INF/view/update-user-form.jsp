<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <title>Update User</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-user-style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>User Form</h2>
    </div>
</div>

<div id="container">
    <h3>Update User</h3>
    <form:form action="update" modelAttribute="user" method="POST">
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Update" class="update"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear; both;"></div>

    <p>
        <a href="${pageContext.request.contextPath}/user/list">Back to List</a>
    </p>

</div>
</body>
</html>










