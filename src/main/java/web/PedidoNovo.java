package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import dominio.Pedido;
import servico.ClienteServico;
import servico.PedidoServico;

@WebServlet("/pedido/novo")
public class PedidoNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/pedido/novo.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
			
		ClienteServico cs = new ClienteServico();
		PedidoServico ps = new PedidoServico();
		int cod = Integer.parseInt(request.getParameter("codCliente"));
		Cliente cli = cs.buscar(cod);
		Pedido p = new Pedido(null, null, cli);
		ps.inserirAtualizar(p);
		
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
