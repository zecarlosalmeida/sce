<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Sistema Pizzaria</title>
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">

</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Confirmar Exclusão de Ingrediente</h1>
		</div>
		<div class="" style="margin-top: 20px;">
			<ul class="list-group">
				<li class="list-group-item">Código: ${ingrediente.codIngrediente}</li>
				<li class="list-group-item">Nome: ${ingrediente.nome}</li>
				<li class="list-group-item">Preço: ${ingrediente.preco}</li>
			</ul>
		</div>


		
			<div class="" style="margin-top: 20px;">
				<a href="<%=request.getContextPath()%>/ingrediente/excluir?cod=${ingrediente.codIngrediente}" class="btn btn-danger">Excluir</a>
				<a href="<%=request.getContextPath()%>/ingrediente/listar"
					class="btn btn-default">voltar </a>
			</div>

	</div>


	<jsp:include page="/resources/templates/rodape.jsp" />


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

</body>
</html>