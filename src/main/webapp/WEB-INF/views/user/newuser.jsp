<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=Windows-1251"
		 pageEncoding="Windows-1251"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;" charset="Windows-1251">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="<c:url value='/static/css/reset.css' />" rel="stylesheet">
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet">
	<title>�������� ������������</title>
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
					<li><a href="<c:url value='/' />">�������<span class="sr-only">(current)</span></a></li>
					<li ><a href="<c:url value='/team/list' />">�������</a></li>
					<li><a href="<c:url value='/player/list' />">������</a></li>
					<li><a href="<c:url value='/comment/list' />">�����������</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">�����... <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='/match/new' />">�������</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">������ ������</a></li>

						</ul>
					</li>
					<sec:authorize access="hasRole('ADMIN')">
						<li><a href="<c:url value='/user/list' />">������ �������������</a></li>
					</sec:authorize>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
						<li><p class="navbar-text"> ${currentUser}</p></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
						<li><a href="<c:url value='/logout' />">�����</a></li>
					</sec:authorize>
					<sec:authorize access="isAnonymous()">
						<li><a href="<c:url value='/login'/>">����</a> </li>
					</sec:authorize>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container " >
		<h2>�������� ������������</h2>

		<form:form method="POST" modelAttribute="user">
			<form:input type="hidden" path="id" id="id"/>
			<table class=" table">
				<tr>
					<td style="line-height: 2" class="col-sm-2 control-label"><label for="firstName">���: </label> </td>
					<td class="col-sm-6"><form:input  cssClass="form-control" path="firstName" id="firstName"/></td>
					<td ><form:errors path="firstName" cssStyle="line-height: 3" cssClass="label label-danger"/></td>
				</tr>

				<tr>
					<td style="line-height: 2" class="col-sm-2 control-label"><label for="lastName">�������: </label> </td>
					<td class="col-sm-6"><form:input cssClass="form-control" path="lastName" id="lastName"/></td>
					<td><form:errors path="lastName" cssStyle="line-height: 3" cssClass="label label-danger"/></td>
				</tr>

				<tr>
					<td style="line-height: 2" class="col-sm-2 control-label"><label for="email">��. �����: </label> </td>
					<td class="col-sm-6"><form:input cssClass="form-control" path="email" id="email"/></td>
					<td><form:errors path="email" cssStyle="line-height: 3" cssClass="label label-danger"/></td>
				</tr>

				<tr>
					<td style="line-height: 2" class="col-sm-2 control-label"><label for="password">������: </label> </td>
					<td class="col-sm-6"><form:input cssClass="form-control" path="password" id="password"/></td>
					<td><form:errors path="password" cssStyle="line-height: 3" cssClass="label label-danger"/></td>
				</tr>

				<tr>
					<td style="line-height: 2" class="col-sm-2 control-label"><label for="roles">����: </label> </td>
					<td class="col-sm-6"><form:select  path="roles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" cssClass="form-control"  id="roles" /></td>
					<td><form:errors path="roles" cssStyle="line-height: 3" cssClass="label label-danger"/></td>
				</tr>

				<tr>
					<td colspan="3">
						<c:choose>
							<c:when test="${edit}">
								<input type="submit" class="btn btn-primary" value="��������"/>
							</c:when>
							<c:otherwise>
								<input type="submit" class="btn btn-primary" value="��������"/>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>
		</form:form>
		<br/>
		<br/>
		��������� � <a href="<c:url value='/user/list' />">������ ���� �������������</a>
	</div>
</div>
</body>
</html>





