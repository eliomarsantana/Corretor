<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erro</title>
</head>
<body>
<p>
					<%
						String erro = (String) request.getAttribute("erro");
					%>
					<%=erro %>
</p>
</body>
		<footer>
		<p>©Instituto Federal de Educação, Ciências e Tecnologia da Bahia - 2016</p>
		</footer>
</html>