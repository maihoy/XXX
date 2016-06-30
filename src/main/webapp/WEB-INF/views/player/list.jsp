<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value='/static/css/reset.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet">
    <title>Список игроков</title>

    <style>
        .navbar-form{
            padding-top: 2px;
        }

    </style>
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
                    <li><a href="<c:url value='/' />">Главная<span class="sr-only">(current)</span></a></li>
                    <li ><a href="<c:url value='/team/list' />">Команды</a></li>
                    <li class="active"><a href="<c:url value='/player/list' />">Игроки</a></li>
                    <li><a href="<c:url value='/comment/list' />">Комментарии</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Матчи... <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                            <li><a href="<c:url value='/match/new' />">Создать</a></li>
                            <li role="separator" class="divider"></li>
                                </sec:authorize>
                            <li><a href="<c:url value='/match/list' />">Список матчей</a></li>

                        </ul>
                    </li>
                    <sec:authorize access="hasRole('ADMIN')">
                        <li><a href="<c:url value='/user/list' />">Список пользователей</a></li>
                    </sec:authorize>
                </ul>
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="search" class="form-control light-table-filter input-sm" data-table="filtered" placeholder="Search">
                    </div>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                        <li><p class="navbar-text">${user}</p></li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                        <li><a href="<c:url value='/logout' />">Выход</a></li>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <li><a href="<c:url value='/login'/>">Вход </a> </li>
                    </sec:authorize>
                </ul>
            </div>
        </div>
    </nav>

    <h2>Список Игроков</h2>
    <div class="table-responsive">
        <table class="table table-hover filtered sortable" id="sortabletable">
            <thead>
            <tr>
                <th>Имя</th><th>Фамилия</th><th>Команда</th><th>Электронный адрес</th>
                <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                <th class="unsortable"></th><th  class="unsortable"></th>
                </sec:authorize>
            </tr>
            </thead>
            <c:forEach items="${players}" var="player">
                <tr>
                    <td>${player.name}</td>
                    <td>${player.surname}</td>
                    <td>${player.teamName}</td>
                    <td>${player.email}</td>
                    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">

                            <td><input class="btn btn-warning btn-xs" value="Изменить" onclick="location.href='edit-${player.id}-player'" type="button" /></td>
                            <td><input class="btn btn-danger btn-xs" value="Удалить" onclick="location.href='delete-${player.id}-player'" type="button" /></td>

                    </sec:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <br/>
    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
    <input class="btn btn-primary" value="Добавить нового игрока" onclick="location.href='new'" type="button" />
    </sec:authorize>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/static/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/filter.js"></script>
<script src="/static/js/sortable.js"></script>
</body>
</html>