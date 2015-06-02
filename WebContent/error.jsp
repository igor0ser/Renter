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

<div class= "center-container">
<div id="message-container">
<b><span>Some errors happened :(</span>
Please try again.</b>
<button  onClick="history.back()">Back to Create Application</button>
</div>
</div>
</body>