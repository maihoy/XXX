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
            background-color: #ffffff;
        }

        .menu-item {
            font-weight: bold;
            background-color: #ffffff;
        }

        .menu-item-selected {
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td class="menu-item"><a href="<c:url value='/' />">Home</a></td>
        <td class="menu-item"><a href="<c:url value='/team/list' />">List of Teams</a></td>
        <td class="menu-item-selected"><a href="<c:url value='/player/list' />">List of Players</a></td>
        <td class="menu-item"><a href="<c:url value='/comment/list' />">Comments</a></td>
    </tr>
</table>
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
            <td><a href="<c:url value='edit-${player.id}-player' />">edit</a></td>
            <td><a href="<c:url value='delete-${player.id}-player' />">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='new' />">Add New Player</a>
</body>
</body>
</html>
