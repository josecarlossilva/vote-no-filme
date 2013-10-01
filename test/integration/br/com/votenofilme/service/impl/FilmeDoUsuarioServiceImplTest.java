package br.com.votenofilme.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import base.dbunit.DbUnitManager;
import br.com.votenofilme.model.FilmeDoUsuario;
import br.com.votenofilme.model.Usuario;
import br.com.votenofilme.service.FilmeDoUsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./WebRoot/WEB-INF/config/spring/applicationContext.xml",
		"file:./WebRoot/WEB-INF/config/spring/applicationContext-persistence-test.xml"
})

@Transactional
public class FilmeDoUsuarioServiceImplTest {
	
	private static final String DATASET = "./test/integration/base/dbunit/xml/FilmeDoUsuarioServiceImplTest.xml";
	
	@Autowired
	private FilmeDoUsuarioService service;
	
	@Autowired
	private DbUnitManager dbUnitManager;
	
	@Before
	public void setUp() throws Exception {
		dbUnitManager.cleanAndInsert(DATASET);
	}

	@Test
	public void deveCarregarOsFilmesDoUsuario() {
		Integer codigo = 10;
		Usuario usuario = new Usuario(codigo);
		
		List<FilmeDoUsuario> filmes = service.listaFilmesDo(usuario);
		
		assertEquals("quantidade", 5, filmes.size());
		
		assertEquals("nome do usuario", "Carlos", filmes.get(0).getUsuario().getNome());
	}

}
