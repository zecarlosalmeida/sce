package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Ingrediente;
import servico.IngredienteServico;
import servico.ServicoException;

@WebServlet("/ingrediente/excluir")
public class ManterIngredientesExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/ingrediente/listar.jsp";
	private static String ERRO = "/publico/erro.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		IngredienteServico in = new IngredienteServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Ingrediente ingrediente = in.buscar(cod);
		try {
			in.excluir(ingrediente);
			List<Ingrediente> itensIngrediente = in.buscarTodosOrdenadosPorNome();
			request.setAttribute("ingrediente", itensIngrediente);
			request.getRequestDispatcher(DESTINO).forward(request,response);
			
		}catch (ServicoException e) {			
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request,response);
		}
	
	}

}