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

@WebServlet("/pizza/listar")
public class PizzaListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/pizza/listar.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PizzaServico ps = new PizzaServico();
		List<Pizza> itens = ps.buscarTodosOrdenadosPorNome();
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
