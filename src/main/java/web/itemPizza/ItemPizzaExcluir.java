package web.itemPizza;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.ItemPizza;
import dominio.Pizza;
import servico.ItemPizzaServico;
import servico.PizzaServico;

@WebServlet("/itemPizza/excluir")
public class ItemPizzaExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/pizza/listar.jsp";
	private static String ERRO = "/publico/erro.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PizzaServico ps = new PizzaServico();
		ItemPizzaServico as = new ItemPizzaServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		ItemPizza art = as.buscar(cod);		
		Pizza p = art.getPizza();
		as.excluir(art);
		
		request.setAttribute("itens", ps.buscarTodosOrdenadosPorNome());
		request.setAttribute("pizza", p);
		request.getRequestDispatcher(DESTINO).forward(request, response);

	}
}
