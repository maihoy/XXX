<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List Of Players</title>
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
<h2>List of Players</h2>
<table>
    <tr>
        <td>Name</td><td>Surname</td><td>Team</td>
    </tr>
    <c:forEach items="${players}" var="player">
        <tr>
            <td>${player.name}</td>
            <td>${player.surname}</td>
            <td>${player.team}</td>
            <td><a href="<c:url value='player/edit-${player.id}-player' />">edit</a></td>
            <td><a href="<c:url value='player/delete-${player.id}-player' />">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='player/new' />">Add New Player</a>
</body>
</body>
</html>
