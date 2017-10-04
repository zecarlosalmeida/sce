package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Pedido;
import servico.PedidoServico;

@WebServlet("/pedido/exibir")
public class PedidoExibir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/pedido/exibir.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		PedidoServico ps = new PedidoServico();
		int cod = Integer.parseInt(request.getParameter("codPedido"));
		Pedido ped = ps.buscar(cod);
		request.setAttribute("pedido", ped);
		request.setAttribute("item", ped);
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
