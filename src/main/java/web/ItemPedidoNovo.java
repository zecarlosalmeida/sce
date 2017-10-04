package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.ItemPedido;
import dominio.Pedido;
import dominio.Pizza;
import servico.ItemPedidoServico;
import servico.PedidoServico;
import servico.PizzaServico;
import servico.ServicoException;

@WebServlet("/itemPedido/novo")
public class ItemPedidoNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/itemPedido/novo.jsp";
	private static String ERRO = "/publico/erro.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PizzaServico zs = new PizzaServico();
		PedidoServico ps = new PedidoServico();
		ItemPedidoServico ips = new ItemPedidoServico();
		
		int pizza = Integer.parseInt(request.getParameter("codPizza"));
		Pizza p = zs.buscar(pizza);
		int pedido = Integer.parseInt(request.getParameter("pedido"));
		Pedido ped = ps.buscar(pedido);
		int qtd = Integer.parseInt(request.getParameter("qtd"));
		ItemPedido ip = new ItemPedido(null, qtd, p, ped);
		System.out.println(ip.getPedido().getCodPedido());
		try {
			ips.inserirAtualizar(ip);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		}
	}

}
