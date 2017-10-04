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
import servico.ServicoException;
import servico.ValidacaoException;

@WebServlet("/ingrediente/inserir")
public class ManterIngredientesInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/ingrediente/listar.jsp";
	private static String FORM = "/ingrediente/inserirIngrediente.jsp";
	private static String ERRO = "/publico/erro.jsp";
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		IngredienteServico in = new IngredienteServico();
		Ingrediente x = Instanciar.ingrediente(request);
		try {
			in.validar(x);
			in.inserir(x);
			List<Ingrediente> ingrediente = in.buscarTodosOrdenadosPorNome();
			request.setAttribute("ingrediente", ingrediente);
			request.getRequestDispatcher(DESTINO).forward(request,response);
			
		} catch (ServicoException e) {
			e.printStackTrace();
			request.setAttribute("erros", e.getMessage());
			request.setAttribute("ingrediente", x);
			request.getRequestDispatcher(FORM).forward(request,response);
		}catch(ValidacaoException e){
			request.setAttribute("erros", e.getErros());
			request.setAttribute("ingrediente", x);
			request.getRequestDispatcher(FORM).forward(request,response);
		}
	}

}