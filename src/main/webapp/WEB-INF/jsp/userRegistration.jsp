<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>

<style>
.error {
	color: #ff0000;
	font-weight: bold;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

</head>
<body>
	<form:form method="POST" modelAttribute="users">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<th>First Name</th>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>

			<tr>
				<th>Last Name</th>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>

			<tr>
				<th>password</th>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>

			<tr>
				<th>Email Id</th>
				<td><form:input path="emailId" /></td>
				<td><form:errors path="emailId" cssClass="error" /></td>
			</tr>

			<tr>
				<th>User Name</th>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error" /></td>
			</tr>

			<tr>
				<th>User Type</th>
				<td><form:select path="userType">
						<option disabled selected></option>
						<c:forEach items="${userTypes}" var="userType">
							<option value="${userType}">${userType.name}</option>
						</c:forEach>
					</form:select></td>
				<td><form:errors path="userType" cssClass="error" /></td>
			</tr>

			<tr>
				<th>Enabled</th>
				<td><form:select path="enabled">
						<option disabled selected></option>
						<c:forEach items="${enabledList}" var="enabledStatus">
							<option value="${enabledStatus.value}">${enabledStatus.name}</option>
						</c:forEach>
					</form:select></td>
				<td><form:errors path="enabled" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit" /></td>

			</tr>
		</table>

	</form:form>
</body>
</html>