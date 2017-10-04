<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
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
			<h1>Pedidos</h1>
		</div>
		<a href="<%=request.getContextPath()%>/clientePedido/listar"
			class="btn btn-warning">Voltar</a>
		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Data do pedido</th>
					<th>Valor</th>
					<th>Ação</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${cliente.getPedidos()}" var="x">
					<tr>
						<td>${x.codPedido}</td>
						<td><fmt:formatDate type="date" pattern="dd/MM/yyyy HH:mm"
								value="${x.data}" /></td>
						<td><fmt:setLocale value="pt_BR" /> <fmt:formatNumber
								type="currency" value="${x.valorTotal()}" /></td>
						<td><a
							href="<%=request.getContextPath()%>/pedido/exibir?codPedido=${x.codPedido}"
							class="btn btn-info">Detalhes</a></td>
						<td><a
							href="<%=request.getContextPath()%>/pedido/excluir?codPedido=${x.codPedido}"
							class="btn btn-danger">Excluir Pedido</a></td>
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

