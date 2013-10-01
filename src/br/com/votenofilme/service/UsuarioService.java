package br.com.votenofilme.service;

import br.com.votenofilme.model.Usuario;

public interface UsuarioService {
	
	public Usuario carregaPor(Integer id);

	public void salva(Usuario usuario);
	
	public Usuario carregaPor(String nome);

}

