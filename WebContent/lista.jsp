<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Listando Erros</title>
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

<table class="table table-hover">
		<thead>
			<tr>
  				<th>#</th>
  				<th>Espaço antes de virgula e ponto</th>	
  			</tr>
  		</thead>
  		<tbody>
  			<tr>
  			<%
      List<String> erros = (List<String>)request.getAttribute("erros");
  			
      int count = 0;
      for (String erro : erros ) {
      %>
  			<th scope="row"><%=count++ %></th>
  			
  			<td><%=erro %></td>
  			</tr>
  			  <%
      }
      %>
      <thead>
			<tr>
  				<th>#</th>
  				<th>Letra maiúscula depois de :</th>	
  			</tr>
  		</thead>
      <tr>
  			<%
      List<String> erros2 = (List<String>)request.getAttribute("erros2");
  			
      
      for (String erro2 : erros2 ) {
      %>
  			<th scope="row"><%=count++ %></th>
  			
  			<td><%=erro2 %></td>
  			</tr>
  			  <%
      }
      %>
      <thead>
			<tr>
  				<th>#</th>
  				<th>Parênteses sem espaço anterior</th>	
  			</tr>
  		</thead>
            <tr>
  			<%
      List<String> erros3 = (List<String>)request.getAttribute("erros3");
  			
     
      for (String erro3 : erros3 ) {
      %>
  			<th scope="row"><%=count++ %></th>
  			
  			<td><%=erro3 %></td>
  			</tr>
  			  <%
      }
      %>
            <thead>
			<tr>
  				<th>#</th>
  				<th>Citação sem espaço anterior</th>	
  			</tr>
  		</thead>
            <tr>
  			<%
      List<String> erros4 = (List<String>)request.getAttribute("erros4");
  			
     
      for (String erro4 : erros4 ) {
      %>
  			<th scope="row"><%=count++ %></th>
  			
  			<td><%=erro4 %></td>
  			</tr>
  			  <%
      }
      %>
  		</tbody>
		</table>
		<footer>
		<p>©Instituto Federal de Educação, Ciências e Tecnologia da Bahia - 2016</p>
		</footer>
</body>
</html>