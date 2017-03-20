<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${action}</title>

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
	<h1>${action}</h1>

	<form:form method="post" modelAttribute="movies">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<th>Name</th>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>

			<tr>
				<th>Description</th>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssClass="error" /></td>
			</tr>

			<tr>
				<th>Year of Release</th>
				<td><form:input path="yearOfRelease" /></td>
				<td><form:errors path="yearOfRelease" cssClass="error" /></td>
			</tr>

			<tr>
				<th>Genre</th>
				<td><form:input path="genre" /></td>
				<td><form:errors path="genre" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
				<input type="submit"
					value="Submit" /></td>

			</tr>
		</table>

	</form:form>

</body>
</html>