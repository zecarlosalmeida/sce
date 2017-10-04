package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Pedido;
import servico.PedidoServico;

@WebServlet("/pedido/excluir")
public class PedidoExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/pedido/excluido.jsp";
	private static String AVISO = "/pedido/aviso.jsp";
	private static String ERRO = "/publico/erro.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		PedidoServico ps = new PedidoServico();
		int cod = Integer.parseInt(request.getParameter("codPedido"));
		Pedido ped = ps.buscar(cod);
		if (ped.getItens().isEmpty()) { // se o pedido não tem itens, pode excluir
			request.setAttribute("pedido", ped);
			ps.excluir(ped);
			try {
				request.getRequestDispatcher(DESTINO).forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{ //se o pedido contém itens não pode excluir
			try {
				request.getRequestDispatcher(AVISO).forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
