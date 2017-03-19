<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<title>Welcome</title>
</head>
<body>

	<sec:authorize ifAllGranted="ROLE_GUEST">
		<a href="<c:url value="/spring_security_login"/>">Login</a>
	</sec:authorize>
	<br /> Welcome
	<sec:authentication property="name" />
	<br />

	<sec:authorize
		ifAnyGranted="ROLE_ADMIN,ROLE_FREE_USER,ROLE_PREMIUM_USER">
		<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
	</sec:authorize>
	<br />

	<sec:authorize ifAllGranted="ROLE_GUEST">
		<a href="#">Register here</a>
	</sec:authorize>
	<br />

	<h1>Users</h1>
	<br />
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>User Name</th>
			<th>Email Id</th>
			<th>User Type</th>
			<th colspan="2">Action</th>
		</tr>

		<c:choose>
			<c:when test="${empty usersList}">
				<tr>
					<td colspan="7" align="center">List Empty</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${usersList}" var="user">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.username}</td>
						<td>${user.emailId}</td>
						<td>${user.userType}</td>
						<td><a href="#"/>edit</td>
						<td><a href="#"/>delete</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<a href="user/registration">Add User</a>


	<h1>List of Movies</h1>
	<br />
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Genre</th>
			<th>Year of Release</th>
			<th colspan="2">Action</th>
		</tr>
		<c:choose>
			<c:when test="${empty movieList}">
				<tr>
					<td colspan="5" align="center">List Empty</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${moviesList}" var="movie">
					<tr>
						<td>${movie.name}</td>
						<td>${movie.description}</td>
						<td>${movie.genre}</td>
						<td>${movie.yearOfRelease}</td>
						<td><a href="#">edit</a></td>
						<td><a href="#">delete</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>


	</table>

	<a href="#">Add Movie</a>

	<h1>List of TV Series</h1>
	<br />
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Episode</th>
			<th>Description</th>
			<th>Season</th>
			<th colspan="2">Action</th>
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
						<td>${movie.description}</td>
						<td>${movie.season}</td>
						<td><a href="#">edit</a></td>
						<td><a href="#">delete</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<a href="#">Add Episode</a>
</body>
</html>