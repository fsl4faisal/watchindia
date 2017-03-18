<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
<title>User Registration</title>
</head>
<body>
	<form:form method="post" modelAttribute="userDetails">
		<table>
			<tr>
				<th>First Name</th>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error"/></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error"/></td>
			</tr>
			<tr>
				<th>Email ID</th>
				<td><form:input path="emailId" /></td>
				<td><form:errors path="emailId" cssClass="error"/></td>
			</tr>
			<tr>
				<th>User Type</th>
				<td><form:select path="userType" items=${userTypes} itemValue="value" itemLabel="name"/></td>
				<td><form:errors path="userType" cssClass="error"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>