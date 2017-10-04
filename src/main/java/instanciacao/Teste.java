package instanciacao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import servico.ClienteServico;
import servico.ServicoException;

@WebServlet("/Teste")
public class Teste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ClienteServico ps = new ClienteServico();
		
		List<Cliente> pi = ps.buscarTodosOrdenadosPorNome();
		System.out.println("\n");
		for(Cliente x: pi){
		response.getWriter().append(x.toString()+"\n");
		}
		try {
			ps.excluir(pi.get(0));	
		} catch (ServicoException e) {
			response.getWriter().append(e.toString()+"\n");
		}
		
		
		
		
		
		
		
	}

}
