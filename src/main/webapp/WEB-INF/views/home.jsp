<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
    <link href="<c:url value='/static/css/index.css' />" rel="stylesheet">
</head>
<body>
<table>
<tr>
    <td class="menu-item-selected"><a href="<c:url value='/' />">Home</a></td>
    <td class="menu-item"><a href="<c:url value='/team/list' />">List of Teams</a></td>
    <td class="menu-item"><a href="<c:url value='/player/list' />">List of Players</a></td>
    <td class="menu-item"><a href="<c:url value='/comment/list' />">List of Comments</a></td>
</tr>
</table>

</body>
</html>
