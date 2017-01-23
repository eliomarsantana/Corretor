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
			<p>Anexar arquivo .tex:</p>
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
		
		<table class="table table-hover">
		<thead>
			<tr>
  				<th>#</th>
  				<th>Introdução</th>
  				<th></th>
  				<th></th>
  			</tr>
  		</thead>
  		<tbody>
  			<tr>
  			<th scope="row">1</th>
  			<td>Mark</td>
  			</tr>
  		</tbody>
		</table>

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