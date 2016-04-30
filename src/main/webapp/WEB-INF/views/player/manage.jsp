<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Player Registration Form</title>
    <link href="<c:url value='/static/css/index.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/reset.css' />" rel="stylesheet">
</head>
<body>
    <div class="wrapper">
        <table class="navigate">
            <tr>
                <td class="menu-item"><a href="<c:url value='/' />">Home</a></td>
                <td class="menu-item"><a href="<c:url value='/team/list' />">List of Teams</a></td>
                <td class="menu-item"><a href="<c:url value='/player/list' />">List of Players</a></td>
                <td class="menu-item"><a href="<c:url value='/comment/list' />">List of Comments</a></td>
            </tr>
        </table>

        <h2>Player Registration Form</h2>

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
                    <td><form:select path="team" items="${teams}" multiple="false" itemValue="id" itemLabel="name" /></td>
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
    </div>
</body>
</html>
