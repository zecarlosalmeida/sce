package servico;

import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import dao.PizzaDao;
import dao.impl.EM;
import dominio.Pizza;

public class PizzaServico {

	private PizzaDao dao;

	public PizzaServico() {
		dao = DaoFactory.criarPizzaDao();
	}
	
	public void validar(Pizza x) throws ValidacaoException {
		List<String> erros = new ArrayList<>();
		
		if (x.getNome()==null) {
			erros.add("Favor preencher o campo nome");
		}	
		
		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação", erros);
		}
	}

	public void inserir(Pizza x) throws ServicoException {
		Pizza aux = dao.buscarNomeExato(x.getNome());
		if(aux != null){
			throw new ServicoException(1, "Já existe uma pizza com esté nome");
		}
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void atualizar(Pizza x) throws ServicoException {
		Pizza aux = dao.buscarNomeExato(x.getNome());
		if(aux != null && aux.getCodPizza() != x.getCodPizza()){
			throw new ServicoException(1, "Já existe uma pizza com esté nome");
		}
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}

	public void excluir(Pizza x) throws ServicoException {
		Pizza aux = dao.buscar(x.getCodPizza());
		if(!aux.getItensPedido().isEmpty()){
			throw new ServicoException(2, "Está pizza não pode ser excluida pois está vinculada a pedidos!");
		}
		
		if(!aux.getItens().isEmpty()){
			throw new ServicoException(2, "Está pizza não pode ser excluida pois está vinculada a ingredientes!");
		}
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}

	public Pizza buscar(int cod) {
		return dao.buscar(cod);
	}

	public List<Pizza> buscarTodos() {
		return dao.buscarTodos();
	}

	public List<Pizza> buscarTodosOrdenadosPorNome() {
		return dao.buscarTodosOrdenadoPorNome();
	}

	public List<Pizza> buscarPorNome(String nome) {
		return dao.buscarPorNome(nome);
	}

	public Pizza buscarNomeExato(String nome) {
		return dao.buscarNomeExato(nome);
	}
}
