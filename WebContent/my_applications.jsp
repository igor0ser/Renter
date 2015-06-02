<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

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

	<div class="appplication-container animated fadeInUpBig">
		<table class="app-table" rules="all">
		<caption>Applications of user <b>
		<c:out value="${sessionScope.login}"></c:out>
		</b></caption>
			<tbody>
				<tr>
					<th>Status</th>
					<th>Type of work</th>
					<th>About</th>
					<th>Creation time</th>
					<th>Desirable time</th>
					<th>Start time</th>
					<th>End time</th>
				</tr>
							<c:forEach var="item" items="${list}">
							
					<tr>
						<td>${item.status}</td>
						<td>${item.typeOfWork}</td>
						<td class="about">${item.about}</td>
						<td class="time"><fmt:formatDate type="both" timeStyle="short" value="${item.creation}"/></td>
						<td class="time"><fmt:formatDate type="both" timeStyle="short" value="${item.desirable}"/></td>
						<td class="time"><fmt:formatDate type="both" timeStyle="short" value="${item.start}"/></td>
						<td class="time"><fmt:formatDate type="both" timeStyle="short"
								value="${item.end}" /></td>
            		</tr>
					</c:forEach>
					<c:if test="${list_size < 1}">
					<tr>
					<td class="time">----</td>
					<td class="time">----</td>
					<td class="time">----</td>
					<td class="time">----</td>
					<td class="time">----</td>
					<td class="time">----</td>
					<td class="time">----</td>
					
					</tr>
					</c:if>
				

			</tbody>
		</table>

	</div>
</body>