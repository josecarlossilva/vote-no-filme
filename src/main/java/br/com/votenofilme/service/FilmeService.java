package main.java.br.com.votenofilme.service;

import java.util.List;

import main.java.br.com.votenofilme.model.Filme;

public interface FilmeService {

	public List<Filme> listaRanking();
	public List<Filme> findFilmeByRanking();

	public void adicionaFilmes();
	
	public List<Filme> listaTodos();

	public Filme listaPor(String nome);

	public void adicionaVoto(Integer idDoFilme);
	
}
