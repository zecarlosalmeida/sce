package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Pedido;
import dominio.Pizza;
import servico.PedidoServico;
import servico.PizzaServico;

@WebServlet("/itemPedido/inserir")
public class ItemPedidoInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/itemPedido/formInserir.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		PedidoServico ps = new PedidoServico();
		PizzaServico zs = new PizzaServico();
		
		int cod = Integer.parseInt(request.getParameter("codPedido"));
		Pedido ped = ps.buscar(cod);
		List<Pizza> itens = zs.buscarTodosOrdenadosPorNome();
		
		request.setAttribute("itens", itens);
		request.setAttribute("pedido", ped);
		try {
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
