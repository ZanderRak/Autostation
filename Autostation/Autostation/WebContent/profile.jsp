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
<title><fmt:message key="profile.title" /></title>
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
			<strong><fmt:message key="profile.title" /></strong>
		</h3>
	</div>
<h3><c:out value="${sessionScope.userInfo.name}"></c:out> </h3>
<h3><c:out value="${sessionScope.userInfo.surname}"></c:out> </h3>
</body>
<script src="<c:url value="/resources/bootstrap/bootstrap.min.js"/>"
	type="text/javascript"></script>
</html>