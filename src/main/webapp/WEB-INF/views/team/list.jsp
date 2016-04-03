<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List Of Teams</title>
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
        body{
            background-color: #1e1e1e;
        }

    </style>

</head>


<body>
<h2>List of Teams</h2>
<table>
    <tr>
        <td>Name</td><td>Short Name</td><td>Notes</td>
    </tr>
    <c:forEach items="${teams}" var="team">
        <tr>
            <td>${team.name}</td>
            <td>${team.shortName}</td>
            <td>${team.notes}</td>
            <td><a href="<c:url value='team/edit-${team.id}-team' />">edit</a></td>
            <td><a href="<c:url value='team/delete-${team.id}-team' />">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='team/new' />">Add New Team</a>
</body>
</html>