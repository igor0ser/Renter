<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Renter - Aplication</title>
<link rel="stylesheet" href="main_admin.css">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
</head>
<body>

	<%@include file="title-menu.jsp"%>



	<div class="appplication-container">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="free_workers"/>
			<table class="app-table" rules="all">
				<caption>
					<b> Created applications </b>
				</caption>
				<tbody>
					<tr>
						<th>Login</th>
						<th>Phone Number</th>
						<th>Address</th>
						<th>Type of work</th>
						<th>About</th>
						<th>Creation time</th>
						<th>Desirable time</th>
						<th>Start time</th>
						<th>End time</th>
					</tr>
					<tr>
						<td>${app.user.login}</td>
						<td>${app.user.phoneNumber}</td>
						<td>${app.user.address}</td>
						<td>${app.typeOfWork}</td>
						<td class="about">${app.about}</td>
						<td class="time"><fmt:formatDate type="both"
								timeStyle="short" value="${app.creation}" /></td>
						<td class="time"><fmt:formatDate type="both"
								timeStyle="short" value="${app.desirable}" /></td>
						<td class="calendar" class="reg-input"><input name="start"
							type="datetime-local"
							value=<c:out value="${default_start}"></c:out> required>
						<td class="calendar" class="reg-input"><input name="end"
							type="datetime-local" required value="${default_end}"></td>


					</tr>
				</tbody>
			</table>

			<input type="checkbox" name="show-all" value="true"
				<c:if test="${is_checked}">checked</c:if>> Show all
			specialties.

			<button type="submit">Show free workers</button>
		</form>
		
		
		
		<c:if test="${list_size > 0}">
			<form action="controller" method="post">
			<input type="hidden" name="command" value="add_workers"/>
				<table class="app-table" rules="all">
					<caption>
						<b> Free workers </b>
					</caption>
					<tbody>
						<tr>
							<th>Name</th>
							<th>Specialty</th>
							<th>Assign</th>
						</tr>
						<c:forEach var="item" items="${list}">
							<tr>
								<td>${item}</td>
								<td>${item.typeOfWork}</td>
								<td><input type="checkbox" name="${item.id}"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<button type="submit">Add to this work</button>
			</form>
		</c:if>
</body>