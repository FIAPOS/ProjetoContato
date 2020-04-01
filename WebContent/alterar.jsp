<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="estilo.css">
</head>
<body>
	<h1>Alterar</h1>
	<div>
  		<form action="alterar" method="post">
			<label for="lnome">Nome</label><br>
    		<input type="text" id="nome" name="nome" value="${contato.nome}"><br>
	  
			<label for="lemail">Email</label><br>
    		<input type="text" id="email" name="email" value="${contato.email}"><br>
	  
			<label for="lendereco">Endereço</label><br>
			<input type="text" id="endereco" name="endereco" value="${contato.endereco}"><br>
	  
			<label for="lnome">Data de Nascimento</label><br>
			<input type="date" id="data" name="data" value="${contato.data}"><br>

    
			<label for="lgenero">Gênero</label><br>
			<c:if test="${contato.genero == 'Feminino'}">
				<input type="radio" id="feminino" name="genero" value="Feminino" checked>Feminino 
				<input type="radio" id="masculino" name="genero" value="Masculino">Masculino
				<input type="radio" id="indiferente" name="genero" value="Indiferente">Indiferente
	  	
			</c:if>
			
			<c:if test="${contato.genero == 'Masculino'}">
				<input type="radio" id="feminino" name="genero" value="Feminino" >Feminino 
				<input type="radio" id="masculino" name="genero" value="Masculino" checked>Masculino
				<input type="radio" id="indiferente" name="genero" value="Indiferente">Indiferente
	  	
			</c:if>
			
			<c:if test="${contato.genero == 'Indiferente'}">
				<input type="radio" id="feminino" name="genero" value="Feminino" >Feminino 
				<input type="radio" id="masculino" name="genero" value="Masculino">Masculino
				<input type="radio" id="indiferente" name="genero" value="Indiferente"checked>Indiferente
	  	
			</c:if>
    		<br>
    		<input type="submit" value="Alterar">
  		</form>
	</div>


</body>
</html>