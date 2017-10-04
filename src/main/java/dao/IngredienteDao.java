package dao;

import java.util.List;

import dominio.Ingrediente;

public interface IngredienteDao {

	public void inserirAtualizar(Ingrediente x);
	public void excluir(Ingrediente x);	
	public Ingrediente buscar(int cod);
	public List<Ingrediente> buscarTodos();
	
	public List<Ingrediente> buscarTodosOrdenadosPorNome();
	
	public List<Ingrediente> buscarPorNome(String nome);//buscar por trecho
	public Ingrediente buscarPorNomeExato(String nome);//buscar exato
	public Ingrediente buscaNomeExatoDiferente (Integer codigo, String nome);
}
