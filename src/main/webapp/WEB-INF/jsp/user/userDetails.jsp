<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Information</title>
</head>
<body>
	<table>
		<tr>
			<th>First Name</th>
			<td>${user.firstName}</td>

		</tr>

		<tr>
			<th>Last Name</th>
			<td>${user.lastName}</td>

		</tr>

		<tr>
			<th>Email Id</th>
			<td>${user.emailId}</td>

		</tr>

		<tr>
			<th>User Name</th>
			<td>${user.username}</td>
		</tr>

		<tr>
			<th>User Type</th>
			<td>${user.role.name}</td>

		</tr>

		<tr>
			<th>Enabled</th>
			<td>${user.enabled.name}</td>

		</tr>
	</table>
<a href="/index">Home</a>
</body>
</html>