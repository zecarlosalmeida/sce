package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Ingrediente;
import servico.IngredienteServico;

@WebServlet("/ingrediente/filtrar")
public class ManterIngredientesFiltrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/ingrediente/listar.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		

		IngredienteServico in = new IngredienteServico();
		String nome = request.getParameter("busca");
		List<Ingrediente> ingrediente = in.buscarPorNome(nome);
		request.setAttribute("ingrediente", ingrediente);
		request.getRequestDispatcher(DESTINO).forward(request,response);
	}

}