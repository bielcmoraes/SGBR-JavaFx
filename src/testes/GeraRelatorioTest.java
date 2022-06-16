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

	
	private GeraRelatorio gr = new GeraRelatorio();
	@BeforeEach
	 
	@Test
	void estoqueTotalComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.estoqueTotal(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void estoqueTotalComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.estoqueTotal(BancoDeDados.getInstance().getListaProdutos()));
	}
	
	@Test
	void estoquePorProdutoComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.estoquePorProduto(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void estoquePorProdutoComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.estoquePorProduto(BancoDeDados.getInstance().getListaProdutos()));
	}
	
	@Test
	void estoqueProdutosPertoDeVencerComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.estoqueProdutosPertoDeVencer(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void estoqueProdutosPertoDeVencerComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.estoqueProdutosPertoDeVencer(BancoDeDados.getInstance().getListaProdutos()));
	}
	
	@Test
	void fornecedorPorProdutoComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.fornecedorPorProduto(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void fornecedorPorProdutoComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.fornecedorPorProduto(BancoDeDados.getInstance().getListaProdutos()));
	}
	
	@Test
	void fornecedorPorFornecedorComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.fornecedorPorFornecedor(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void fornecedorPorFornecedorComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.fornecedorPorFornecedor(BancoDeDados.getInstance().getListaFornecedores()));
	}
	
	@Test
	void vendasTotalComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.vendasTotal(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void vendasTotalComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.vendasTotal(BancoDeDados.getInstance().getListaVendas()));
	}
	
	@Test
	void vendasPorPeriodoComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.vendasPorPeriodo(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void vendasPorPeriodoComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.vendasPorPeriodo(BancoDeDados.getInstance().getListaVendas()));
	}
	
	@Test
	void vendasPorTipoDePratoComListaNull() throws RelatorioNaoGerado, ErroGrave {
		assertThrows(ErroGrave.class, () -> gr.vendasPorTipoDePrato(null), "Tentando gerar relatório de estoque total com lista não instanciada");	
	}
	
	@Test
	void vendasPorTipoDePratoComSucesso() throws RelatorioNaoGerado, ErroGrave {
		assertTrue(gr.vendasPorTipoDePrato(BancoDeDados.getInstance().getListaVendas()));
	}
	
	@Test
	void notaFiscalComSucesso() throws RelatorioNaoGerado {
		assertTrue(gr.notaFiscal(BancoDeDados.getInstance().getListaVendas().get(0)));
	}
}
