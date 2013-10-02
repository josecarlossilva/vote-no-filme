var ctx = $("#ctx").val();
$(document).ready(function () {
	
	$("#demais_filmes").hide();
	$(".alert").alert('close');
	
	$("#cosmopolis, #gi_joe, #world_war").click(function() {
		var idFilme = this.value;
		$.adicionaVotoFinal(idFilme);
	});
	
	$("#batman, #abraham").click(function() {
		var idFilme = this.value;
		$.adicionaVoto(idFilme);
	});
	
	$("#encerra_votacao").click(function() {
		window.location.href = ctx + "ranking";
	});
	
	$("#continua_votacao").click(function() {
		$("#filmes_principais").hide();
		$("#demais_filmes").show();
		$('#primeiro_modal_sucesso').modal('hide');
	});
	
});

$.adicionaVoto = function(idFilme) {
	var url = ctx + "adiciona/voto";
	jQuery.ajax({
		url: url,
		type: 'POST',
		data: {
			idFilme: idFilme
		},
		success: function(data) {
			$('#primeiro_modal_sucesso').modal('show');
		},
		error: function(response) {
			alert(response);
		}
	});
};

$.adicionaVotoFinal = function(idFilme) {
	var url = ctx + "adiciona/voto";
	jQuery.ajax({
		url: url,
		type: 'POST',
		data: {
			idFilme: idFilme
		},
		success: function(data) {
			$('#segundo_modal_sucesso').modal('show');
		},
		error: function(response) {
			alert(response);
		}
	});
};