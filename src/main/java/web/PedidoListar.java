package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import servico.ClienteServico;

@WebServlet("/pedido/listar")
public class PedidoListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/pedido/listar.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		ClienteServico cs = new ClienteServico();
		int cod = Integer.parseInt(request.getParameter("codCliente"));
		Cliente cli = cs.buscar(cod);
		request.setAttribute("cliente", cli);
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
