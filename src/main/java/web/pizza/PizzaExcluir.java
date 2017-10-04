package web.pizza;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Pizza;
import servico.PizzaServico;
import servico.ServicoException;

@WebServlet("/pizza/excluir")
public class PizzaExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/pizza/listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PizzaServico as = new PizzaServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Pizza art = as.buscar(cod);
		try {
			as.excluir(art);
			List<Pizza> itens = as.buscarTodosOrdenadosPorNome();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		}
	}
}
