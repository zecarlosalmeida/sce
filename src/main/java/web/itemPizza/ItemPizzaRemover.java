package web.itemPizza;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.ItemPizza;
import servico.ItemPizzaServico;

@WebServlet("/pizza/removerIngrediente")
public class ItemPizzaRemover extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/itemPizza/confirmarExclusao.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ItemPizzaServico as = new ItemPizzaServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		ItemPizza art = as.buscar(cod);
		request.setAttribute("item", art);
		request.setAttribute("pizza", art.getPizza());
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
