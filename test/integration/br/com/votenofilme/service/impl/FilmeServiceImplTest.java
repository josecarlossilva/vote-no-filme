package br.com.votenofilme.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import base.dbunit.DbUnitManager;
import br.com.votenofilme.model.Filme;
import br.com.votenofilme.service.FilmeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./WebRoot/WEB-INF/config/spring/applicationContext.xml",
		"file:./WebRoot/WEB-INF/config/spring/applicationContext-persistence-test.xml"
})

@Transactional
public class FilmeServiceImplTest {
	
	private static final String DATASET = "./test/integration/base/dbunit/xml/FilmeServiceImplTest.xml";
	
	@Autowired
	private FilmeService service;
	
	@Autowired
	private DbUnitManager dbUnitManager;
	
	@Before
	public void setUp() throws Exception {
		dbUnitManager.cleanAndInsert(DATASET);
	}

	@Test
	public void deveriaListarRanking() {
		List<Filme> filmes = service.listaRanking();
		
		assertTrue(!filmes.isEmpty());
		
		assertEquals("Primeiro Lugar", "World War Z", filmes.get(0).getNome());
		assertEquals("Segundo Lugar", "Abraham Lincoln: Vampire Hunter", filmes.get(1).getNome());
		assertEquals("Terceiro Lugar", "G.I. Joe 2: Retaliation", filmes.get(2).getNome());
		assertEquals("Quarto Lugar", "Cosmopolis", filmes.get(3).getNome());
		assertEquals("Quinto Lugar", "Batman: O Cavaleiro das Trevas Ressurge", filmes.get(4).getNome());
	}
	
	@Test
	public void deveriaAdicionarListaDeFilmes() {
		service.adicionaFilmes();
		
		List<Filme> lista = service.listaTodos();
		
		assertEquals("lista", 10, lista.size());
	}

}
