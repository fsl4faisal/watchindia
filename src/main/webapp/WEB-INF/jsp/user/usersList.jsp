<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/includes.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
</head>
<body>
	<sec:authorize ifAllGranted="ROLE_ADMIN">
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
				<th colspan="2">Action REST</th>
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
							<td>${user.role.name}</td>
							<td><a href="admin/user?id=${user.id}&edit">edit</a></td>
							<td><a href="admin/user?id=${user.id}&delete">delete</a></td>
							<td><form:form method="delete">
									
								</form:form>
							</td>
							<td></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<a href="admin/user?add">Add User</a>
	</sec:authorize>

</body>
</html>