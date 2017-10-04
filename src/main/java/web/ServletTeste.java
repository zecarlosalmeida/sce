package web;

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

@WebServlet("/ServletTeste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Ingrediente i1 = new Ingrediente(null, "Farinha", new BigDecimal("2.50"));
			Ingrediente i2 = new Ingrediente(null, "Ovo", new BigDecimal("1.75"));
			Ingrediente i3 = new Ingrediente(null, "Queijo", new BigDecimal("3.00"));
			Ingrediente i4 = new Ingrediente(null, "Calabresa", new BigDecimal("5.50"));
			Ingrediente i5 = new Ingrediente(null, "Leite", new BigDecimal("3.75"));

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
			
			response.getWriter().append("\nValor total das pizzas\n");		
			response.getWriter().append(pizza1.valorTotal().toString()+"\n");
			response.getWriter().append(pizza2.valorTotal().toString()+"\n");
			response.getWriter().append(pizza3.valorTotal().toString()+"\n");
			response.getWriter().append("\nSub total item pedido\n");
			response.getWriter().append(ip1.subTotal().toString()+"\n");
			response.getWriter().append(ip2.subTotal().toString()+"\n");
			response.getWriter().append(ip3.subTotal().toString()+"\n");
			response.getWriter().append(ip4.subTotal().toString()+"\n");
			response.getWriter().append(ip5.subTotal().toString()+"\n");
			response.getWriter().append(ip6.subTotal().toString()+"\n");
			response.getWriter().append(ip7.subTotal().toString()+"\n");
			response.getWriter().append(ip8.subTotal().toString()+"\n");
			response.getWriter().append(ip9.subTotal().toString()+"\n");
			response.getWriter().append(ip10.subTotal().toString()+"\n");
			response.getWriter().append("\nValor total dos pedios\n");		
			response.getWriter().append(p1.valorTotal().toString()+"\n");
			response.getWriter().append(p2.valorTotal().toString()+"\n");
			response.getWriter().append(p3.valorTotal().toString()+"\n");
			response.getWriter().append(p4.valorTotal().toString()+"\n");
			response.getWriter().append(p5.valorTotal().toString()+"\n");
			
			
			
		} catch (ParseException e) {
			response.getWriter().append(e.getMessage());
		}

		response.getWriter().append("Pronto");
	}


}
