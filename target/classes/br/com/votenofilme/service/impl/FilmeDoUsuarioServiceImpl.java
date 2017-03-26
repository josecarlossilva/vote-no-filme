package br.com.votenofilme.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import br.com.votenofilme.model.FilmeDoUsuario;
import br.com.votenofilme.model.Usuario;
import br.com.votenofilme.service.FilmeDoUsuarioService;

@Service
public class FilmeDoUsuarioServiceImpl implements FilmeDoUsuarioService {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<FilmeDoUsuario> listaFilmesDo(Usuario usuario) {
		
		Criteria criteria =  getSession().createCriteria(FilmeDoUsuario.class);
        criteria.add(Restrictions.eq("usuario", usuario));

        return (List<FilmeDoUsuario>) criteria.list();
	}
	
	private Session getSession() {
        return ((Session) entityManager.getDelegate());
    }

}
