<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang = "en">
<head>
<meta charset ="UTF-8">
<title>Renter - Aplication</title>
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="animate.css">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<fmt:setLocale value="${language}" />
</head>
<body>

<%@include file="title-menu.jsp" %>

<div class= "center-container">
<div id="message-container">
<b><span><fmt:message key="Some_errors" /></span>
<fmt:message key="Try_again" /></b>
<button  onClick="history.back()"><fmt:message key="Back_to_create" /></button>
</div>
</div>
</body>