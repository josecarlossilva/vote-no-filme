package br.com.votenofilme.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import br.com.votenofilme.model.Filme;
import br.com.votenofilme.service.FilmeService;

@Service
public class FilmeServiceImpl implements FilmeService {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Filme> listaRanking() {
		Criteria criteria =  getSession().createCriteria(Filme.class);

		criteria.addOrder(Order.desc("quantidadeDeVotos"));
		
        return (List<Filme>) criteria.list();
	}
	
	private Session getSession() {
        return ((Session) entityManager.getDelegate());
    }

	@Override
	public void adicionaFilmes() {
		List<Filme> filmes = Lists.newArrayList( new Filme(1, "Abraham Lincoln: Vampire Hunter"),
												new Filme(2, "Batman: O Cavaleiro das Trevas Ressurge"),
												new Filme(3, "Cosmopolis"), 
												new Filme(4, "G.I. Joe 2: Retaliation"),
												new Filme(5, "World War Z"));
		
		
		for (Filme filme : filmes) {
			entityManager.persist(filme);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Filme> listaTodos() {
		Criteria criteria =  getSession().createCriteria(Filme.class);
		
		return criteria.list();
	}
	
	@Override
	public Filme listaPor(String nome) {
		Criteria criteria =  getSession().createCriteria(Filme.class);

		criteria.add(Restrictions.eq("nome", nome));
		
        return (Filme) criteria.uniqueResult();
	}

	@Override
	public void adicionaVoto(Integer idDoFilme) {
		Filme filme = entityManager.find(Filme.class, idDoFilme);
		filme.setQuantidadeDeVotos(filme.getQuantidadeDeVotos() + 1L);
		
		entityManager.merge(filme);
	}

}
