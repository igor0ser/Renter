<!doctype html>
<html lang = "en">
<head>
<meta charset ="UTF-8">
<title>Welcome to Renter</title>
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="animate.css">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">

<script>
function checkPw(form) {
pw1 = form.password.value;
pw2 = form.repeat_password.value;
if (pw1 != pw2) {
alert ("Password doesn't equal to repeated password!")
return false;
}
else return true;
}
</script>

</head>
<body>
<div class = "title-container">
<div id = "title-string">RENTER</div>

<div id = "language">
<button  name="application" type="submit">EN</button></br>
<button  name="application" type="submit">RU</button></br>
</div>

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
<div id="hello"><b>Welcome to RENTER!</b></div>
<b>Registration form:</b>
<form id="reg-form" onSubmit="return checkPw(this)" action="controller" method="get">
<input type="hidden" name="command" value ="registration"/>
<table>
<tr ><td>Login:</td>
<div >
<td class="reg-input"><input type="text" name="login" required>
<span class="required"></span></td></tr>
<tr><td>Password:</td>
<td class="reg-input"><input type="password" name="password" required>
<span class="required"></span></td></tr>
<tr><td>Repeat Password:</td>
<td class="reg-input"><input type="password" name="repeat_password" required>
<span class="required"></span></td></tr>
<tr><td>Email:</td>
<td class="reg-input"><input type="email" name="email" required>
<span class="required"></span></td></tr>
<tr><td>First Name:</td>
<td class="reg-input"><input type="text" name="first_name" required>
<span class="required"></span></td></tr>
<tr><td>Last Name:</td>
<td class="reg-input"><input type="text" name="last_name" required>
<span class="required"></span></td></tr>
<tr><td>Phone Number:</td>
<td class="reg-input"><input type="tel" name="phone_number" required>
<span class="required"></span></td></tr>
<tr><td><b>Adress:</b></td></tr>
<tr ><td>Street:</td>
<td class="reg-input"><input type="text" name="street" required>
<span class="required"></span></td></tr>
<tr ><td>House number:</td>
<td class="reg-input"><input type="text" name="house_number" required>
<span class="required"></span></td></tr>
<tr ><td>Appartment number: </td>
<td class="reg-input"><input type="text" name="appartment_number" required>
<span class="required"></span></td></tr>
<tr><td colspan = "2"  align = "center">
<button  name="registatin" type="submit">Submit</button></td></tr>
</table>
</form>
</div>
</body>

