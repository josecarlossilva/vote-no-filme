package main.java.br.com.votenofilme.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import main.java.br.com.votenofilme.model.Usuario;
import main.java.br.com.votenofilme.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Usuario carregaPor(Integer id) {
		return entityManager.find(Usuario.class, id);
	}

	@Override
	public void salva(Usuario usuario) {
			entityManager.merge(usuario);
	}

	@Override
	public Usuario carregaPor(String nome) {
		Criteria criteria = getSession().createCriteria(Usuario.class);

		criteria.add(Restrictions.eq("nome", nome));
		
        return (Usuario) criteria.uniqueResult();
		
	}
	
	private Session getSession() {
        return ((Session) entityManager.getDelegate());
    }
}