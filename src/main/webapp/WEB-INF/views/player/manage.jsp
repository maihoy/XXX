<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value='/static/css/reset.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet">
    <title>Создание игрока</title>

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
                    <li><a href="<c:url value='/player/list' />">Игроки</a></li>
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

    <div class="container " >
        <h2>Создание Игрока</h2>



        <form:form method="POST" modelAttribute="player" acceptCharset="utf-8" enctype="application/x-www-form-urlencoded" >
            <form:input type="hidden" path="id" id="id"/>
            <table class=" table">
                <tr>
                    <td style="line-height: 2" class="col-sm-2 control-label"><label for="name">Имя: </label> </td>
                    <td class="col-sm-6"><form:input  cssClass="form-control" path="name" id="name"/></td>
                    <td ><form:errors path="name" cssStyle="line-height: 3" cssClass="label label-danger"/></td>
                </tr>

                <tr>
                    <td style="line-height: 2" class="col-sm-2 control-label"><label for="surname">Фамилия: </label> </td>
                    <td class="col-sm-6"><form:input cssClass="form-control" path="surname" id="surname"/></td>
                    <td><form:errors path="surname" cssStyle="line-height: 3" cssClass="label label-danger"/></td>
                </tr>

                <tr>
                    <td style="line-height: 2" class="col-sm-2 control-label"><label for="email">Эл. адрес: </label> </td>
                    <td class="col-sm-6"><form:input cssClass="form-control" path="email" id="email"/></td>
                    <td><form:errors path="email" cssStyle="line-height: 3" cssClass="label label-danger"/></td>
                </tr>

                <tr>
                    <td style="line-height: 2" class="col-sm-2 control-label"><label for="team">Команда: </label> </td>
                    <td class="col-sm-6"><form:select  path="team" items="${teams}" multiple="false" itemValue="id" itemLabel="name" cssClass="form-control"  id="team" /></td>
                   <td><form:errors path="team" cssStyle="line-height: 3" cssClass="label label-danger"/></td>
                </tr>

                <tr>
                    <td colspan="3">
                        <c:choose>
                            <c:when test="${edit}">
                                <input type="submit" class="btn btn-primary" value="Обновить"/>
                            </c:when>
                            <c:otherwise>
                                <input type="submit" class="btn btn-primary" value="Создать"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </form:form>
        <br/>
        <br/>
        Вернуться к <a href="<c:url value='/player/list' />">Списку всех Игроков</a>
    </div>
</div>
</body>
</html>





