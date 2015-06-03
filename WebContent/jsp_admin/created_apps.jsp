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
		<table class="app-table" rules="all">
			<caption><b>
			Created applications
				</b>
			</caption>
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
						<td class="time"><fmt:formatDate type="both"
								timeStyle="short" value="${item.creation}" /></td>
						<td class="time"><fmt:formatDate type="both"
								timeStyle="short" value="${item.desirable}" /></td>
						<td class="time"><fmt:formatDate type="both"
								timeStyle="short" value="${item.start}" /></td>
						<td class="time"><fmt:formatDate type="both"
								timeStyle="short" value="${item.end}" /></td>
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