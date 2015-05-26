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


<div id = "menu">
<button  name="application" type="submit">Leave Aplication</button></br>
<button  name="application" type="submit">My Applications</button></br>
<button  name="application" type="submit">Log out</button>
</div>
</div>
<div class= "center-container animated fadeInUpBig">
<b>Aplication form:</b>
<form id="reg-form">
<table>
<tr><td>About problem:</td>
<td><input type="text" name="about"></td></tr>
<tr><td>Type of work:</td>
<td>
<select name="typeOfWork">
<option value="OTHER"></option>
<option value="ELECTRIC">Electric</option>
<option value="SANTECHNIC">Santecnic</option>
<option value="HEATING">Heating</option>
<option value="AIR_CONDITIONING">Air conditioning</option>
<option value="OTHER">Other</option></select>
</td></tr>
<tr><td>Desirable time of execution:</td>
<td><input type="datetime-local" name="calendar"></td></tr>

<tr><td colspan = "2"  align = "center"><button  name="application" type="submit">Submit</button></td></tr>
</table>
</form>
</div>
</body>