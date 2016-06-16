<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Match</title>
    <link href="<c:url value='/static/css/reset.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet">
</head>
<body>


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
                <li><a href="<c:url value='/team/list' />">List of Teams</a></li>
                <li><a href="<c:url value='/player/list' />">List of Players</a></li>
                <li><a href="<c:url value='/comment/list' />">Comments</a></li>
                <li class="dropdown active">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Match... <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value='/match/new' />">Create</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">?</a></li>

                    </ul>
                </li>
                <sec:authorize access="hasRole('ADMIN')">
                    <li><a href="<c:url value='/user/list' />">List of Users</a></li>
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


<div class="container">
<h2>Create Match</h2>
    <form:form method="POST" modelAttribute="match">
    <div class="dropdown">
        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            Dropdown
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="#">Action</a></li>
        </ul>
    </div>

        <table>
            <tr>
                <td style="line-height: 2" class="col-sm-2 control-label"><label for="team">Team: </label> </td>
                <td class="col-sm-6"><form:select  path="team" items="${teams}" multiple="false" itemValue="id" itemLabel="name" cssClass="form-control"  id="team" /></td>
                <td><form:errors path="team" cssStyle="line-height: 3" cssClass="label label-danger"/></td>
            </tr>
        </table>
    </form:form>
</div>

</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/static/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/static/js/bootstrap.js"></script>
</body>
</html>
