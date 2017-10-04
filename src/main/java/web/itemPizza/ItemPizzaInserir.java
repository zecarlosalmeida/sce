package web.itemPizza;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.ItemPizza;
import servico.ItemPizzaServico;
import servico.PizzaServico;
import servico.ServicoException;
import web.Instanciar;

@WebServlet("/itemPizza/inserir")
public class ItemPizzaInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/pizza/listar.jsp";
	private static String FORM = "/pizza/formInserir.jsp";
	private static String ERRO = "/publico/erro.jsp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PizzaServico ps = new PizzaServico();
		ItemPizzaServico ips = new ItemPizzaServico();
						
		ItemPizza x = Instanciar.itemPizza(request);
		
		try {			
			ips.inserir(x);
			request.setAttribute("itens", ps.buscarTodosOrdenadosPorNome());					
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {			
			request.setAttribute("itens", x.getPizza().getItens());
			request.setAttribute("pizza", x.getPizza());
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		}
	}
}
