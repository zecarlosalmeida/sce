package servico;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Cliente;

public class ClienteServico {

	private ClienteDao dao;
	
	public ClienteServico() {
		dao = DaoFactory.criarClienteDao();
	}
	public void validar(Cliente x) throws ValidacaoException {
		List<String> erros = new ArrayList<>();
		
		if (x.getNome()==null) {
			erros.add("Favor preencher o campo nome");
		}
		if (x.getCpf()==null) {
			erros.add("Favor preencher o campo CPF");
		}
		if (x.getRenda()==null) {
			erros.add("Favor preencher um valor válido para a renda");
		}
		if (x.getDataNasc()==null) {
			erros.add("Favor preencher um valor válido para a data de nascimento");
		}
		if (x.getTelefone()==null) {
			erros.add("Favor preencher o campo Telefone");
		}
		if (x.getEmail()==null) {
			erros.add("Favor preencher o campo Email");
		}
		
		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação", erros);
		}
	}
	
	
	public void inserir(Cliente x) throws ServicoException  {
		Cliente aux = dao.buscarPorCpf(x.getCpf());
		if(aux != null){
			throw new ServicoException(1, "Já existe cliente cadastrado com este cpf!");
		}
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void atualizar(Cliente x) throws ServicoException  {
		Cliente aux = dao.buscarPorCpf(x.getCpf());
		if(aux != null && aux.getCodCliente() != x.getCodCliente()){
			throw new ServicoException(1, "Já existe cliente cadastrado com este cpf!");
		}
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Cliente x) throws ServicoException {
		x = dao.buscar(x.getCodCliente());
		if(!x.getPedidos().isEmpty()){
			throw new ServicoException(2, "Cliente não pode ser excluido pois possui pedidos em seu nome!");
		}
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Cliente buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Cliente> buscarTodos() {
		return dao.buscarTodos();
	}
	
	public List<Cliente> buscarTodosOrdenadosPorNome() {
		return dao.buscarTodosOrdenadoPorNome();
	}

	public List<Cliente> buscarPorNome(String nome) {
		return dao.buscarPorNome(nome);
	}
}
