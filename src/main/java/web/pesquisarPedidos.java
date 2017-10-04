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

@WebServlet("/pedido/pesquisar")
public class pesquisarPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/pedido/pesquisarPedido.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

		request.getRequestDispatcher(DESTINO).forward(request,response);
	}

}