
<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=request.getContextPath() %>">Sistema Pizzaria</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="<%=request.getContextPath()%>">Home</a></li>
				<li><a href="<%=request.getContextPath()%>/ingrediente/listar">Cadastrar
						Ingrediente</a></li>
				<li><a href="<%=request.getContextPath()%>/pedido/pesquisar">Pesquisar Pedido</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>