package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IngredienteDao;
import dominio.Ingrediente;

public class IngredienteDaoImpl implements IngredienteDao {

	private EntityManager em;

	public IngredienteDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Ingrediente x) {
		
		if (x.getCodIngrediente() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Ingrediente x) {
		
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Ingrediente buscar(int cod) {
		
		return em.find(Ingrediente.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ingrediente> buscarTodos() {
		
		String jpql = "SELECT x FROM Ingrediente x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ingrediente> buscarTodosOrdenadosPorNome(){
		
		String jpql = "SELECT x FROM Ingrediente x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Ingrediente> buscarPorNome(String nome){
		
		String jpql = "SELECT x FROM Ingrediente x where x.nome like :p1 ";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+nome+"%");
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public Ingrediente buscarPorNomeExato(String nome){
		
		String jpql = "SELECT x FROM Ingrediente x where x.nome like :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome);
		List<Ingrediente> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Ingrediente buscaNomeExatoDiferente(Integer codigo, String nome) {
		
		String jpql = "SELECT x FROM Ingrediente x WHERE x.codIngrediente <> :p0 AND x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p0", codigo);
		query.setParameter("p1", nome);
		List<Ingrediente> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
}
