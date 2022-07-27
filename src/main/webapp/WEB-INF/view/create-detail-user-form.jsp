<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save User</title>

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
        <h2>User Detail Form</h2>
    </div>
</div>

<div id="container">
    <h3>Save User</h3>
    <form:form action="create" modelAttribute="userDetail" method="POST">
        <table>
            <tbody>
            <tr>
                <td><label>Father Name:</label></td>
                <td><form:input path="fatherName"/></td>
                <td><form:errors path="fatherName"/></td>
            </tr>
            <tr>
                <td><label>Mother Name:</label></td>
                <td><form:input path="motherName"/></td>
                <td><form:errors path="motherName"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>

    <p>
        <a href="${pageContext.request.contextPath}/user/detail/list">Back to List</a>
    </p>

</div>
</body>
</html>










