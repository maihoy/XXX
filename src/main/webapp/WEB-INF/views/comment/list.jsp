<%@ page language="java" contentType="text/html; charset=Windows-1251"
         pageEncoding="Windows-1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value='/static/css/reset.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/comment.css' />" rel="stylesheet">
    <title>Êîììåíòàðèè</title>
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
                <a class="navbar-brand" href="<c:url value='/' />">VSA</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="<c:url value='/' />">Ãëàâíàÿ</a></li>
                    <li ><a href="<c:url value='/team/list' />">Êîìàíäû<span class="sr-only">(current)</span></a></li>
                    <li><a href="<c:url value='/player/list' />">Èãðîêè</a></li>
                    <li class="active"><a href="<c:url value='/comment/list' />">Êîììåíòàðèè</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ìàò÷è... <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<c:url value='/match/new' />">Ñîçäàòü</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Ñïèñîê ìàò÷åé</a></li>

                        </ul>
                    </li>
                    <sec:authorize access="hasRole('ADMIN')">
                        <li><a href="<c:url value='/user/list' />">Ñïèñîê ïîëüçîâàòåëåé</a></li>
                    </sec:authorize>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                        <li><p class="navbar-text"> ${user}</p></li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                        <li><a href="<c:url value='/logout' />">Âûõîä</a></li>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <li><a href="<c:url value='/login'/>">Âõîä </a> </li>
                    </sec:authorize>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container bootstrap snippet">
        <div class="row">
            <div class="col-md-12">
                <div class="blog-comment">
                    <h3 class="text-success">Êîììåíòàðèè</h3>
                    <hr/>
                    <ul class="comments">
                        <c:forEach items="${comments}" var="comment">
                        <li class="clearfix">
                            <div class="post-comments">
                                <p class="meta">${comment.date} <a href="#">${comment.creator}</a> íàïèñàë : <i class="pull-right"><a href="#">
                                    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                                    <small><a href="<c:url value='delete-${comment.id}-comment' />">Óäàëèòü</a></small>
                                    </sec:authorize>
                                </a></i>
                                </p>
                                <p>${comment.text}</p>
                            </div>
                        </li>
                        </c:forEach>
                    </ul>
                    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                        <input class="btn btn-primary" value="Íîâûé êîììåíòàðèé" onclick="location.href='new'" type="button" />
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/static/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/filter.js"></script>
<script src="/static/js/sortable.js"></script>
</body>
</html>
