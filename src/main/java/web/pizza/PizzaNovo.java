package web.pizza;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Pizza;

@WebServlet("/pizza/novo")
public class PizzaNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/pizza/formInserir.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("item", new Pizza());
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
