<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collection</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<body>
	<div
		style="background-color: maroon; border: 1px solid black; padding: 7px; width: auto;">
		<!-- Mempercantik Tampilan -->
		<marquee>
			<span style="color: white;"> Data Kamu Saat ini : <c:forEach
					items="${requestScope.empList}" var="emp">

					<tr>
						<td><c:out value="${emp.id}"></c:out> |</td>
						<td><c:out value="${emp.nama}"></c:out> |</td>
						<td><c:out value="${emp.tanggal}"></c:out> |</td>
						<td>---</td>
				</c:forEach>
			</span>
		</marquee>
		<!-- Mempercantik Tampilan -->
	</div>

	<center>
		<h1>
			<font size='7' face='Georgia, Arial' color='maroon'>T</font>able <font
				size='7' face='Georgia, Arial' color='maroon'>C</font>ollection
		</h1>
		<hr />
		<br />
	</center>
	<center>
		<table border="1" cellpadding="10" cellspacing="1">
			<tbody>
				<tr>
					<th>ID</th>
					<th>Nama</th>
					<th>Tanggal</th>
					<th>Golongan</th>
				</tr>
				<c:forEach items="${requestScope.empList}" var="emp">
					<tr>
						<td><c:out value="${emp.id}"></c:out></td>
						<td><c:out value="${emp.nama}"></c:out></td>
						<td><c:out value="${emp.tanggal}"></c:out></td>
						<td><a href='Case2Servlet?id=${emp.id}'>Golongan</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
	<center>
		<p>*Hasil sorting didapat dari collection, dan hasil tabel didapat dari collection.csv</p>
	</center>
</body>
</html>