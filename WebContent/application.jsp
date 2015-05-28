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
<b>Aplication form:</b>
<form id="app-form" action="controller" method="get">
<input type="hidden" name="command" value ="create_application"/>
<table>
<tr><td>About problem:</td>
<td class="reg-input"><input type="text" name="about" required>
<span class="required"></span></td></tr>

<tr><td>Type of work:</td>
<td class="reg-input">
<select name="typeOfWork" required>
<option></option>
<option value="ELECTRIC">Electric</option>
<option value="SANTECHNIC">Santechnic</option>
<option value="HEATING">Heating</option>
<option value="AIR_CONDITIONING">Air conditioning</option>
<option value="OTHER">Other</option>
</select>
<span class="required"></span></td></tr>
<tr><td>Desirable time of execution:</td>
<td class="reg-input"><input type="datetime-local" name="calendar" required>
<span class="required"></span></td>
</tr>

<tr><td colspan = "2"  align = "center"><button  name="application" type="submit">Submit</button></td></tr>
</table>
</form>
</div>
</body>