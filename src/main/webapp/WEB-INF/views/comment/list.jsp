<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List of Comments</title>
    <link href="<c:url value='/static/css/index.css' />" rel="stylesheet">
</head>


<body>
<table>
    <tr>
        <td class="menu-item"><a href="<c:url value='/' />">Home</a></td>
        <td class="menu-item"><a href="<c:url value='/team/list' />">List of Teams</a></td>
        <td class="menu-item"><a href="<c:url value='/player/list' />">List of Players</a></td>
        <td class="menu-item-selected"><a href="<c:url value='/comment/list' />">List of Comments</a></td>
    </tr>
</table>
<h2>List of Comments</h2>
<table class="table-list">
    <tr>
        <td>id</td><td>Text</td>
    </tr>
    <c:forEach items="${comments}" var="comment">
        <tr>
            <td>${comment.id}</td>
            <td>${comment.text}</td>
            <td><a href="<c:url value='delete-${comment.id}-comment' />">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='new' />">Add New Comment</a>
</body>
</html>
