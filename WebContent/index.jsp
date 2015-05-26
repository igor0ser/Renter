<!doctype html>
<html lang = "en">
<head>
<meta charset ="UTF-8">
<title>Welcome to Renter</title>
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="animate.css">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
</head>
<body>

<div class = "title-container">
<div id = "title-string">RENTER</div>
<form id="login-form" action="controller" method="get" name="command">
<input type="hidden" name="command" value ="login"/>
<table>
<tr>
<td>Login:</td>
<td class="info"><input type="text" name="login"></td>
</tr>
<tr><td>Password: </td>
<td class="info"><input type="password" name="password"></td></tr>
<tr><td colspan = "2"  align = "center"><button type="submit">Submit</button></td></tr>
</table>
</form>
</div>


<div class= "center-container animated fadeInUpBig">
<b>Registration form:</b>
<form id="reg-form" action="controller" method="get">
<input type="hidden" name="command" value ="registration"/>
<table>
<tr><td>Login:</td>
<td><input type="text" name="login" required></td></tr>
<tr><td>Password:</td>
<td><input type="password" name="password" required></td></tr>
<tr><td>Repeat Password:</td>
<td><input type="password" name="repeat_password" required></td></tr>
<tr><td>Email:</td>
<td><input type="email" name="email" required></td></tr>
<tr><td>First Name:</td>
<td><input type="text" name="first_name" required></td></tr>
<tr><td>Last Name:</td>
<td><input type="text" name="last_name" required></td></tr>
<tr><td>Phone Number:</td>
<td><input type="tel" name="phone_number" required></td></tr>
<tr><td><b>Adress:</b></td></tr>
<tr ><td>Street:</td>
<td><input type="text" name="street" required></td></tr>
<tr ><td>House number:</td>
<td><input type="text" name="house_number" required></td></tr>
<tr ><td>Appartment number: </td>
<td><input type="text" name="appartment_number" required></td></tr>
<tr><td colspan = "2"  align = "center"><button  name="registatin" type="submit">Submit</button></td></tr>
</table>
</form>
</div>
</body>