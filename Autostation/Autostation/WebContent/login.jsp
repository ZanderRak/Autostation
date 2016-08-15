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
<title><fmt:message key="login.title" /></title>
<link href="<c:url value="/resources/bootstrap/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/resources/bootstrap/bootstrap-theme.min.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="<c:url value="/resources/Jquery/jquery-2.1.4.min.js"/>"></script>

</head>
<body>

	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="img-responsive center-block"
					src="<c:url value="/resources/carouselPics/auto1.jpg"/>"
					alt="Auto1">

			</div>
			<div class="item">
				<img class="img-responsive center-block"
					src="<c:url value="/resources/carouselPics/auto2.jpg"/>"
					alt="Auto2">

			</div>
			<div class="item">
				<img class="img-responsive center-block"
					src="<c:url value="/resources/carouselPics/auto3.jpg"/>"
					alt="Auto3">
			</div>

		</div>

		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<div class="text-center">
		<h2>
			<strong><fmt:message key="login.motordepot" /></strong>
		</h2>
		<h3>
			<em><fmt:message key="login.welcometoautostation" /></em>
		</h3>

		<button type="button" class="btn btn-primary btn-lg"
			data-toggle="modal" data-target="#myModal">
			<fmt:message key="login.login" />
		</button>
	</div>



	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						<fmt:message key="login.login" />
					</h4>
				</div>
				<div class="modal-body">
					<div class="container">
						<form method="POST" action="/Autostation/controller">
							<div class="form-group col-md-4 text-center">
								<label class="control-label"><fmt:message
										key="login.loginLabel" /></label> <input
									class="form-control input-sm" type="text" id="login"
									name="login" ng-model="login" required /> <label><fmt:message
										key="login.passwordLabel" /></label><input
									class="form-control input-sm" type="password" id="password"
									name="password" ng-model="password" required />
									<input type="hidden" name="command" value="login"/>
							</div>
							<button type="submit" class="btn btn-primary">
								<fmt:message key="login.login" />
							</button>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<fmt:message key="login.close" />
					</button>


				</div>

			</div>

		</div>

	</div>

	<div id="footer">
		<%@ include file="/fragments/footer.jspf"%>
	</div>


</body>
<script src="<c:url value="/resources/bootstrap/bootstrap.min.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/Jquery/jquery-2.1.4.min.js"/>"
	type="text/javascript"></script>
</html>