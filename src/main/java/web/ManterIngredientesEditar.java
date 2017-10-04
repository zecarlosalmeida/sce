package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Ingrediente;
import servico.IngredienteServico;

@WebServlet("/ingrediente/editar")
public class ManterIngredientesEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/ingrediente/editarIngrediente.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		IngredienteServico in = new IngredienteServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Ingrediente ingrediente = in.buscar(cod);
		
		request.setAttribute("ingrediente", ingrediente);
		request.getRequestDispatcher(DESTINO).forward(request,response);
	}

}