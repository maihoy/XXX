<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Open modal </button>
                    </sec:authorize>

                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="exampleModalLabel">New message</h4>
                                </div>
                                <div class="modal-body">
                                     <form>

                                            <table>
                                                <tr>
                                                    <td><label for="text">Text: </label> </td>
                                                    <td><textarea></textarea></td>
                                                    <td>></td>
                                                </tr>
                                                <tr>

                                                </tr>
                                            </table>
                                        </form>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary">Send message</button>
                                </div>
                            </div>
                        </div>
                    </div>
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
