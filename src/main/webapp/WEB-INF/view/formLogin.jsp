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
<h2>Login</h2>
	<form action="${entreUnique}" method="post">
		Login: <input type="text" name="login" />
		Pass: <input type="password" name="pass" />
		<input name="action" value="Login" type="hidden"/>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>