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
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">


<link rel="icon" href="../../favicon.ico">

	<jsp:include page="/resources/templates/navbar.jsp" />



</head>
<body>

	<jsp:include page="/resources/templates/navbar.jsp" />
	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Ingredientes</h1>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<form class="navbar-form" action="<%=request.getContextPath()%>/ingrediente/novo">
					<button type="submit" class=" btn btn-primary">Inserir Novo</button>
				</form>
			</div>
			<div class="col-sm-6">
				<form class="navbar-form" action="<%=request.getContextPath()%>/ingrediente/filtrar">
					<div class="form-group">
						<input type="text" name="busca" placeholder="Digite o ingrediente" class="form-control"/>
					</div>
					<button type="submit" class="btn btn-primary">Filtrar</button>
				</form>
			</div>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Preço</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ingrediente}" var="x">
					<tr>
						<td>${x.codIngrediente}</td>
						<td>${x.nome}</td>
						<td>${x.preco }</td>
						<td><a href="<%=request.getContextPath()%>/ingrediente/editar?cod=${x.codIngrediente}" class="btn btn-primary btn-xs">Editar</a>
							<a href="<%=request.getContextPath()%>/ingrediente/remover?cod=${x.codIngrediente}" class="btn btn-danger btn-xs">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>





<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>
	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>	

