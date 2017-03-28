<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${message}</title>
<style>
.error {
	font-weight: bold;
	color: #ff0000;
}

.errorBlock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/security.jsp"%>
	<h1>${message}</h1>

	<form:form method="post" modelAttribute="tvSeries">
		<form:errors path="*" cssClass="errorBlock" element="div" />
		<table>
			<tr>
				<th>Name</th>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<th>Season</th>
				<td><form:input path="season" /></td>
				<td><form:errors path="season" cssClass="error" /></td>
			</tr>
			<tr>
				<th>Episode</th>
				<td><form:input path="episode" /></td>
				<td><form:errors path="episode" cssClass="error" /></td>
			</tr>

			<tr>
				<th>Description</th>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssClass="error" /></td>
			</tr>


			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="submit" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>