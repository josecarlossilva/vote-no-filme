package br.com.votenofilme.service;

import java.util.List;

import br.com.votenofilme.model.FilmeDoUsuario;
import br.com.votenofilme.model.Usuario;

public interface FilmeDoUsuarioService {
	
	public List<FilmeDoUsuario> listaFilmesDo(Usuario usuario);

}
