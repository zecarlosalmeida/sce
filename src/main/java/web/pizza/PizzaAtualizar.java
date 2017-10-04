package web.pizza;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Pizza;
import servico.PizzaServico;
import servico.ServicoException;
import servico.ValidacaoException;
import web.Instanciar;

@WebServlet("/pizza/atualizar")
public class PizzaAtualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/pizza/listar.jsp";
	private static String FORM = "/pizza/formEditar.jsp";
	private static String ERRO = "/pizza/erro.jsp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PizzaServico as = new PizzaServico();
		Pizza x = Instanciar.pizza(request);
		try {
			as.validar(x);
			as.atualizar(x);
			List<Pizza> itens = as.buscarTodosOrdenadosPorNome();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			List<String> erros = new ArrayList<>();
			erros.add(e.getMessage());
			request.setAttribute("erros", erros);
			request.setAttribute("item", x);
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(FORM).forward(request, response);
		} catch (ValidacaoException e) {
			request.setAttribute("erros", e.getErros());
			request.setAttribute("item", x);
			request.getRequestDispatcher(FORM).forward(request, response);
		}
	}
}
