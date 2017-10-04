<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Filmes</title>
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
			<h1>Confirmar exclus�o do cliente</h1>
		</div>

		<div>
			<ul class="list-group">
				<li class="list-group-item">C�digo: ${item.codCliente}</li>
				<li class="list-group-item">Nome: ${item.nome}</li>
				<li class="list-group-item">CPF: ${item.cpf}</li>
				<li class="list-group-item">Renda: <fmt:setLocale value="pt_BR" /> <fmt:formatNumber
						type="currency" value="${item.renda}" /></li>
				<li class="list-group-item">Data de nascimento: <fmt:formatDate type="date" pattern="dd/MM/yyyy"
						value="${item.dataNasc}" /></li>
			</ul>
		</div>

		<div>
			<a href="<%=request.getContextPath()%>/cliente/excluir?cod=${item.codCliente}" class="btn btn-danger">Excluir</a>
			<a href="<%=request.getContextPath()%>/cliente/listar"
				class="btn btn-default">Voltar</a>
		</div>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
