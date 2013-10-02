<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<input type="hidden" id="ctx" value="<%=basePath%>" />
  	
    <link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath%>css/votenofilme.css" rel="stylesheet">
    
    <script src="<%=basePath%>js/jquery.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/votenofilme.js"></script>
  </head>
  <body>
  	<br/>
  	<br/>
  	<h3>Ranking de Filmes mais votados</h3>
	<table class="table table-bordered" style="width: 600px;">
		<thead>
			<th>Nome</th>
			<th>Quantidade de Votos</th>
		</thead>
		<tbody>
			<tr>
				<td>${filme1.nome}</td>
				<td>${filme1.quantidadeDeVotos}</td>
			</tr>
			<tr>
				<td>${filme2.nome}</td>
				<td>${filme2.quantidadeDeVotos}</td>
			</tr>
			<tr>
				<td>${filme3.nome}</td>
				<td>${filme3.quantidadeDeVotos}</td>
			</tr>
			<tr>
				<td>${filme4.nome}</td>
				<td>${filme4.quantidadeDeVotos}</td>
			</tr>
			<tr>
				<td>${filme5.nome}</td>
				<td>${filme5.quantidadeDeVotos}</td>
			</tr>
		</tbody>
	</table>
  </body>
</html>
