<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>P3 LAB BD</title>
</head>
<style>
.pattern {
	background-color: #39c0db;
	opacity: 1;
	background-image: linear-gradient(30deg, #000000 12%, transparent 12.5%, transparent 87%,
		#000000 87.5%, #000000),
		linear-gradient(150deg, #000000 12%, transparent 12.5%, transparent 87%,
		#000000 87.5%, #000000),
		linear-gradient(30deg, #000000 12%, transparent 12.5%, transparent 87%,
		#000000 87.5%, #000000),
		linear-gradient(150deg, #000000 12%, transparent 12.5%, transparent 87%,
		#000000 87.5%, #000000),
		linear-gradient(60deg, #00000077 25%, transparent 25.5%, transparent 75%
		, #00000077 75%, #00000077),
		linear-gradient(60deg, #00000077 25%, transparent 25.5%, transparent 75%
		, #00000077 75%, #00000077);
	background-size: 40px 70px;
	background-position: 0 0, 0 0, 20px 35px, 20px 35px, 0 0, 20px 35px;
}

.black {
	background-color: #000000;
}

.vertical-center {
	min-height: 100%; /* Fallback for browsers do NOT support vh unit */
	min-height: 100vh; /* These two lines are counted as one :-)       */
	align-items: center;
}
</style>
<body class="pattern">
	<div class="container black vertical-center">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 my-4">
					<h3 class="text-center text-warning">Sistema de notas/faltas</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 my-4">
					<a href="/SigaBom/faltas.jsp">
						<button type="button" class="btn btn-success btn-block btn-lg">
							Faltas</button>
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 my-4">
					<a href="/SigaBom/notas.jsp">
						<button type="button" class="btn btn-block btn-lg btn-info">
							Notas</button>
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 my-4">
					<a href="/SigaBom/relatorioFalta.jsp">
						<button type="button" class="btn btn-block btn-lg btn-warning">
							Relatório Faltas</button>
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 my-4">
					<a href="/SigaBom/relatorioNota.jsp">
						<button type="button" class="btn btn-block btn-lg btn-danger">
							Relatório Notas</button>
					</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>