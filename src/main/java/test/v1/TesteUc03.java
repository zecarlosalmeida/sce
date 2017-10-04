package test.v1;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import dominio.Cliente;
import dominio.Ingrediente;
import dominio.ItemPedido;
import dominio.ItemPizza;
import dominio.Pedido;
import dominio.Pizza;
import junit.framework.Assert;
import servico.ServicoException;

public class TesteUc03 {@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void manterClientes() throws java.text.ParseException,ServicoException {	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Pizza pizza1 = new Pizza(null, "Calabresa");
		Ingrediente i1 = new Ingrediente(null, "Calabresa", new BigDecimal("5.50"));
		Cliente c1 = new Cliente(null, "Teste", "drika@gmail.com", "000.111.222-55", "(34)99242-0221",sdf.parse("19/10/1979"), new BigDecimal("1300.00"));
		ItemPizza ipizza1  = new ItemPizza(null, pizza1, i1);
		Pedido p1 = new Pedido(null, sdf.parse("25/08/2016"), c1);
		ItemPedido ip1  = new ItemPedido(null, 1, pizza1, p1);
		
		
		c1.addPedido(p1);
		c1.addPedido(p1);
		
		Assert.assertEquals(c1.getPedidos().size(), 2);
		//ItemPedido i = new ItemPedido();
		p1.addItem(ip1);
		
		//thrown.expect(ServicoException.class);
		//cs.inserir(c1);
		
		}	
	}