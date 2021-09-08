<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Created Company</title>
</head>
<body>
<c:import url="logoutParse.jsp" />
	<c:if test="${not empty company}">
		<p>Empresa ${company}</p>
	</c:if>
	<c:if test="${empty company}">
		<p>Nem uma empresa cadastras</p>
	</c:if>
</body>
</html>