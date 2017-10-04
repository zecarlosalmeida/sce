package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.PizzaDao;
import dominio.Pizza;

public class PizzaDaoImpl implements PizzaDao {

	private EntityManager em;

	public PizzaDaoImpl() {
		
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Pizza x) {
	
		if (x.getCodPizza() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Pizza x) {
		
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Pizza buscar(int cod) {
		
		return em.find(Pizza.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pizza> buscarTodos() {
	
		String jpql = "SELECT x FROM Pizza x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Pizza> buscarTodosOrdenadoPorNome() {
		String jpql = "SELECT x FROM Pizza x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pizza> buscarPorNome(String nome) {
		String jpql = "SELECT x FROM Pizza x WHERE x.nome LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+nome+"%");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Pizza buscarNomeExato(String nome) {
		String jpql = "SELECT x FROM Pizza x WHERE x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome );
		List<Pizza> aux = query.getResultList();
		return (aux.size() > 0)? aux.get(0):null;	
	}

}
