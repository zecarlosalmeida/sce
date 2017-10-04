package web.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import servico.ClienteServico;
import servico.ServicoException;

@WebServlet("/cliente/excluir")
public class ClienteExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/cliente/listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClienteServico as = new ClienteServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Cliente art = as.buscar(cod);
		try {
			as.excluir(art);
			List<Cliente> itens = as.buscarTodosOrdenadosPorNome();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			List<Cliente> itens = as.buscarTodosOrdenadosPorNome();			
			List<String> erros = new ArrayList<>();
			erros.add(e.getMessage());
			request.setAttribute("erros", erros);
			request.setAttribute("msg", e.getMessage());			
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} 
	}
}
