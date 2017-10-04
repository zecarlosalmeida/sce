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
			<h1>Editar Ingrediente</h1>
		</div>
		<form method="post" name="myform" class="fomr-horizontal"
			action="<%=request.getContextPath()%>/ingrediente/atualizar">
			<div class="form-group">
				<ul>
					<c:forEach items="${erros}" var="msg">
						<li class="estiloerro">${msg}</li>
					</c:forEach>
				</ul>
			</div>


			<div class="form-group">
				<label class="col-sm-3 control-label" for="codIngrediente">Código:</label>
				<div class="col-sm-9">
					<input type="text" name="codIngrediente" id="codIngrediente"
						value="${ingrediente.codIngrediente}" readonly required="required"
						class="form-control">
				</div>
			</div>
			<span style="margin: 90px 1px;"></span>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="nome">Nome:</label>
				<div class="col-sm-9">
					<input type="text" name="nome" id="nome"
						value="${ingrediente.nome}" required="required"
						class="form-control">
				</div>

			</div>
			<span style="margin: 90px 1px;"></span>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="preco">Preço:</label>
				<div class="col-sm-9">
					<input type="text" name="preco" id="preco"
						value="${ingrediente.preco}" required="required"
						class="form-control">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10" style="margin-top: 20px;">
					<button typw="submit" class="btn btn-primary">Atualizar</button>
					<a href="<%=request.getContextPath()%>/ingrediente/listar"
						class="btn btn-default">voltar </a>
				</div>
			</div>
		</form>
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