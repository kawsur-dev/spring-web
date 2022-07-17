<%@ page import="jsp.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Record</title>
</head>
<body>

<% List<Student> students = new ArrayList<>();
    students.add(new Student(1, "Kawsur", "CSE"));
    students.add(new Student(2, "Rahim", "CSE"));
    students.add(new Student(3, "Karim", "EEE"));

    pageContext.setAttribute("students", students);
%>

<c:forEach var="student" items="${students}">
    <c:if test="${not student.department.equals('CSE')}">
        ${student.id} ${fn:toUpperCase(student.name)} ${student.department}

        ${fn:length(student.name)}
    </c:if>
</c:forEach>

</body>
</html>
