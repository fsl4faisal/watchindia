
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

	<%@ include file="/WEB-INF/jsp/security.jsp"%>

	<%@ include file="/WEB-INF/jsp/user/usersList.jsp" %>
	
	<%@ include file="/WEB-INF/jsp/movie/moviesList.jsp" %>

	<%@ include file="/WEB-INF/jsp/tvseries/tvseriesList.jsp" %>
</body>
</html>