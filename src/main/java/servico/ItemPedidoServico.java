package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ItemPedidoDao;
import dao.PedidoDao;
import dao.PizzaDao;
import dao.impl.EM;
import dominio.ItemPedido;
import dominio.Pedido;
import dominio.Pizza;

public class ItemPedidoServico {

	private ItemPedidoDao dao;
	private PedidoDao pedidoDao;
	private PizzaDao pizzaDao;
	
	public ItemPedidoServico() {
		dao = DaoFactory.criarItemPedidoDao();
		pedidoDao = DaoFactory.criarPedidoDao();
		pizzaDao = DaoFactory.criarPizzaDao();
	}
	
	private boolean existePizza(Pedido ped, Pizza p) {
		for (ItemPedido ip : ped.getItens()) {
			if (ip.getPizza() == p) {
				return true;
			}
		}
		return false;
	}
	
	public void inserirAtualizar(ItemPedido x) throws ServicoException {
		x.setPedido(pedidoDao.buscar(x.getPedido().getCodPedido()));
		x.setPizza(pizzaDao.buscar(x.getPizza().getCodPizza()));
		if (existePizza(x.getPedido(), x.getPizza())) {
			throw new ServicoException(1, "Pizza já existe no pedido");			
		}
		
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}

	public void excluir(ItemPedido x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}

	public ItemPedido buscar(int cod) {
		return dao.buscar(cod);
	}

	public List<ItemPedido> buscarTodos() {
		return dao.buscarTodos();
	}

}
