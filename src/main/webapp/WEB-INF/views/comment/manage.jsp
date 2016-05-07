<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Comment Creation Form</title>
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
        <h2>Comment Creation Form</h2>

        <form:form method="POST" modelAttribute="comment">
            <form:input type="hidden" path="id" id="id"/>
            <table>
                <tr>
                    <td><label for="text">Text: </label> </td>
                    <td><form:textarea path="text" id="text"/></td>
                    <td><form:errors path="text" cssClass="error"/></td>
                </tr>
                <tr>
                    <td colspan="3">
                        <c:choose>
                            <c:when test="${edit}">
                                <input type="submit" value="Update"/>
                            </c:when>
                            <c:otherwise>
                                <input type="submit" value="Add"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </form:form>
        <br/>
        <br/>
        Go back to <a href="<c:url value='/comment/list' />">List of All Comments</a>
    </div>
</body>
</html>