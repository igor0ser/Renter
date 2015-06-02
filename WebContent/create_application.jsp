<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Renter - Aplication</title>
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="animate.css">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
</head>
<body>

	<div class="title-container">
		<div id="title-string">RENTER</div>




		<div id="language">
			<button name="application" type="submit">EN</button>
			</br>
			<button name="application" type="submit">RU</button>
			</br>
		</div>

		<div id="menu">
			<table>
				<tbody>
					<tr>

						<td><a href="create_application.jsp"><button>Create
									Aplication</button></a></td>

						<td>
							<form>
								<button name="application" type="submit">My
									Applications</button>
								<input type="hidden" name="command" value="see_app_user" />
							</form>
						</td>

						<td>
							<button name="application" type="submit">Log out</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
	<div class="center-container animated fadeInUpBig">
		<b>Aplication form:</b>
		<form id="app-form" action="controller" method="get">
			<input type="hidden" name="command" value="create_app" />
			<table>
				<tr>
					<td>About problem:</td>
					<td class="reg-input"><input type="text" name="about" required>
						<span class="required"></span></td>
				</tr>

				<tr>
					<td>Type of work:</td>
					<td class="reg-input"><select name="type_of_work" required>
							<option></option>
							<option value="ELECTRIC">Electric</option>
							<option value="SANTECHNIC">Santechnic</option>
							<option value="HEATING">Heating</option>
							<option value="AIR_CONDITIONING">Air conditioning</option>
							<option value="OTHER">Other</option>
					</select> <span class="required"></span></td>
				</tr>
				<tr>
					<td>Desirable time of execution:</td>
					<td class="reg-input"><input name="desirable"
						type="datetime-local" name="calendar" required> <span
						class="required"></span></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><button name="application"
							type="submit">Submit</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>