
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Pizzaria</title>
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
			<h1>Inserir novo item ao pedido</h1>
		</div>

		<form method="post" name="myform" class="form-horizontal"
			action="<%=request.getContextPath()%>/itemPedido/novo">

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<ul>
						<c:forEach items="${erros}" var="msg">
							<li class="erro">${msg}</li>
						</c:forEach>
					</ul>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Pedido: </label>
				<div class="col-sm-5">
					<input type="text" name="pedido" id="pedido"
						value="${pedido.codPedido}" required="required"
						class="form-control" readonly="readonly" /> <input type="hidden"
						name="codPedido" id="pedido" value="${pedido.codPedido}"
						required="required" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Quantidade:</label>
				<div class="col-sm-5">
					<input type="text" name="qtd" id="qtd" value="1"
						required="required" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Pizza:</label>
				<div class="col-sm-5">
					<select type="text" name="codPizza" id="codPizza" required="required" class="form-control" />
					<c:forEach items="${itens}" var="x">
						<option value="${x.codPizza}">${x.nome}</option>
					</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Inserir</button>
					<a href="<%=request.getContextPath()%>/pizza/listar"
						class="btn btn-default">Voltar</a>
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

