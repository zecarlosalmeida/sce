package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Ingrediente;
import dominio.Pedido;
import servico.IngredienteServico;
import servico.PedidoServico;
import servico.ServicoException;

@WebServlet("/pedido/pesquisado")
public class pedidoPesquisado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/pedido/pesquisadoPedido.jsp";
	private static String ERRO = "/publico/erro.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try{
		PedidoServico ps = new PedidoServico();
		String min = request.getParameter("anoMin");
		String max = request.getParameter("anoMax");
		Date dataMin = formato.parse(min);
		Date dataMax = formato.parse(max);
		List<Pedido> pedido = ps.buscarPorData(dataMin, dataMax);
		request.setAttribute("ingrediente", pedido);
		request.getRequestDispatcher(DESTINO).forward(request,response);
		}catch(ParseException e){
			request.getRequestDispatcher(ERRO).forward(request,response);
		}
	}

}