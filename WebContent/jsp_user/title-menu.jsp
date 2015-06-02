

<div class="title-container">
	<div id="title-string">RENTER</div>
	<div id="language">
		<button name="application" type="submit">EN</button></br>
		<button name="application" type="submit">RU</button></br>
	</div>

	<div id="menu">
		<table>
			<tbody>
				<tr>
					<td><a href="create_application.jsp"><button>Create
								Aplication</button></a></td>
					<td>
						<form action="controller" method="post">
							<input type="hidden" name="command" value="see_app_user" />
							<button type="submit">My Applications</button>
						</form>
					</td>
					<td>
						<form action="controller" method="post">
							<input type="hidden" name="command" value="logout" />
							<button type="submit">Log out</button>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>





</body>