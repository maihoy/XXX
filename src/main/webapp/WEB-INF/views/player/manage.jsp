<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Player Registration Form</title>

    <style>

        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>
<h2>Registration Form</h2>

<form:form method="POST" modelAttribute="player">
    <form:input type="hidden" path="id" id="id"/>
    <table>
        <tr>
            <td><label for="name">Name: </label> </td>
            <td><form:input path="name" id="name"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="surname">Surname: </label> </td>
            <td><form:input path="surname" id="surname"/></td>
            <td><form:errors path="surname" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="team">Team: </label> </td>
            <td><form:input path="team" id="team"/></td>
            <td><form:errors path="team" cssClass="error"/></td>
        </tr>

        <tr>
            <td colspan="3">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>
</form:form>
<br/>
<br/>
Go back to <a href="<c:url value='/player/list' />">List of All Players</a>
</body>
</html>
