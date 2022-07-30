<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <title>Update User</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/css/add-user-style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>User Contact Form</h2>
    </div>
</div>

<div id="container">
    <h3>Update User</h3>
    <form:form action="update" modelAttribute="userContact" method="POST">
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>Type:</label></td>
                <td><form:input path="contactType"/></td>
            </tr>
            <tr>
                <td><label>Contact No:</label></td>
                <td><form:input path="contactNo"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Update" class="update"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>

    <p>
        <a href="${pageContext.request.contextPath}/user/contact/list">Back to List</a>
    </p>

</div>
</body>
</html>










