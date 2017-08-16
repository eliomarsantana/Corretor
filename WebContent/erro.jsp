<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Error</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/heroic-features.css" rel="stylesheet">

</head>

<body>

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
    <div class="container">
	<form action="ProcessFile" method="POST" onSubmit="return (validar(this))">
        <!-- Jumbotron Header -->
        <header class="jumbotron my-4">
        <%
				String erro = (String) request.getAttribute("erro");
		%>
        <h1 class="display-3"><%=erro %></h1>
            <p class="lead">Faça aqui o Upload do "main.tex"</p>
            <input name="arquivo" type="file" id="arquivo" value="arquivo" /><br><br>
            <input type="submit" class="btn btn-primary btn-large" value="Uplad"/>
        </header>

        <!-- Page Features -->
        <div class="row text-center">


        </div>
        <!-- /.row -->

    </div>
    </form>
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