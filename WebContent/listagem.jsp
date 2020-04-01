<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="estilo.css">
</head>
<body>
	<table id ="customers">
		<tr>
			<th>Nome</th>
			<th>Endereco</th>
			<th>Email</th>
			<th>Data</th>
			<th>Genero</th>
			<th></th>
			<th></th>
		</tr>
		
		<c:forEach var="contato" items="${lista}">
			<tr>
				<td>${contato.nome}</td>
				<td>${contato.endereco}</td>
				<td>${contato.email}</td>
				<td><fmt:formatDate value="${contato.data}" pattern="dd/MM/yyyy"/></td>
				<td>${contato.genero}</td>
				<td><a href="buscarEmail?email=${contato.email}">Alterar</a></td>
				<td><a href="remover?email=${contato.email}">Remover</a></td>
			</tr>		
		</c:forEach>		
	</table>
	<h3><a href="index.jsp">Cadastrar Contato</a></h3>
</body>
</html>