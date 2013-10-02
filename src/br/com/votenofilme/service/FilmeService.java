package br.com.votenofilme.service;

import java.util.List;

import br.com.votenofilme.model.Filme;

public interface FilmeService {

	public List<Filme> listaRanking();

	public void adicionaFilmes();
	
	public List<Filme> listaTodos();

	public Filme listaPor(String nome);

	public void adicionaVoto(Integer idDoFilme);
	
}
