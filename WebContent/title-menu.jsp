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
<table>
<tbody>
<tr>
<td>
<a href="create_application.jsp"><button>Create Aplication</button></a>
</td>
<td>
<form>
<button  name="application" type="submit">My Applications</button>
<input type="hidden" name="command" value ="see_app_user"/>
</form>
</td>
<td>
<button  name="application" type="submit">Log out</button>
</td>
</tr>
</tbody>
</table>
</div>
</div>





</body>