package web.itemPizza;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Pizza;
import servico.PizzaServico;

@WebServlet("/pizza/detalhe")
public class ItemPizzaListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/itemPizza/listar.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PizzaServico as = new PizzaServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Pizza art = as.buscar(cod);
		request.setAttribute("itens", art.getItens());
		request.setAttribute("pizza", art);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
