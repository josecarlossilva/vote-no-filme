package main.java.br.com.votenofilme.service;

import java.util.List;

import main.java.br.com.votenofilme.model.FilmeDoUsuario;
import main.java.br.com.votenofilme.model.Usuario;

public interface FilmeDoUsuarioService extends CrudRepository<FilmeDoUsuario, Long> {
	
	List<FilmeDoUsuario> findByUsuario(Usuario usuario);

}
