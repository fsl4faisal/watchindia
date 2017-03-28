<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tv Series List</title>
</head>
<body>

	<h1>List of TV Series</h1>
	<br />
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Episode</th>
			<th>Description</th>
			<th>Season</th>
			<sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PREMIUM_USER">
				<th>Download</th>
			</sec:authorize>

			<sec:authorize ifAllGranted="ROLE_ADMIN">
				<th colspan="2">Action</th>
			</sec:authorize>
		</tr>

		<c:choose>
			<c:when test="${empty tvSeriesList}">
				<tr>
					<td colspan="6" align="center">List Empty</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${tvSeriesList}" var="tvSeries">
					<tr>
						<td>${tvSeries.name}</td>
						<td>${tvSeries.episode}</td>
						<td>${tvSeries.description}</td>
						<td>${tvSeries.season}</td>
						<sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_PREMIUM_USER">
							<td><a href="#">link</a></td>
						</sec:authorize>
						<sec:authorize ifAllGranted="ROLE_ADMIN">
							<td><a href="admin/tvSeries?id=${tvSeries.id}&edit">edit</a></td>
							<td><a href="admin/tvSeries?id=${tvSeries.id}&delete">delete</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<sec:authorize ifAllGranted="ROLE_ADMIN">
		<a href="admin/tvSeries?add">Add Episode</a>
	</sec:authorize>
</body>
</html>