package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.BancoDeDados;
import model.Cliente;
import model.Fornecedor;
import model.Funcionario;
import model.Gerente;
import model.Prato;
import model.Produto;
import model.Usuario;
import model.Venda;

class BancoDeDadosTest {
	
	@Test
	void listaFornecedoresComPreCadastro() {
		ArrayList<Fornecedor> lf = BancoDeDados.getInstance().getListaFornecedores();
		assertFalse(lf.isEmpty(), "Lista de fornecedores vazia");
	}
	
	@Test
	void adicionandoUmFornecedorNaLista() {
		
		Fornecedor f1 = new Fornecedor(BancoDeDados.getInstance().getListaIds(), "Fornecedor1", "373746667", "Rua Bonita", new ArrayList<String>());
		ArrayList<Fornecedor> lf = BancoDeDados.getInstance().getListaFornecedores();
		lf.add(f1);
		assertEquals(f1,lf.get(lf.indexOf(f1)), "Adicionando um fornecedor a lista de fornecedores");
	}
	
	@Test
	void cardapioComPreCadastro() {
		ArrayList<Prato> c = BancoDeDados.getInstance().getCardapio();
		assertFalse(c.isEmpty(), "Lista de fornecedores vazia");
	}
	
	@Test
	void adicionandoUmPratoNoCardapio() {
		HashMap<String, Double> receita = new HashMap<String, Double>();
		Prato p1 = new Prato(BancoDeDados.getInstance().getListaIds(), "Pizza", 22.45, "Pizza media", "Massas", BancoDeDados.getInstance().getListaProdutos(),receita);
		ArrayList<Prato> c = BancoDeDados.getInstance().getCardapio();
		c.add(p1);
		assertEquals(p1,c.get(c.indexOf(p1)), "Adicionando um prato ao cardapio");
	}
	
	@Test
	void estoqueProdutoComPreCadastro() {
		HashMap<String, ArrayList<Produto>> lp = BancoDeDados.getInstance().getListaProdutos();
		assertFalse(lp.isEmpty(), "Lista de fornecedores vazia");
	}
	
	@Test
	void adicionandoUmProdutoNaListaVazia() {
		LocalDate validade = LocalDate.of(2022, 07, 22);
		ArrayList<Fornecedor> f1 = new ArrayList();
		Produto p1 = new Produto(BancoDeDados.getInstance().getListaIds(), "Tomate", 5.77, 50.00, "kg", validade, f1);
		HashMap<String, ArrayList<Produto>> lp= BancoDeDados.getInstance().getListaProdutos();
		lp.put(p1.getNome(), new ArrayList<Produto>());
		lp.get(p1.getNome()).add(p1);
		assertEquals(p1, lp.get(p1.getNome()).get(0), "Adicionando um produto a lista");
	}
	
	@Test
	void listaUsuarioVazia() {
		ArrayList<Usuario> lu = BancoDeDados.getInstance().getListaUsuarios();
		assertTrue(lu.isEmpty(), "Lista de fornecedores vazia");
	}
	
	@Test
	void adicionandoUmGerenteNaListaDeUsuarios() {
		Usuario u1 = new Gerente();
		ArrayList<Usuario> u = BancoDeDados.getInstance().getListaUsuarios();
		u.add(u1);
		assertEquals(u1,u.get(u.indexOf(u1)), "Adicionando um gerente na lista de usuarios");
	}
	
	@Test
	void adicionandoUmFuncionarioNaListaDeUsuarios() {
	Usuario u1 = new Funcionario(BancoDeDados.getInstance().getListaIds(), "Funcionario do mes", "funcionariotop", "senhatop");
		ArrayList<Usuario> u = BancoDeDados.getInstance().getListaUsuarios();
		u.add(u1);
		assertEquals(u1,u.get(0), "Adicionando um funcionario na lista de usuarios");
	}
	
	@Test
	void listaVendaComPreCadastro() {
		ArrayList<Venda> lv = BancoDeDados.getInstance().getListaVendas();
		assertFalse(lv.isEmpty(), "Lista de fornecedores vazia");
	}
	
	@Test
	void adicionandoUmaVendaNaLista() {
		Cliente cliente = new Cliente(BancoDeDados.getInstance().getListaIds(), "Coringa","88616574390", "risadinha@gmail.com", "212299898");
		Venda v1 = new Venda(BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getCardapio(), 99.55, "Credito", cliente);
		ArrayList<Venda> v = BancoDeDados.getInstance().getListaVendas();
		v.add(v1);
		assertEquals(v1,v.get(v.indexOf(v1)), "Adicionando uma venda na lista de vendas");
	}
	
	@Test
	void listaIdsVazia() {
		ArrayList<String> li = BancoDeDados.getInstance().getListaIds();
		assertTrue(li.isEmpty(), "Lista de fornecedores vazia");
	}
	
	@Test
	void adicionandoUmIdNaLista() {
		String id = "37366";
		ArrayList<String> i = BancoDeDados.getInstance().getListaIds();
		i.add(id);
		assertEquals(id,i.get(0), "Adicionando uma venda na lista de vendas");
	}
}
