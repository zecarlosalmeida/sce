package web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import dominio.Cliente;
import dominio.Ingrediente;
import dominio.ItemPizza;
import dominio.Pizza;
import servico.IngredienteServico;
import servico.PizzaServico;

public class Instanciar {

	public static Pizza pizza(HttpServletRequest request) {		
		Pizza aux = new Pizza();
		String s;

		s = request.getParameter("codPizza");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setCodPizza(Integer.parseInt(s));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codPizza invalido");
			}
		}

		s = request.getParameter("nome");
		if (s != null && !s.isEmpty()) {
			aux.setNome(s);
		}		

		return aux;
	}

	public static ItemPizza itemPizza(HttpServletRequest request) {

		PizzaServico as = new PizzaServico();
		IngredienteServico fs = new IngredienteServico();
		
		ItemPizza aux = new ItemPizza();
		String s;
		
		s = request.getParameter("codPizza");
		if (s != null && !s.isEmpty()) {
			try {
				Pizza x = as.buscar(Integer.parseInt(s));
				aux.setPizza(x);
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codPizza invalido");
			}
		}

		s = request.getParameter("codIngrediente");
		if (s != null && !s.isEmpty()) {
			try {
				Ingrediente x = fs.buscar(Integer.parseInt(s));
				aux.setIngrediente(x);
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codIngrediente invalido");
			}
		}
		
		
		return aux;
	}


	public static Ingrediente ingrediente(HttpServletRequest request) {
		Ingrediente aux = new Ingrediente();
		String s;

		s = request.getParameter("codIngrediente");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setCodIngrediente(Integer.parseInt(s));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		s = request.getParameter("nome");
		if (s != null && !s.isEmpty()) {
			aux.setNome(s);
		}
		s = request.getParameter("preco");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setPreco(new BigDecimal(s));

			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

		}
		return aux;

	}
	
	public static Cliente cliente(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Cliente aux = new Cliente();
		String s;

		s = request.getParameter("codCliente");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setCodCliente(Integer.parseInt(s));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codCliente invalido");
			}
		}

		s = request.getParameter("nome");
		if (s != null && !s.isEmpty()) {
			aux.setNome(s);
		}

		s = request.getParameter("email");
		if (s != null && !s.isEmpty()) {
			aux.setEmail(s);
		}
		
		s = request.getParameter("cpf");
		if (s != null && !s.isEmpty()) {
			aux.setCpf(s);
		}
		
		s = request.getParameter("telefone");
		if (s != null && !s.isEmpty()) {
			aux.setTelefone(s);
		}

		s = request.getParameter("renda");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setRenda(new BigDecimal(s));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: renda invalido");
			}
		}

		s = request.getParameter("dataNasc");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setDataNasc(sdf.parse(s));
			} catch (ParseException e) {
				System.out.println("Instanciacao: nascimento invalido");
			}
		}

		return aux;
	}	

		


}
