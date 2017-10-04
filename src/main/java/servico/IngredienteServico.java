package servico;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dao.IngredienteDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Ingrediente;
import dominio.ItemPizza;
import dao.Transaction;


public class IngredienteServico {

	private IngredienteDao dao;
	
	public IngredienteServico() {
		dao = DaoFactory.criarIngredienteDao();
	}
	
	public void validar (Ingrediente x) throws ValidacaoException{
		List<String> erros = new ArrayList<>();
		Double aux;
		if(x.getNome() == null){
			erros.add("Favor preencher o campo NOME!");
		} 
		if(x.getPreco() != null && (x.getPreco().compareTo(new BigDecimal(0.0))) <= 0){
			erros.add("Favor preencher um valor v�lido para o campo PRE�O!");
		}
		if(x.getPreco() == null ){
			erros.add("Favor preencher um valor v�lido para o campo PRE�O!");
		}
		if(!erros.isEmpty()){
			throw new ValidacaoException("Erro de Valida��o!",erros);
		}
	}
	
	public void inserir(Ingrediente x) throws ServicoException{
		try{
			Ingrediente aux = dao.buscarPorNomeExato(x.getNome());
			if(aux != null){
				throw new ServicoException (1,"J� existe um ingrediente com esse nome!");
			}
			
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch(RuntimeException e) {
			if(Transaction.isActive()){
				Transaction.rollback();
			}
			System.out.println("Erro" + e.getMessage());
			
		}
		
	}
	
	public void atualizar(Ingrediente x) throws ServicoException{
		try{
			Ingrediente aux = dao.buscarPorNomeExato(x.getNome());
			if(aux != null && (aux.getCodIngrediente() != x.getCodIngrediente())){
				throw new ServicoException (1,"J� existe um ingrediente com esse nome!");
			}
			
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch(RuntimeException e) {
			if(Transaction.isActive()){
				Transaction.rollback();
			}
			System.out.println("Erro" + e.getMessage());
			
		}
		
	}
	
	
	
	public void excluir(Ingrediente x) throws ServicoException {
		x = dao.buscar(x.getCodIngrediente());
		List<ItemPizza> ip = x.getItens();
		if (!ip.isEmpty()){
			throw new ServicoException (1,"N�o pode excluir ingrediente, pois ela est� vinculada a uma pizza!");
		}
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Ingrediente buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Ingrediente> buscarTodos() {
		return dao.buscarTodos();
	}
	
	public List<Ingrediente> buscarTodosOrdenadosPorNome(){
		return dao.buscarTodosOrdenadosPorNome();
	}

	public List<Ingrediente> buscarPorNome(String nome) {
		return dao.buscarPorNome(nome);
	}
	
}
