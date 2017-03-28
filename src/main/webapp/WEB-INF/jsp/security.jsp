<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<sec:authorize
		ifAnyGranted="ROLE_GUEST,ROLE_FREE_USER,ROLE_PREMIUM_USER,ROLE_ADMIN">
		<br /> Welcome
	<sec:authentication property="name" />
	</sec:authorize>

	<br />

	<sec:authorize ifAllGranted="ROLE_GUEST">
		<a href="<c:url value="/spring_security_login"/>">Login</a>
		<br />
		<a href="user?register">Register here</a>
	</sec:authorize>

	<br />

	<sec:authorize
		ifAnyGranted="ROLE_GUEST,ROLE_FREE_USER,ROLE_PREMIUM_USER,ROLE_ADMIN">
		<br />
		<b>Note:</b>
		<br /> Only registered users can download movies or TV series
	<br /> Only premium members can download TV Series
	</sec:authorize>
	<br />

	<sec:authorize
		ifAnyGranted="ROLE_ADMIN,ROLE_FREE_USER,ROLE_PREMIUM_USER">
		<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
	</sec:authorize>
	<br />

</body>
</html>