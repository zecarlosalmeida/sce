package servico;

import java.util.List;

import dao.DaoFactory;
import dao.IngredienteDao;
import dao.ItemPizzaDao;
import dao.PizzaDao;
import dao.Transaction;
import dao.impl.EM;
import dominio.Ingrediente;
import dominio.ItemPizza;
import dominio.Pizza;

public class ItemPizzaServico {

	private ItemPizzaDao dao;
	private PizzaDao pizzaDao;
	private IngredienteDao ingDao;
	
	public ItemPizzaServico() {
		dao = DaoFactory.criarItemPizzaDao();
		pizzaDao = DaoFactory.criarPizzaDao();
		ingDao = DaoFactory.criarIngredienteDao();

	}
	
	private boolean existeIngrediente(Pizza p, Ingrediente i) {
		for (ItemPizza ip : p.getItens()) {
			if (ip.getIngrediente() == i) {
				return true;
			}
		}
		return false;
	}
	
	public void inserir(ItemPizza x) throws ServicoException{
		x.setPizza(pizzaDao.buscar(x.getPizza().getCodPizza()));
		x.setIngrediente(ingDao.buscar(x.getIngrediente().getCodIngrediente()));
		if (existeIngrediente(x.getPizza(), x.getIngrediente())) {
			throw new ServicoException(3, "O ingrediente já pertence a pizza!");
		}
		Transaction.begin();
		dao.inserirAtualizar(x);
		Transaction.commit();
	}
	
	public void excluir(ItemPizza x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public ItemPizza buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<ItemPizza> buscarTodos() {
		return dao.buscarTodos();
	}
}
