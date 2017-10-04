package web.cliente;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import servico.ClienteServico;
import servico.ServicoException;
import servico.ValidacaoException;
import web.Instanciar;

@WebServlet("/cliente/inserir")
public class ClienteInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/cliente/listar.jsp";
	private static String FORM = "/cliente/formInserir.jsp";
	private static String ERRO = "/publico/erro.jsp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClienteServico as = new ClienteServico();
		Cliente x = Instanciar.cliente(request);
		try {
			as.validar(x);
			as.inserir(x);
			List<Cliente> itens = as.buscarTodosOrdenadosPorNome();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		} catch (ValidacaoException e) {
			request.setAttribute("erros", e.getErros());
			request.setAttribute("item", x);
			request.getRequestDispatcher(FORM).forward(request, response);
		}
	}
}
