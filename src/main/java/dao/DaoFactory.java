package dao;

import dao.impl.ClienteDaoImpl;
import dao.impl.IngredienteDaoImpl;
import dao.impl.ItemPedidoDaoImpl;
import dao.impl.ItemPizzaDaoImpl;
import dao.impl.PedidoDaoImpl;
import dao.impl.PizzaDaoImpl;

public class DaoFactory {
	
	public static ClienteDao criarClienteDao(){
		return new ClienteDaoImpl();
	}
	
	public static IngredienteDao criarIngredienteDao(){
		return new IngredienteDaoImpl();
	}
	
	public static ItemPedidoDao criarItemPedidoDao(){
		return new ItemPedidoDaoImpl();
	}
	
	public static ItemPizzaDao criarItemPizzaDao(){
		return new ItemPizzaDaoImpl();
	}
	
	public static PedidoDao criarPedidoDao(){
		return new PedidoDaoImpl();
	}
	
	public static PizzaDao criarPizzaDao(){
		return new PizzaDaoImpl();
	}

}
