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
  				<th>Erros</th>	
  			</tr>
  		</thead>
  		<tbody>
  			<tr>
  			<%
      List<String> erros = (List<String>)session.getAttribute("erros");
  			
      int count = 0;
      for (String erro : erros ) {
      %>
  			<th scope="row"><%=count++ %></th>
  			
  			<td><%=erro %></td>
  			</tr>
  			  <%
      }
      %>
      
      <tr>
  			<%
      List<String> erros2 = (List<String>)session.getAttribute("erros2");
  			
      int counts = 0;
      for (String erro2 : erros2 ) {
      %>
  			<th scope="row"><%=counts++ %></th>
  			
  			<td><%=erro2 %></td>
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