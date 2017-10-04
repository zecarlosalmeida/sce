package servico;

import java.util.Date;
import java.util.List;

import dao.PedidoDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Pedido;

public class PedidoServico {

	private PedidoDao dao;
	
	public PedidoServico() {
		dao = DaoFactory.criarPedidoDao();
	}
	
	public void inserirAtualizar(Pedido x) {
		Date date = new Date();
		x.setData(date);
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Pedido x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Pedido buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Pedido> buscarTodos() {
		return dao.buscarTodos();
	}
	
	public List<Pedido> buscarPorData(Date dataMin, Date dataMax){
		return dao.buscarPorData(dataMin, dataMax);
	}

	
}
