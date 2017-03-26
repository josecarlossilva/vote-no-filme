package main.java.br.com.votenofilme.service;

import main.java.br.com.votenofilme.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
	
	public Usuario carregaPor(Integer id);

	public void salva(Usuario usuario);
	
	public Usuario carregaPor(String nome);

}

