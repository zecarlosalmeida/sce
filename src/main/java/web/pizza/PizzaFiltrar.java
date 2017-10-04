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

@WebServlet("/pizza/filtrar")
public class PizzaFiltrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/pizza/listar.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PizzaServico as = new PizzaServico();
		String nome = request.getParameter("busca");
		List<Pizza> itens = as.buscarPorNome(nome);
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
