<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies List</title>
</head>
<body>
	<h1>List of Movies</h1>
	<br />
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Genre</th>
			<th>Year of Release</th>

			<sec:authorize
				ifAnyGranted="ROLE_ADMIN,ROLE_FREE_USER,ROLE_PREMIUM_USER">
				<th>Download</th>
			</sec:authorize>

			<sec:authorize ifAnyGranted="ROLE_ADMIN">
				<th colspan="2">Action</th>
			</sec:authorize>

		</tr>
		<c:choose>
			<c:when test="${empty moviesList}">
				<tr>
					<td colspan="7" align="center">List Empty</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${moviesList}" var="movie">
					<tr>
						<td>${movie.name}</td>
						<td>${movie.description}</td>
						<td>${movie.genre}</td>
						<td>${movie.yearOfRelease}</td>
						<sec:authorize
							ifAnyGranted="ROLE_ADMIN,ROLE_FREE_USER,ROLE_PREMIUM_USER">
							<td><a href="#">link</a></td>
						</sec:authorize>
						<sec:authorize ifAllGranted="ROLE_ADMIN">
							<td><a href="admin/movies?id=${movie.id}&edit">edit</a></td>
							<td><a href="admin/movies?id=${movie.id}&delete">delete</a></td>
						</sec:authorize>

					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>

	<sec:authorize ifAllGranted="ROLE_ADMIN">
		<a href="admin/movies?add">Add Movie</a>
	</sec:authorize>

</body>
</html>