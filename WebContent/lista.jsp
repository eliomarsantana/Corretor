<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, corretor.regras.Regras" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Erros</title>
</head>
<body>


<table class="table">
  <thead>
    <tr>
      <th>Imprimindo erros</th>
    </tr>
  </thead>
  <tbody>
  
    <tr>
     <td>

      <%
      List<String> erros = (List<String>)session.getAttribute("erros");
      
      for (String erro : erros ) {
      %>
        <tr>
          <td><%=erro %></td> 
          
        </tr>
      <%
      }
      %>

     </td>

    </tr>
    
  </tbody>
</table>
</body>
</html>