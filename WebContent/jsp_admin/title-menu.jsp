
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
					<td>
						<form action="controller" method="post">
							<input type="hidden" name="command" value="created_apps" />
							<button type="submit">Created Applications</button>
						</form>
					</td>
					<td>
						<form action="controller" method="post">
							<input type="hidden" name="command" value="assigned_apps" />
							<button type="submit">Assigned Applications</button>
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