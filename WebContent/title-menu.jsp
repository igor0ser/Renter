

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
							<form id="my_apps" action="controller" method="post">
								<input type="hidden" name="command" value="see_app_user" />
								<button name="application" type="submit" 
									>My Applications</button>
							</form>
						</td>
						<td>
							<button name="application">Log out</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>





</body>