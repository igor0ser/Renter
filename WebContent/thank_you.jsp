<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang = "en">
<head>
<meta charset ="UTF-8">
<title>Renter - Aplication</title>
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="animate.css">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
</head>
<body>

<%@include file="title-menu.jsp" %>


<div class= "center-container animated fadeInUpBig">
<div id="welcome_user">
</br><b>Thank you, 
<c:out value="${sessionScope.login}"></c:out>
!
</b><br>
<b>Welcome, to our site!<b>
</div>
</div>
</body>