package test.v1;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class Testes {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void incluirItemPedido() throws java.text.ParseException,ServicoException {	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Pizza pizza1 = new Pizza(null, "Calabresa");
		Ingrediente i1 = new Ingrediente(null, "Calabresa", new BigDecimal("5.50"));
		Cliente c1 = new Cliente(null, "Teste", "drika@gmail.com", "000.111.222-55", "(34)99242-0221",sdf.parse("19/10/1979"), new BigDecimal("1300.00"));
		ItemPizza ipizza1  = new ItemPizza(null, pizza1, i1);
		
		Pedido p1 = new Pedido(null, sdf.parse("25/08/2016"), c1);//Inserindo em pedido o cliente
		ItemPedido ip1  = new ItemPedido(null, 1, pizza1, p1);//Incluir a pedido em Pizza
		
		Assert.assertEquals(c1.getPedidos().size(), 1);
		if(pizza1.getNome() == "Calabresa"){
			System.out.println("Não pode inserir a mesma pizza");
		}
		else{
			 ip1  = new ItemPedido(null, 1, pizza1, p1);
		}
		
		Assert.assertEquals(c1.getPedidos().size(), 1);
		
	}
	@Test
	public void pesquisarPedido() throws java.text.ParseException,ServicoException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Pizza pizza1 = new Pizza(null, "Calabresa");
		Ingrediente i1 = new Ingrediente(null, "Calabresa", new BigDecimal("5.50"));
		Cliente c1 = new Cliente(null, "Teste", "drika@gmail.com", "000.111.222-55", "(34)99242-0221",sdf.parse("19/10/1979"), new BigDecimal("1300.00"));
		ItemPizza ipizza1  = new ItemPizza(null, pizza1, i1);
		
		Pedido p1 = new Pedido(null, sdf.parse("30/08/2016"), c1);//Inserindo em pedido o cliente
		ItemPedido ip1  = new ItemPedido(null, 1, pizza1, p1);//Incluir a pedido em Pizza
		
		Date dInicio = sdf.parse("01/08/2016");
		Date dFim = sdf.parse("01/10/2016");
		boolean aux = false;
		
		//Verifica se uma dataInicio é maior que a dataFim
		if (dInicio.before(dFim)){
			aux = true;
		}else {
			System.out.println("Data Inicio: "+dInicio+" é maior que a Data Fim: "+dFim);
		}
		Assert.assertEquals(aux, true);
	}
	@Test
	public void manterCliente() throws java.text.ParseException,ServicoException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Cliente c1 = new Cliente(null, "Teste", "drika@gmail.com", "000.111.222-55", "(34)99242-0221",sdf.parse("19/10/1979"), new BigDecimal("1300.00"));
		
		c1.setNome("jose");
		c1.setCpf("105.305.455-58");
		Assert.assertEquals(c1.getNome(), "jose");
		
		
		
	}
	
	
}