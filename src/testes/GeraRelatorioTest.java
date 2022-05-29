package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PreCadastro.PreCadastro;
import exceptions.ErroGrave;
import exceptions.RelatorioNaoGerado;
import model.BancoDeDados;
import model.GeraRelatorio;

class GeraRelatorioTest {

	private BancoDeDados bd = new BancoDeDados();
	private PreCadastro pc = new PreCadastro();
	private GeraRelatorio gr = new GeraRelatorio();
	@BeforeEach
	 
	@Test
	void estoqueTotalComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.estoqueTotal(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void estoqueTotalComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.estoqueTotal(bd.getListaProdutos()));
	}
	
	@Test
	void estoquePorProdutoComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.estoquePorProduto(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void estoquePorProdutoComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.estoquePorProduto(bd.getListaProdutos()));
	}
	
	@Test
	void estoqueProdutosPertoDeVencerComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.estoqueProdutosPertoDeVencer(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void estoqueProdutosPertoDeVencerComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.estoqueProdutosPertoDeVencer(bd.getListaProdutos()));
	}
	
	@Test
	void fornecedorPorProdutoComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.fornecedorPorProduto(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void fornecedorPorProdutoComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.fornecedorPorProduto(bd.getListaProdutos()));
	}
	
	@Test
	void fornecedorPorFornecedorComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.fornecedorPorFornecedor(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void fornecedorPorFornecedorComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.fornecedorPorFornecedor(bd.getListaFornecedores()));
	}
	
	@Test
	void vendasTotalComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.vendasTotal(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void vendasTotalComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.vendasTotal(bd.getListaVendas()));
	}
	
	@Test
	void vendasPorPeriodoComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.vendasPorPeriodo(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void vendasPorPeriodoComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.vendasPorPeriodo(bd.getListaVendas()));
	}
	
	@Test
	void vendasPorTipoDePratoComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.vendasPorTipoDePrato(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void vendasPorTipoDePratoComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.vendasPorTipoDePrato(bd.getListaVendas()));
	}
}
