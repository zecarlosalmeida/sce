package dao;

import java.util.List;

import dominio.Cliente;

public interface ClienteDao {
 
	public void inserirAtualizar(Cliente x);
	public void excluir(Cliente x);	
	public Cliente buscar(int cod);
	public List<Cliente> buscarTodos();
	public Cliente buscarPorCpf(String x);
	public List<Cliente> buscarTodosOrdenadoPorNome();
	public List<Cliente> buscarPorNome(String x);
	

}
