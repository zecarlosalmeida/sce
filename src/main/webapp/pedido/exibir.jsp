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
		<a href="<%=request.getContextPath()%>/cliente/listar"
			class="btn btn-warning">Voltar</a> <a
			href="<%=request.getContextPath()%>/itemPedido/inserir?codPedido=${pedido.codPedido}"
			class="btn btn-success">Adicionar item</a>
		<table class="table">
			<thead>
				<tr>
					<th>Quantidade</th>
					<th>Pizza</th>
					<th>Preço</th>
					<th>Ação</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${item.getItens()}" var="x">
					<tr>
						<td>${x.getQuantidade()}</td>
						<td>${x.getPizza().getNome()}</td>
						<td><fmt:setLocale value="pt_BR" />
							<fmt:formatNumber type="currency"
								value="${x.getPizza().valorTotal()}" /></td>
						<td><a
							href="<%=request.getContextPath()%>/itemPedido/excluir?codItem=${x.codItemPedido}"
							class="btn btn-danger">Excluir item</a></td>
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

