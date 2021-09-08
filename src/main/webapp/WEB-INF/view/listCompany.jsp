<%@page import="br.com.gerenciador.modelo.Company"%>
<%@page import="java.util.Set"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/entre" var="entreUnique"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Companys List</title>
</head>
<body>
	<h1>Lista de empresas</h1>
	<c:import url="logoutParse.jsp" />
	<c:if test="${not empty company}">
		<p>Empresa ${company}</p>
	</c:if>
	
	<ul>
		<c:forEach items="${listCompany}" var="company">
			<%--
			 <li>${company.name}- <fmt:formatDate value="${company.dataOpen}"
					pattern="dd/MM/yyyy"/> 			
			 --%>
			 <li>${company.name} - ${company.dataOpen}
					<a href="${entreUnique}?action=EditeCompany&id=${company.id}">Editar</a> 
					<a href="${entreUnique}?action=RemoveCompany&id=${company.id}">remove</a> 
			</li>
		</c:forEach>
	</ul>
	<button>
	<a href="${entreUnique}?action=FormCompany">New</a>
	</button>
</body>
</html>