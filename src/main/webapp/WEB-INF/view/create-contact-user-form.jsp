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
        <h2>User Contact Form</h2>
    </div>
</div>

<div id="container">
    <h3>Save User Contact</h3>
    <form:form action="create" modelAttribute="userContact" method="POST">
        <table>
            <tbody>
            <tr>
                <td><label>Type:</label></td>
                <td><form:input path="contactType"/></td>
                <td><form:errors path="contactType"/></td>
            </tr>
            <tr>
                <td><label>Contact No:</label></td>
                <td><form:input path="contactNo"/></td>
                <td><form:errors path="contactNo"/></td>
            </tr>
            <tr>
                <td><label>User Detail:</label></td>
                <td>
                    <form:select path="userDetail">
                        <form:options items="${userDetails}" itemValue="id" itemLabel="fatherName"/>
                    </form:select>
                </td>
                <td><form:errors path="userDetail"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
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










