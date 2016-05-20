<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value='/static/css/reset.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet">

    <title>Team Registration Form</title>
</head>
<body>
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<c:url value='/' />">Project name</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="<c:url value='/' />">Home<span class="sr-only">(current)</span></a></li>
                        <li ><a href="<c:url value='/team/list' />">List of Teams</a></li>
                        <li><a href="<c:url value='/player/list' />">List of Players</a></li>
                        <li><a href="<c:url value='/comment/list' />">Comments</a></li>
                        <sec:authorize access="hasRole('ADMIN')">
                            <li><a href="#">List of Users</a></li>
                        </sec:authorize>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                            <li><p class="navbar-text">Signed in as ${user}</p></li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                            <li><a href="<c:url value='/logout' />">Sign out</a></li>
                        </sec:authorize>
                        <sec:authorize access="isAnonymous()">
                            <li><a href="<c:url value='/login'/>">Sign in </a> </li>
                        </sec:authorize>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container " >
            <h2>Team Registration Form</h2>

            <form:form method="POST" modelAttribute="team">
                <form:input type="hidden" path="id" id="id"/>
                <table class=" table">
                    <tr>
                        <td style="line-height: 2" class="col-sm-2 control-label"><label for="name">Name: </label> </td>
                        <td class="col-sm-6"><form:input  cssClass="form-control" path="name" id="name"/></td>
                        <td ><form:errors path="name" cssStyle="line-height: 3" cssClass="label label-danger"/></td>
                    </tr>

                    <tr>
                        <td style="line-height: 2" class="col-sm-2 control-label"><label for="shortName">Short Name: </label> </td>
                        <td class="col-sm-6"><form:input cssClass="form-control" path="shortName" id="shortName"/></td>
                        <td><form:errors path="shortName" cssStyle="line-height: 3" cssClass="label label-danger"/></td>
                    </tr>

                    <tr>
                        <td style="line-height: 2" class="col-sm-2 control-label"><label for="notes">Notes: </label> </td>
                        <td class="col-sm-6"><form:textarea cssClass="form-control" path="notes" id="notes" /></td>
                        <td><form:errors path="notes" cssStyle="line-height: 3" cssClass="label label-danger"/></td>
                    </tr>

                    <tr>
                        <td colspan="3">
                            <c:choose>
                                <c:when test="${edit}">
                                    <input type="submit" class="btn btn-primary" value="Update"/>
                                </c:when>
                                <c:otherwise>
                                    <input type="submit" class="btn btn-primary" value="Register"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </table>
            </form:form>
            <br/>
            <br/>
            Go back to <a href="<c:url value='/team/list' />">List of All Teams</a>
        </div>
    </div>
</body>
</html>
