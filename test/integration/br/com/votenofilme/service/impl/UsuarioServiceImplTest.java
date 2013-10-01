package br.com.votenofilme.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import base.dbunit.DbUnitManager;
import br.com.votenofilme.model.Usuario;
import br.com.votenofilme.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./WebRoot/WEB-INF/config/spring/applicationContext.xml",
		"file:./WebRoot/WEB-INF/config/spring/applicationContext-persistence-test.xml"
})

@Transactional
public class UsuarioServiceImplTest {
	
	private static final String DATASET = "./test/integration/base/dbunit/xml/UsuarioServiceImplTest.xml";
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private DbUnitManager dbUnitManager;
	
	@Before
	public void setUp() throws Exception {
		dbUnitManager.cleanAndInsert(DATASET);
	}

	@Test
	public void deveCarrgarUsuario() {
		Integer id = 10;
		Usuario usuario = service.carregaPor(id);
		
		assertEquals("descricao", "TESTE", usuario.getNome());
	}
	
	@Test
	public void deveSalvarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Usuário de Teste");
		usuario.setEmail("usuario@teste.com.br");
		
		service.salva(usuario);
		
		Usuario usuarioDoBanco = service.carregaPor(usuario.getNome());
		
		assertEquals("nome", usuario.getNome(), usuarioDoBanco.getNome());
	}
	
}
