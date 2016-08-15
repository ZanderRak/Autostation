<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="ua.khpi.shapoval.i18n.lang" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="registration.title" /></title>
<link href="<c:url value="/resources/bootstrap/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/resources/bootstrap/bootstrap-theme.min.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"
	type="text/css">
<script src="<c:url value="/resources/Jquery/jquery-2.1.4.min.js"/>"
	type="text/javascript"></script>

</head>
<body>
	<div id="header">
		<%@ include file="/fragments/header.jspf"%>
	</div>
	<div class="text-center">
		<h3>
			<fmt:message key="registration.title" />
		</h3>
	</div>
	<div class="col-xs-4 centerBlock text-center">
		<form action="/Autostation/controller" method="POST">
			<div class="form-group">
				<label class="control-label"><fmt:message
						key="registration.newLogin" /> </label> <input
					class="form-control input-sm" type="text" id="login" name="login"
					ng-model="name" required="true" />
			</div>
			<div class="form-group">
				<label class="control-label"><fmt:message
						key="registration.newPassword" /> </label> <input
					class="form-control input-sm" type="password" id="password"
					name="password" ng-model="password" required="true" />
			</div>
			<div class="form-group">
				<label class="control-label"><fmt:message
						key="registration.newName" /> </label> <input
					class="form-control input-sm" type="text" id="name" name="name"
					ng-model="name" required="true" />
			</div>
			<div class="form-group">
				<label class="control-label"><fmt:message
						key="registration.newSurname" /> </label> <input
					class="form-control input-sm" type="text" id="surname"
					name="surname" ng-model="surname" required="true" />
			</div>
			<div class="form-group">
				<label class="control-label"><fmt:message
						key="registration.newType" /> </label> <select name="role" id="role"
					class="form-control input-sm">
					<option value="1"><fmt:message key="registration.admin" /></option>
					<option value="2"><fmt:message
							key="registration.dispatcher" /></option>
					<option value="3"><fmt:message key="registration.driver" /></option>
				</select>
			</div>
			<div class="form-group">
				<input type="hidden" name="command" value="register">
				<button type="submit" class="btn btn-success">
					<fmt:message key="registration.registrButton" />
				</button>
			</div>

		</form>
	</div>
	<br>
	<div id="footer">
		<%@ include file="/fragments/footer.jspf"%>
	</div>


</body>
<script src="<c:url value="/resources/bootstrap/bootstrap.min.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/Jquery/jquery-2.1.4.min.js"/>"
	type="text/javascript"></script>
</html>