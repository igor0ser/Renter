<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang = "en">
<head>
<meta charset ="UTF-8">
<title>Renter</title>
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="animate.css">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<fmt:setLocale value="${language}" />
</head>
<body>

<div class = "title-container">
<div id = "title-string">RENTER</div>

<div id = "language">
<button  name="application" type="submit">EN</button></br>
<button  name="application" type="submit">RU</button></br>
</div>
</div>

<div class= "center-container">
<div id="message-container">
<b><c:out value="${error}"><fmt:message key="Some_errors" /></c:out></b>

<button  onClick="history.back()"><fmt:message key="Back_to_start" /></button>

</div>
</div>
</body>