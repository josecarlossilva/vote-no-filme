package br.com.votenofilme.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import br.com.votenofilme.model.Filme;
import br.com.votenofilme.service.FilmeService;

@Service
public class FilmeServiceImpl implements FilmeService {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Filme> listaRanking() {
		Criteria criteria =  getSession().createCriteria(Filme.class);

		criteria.addOrder(Order.desc("quantidadeDeVotos"));
		
        return (List<Filme>) criteria.list();
	}
	
	private Session getSession() {
        return ((Session) entityManager.getDelegate());
    }

}
