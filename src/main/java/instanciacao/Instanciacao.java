package instanciacao;

import java.awt.PointerInfo;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import dominio.Ingrediente;
import dominio.ItemPedido;
import dominio.ItemPizza;
import dominio.Pedido;
import dominio.Pizza;
import servico.ClienteServico;
import servico.IngredienteServico;
import servico.ItemPedidoServico;
import servico.ItemPizzaServico;
import servico.PedidoServico;
import servico.PizzaServico;
import servico.ServicoException;


@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Ingrediente i1 = new Ingrediente(null, "Tomate", new BigDecimal("2.50"));
			Ingrediente i2 = new Ingrediente(null, "Ovo", new BigDecimal("1.75"));
			Ingrediente i3 = new Ingrediente(null, "Queijo", new BigDecimal("3.00"));
			Ingrediente i4 = new Ingrediente(null, "Calabresa", new BigDecimal("5.50"));
			Ingrediente i5 = new Ingrediente(null, "Provolone", new BigDecimal("3.75"));

			Pizza pizza1 = new Pizza(null, "Calabresa");
			Pizza pizza2 = new Pizza(null, "Queijo");
			Pizza pizza3 = new Pizza(null, "Calabresa com Queijo");

			Cliente c1 = new Cliente(null, "Saulo", "saulo.camargos.sc@gmail.com", "000.111.222-53", "(34)99227-8939",sdf.parse("08/03/1996"), new BigDecimal("1200.00"));
			Cliente c2 = new Cliente(null, "Cirania", "ciraniaborges@hotmail.com", "000.111.222-54", "(34)99632-0027",sdf.parse("20/05/1979"), new BigDecimal("986.00"));
			Cliente c3 = new Cliente(null, "Adriana", "drika@gmail.com", "000.111.222-55", "(34)99242-0221",sdf.parse("19/10/1979"), new BigDecimal("1300.00"));
			
			ItemPizza ipizza1  = new ItemPizza(null, pizza1, i1);
			ItemPizza ipizza2  = new ItemPizza(null, pizza1, i2);
			ItemPizza ipizza3  = new ItemPizza(null, pizza1, i4);
			ItemPizza ipizza4  = new ItemPizza(null, pizza1, i5);
			ItemPizza ipizza5  = new ItemPizza(null, pizza2, i1);
			ItemPizza ipizza6  = new ItemPizza(null, pizza2, i2);
			ItemPizza ipizza7  = new ItemPizza(null, pizza2, i3);
			ItemPizza ipizza8  = new ItemPizza(null, pizza2, i5);
			ItemPizza ipizza9  = new ItemPizza(null, pizza3, i1);
			ItemPizza ipizza10 = new ItemPizza(null, pizza3, i2);
			ItemPizza ipizza11 = new ItemPizza(null, pizza3, i3);
			ItemPizza ipizza12 = new ItemPizza(null, pizza3, i4);
			ItemPizza ipizza13 = new ItemPizza(null, pizza3, i5);
			
			Pedido p1 = new Pedido(null, sdf.parse("25/08/2016"), c3);
			Pedido p2 = new Pedido(null, sdf.parse("26/08/2016"), c2);
			Pedido p3 = new Pedido(null, sdf.parse("27/08/2016"), c2);
			Pedido p4 = new Pedido(null, sdf.parse("27/08/2016"), c3);
			Pedido p5 = new Pedido(null, sdf.parse("27/08/2016"), c1);
			
			ItemPedido ip1  = new ItemPedido(null, 1, pizza1, p1);
			ItemPedido ip2  = new ItemPedido(null, 1, pizza2, p1);
			ItemPedido ip3  = new ItemPedido(null, 2, pizza3, p2);
			ItemPedido ip4  = new ItemPedido(null, 1, pizza2, p2);
			ItemPedido ip5  = new ItemPedido(null, 1, pizza3, p3);
			ItemPedido ip6  = new ItemPedido(null, 2, pizza1, p3);
			ItemPedido ip7  = new ItemPedido(null, 1, pizza2, p4);
			ItemPedido ip8  = new ItemPedido(null, 2, pizza1, p4);
			ItemPedido ip9  = new ItemPedido(null, 1, pizza2, p5);
			ItemPedido ip10 = new ItemPedido(null, 1, pizza1, p5);
			
			ClienteServico cs = new ClienteServico();
			IngredienteServico is = new IngredienteServico();
			ItemPedidoServico ips = new ItemPedidoServico();
			ItemPizzaServico ipizzas = new ItemPizzaServico();
			PedidoServico ps = new PedidoServico();
			PizzaServico pizzas = new PizzaServico();
			
			is.inserir(i1);
			is.inserir(i2);
			is.inserir(i3);
			is.inserir(i4);
			is.inserir(i5);
			
			pizzas.inserir(pizza1);
			pizzas.inserir(pizza2);
			pizzas.inserir(pizza3);
			
			cs.inserir(c1);
			cs.inserir(c2);
			cs.inserir(c3);
			
			ipizzas.inserir(ipizza1);
			ipizzas.inserir(ipizza2);
			ipizzas.inserir(ipizza3);
			ipizzas.inserir(ipizza4);
			ipizzas.inserir(ipizza5);
			ipizzas.inserir(ipizza6);
			ipizzas.inserir(ipizza7);
			ipizzas.inserir(ipizza8);
			ipizzas.inserir(ipizza9);			
			ipizzas.inserir(ipizza10);
			ipizzas.inserir(ipizza11);
			ipizzas.inserir(ipizza12);
			ipizzas.inserir(ipizza13);
			
			ps.inserirAtualizar(p1);
			ps.inserirAtualizar(p2);
			ps.inserirAtualizar(p3);
			ps.inserirAtualizar(p4);
			ps.inserirAtualizar(p5);
			
			ips.inserirAtualizar(ip1);
			ips.inserirAtualizar(ip2);
			ips.inserirAtualizar(ip3);
			ips.inserirAtualizar(ip4);
			ips.inserirAtualizar(ip5);
			ips.inserirAtualizar(ip6);
			ips.inserirAtualizar(ip7);
			ips.inserirAtualizar(ip8);
			ips.inserirAtualizar(ip9);
			ips.inserirAtualizar(ip10);
			 
			response.getWriter().append("Pronto");
		} catch (ParseException e) {
			response.getWriter().append(e.getMessage());
		}
		catch (ServicoException e) {
			response.getWriter().append(e.getMessage());
		}
		
	}

}
