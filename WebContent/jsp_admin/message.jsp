<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Renter - Aplication</title>
<link rel="stylesheet" href="main_admin.css">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<fmt:setLocale value="${language}" />
</head>
<body>

	<%@include file="title-menu.jsp"%>



	<div class="center-container">
		<div id="message-container">
			<b><c:out value="${message}"></c:out></b>
			</div>
	</div>

</body>