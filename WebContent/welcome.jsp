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
<div id = "title-string" >RENTER</div>




<div id = "language">
<button  name="application" type="submit">EN</button></br>
<button  name="application" type="submit">RU</button></br>
</div>

<div id = "menu">
<button  name="application" type="submit">Leave Aplication</button>
<button  name="application" type="submit">My Applications</button>
<button  name="application" type="submit">Log out</button>
</div>

</div>
<div class= "center-container animated fadeInUpBig">
<div id="welcome_user">
</br><b>Hello, 
<c:out value="${user.name}">guest</c:out>
!
</b><br>
<b>Welcome, to our site!<b>
</div>
</div>
</body>