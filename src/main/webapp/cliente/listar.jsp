<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<div class="col-sm-2">
				<form class="navbar-form" action="<%=request.getContextPath()%>/cliente/novo">
					<button type="submit" class="btn btn-primary">Inserir novo</button>
				</form>
			</div>
			<div class="col-sm-6">
				<form class="navbar-form" action="<%=request.getContextPath()%>/cliente/filtrar">
					<div class="form-group">
						<input type="text" name="busca" placeholder="Digite um nome" class="form-control"/>
					</div>
					<button type="submit" class="btn btn-success">Filtrar</button>
				</form>
			</div>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>Nascimento</th>
					<th>Renda mensal</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codCliente}</td>
						<td>${x.nome}</td>
						<td>${x.cpf}</td>
						<td>${x.telefone}</td>
						<td>${x.email}</td>						
						<td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${x.dataNasc}"/></td>
						<td><fmt:setLocale value="pt_BR"/><fmt:formatNumber type="currency" value="${x.renda}" /></td>
						<td>
						
						<a href="<%=request.getContextPath()%>/cliente/editar?cod=${x.codCliente}" class="btn btn-primary btn-xs">Editar</a>
						<a href="<%=request.getContextPath()%>/cliente/remover?cod=${x.codCliente}" class="btn btn-danger btn-xs">Excluir</a></td>
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

