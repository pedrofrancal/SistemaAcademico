<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<title> SIGA Bom</title>
</head>
<style>

</style>

<body>
	<center>
		<form action="relatorioFalta" method="post">
			<select name="materias" id="materias">
	  			<option value="4203-010">Arquitetura e Organiza��o de Computadores - tarde  </option>
	  			<option value="4203-020">Arquitetura e Organiza��o de Computadores - noite  </option>
	  			<option value="4208-010">Laborat�rio de Hardware   </option>
	  			<option value="4226-004">Banco de Dados   </option>
	  			<option value="4213-003">Sistemas Operacionais I - tarde   </option>
	  			<option value="4213-013">Sistemas Operacionais I - noite   </option>
	  			<option value="4233-005">Laborat�rio de Banco de Dados   </option>
	  			<option value="4203-011">M�todos Para a Produ��o do Conhecimento   </option>
			</select>

			<input type="submit" name="enviar" id="enviar" value="Mostrar">
		</form>
	</center>
	
</body>
</html>