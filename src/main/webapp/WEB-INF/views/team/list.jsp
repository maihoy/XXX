<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value='/static/css/reset.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet">
    <title>List Of Teams</title>
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
                    <li><a href="<c:url value='/' />">Home</a></li>
                    <li class="active"><a href="<c:url value='/team/list' />">List of Teams<span class="sr-only">(current)</span></a></li>
                    <li><a href="<c:url value='/player/list' />">List of Players</a></li>
                    <li><a href="<c:url value='/comment/list' />">Comments</a></li>
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

    <h2>List of Teams</h2>
    <div class="table-responsive">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Name</th><th>Short Name</th><th>Notes</th>
                    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                    <th></th><th></th>
                    </sec:authorize>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${teams}" var="team">
                <tr>
                    <td>${team.name}</td>
                    <td>${team.shortName}</td>
                    <td>${team.notes}</td>
                    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                    <td><input class="btn btn-warning btn-xs" value="Edit" onclick="location.href='edit-${team.id}-team'" type="button" /></td>
                    <td><input class="btn btn-danger btn-xs" value="Delete" onclick="location.href='delete-${team.id}-team'" type="button" /></td>
                    </sec:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <br/>
    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
    <input class="btn btn-primary" value="Add New Team" onclick="location.href='new'" type="button" />
    </sec:authorize>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/static/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/static/js/bootstrap.js"></script>
</body>
</html>
