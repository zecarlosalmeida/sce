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

	<!-- Fixed navbar -->

	<jsp:include page="/resources/templates/navbar.jsp" />
	<!--/.nav-collapse -->

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Pesquisar Pedido</h1>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<form method="post" name="myform" class="form-horizontal"
					action="<%=request.getContextPath()%>/pedido/pesquisado">

					<div class="form-group">
						<label class="col-md-3 control-label" for="anoMin">Data mínima: </label>
						<div class="col-md-9">
							<input type="text" name="anoMin" id="anoMin" value=""
								required="required" class="form-control"
								placeholder="data mínima" />
								<p class="help-block">Formato de data "dd/mm/aaaa"</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="anoMax">Data máxima: </label>
						<div class="col-md-9">
							<input type="text" name="anoMax" id="anoMax" value=""
								required="required" class="form-control" placeholder="data máxima"/>
								<p class="help-block">Formato de data "dd/mm/aaaa"</p>
						</div>
					</div>
					<div class="form-group">
				<div class="col-md-12 text-right">
					<button type="submit" class="btn btn-primary pull-right">Pesquisar</button>					
				</div>
			</div>
				</form>
			</div>
		</div>

	</div>


		<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>


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