<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Home</title>
        <link href="<c:url value='/static/css/reset.css' />" rel="stylesheet">
        <link href="<c:url value='/static/css/index.css' />" rel="stylesheet">
    </head>
    <body>
        <div class="wrapper">
            <table class="navigate">
                <tr>
                    <td class="menu-item-selected"><a href="<c:url value='/' />">Home</a></td>
                    <td class="menu-item"><a href="<c:url value='/team/list' />">List of Teams</a></td>
                    <td class="menu-item"><a href="<c:url value='/player/list' />">List of Players</a></td>
                    <td class="menu-item"><a href="<c:url value='/comment/list' />">List of Comments</a></td>
                    <td>${user}</td>
                    <td class="menu-item">
                        <sec:authorize access="hasRole('ADMIN')">
                        <label><a href="#">List of Users</a></label>
                        </sec:authorize>
                    </td>
                    <td>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                        <label><a href="<c:url value='/logout' />">logout</a></label>
                        </sec:authorize>
                        <sec:authorize access="isAnonymous()">
                            <label><a href="<c:url value='/login'/>">login </a> </label>
                        </sec:authorize>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
