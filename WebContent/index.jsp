<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Analisador de Texto</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="./bootstrap/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<link href="./bootstrap/bootstrap-responsive.css" rel="stylesheet">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->

</head>
<body>

	<SCRIPT language=JavaScript>
		function validar(formulario) {
			if (formulario.arquivo.value == '') {
				alert('POR FAVOR, ESCOLHA UM ARQUIVO!');
				formulario.arquivo.focus();
				return false;
			}
			return true;
		}
	</SCRIPT>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand">Corretor para modelo ACM</a>
				<div class="nav-collapse collapse"></div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">
	<form action="ProcessFile" method="POST" onSubmit="return (validar(this))">
		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<p>Faça aqui o upload do seu arquivo .tex:</p>
			<p>
					<%
						String erro = (String) request.getAttribute("erro");
					%>
					<%=erro%>
				</p>
				<p>
					<input type="submit" class="btn btn-primary btn-large" value="Enviar"/>
					<input name="arquivo" type="file" id="arquivo" value="arquivo" />
				</p>
			
		</div>

		<!-- Example row of columns -->
		<div class="row">
			<div class="span4">
				<h2>Title</h2>
				<div class="alert alert-success" role="alert"><p>
					<%
						String msn = (String) request.getAttribute("msg");
					%>
					<%=msn%>
				</p></div>
				<div class="alert alert-danger" role="alert"><p>
					<%
						String msn2 = (String) request.getAttribute("msg2");
					%>
					<%=msn2%>
				</p></div>
								<p>
					<%
						String msn3 = (String) request.getAttribute("msg3");
					%>
					<%=msn3%>
				</p>
				</p>
								<p>
					<%
						String msn4 = (String) request.getAttribute("msg4");
					%>
					<%=msn4%>
				</p>
				<p>
					<a class="btn"
						href="#">Mais detalhes »</a>
				</p>
			</div>
			<div class="span4">
				<h2>Abstract</h2>
				<p></p>
				<p>
					<a class="btn"
						href="#">Mais detalhes »</a>
				</p>
			</div>
			<div class="span4">
				<h2>Introdução</h2>
				<p></p>
				<p>
					<a class="btn"
						href="#">Mais detalhes »</a>
				</p>
			</div>
		</div>
		<div class="alert alert-success" role="alert">...</div>
<div class="alert alert-info" role="alert">...</div>
<div class="alert alert-warning" role="alert">...</div>
<div class="alert alert-danger" role="alert">...</div>
		<hr>

		<footer>
		<p>©Instituto Federal de Educação, Ciências e Tecnologia da Bahia
			- 2016</p>
		</footer>
	</form>
	</div>

	<!-- /container -->


	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="./bootstrap/jquery.js.download"></script>
	<script src="./bootstrap/bootstrap-transition.js.download"></script>
	<script src="./bootstrap/bootstrap-alert.js.download"></script>
	<script src="./bootstrap/bootstrap-modal.js.download"></script>
	<script src="./bootstrap/bootstrap-dropdown.js.download"></script>
	<script src="./bootstrap/bootstrap-scrollspy.js.download"></script>
	<script src="./bootstrap/bootstrap-tab.js.download"></script>
	<script src="./bootstrap/bootstrap-tooltip.js.download"></script>
	<script src="./bootstrap/bootstrap-popover.js.download"></script>
	<script src="./bootstrap/bootstrap-button.js.download"></script>
	<script src="./bootstrap/bootstrap-collapse.js.download"></script>
	<script src="./bootstrap/bootstrap-carousel.js.download"></script>
	<script src="./bootstrap/bootstrap-typeahead.js.download"></script>

</body>
<object id="fa785899-e89b-be94-798b-89b559be898f" width="0" height="0"
	type="application/gas-events-cef"></object>

</html>