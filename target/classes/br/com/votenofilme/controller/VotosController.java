package br.com.votenofilme.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.votenofilme.model.Filme;
import br.com.votenofilme.model.Usuario;
import br.com.votenofilme.service.FilmeService;
import br.com.votenofilme.service.UsuarioService;

@Resource
public class VotosController {
	
	private static final String COSMOPOLIS = "Cosmopolis";
	private Result result;
    private UsuarioService usuarioService;
    private FilmeService filmeService;
    
    public VotosController(Result result, UsuarioService usuarioService,
    						   FilmeService filmeService) {
        this.result = result;
		this.usuarioService = usuarioService;
		this.filmeService = filmeService;
    }

	@Get("/")
	public void index() {
		preparaParaVotar();
	}
	
	@Post("/adiciona/voto")
	public void adicionaVoto(Integer idFilme) {
		try {
			
			filmeService.adicionaVoto(idFilme);
			
			result.use(Results.status()).ok();
		} catch (Exception e) {
			result.use(Results.http()).sendError(500, e.getMessage());
		}
	}
	
	@Post("/adiciona/usuario")
	public void adicionaUsuario(Usuario usuario) {
		try {
			
			usuarioService.salva(usuario);
			
			result.forwardTo(this).ranking();
		} catch (Exception e) {
			result.forwardTo(this).index();
		}
	}

	@Get("/ranking")
	public void ranking() {
		List<Filme> ranking = filmeService.listaRanking();
		
		result.include("filme1", ranking.get(0));
		result.include("filme2", ranking.get(1));
		result.include("filme3", ranking.get(2));
		result.include("filme4", ranking.get(3));
		result.include("filme5", ranking.get(4));
	}

	private void preparaParaVotar() {
		Filme filme = filmeService.listaPor(COSMOPOLIS);
		if(filme == null) {
			filmeService.adicionaFilmes();
		}
	}
}