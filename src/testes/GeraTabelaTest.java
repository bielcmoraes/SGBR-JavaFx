package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lowagie.text.Table;

import PreCadastro.PreCadastro;
import exceptions.ErroGrave;
import model.BancoDeDados;
import model.GeraTabela;
import model.Produto;

class GeraTabelaTest {
	
	PreCadastro pc = new PreCadastro();
	GeraTabela gt = new GeraTabela();
	@BeforeEach
	
	@Test 
	void estoqueTotalComListaDeProdutosNull() {
		assertThrows(ErroGrave.class, () -> gt.estoqueTotal(null), "Tentando gerar tabela de estoque total com lista não instanciada");	
	}
	
	@Test
	void estoqueTotalComListaDeProdutosVazia() throws ErroGrave {
		assertTrue((gt.estoqueTotal(BancoDeDados.getInstance().getListaProdutos()) instanceof Table), "Tentando gerar tabela de estoque total com lista não instanciada");	

	}
	
	@Test
	void estoqueTotalComSucesso() throws ErroGrave {
		assertTrue((gt.estoqueTotal(BancoDeDados.getInstance().getListaProdutos()) instanceof Table), "Tentando gerar tabela de estoque total com lista não instanciada");	

	}
	
	@Test
	void estoquePorProdutoComListaDeProdutosNull() {
		assertThrows(ErroGrave.class, () -> gt.estoquePorProduto(null), "Tentando gerar tabela de estoque por produto com lista não instanciada");	
	}
	
	@Test 
	void estoquePorProdutoComListaDeProdutosVazia() throws ErroGrave {
		assertTrue((gt.estoquePorProduto(BancoDeDados.getInstance().getListaProdutos()) instanceof Table));
	}
	
	@Test 
	void estoquePorProdutoComSucesso() throws ErroGrave {
		assertTrue((gt.estoquePorProduto(BancoDeDados.getInstance().getListaProdutos()) instanceof Table));
	}
	
	@Test
	void estoqueProdutosPertoDeVencerComListaNull() {
		assertThrows(ErroGrave.class, () -> gt.estoqueProdutosPertoDeVencer(null), "Tentando gerar tabela de estoque produtos perto de vencer com lista não instanciada");	
	}
	
	@Test
	void estoqueProdutosPertoDeVencerComListaVazia() throws ErroGrave {
		assertTrue((gt.estoqueProdutosPertoDeVencer(BancoDeDados.getInstance().getListaProdutos()) instanceof Table ), "Tentando gerar tabela de estoque produtos perto de vencer com lista não instanciada");	
	}
	
	@Test
	void estoqueProdutosPertoDeVencerComSucesso() throws ErroGrave {
		LocalDate validade = LocalDate.of(2022, 05, 07);
		Produto pertoDeVencer = new Produto(BancoDeDados.getInstance().getListaIds(), "Pao", 0.5, 10.0, "Un", validade, BancoDeDados.getInstance().getListaFornecedores());
		assertTrue((gt.estoqueProdutosPertoDeVencer(BancoDeDados.getInstance().getListaProdutos()) instanceof Table ), "Tentando gerar tabela de estoque produtos perto de vencer com lista não instanciada");	
	}
	
	
	@Test
	void estoqueProdutosVencidosComListaNull() {
		assertThrows(ErroGrave.class, () -> gt.estoqueProdutosVencidos(null), "Tentando gerar tabela de estoque produtos vencidos com lista não instanciada");	
	}
	
	@Test
	void estoqueProdutosVencidosComListaVazia() throws ErroGrave {
		assertTrue((gt.estoqueProdutosVencidos(BancoDeDados.getInstance().getListaProdutos()) instanceof Table ), "Tentando gerar tabela de estoque produtos perto de vencer com lista não instanciada");	
	}
	
	@Test
	void estoqueProdutosVencidosComSucesso() throws ErroGrave {
		LocalDate validade = LocalDate.of(2020, 05, 07);
		Produto pertoDeVencer = new Produto(BancoDeDados.getInstance().getListaIds(), "Pao", 0.5, 10.0, "Un", validade, BancoDeDados.getInstance().getListaFornecedores());
		assertTrue((gt.estoqueProdutosVencidos(BancoDeDados.getInstance().getListaProdutos()) instanceof Table ), "Tentando gerar tabela de estoque produtos perto de vencer com lista não instanciada");	
	}
	
	@Test
	void fornecedorPorProdutoComListaNull() {
		assertThrows(ErroGrave.class, () -> gt.fornecedorPorProduto(null), "Tentando gerar tabela de fornecedor por fornecedor com lista não instanciada");	
	}
	
	@Test
	void fornecedorPorProdutoComListaVazia() throws ErroGrave {
		assertTrue((gt.fornecedorPorProduto(BancoDeDados.getInstance().getListaProdutos()) instanceof Table), "Tentando gerar tabela de fornecedor por produto com lista não instanciada");	
	}
	
	@Test
	void fornecedorPorProdutoComSucesso() throws ErroGrave {
		assertTrue((gt.fornecedorPorProduto(BancoDeDados.getInstance().getListaProdutos()) instanceof Table), "Tentando gerar tabela de fornecedor por produto com lista não instanciada");	
	}
	
	@Test
	void fornecedorPorFornecedorComListaNull() {
		assertThrows(ErroGrave.class, () -> gt.fornecedorPorFornecedor(null), "Tentando gerar tabela de fornecedor por produto com lista não instanciada");	
	}
	
	@Test
	void fornecedorPorFornecedorComListaVazia() throws ErroGrave {
		assertTrue((gt.fornecedorPorFornecedor(BancoDeDados.getInstance().getListaFornecedores()) instanceof Table), "Tentando gerar tabela de fornecedor por produto com lista não instanciada");	
	}
	
	@Test
	void fornecedorPorFornecedorComSucesso() throws ErroGrave {
		assertTrue((gt.fornecedorPorFornecedor(BancoDeDados.getInstance().getListaFornecedores()) instanceof Table), "Tentando gerar tabela de fornecedor por produto com lista não instanciada");	
	}
	
	@Test
	void vendasTotalComListaNull() {
		assertThrows(ErroGrave.class, () -> gt.vendasTotal(null), "Tentando gerar tabela de vendas totais com lista não instanciada");	
	}
	
	@Test
	void vendasTotalComListaVazia() throws ErroGrave {
		assertTrue((gt.vendasTotal(BancoDeDados.getInstance().getListaVendas()) instanceof Table), "Tentando gerar tabela de vendas totais com lista não instanciada");	
	}
	
	@Test
	void vendasTotalComSucesso() throws ErroGrave {
		assertTrue((gt.vendasTotal(BancoDeDados.getInstance().getListaVendas()) instanceof Table), "Tentando gerar tabela de vendas totais com lista não instanciada");	
	}
	
	@Test
	void vendasDiariasComListaNull() {
		assertThrows(ErroGrave.class, () -> gt.vendasDiarias(null), "Tentando gerar tabela de vendas diarias com lista não instanciada");	
	}
	
	@Test
	void vendasDiariasComListaVazia() throws ErroGrave {
		assertTrue((gt.vendasDiarias(BancoDeDados.getInstance().getListaVendas()) instanceof Table), "Tentando gerar tabela de vendas diarias com lista não instanciada");	
	}
	
	@Test
	void vendasDiariasComSucesso() throws ErroGrave {
		assertTrue((gt.vendasDiarias(BancoDeDados.getInstance().getListaVendas()) instanceof Table), "Tentando gerar tabela de vendas diarias com lista não instanciada");	
	}
	
	@Test
	void vendasSemanalComListaNull() {
		assertThrows(ErroGrave.class, () -> gt.vendasSemanal(null), "Tentando gerar tabela de vendas semanal com lista não instanciada");	
	}
	
	@Test
	void vendasSemanalComListaVazia() throws ErroGrave {
		assertTrue((gt.vendasSemanal(BancoDeDados.getInstance().getListaVendas()) instanceof Table), "Tentando gerar tabela de vendas diarias com lista não instanciada");	
	}
	
	@Test
	void vendasSemanalComSucesso() throws ErroGrave {
		assertTrue((gt.vendasSemanal(BancoDeDados.getInstance().getListaVendas()) instanceof Table), "Tentando gerar tabela de vendas diarias com lista não instanciada");	
	}
	
	@Test
	void vendasMensaisComListaNull() {
		assertThrows(ErroGrave.class, () -> gt.vendasMensais(null), "Tentando gerar tabela de vendas mensais com lista não instanciada");	
	}
	
	@Test
	void vendasMensaisComListaVazia() throws ErroGrave {
		assertTrue((gt.vendasMensais(BancoDeDados.getInstance().getListaVendas()) instanceof Table), "Tentando gerar tabela de vendas diarias com lista não instanciada");	
	}
	
	@Test
	void vendasMensaisComSucesso() throws ErroGrave {
		assertTrue((gt.vendasMensais(BancoDeDados.getInstance().getListaVendas()) instanceof Table), "Tentando gerar tabela de vendas diarias com lista não instanciada");	
	}
	
	@Test
	void vendasPorTipoDePratoComListaNull() {
		assertThrows(ErroGrave.class, () -> gt.vendasPorTipoDePrato(null), "Tentando gerar tabela de vendas por tipo de prato com lista não instanciada");	
	}
	
	@Test
	void vendasPorTipoDePratoComListaVazia() throws ErroGrave {
		assertTrue((gt.vendasPorTipoDePrato(BancoDeDados.getInstance().getListaVendas()) instanceof Table), "Tentando gerar tabela de vendas diarias com lista não instanciada");	
	}
	
	@Test
	void vendasPorTipoDePratoComSucesso() throws ErroGrave {
		assertTrue((gt.vendasPorTipoDePrato(BancoDeDados.getInstance().getListaVendas()) instanceof Table), "Tentando gerar tabela de vendas diarias com lista não instanciada");	
	}
}
