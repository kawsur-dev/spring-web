<%--
  Created by IntelliJ IDEA.
  User: MIRMDKAWSUR
  Date: 7/17/2022
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Registration Confirmation</title>
</head>
<body>

<h1>Registration Confirmation</h1>

<%--First Name: <%= request.getParameter("firstname") %>--%>

First Name: ${param.firstname}

<br><br>

Last Name: <%= request.getParameter("lastname") %>

<br><br>

Gender: <%= request.getParameter("gender") %>

<br><br>

Language: <% String[] languages = request.getParameterValues("lan");
    if(languages != null) {
        for(String language: languages) {
            out.println(language + " ");
        }
    }
%>

<br><br>

Country: <%= request.getParameter("country") %>

<h2> Congratulations! You are a registered member now. </h2>

</body>
</html>
