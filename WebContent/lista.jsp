<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Analisador de Texto</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="css/heroic-features.css" rel="stylesheet">
    
        <!-- Bootstrap Core CSS -->
    <link href="../vendor2/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor2/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../vendor2/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor2/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">

            </ul>
        </div>
    </nav>

    <!-- Page Content -->
     
    <div class="row">
	<div class="col-lg-6">
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
		</div>
		<div class="col-lg-4">
		 <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bell fa-fw"></i> Notifications Panel
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="list-group">
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small"><em>4 minutes ago</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small"><em>12 minutes ago</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small"><em>27 minutes ago</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small"><em>43 minutes ago</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small"><em>11:32 AM</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-bolt fa-fw"></i> Server Crashed!
                                    <span class="pull-right text-muted small"><em>11:13 AM</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-warning fa-fw"></i> Server Not Responding
                                    <span class="pull-right text-muted small"><em>10:57 AM</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-shopping-cart fa-fw"></i> New Order Placed
                                    <span class="pull-right text-muted small"><em>9:49 AM</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-money fa-fw"></i> Payment Received
                                    <span class="pull-right text-muted small"><em>Yesterday</em>
                                    </span>
                                </a>
                            </div>
                            <!-- /.list-group -->
                            <a href="#" class="btn btn-default btn-block">View All Alerts</a>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    </div>
    </div>

    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; Instituto Federal de Educação, Ciências e Tecnologia da Bahia - 2017</p>
        </div>
        <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>