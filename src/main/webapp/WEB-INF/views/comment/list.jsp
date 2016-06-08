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
    <link href="<c:url value='/static/css/comment.css' />" rel="stylesheet">
    <title>Comments</title>
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
                    <li ><a href="<c:url value='/team/list' />">List of Teams<span class="sr-only">(current)</span></a></li>
                    <li><a href="<c:url value='/player/list' />">List of Players</a></li>
                    <li class="active"><a href="<c:url value='/comment/list' />">Comments</a></li>
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
    <div class="container bootstrap snippet">
        <div class="row">
            <div class="col-md-12">
                <div class="blog-comment">
                    <h3 class="text-success">Comments</h3>
                    <hr/>
    <ul class="comments">
        <c:forEach items="${comments}" var="comment">
        <li class="clearfix">
            <div class="post-comments">
                <p class="meta">Dec 18, 2014 <a href="#">JohnDoe</a> says : <i class="pull-right"><a href="#">
                    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                    <small><a href="<c:url value='delete-${comment.id}-comment' />">delete</a></small>
                    </sec:authorize>
                </a></i>
                </p>
                <p>${comment.text}</p>
            </div>
        </li>
        </c:forEach>
    </ul>
                    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                        <input class="btn btn-primary" value="Add New Comment" onclick="location.href='new'" type="button" />
                    </sec:authorize>
                    </div>
                </div>
            </div>
        </div>
</div>
</body>
</html>
