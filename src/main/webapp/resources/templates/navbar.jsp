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
			<a class="navbar-brand" href="<%=request.getContextPath()%>/">Sistema
				de Pizzaria</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
			<li><a href="<%=request.getContextPath()%>/clientePedido/listar">Pedidos</a></li>
			<li><a href="<%=request.getContextPath()%>/pedido/pesquisar">Pesquisar Pedido</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Gerenciamento <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<%=request.getContextPath()%>/cliente/listar">Clientes</a></li>
						<li><a href="<%=request.getContextPath()%>/ingrediente/listar">Ingrediente</a></li>						
						<li><a href="<%=request.getContextPath()%>/pizza/listar">Pizzas</a></li>
						<!-- <li role="separator" class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li> -->
					</ul></li>

			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>
