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

<div class = "title-container">
<div id = "title-string">RENTER</div>

<div id = "language">
<button  name="application" type="submit">EN</button>
<button  name="application" type="submit">RU</button>
</div>
</div>

<div class= "center-container">
<div id="message-container">
<b><c:out value="${error}">Some errors happened :( Sorry!)</c:out></b>

<button  onClick="history.back()">Back to start page</button>

</div>
</div>
</body>