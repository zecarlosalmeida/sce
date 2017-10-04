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




</head>
<body>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Clientes</h1>
		</div>



		<div class="row">
		<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<ul>
						<c:forEach items="${erros}" var="msg">
							<li class="erro">${msg}</li>
						</c:forEach>
					</ul>
				</div>
			</div>			
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>Códigoo</th>
					<th>Nome</th>					
					<th>Telefone</th>
					<th>Email</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codCliente}</td>
						<td>${x.nome}</td>						
						<td>${x.telefone}</td>
						<td>${x.email}</td>					
						
						<td>
						<a href="<%=request.getContextPath()%>/pedido/novo?codCliente=${x.codCliente}" class="btn btn-success btn-xs">Adicionar pedido</a>
						<a href="<%=request.getContextPath()%>/pedido/listar?codCliente=${x.codCliente}" class="btn btn-primary btn-xs">Ver pedidos</a>
						
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

