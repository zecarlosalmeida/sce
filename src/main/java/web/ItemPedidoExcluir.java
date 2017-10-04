package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.ItemPedido;
import servico.ItemPedidoServico;

@WebServlet("/itemPedido/excluir")
public class ItemPedidoExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/itemPedido/excluido.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		ItemPedidoServico ips = new ItemPedidoServico();
		int cod = Integer.parseInt(request.getParameter("codItem"));
		ItemPedido ip = ips.buscar(cod);
		ips.excluir(ip);
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
