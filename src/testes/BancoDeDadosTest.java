package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import model.BancoDeDados;
import model.Fornecedor;
import model.Funcionario;
import model.Gerente;
import model.Prato;
import model.Produto;
import model.Usuario;
import model.Venda;

class BancoDeDadosTest {

	@Test
	void listaFornecedoresVazia() {
		BancoDeDados bd = new BancoDeDados();
		ArrayList<Fornecedor> lf = bd.getListaFornecedores();
		assertTrue(lf.isEmpty(), "Lista de fornecedores vazia");
	}
	
	@Test
	void adicionandoUmFornecedorNaListaVazia() {
		BancoDeDados bd = new BancoDeDados();
		Fornecedor f1 = new Fornecedor(bd.getListaIds(), "Fornecedor1", "373746667", "Rua Bonita");
		ArrayList<Fornecedor> lf = bd.getListaFornecedores();
		lf.add(f1);
		assertEquals(f1,lf.get(0), "Adicionando um fornecedor a lista de fornecedores");
	}
	
	@Test
	void cardapioVazio() {
		BancoDeDados bd = new BancoDeDados();
		ArrayList<Prato> c = bd.getCardapio();
		assertTrue(c.isEmpty(), "Lista de fornecedores vazia");
	}
	
	@Test
	void adicionandoUmPratoNoCardapioVazio() {
		BancoDeDados bd = new BancoDeDados();
		HashMap<String, Double> receita = new HashMap<String, Double>();
		Prato p1 = new Prato(bd.getListaIds(), "Pizza", 22.45, "Pizza media", "Massas", bd.getListaProdutos(),receita);
		ArrayList<Prato> c = bd.getCardapio();
		c.add(p1);
		assertEquals(p1,c.get(0), "Adicionando um prato ao cardapio");
	}
	
	@Test
	void estoqueProdutoVazio() {
		BancoDeDados bd = new BancoDeDados();
		HashMap<String, ArrayList<Produto>> lp = bd.getListaProdutos();
		assertTrue(lp.isEmpty(), "Lista de fornecedores vazia");
	}
	
	@Test
	void adicionandoUmProdutoNaListaVazia() {
		BancoDeDados bd = new BancoDeDados();
		LocalDate validade = LocalDate.of(2022, 07, 22);
		ArrayList<Fornecedor> f1 = new ArrayList();
		Produto p1 = new Produto(bd.getListaIds(), "Tomate", 5.77, 50.00, "kg", validade, f1);
		HashMap<String, ArrayList<Produto>> lp= bd.getListaProdutos();
		lp.put(p1.getNome(), new ArrayList<Produto>());
		lp.get(p1.getNome()).add(p1);
		assertEquals(p1, lp.get(p1.getNome()).get(0), "Adicionando um produto a lista");
	}
	
	@Test
	void listaUsuarioVazia() {
		BancoDeDados bd = new BancoDeDados();
		ArrayList<Usuario> lu = bd.getListaUsuarios();
		assertTrue(lu.isEmpty(), "Lista de fornecedores vazia");
	}
	
	@Test
	void adicionandoUmGerenteNaListaDeUsuarios() {
		BancoDeDados bd = new BancoDeDados();
		Usuario u1 = new Gerente();
		ArrayList<Usuario> u = bd.getListaUsuarios();
		u.add(u1);
		assertEquals(u1,u.get(0), "Adicionando um gerente na lista de usuarios");
	}
	
	@Test
	void adicionandoUmFuncionarioNaListaDeUsuarios() {
		BancoDeDados bd = new BancoDeDados();
	Usuario u1 = new Funcionario(bd.getListaIds(), "Funcionario do mes", "funcionariotop", "senhatop");
		ArrayList<Usuario> u = bd.getListaUsuarios();
		u.add(u1);
		assertEquals(u1,u.get(0), "Adicionando um funcionario na lista de usuarios");
	}
	
	@Test
	void listaVendaVazia() {
		BancoDeDados bd = new BancoDeDados();
		ArrayList<Venda> lv = bd.getListaVendas();
		assertTrue(lv.isEmpty(), "Lista de fornecedores vazia");
	}
	
	@Test
	void adicionandoUmaVendaNaLista() {
		BancoDeDados bd = new BancoDeDados();
		Venda v1 = new Venda(bd.getListaIds(), bd.getCardapio(), 99.55, "Credito");
		ArrayList<Venda> v = bd.getListaVendas();
		v.add(v1);
		assertEquals(v1,v.get(0), "Adicionando uma venda na lista de vendas");
	}
	
	@Test
	void listaIdsVazia() {
		BancoDeDados bd = new BancoDeDados();
		ArrayList<String> li = bd.getListaIds();
		assertTrue(li.isEmpty(), "Lista de fornecedores vazia");
	}
	
	@Test
	void adicionandoUmIdNaLista() {
		BancoDeDados bd = new BancoDeDados();
		String id = "37366";
		ArrayList<String> i = bd.getListaIds();
		i.add(id);
		assertEquals(id,i.get(0), "Adicionando uma venda na lista de vendas");
	}
}
