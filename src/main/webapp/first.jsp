<%@ page import="java.util.Date" %>
<%@ page import="jsp.Hello" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First Page</title>
</head>
<body>

<%! String name; %>

<h1>Hello JSP!</h1>

<%= new Date().toString() %>

<%
    name = "Mir Md Kawsur";
    out.println(name);

    out.println(new Hello().convertToUpperCase(name));
%>

</body>
</html>
