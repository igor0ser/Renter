<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Renter - Aplication</title>
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="animate.css">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<fmt:setLocale value="${language}" />
</head>
<body>

	<%@include file="title-menu.jsp"%>


	<div class="center-container  animated fadeInUpBig">
		<div id="message-container">
			<b>Thank you, <c:out value="${sessionScope.login}"></c:out>!</b>
			<b>We received your application!</b></br> <span></span>
			<div id="flying_man">
				<%@include file="flying_man.html"%>
			</div>
			<b>We will handle it as soon as we can!<b>
		</div>
	</div>


	</div>
</body>