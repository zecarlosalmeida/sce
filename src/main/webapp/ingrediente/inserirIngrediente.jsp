<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf8">
<title>Sistema de Pizzaria</title>
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"	rel="stylesheet">


<link rel="icon" href="../../favicon.ico">




</head>
<body>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Inserir novo Ingrediente</h1>
		</div>
		<form method="post" name="myform" class="fomr-horizontal"
			action="<%=request.getContextPath()%>/ingrediente/inserir">
			<div class="form-group">
				<ul>
					<c:forEach items="${erros}" var="msg">
						<li class="estiloerro">${msg}</li>
					</c:forEach>
				</ul>
			</div>
			
			<div class="row">
			<div class="form-group">
				<label class="col-sm-3 control-label" for="nome">Nome:</label>
				<div class="col-sm-9">
					<input type="text" name="nome" id="nome"
						value="${ingrediente.nome}" required="required"
						class="form-control">
				</div>
			</div>
			</div>
	<div class="clearfix"></div>
	
		<div class="row">
			<div class = "form-group">
				<label class="col-sm-3 control-label" for="preco">Preço:</label>
				<div class="col-sm-9">
					<input type="text" name="preco" id="preco" value="${ingrediente.preco}" required="required" class="form-control">
				</div>
			</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10" style="margin-top: 20px;">
					<button typw="submit" class="btn btn-primary">Inserir</button>
					<a href="<%=request.getContextPath()%>/ingrediente/listar"
						class="btn btn-default">voltar </a>
				</div>
			</div>
		</form>
	</div>


	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>
	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>	

