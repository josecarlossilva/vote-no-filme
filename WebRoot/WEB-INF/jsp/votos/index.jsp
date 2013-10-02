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
	<div id="filmes_principais" class="jumbotron">
	  <div class="container">
	    <h1>Olá! Qual desses filmes você mais gosta?</h1>
  			<input value="1" style="display: inline-block; margin-left: 150px;" id="abraham" class="thumbnail" type="image" src="<%=basePath%>imagens/Abraham_Lincoln_-_Vampire_Hunter_Poster.jpg">
  			<input value="2" style="display: inline-block; margin-left: 100px" id="batman" class="thumbnail" type="image" src="<%=basePath%>imagens/Batman- O Cavaleiro das Trevas Ressurge.jpg">
	  </div>
	</div>

	<div id="demais_filmes" class="jumbotron">
	  <div class="container">
	  		<h1 style="">E desses filmes, qual você mais gosta?</h1>
  			<input value="3" style="display: inline-block; margin-left: 75px;" id="cosmopolis" class="thumbnail" type="image" src="<%=basePath%>imagens/cosmopolis.jpg">
  			<input value="4" style="display: inline-block; margin-left: 25px" id="gi_joe" class="thumbnail" type="image" src="<%=basePath%>imagens/G.I. Joe 2 - Retaliation.jpg">
  			<input value="5" style="display: inline-block; margin-left: 25px" id="world_war" class="thumbnail" type="image" src="<%=basePath%>imagens/World War Z.jpg">
	  </div>
	</div>

	<div id="primeiro_modal_sucesso" class="modal fade">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        <h4 class="modal-title">Voto adicionado com sucesso!</h4>
	      </div>
	      <div class="modal-body">
	        <p>Deseja continuar a votar?</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal" id="encerra_votacao">Não</button>
	        <button type="button" class="btn btn-primary" id="continua_votacao">Sim</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div id="segundo_modal_sucesso" class="modal fade">
	  <div class="modal-dialog">
	    <div class="modal-content">
		    <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title">Voto adicionado com sucesso!</h4>
	      	</div>
			<form id="formulario_usuario" role="form" action="<%=basePath%>adiciona/usuario" method="post">
			  <div class="form-group">
			    <label for="exampleInputEmail1">Email</label>
			    <input type="text" class="form-control" name="usuario.email" placeholder="Email">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Nome</label>
			    <input type="text" class="form-control" name="usuario.nome" placeholder="Nome">
			  </div>
			  <button type="submit" class="btn btn-default">Enviar</button>
			</form>
		</div>
      </div>
    	</div>
  </body>
</html>
