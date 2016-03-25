<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>University Enrollments</title>

    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

</head>


<body>
<h2>List of Teams</h2>
<table>
    <tr>
        <td>Name</td><td>Short Name</td><td>Notes</td>
    </tr>
    <c:forEach items="${teams}" var="teams">
        <tr>
            <td>${teams.name}</td>
            <td>${teams.shortName}</td>
            <td>${teams.notes}</td>
            <td><a href="<c:url value='/edit-${team.id}-team' />">edit</a></td>
            <td><a href="<c:url value='/delete-${team.id}-team' />">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='/new' />">Add New Team</a>
</body>
</html>
