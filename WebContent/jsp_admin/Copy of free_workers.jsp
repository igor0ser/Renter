<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<table class="app-table" rules="all">
	<caption>
		<b> Free workers </b>
	</caption>
	<tbody>
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Speciality</th>
			<th>Apply to this work</th>

		</tr>
		<tr>
			<td>${worker.name}</td>
			<td>${worker.surname}</td>

			<td>${worker.typeOfWork}</td>
			<td>${worker.typeOfWork}</td>
			<td><input type="checkbox" value="William Pharell"></td>
		</tr>



	</tbody>
</table>
