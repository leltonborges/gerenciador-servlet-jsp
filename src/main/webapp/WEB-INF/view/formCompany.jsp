<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entre" var="entreUnique"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastra empresa</title>
</head>
<body>
<c:import url="logoutParse.jsp" />
	<form action="${entreUnique}" method="post">
		Name: <input type="text" name="name" />
		Data: <input type="text" name="data" />
		<input name="action" value="NewCompany" type="hidden"/>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>