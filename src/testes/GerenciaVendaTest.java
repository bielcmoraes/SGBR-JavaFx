package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.ClienteNaoCadastrado;
import exceptions.ErroGrave;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoHorarioInvalido;
import exceptions.FormatoIngredientesInvalido;
import exceptions.FormatoQuantidadeInvalido;
import exceptions.FornecedorNaoCadastrado;
import exceptions.PratoNaoCadastrado;
import exceptions.PrecoInvalido;
import exceptions.ProdutoNaoCadastrado;
import exceptions.QuantidadeInvalida;
import exceptions.QuantidadeProdutosInsuficiente;
import exceptions.VendaNaoCadastrada;
import model.BancoDeDados;
import model.GerenciaCardapio;
import model.GerenciaFornecedor;
import model.GerenciaProdutos;
import model.GerenciaVendas;

class GerenciaVendaTest {

	GerenciaFornecedor gerenciaFornecedores = new GerenciaFornecedor();
	GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
	GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
	GerenciaVendas gerenciaVendas = new GerenciaVendas();
	String codigoVenda;
	
	@Test
	void CadastrandoVendaDeUmPratoCadastrado() throws PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave, ClienteNaoCadastrado {
		String [] info = new String[3];
		
		info[0] = "Cachorro Quente";
		info[1] = "Pix";
		info[2] = "Fernando Marcos Vinicius Melo";
		
		assertTrue(gerenciaVendas.cadastrarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getCardapio(), info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes()),
		"Tentando cadastrar uma venda de um prato cadastrado");
	}
	
	@Test
	void CadastrandoVendaDeUmPratoNaoCadastrado() throws PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[3];
		
		info[0] = "Cachorro Quente Vegano";
		info[1] = "Pix";
		info[2] = "Fernando Marcos Vinicius Melo";
		
		assertThrows(PratoNaoCadastrado.class, () -> gerenciaVendas.cadastrarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getCardapio(), info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes()),
		"Tentando cadastrar uma venda de um prato nao cadastrado");
	}
	
	@Test
	void CadastrandoVendaComQuantidadeDeProdutosInsuficiente() throws PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[4];
		
		info[0] = "Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente";
		info[1] = "Pix";
		info[2] = "Fernando Marcos Vinicius Melo";
		info[3] = "Fernando Marcos Vinicius Melo";
		
		assertThrows(QuantidadeProdutosInsuficiente.class, () -> gerenciaVendas.cadastrarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getCardapio(), info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes()),
		"Tentando cadastrar uma venda com quantidade de produtos insuficiente");
	}
	
	@Test
	void CadastrandoVendaEmListaNaoInstanciada() throws PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[3];
		
		info[0] = "Cachorro Quente";
		info[1] = "Pix";
		info[2] = "Fernando Marcos Vinicius Melo";
		
		assertThrows(ErroGrave.class, () -> gerenciaVendas.cadastrarVenda(null, BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getCardapio(), info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes()),
		"Tentando cadastrar uma venda em uma lista nao instanciada");
	}
	
	@Test
	void CadastrandoTresVendasComProdutosCadastrados() throws PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave, ClienteNaoCadastrado {
		String [] info = new String[4];
		
		info[0] = "Cachorro Quente";
		info[1] = "Pix";
		info[2] = "Fernando Marcos Vinicius Melo";
		info[3] = "Fernando Marcos Vinicius Melo";
		
		gerenciaVendas.cadastrarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getCardapio(), info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes());
		
		info[0] = "Cachorro Quente";
		info[1] = "Pix";
		info[2] = "Fernando Marcos Vinicius Melo";
		info[3] = "Fernando Marcos Vinicius Melo";
		
		gerenciaVendas.cadastrarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getCardapio(), info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes());
		
		assertEquals(4, BancoDeDados.getInstance().getListaProdutos().size(), "Verificando se os produtos utilizados na venda estam sendo removidos da lista de produtos");
		
	}
	/*
	@Test
	void EditandoVendaCadastradaComPratoCadastrado() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave, VendaNaoCadastrada, ClienteNaoCadastrado {
		String [] info = new String[5];
		
		info[0] = "10/10/2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente";
		info[3] = "Pix";
		info[4] = "Fernando Marcos Vinicius Melo";

		assertTrue(gerenciaVendas.editarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaVendas().get(0).getId(), info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes()),
		"Tentando editar uma venda cadastrada com um prato cadastrado");
		
	}
	*/
	@Test
	void EditandoVendaNaoCadastradaComPratoCadastrado() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[4];
		
		info[0] = "10/10/2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente";
		info[3] = "Pix";

		assertThrows(VendaNaoCadastrada.class, () -> gerenciaVendas.editarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getCardapio(), "-999", info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes()),
		"Tentando editar uma venda nao cadastrada com um prato cadastrado");	
	}
	
	@Test
	void EditandoVendaCadastradaComPratoNaoCadastrado() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[5];
		
		info[0] = "10/10/2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente Vegano";
		info[3] = "Pix";
		info[4] = "Fernando Marcos Vinicius Melo";

		assertThrows(PratoNaoCadastrado.class, () -> gerenciaVendas.editarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaVendas().get(0).getId(), info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes()),
		"Tentando editar uma venda cadastrada com um prato nao cadastrado");	
	}
	
	@Test
	void EditandoVendaCadastradaComFormatoDaDataInvalido() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[5];
		
		info[0] = "10 10 2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente";
		info[3] = "Pix";
		info[4] = "Fernando Marcos Vinicius Melo";

		assertThrows(FormatoDataInvalido.class, () -> gerenciaVendas.editarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaVendas().get(0).getId(), info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes()),
		"Tentando editar uma venda cadastrada com formato da data invalido");	
	}
	
	@Test
	void EditandoVendaCadastradaComFormatoDoHorarioInvalido() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[5];
		
		info[0] = "10/10/2022";
		info[1] = "10 10";
		info[2] = "Cachorro Quente";
		info[3] = "Pix";
		info[4] = "Fernando Marcos Vinicius Melo";

		assertThrows(FormatoHorarioInvalido.class, () -> gerenciaVendas.editarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaVendas().get(0).getId(), info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes()),
		"Tentando editar uma venda cadastrada com formato do horario invalido");	
	}
	
	@Test
	void EditandoVendaCadastradaComQuantidadeDeProdutosInsuficiente() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[5];
		
		info[0] = "10/10/2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente, Cachorro Quente";
		info[3] = "Pix";
		info[4] = "Fernando Marcos Vinicius Melo";

		assertThrows(QuantidadeProdutosInsuficiente.class, () -> gerenciaVendas.editarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaVendas().get(0).getId(), info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes()),
		"Tentando editar uma venda cadastrada com quantidade de produtos insuficientes");	
	}
	
	@Test
	void EditandoVendaEmListaNaoInstanciada() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[4];
		
		info[0] = "10/10/2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente";
		info[3] = "Pix";

		assertThrows(ErroGrave.class, () -> gerenciaVendas.editarVenda(null, BancoDeDados.getInstance().getCardapio(), codigoVenda, info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes()),
		"Tentando editar uma venda em uma lista nao instanciada");	
	}
	
	/*
	@Test
	void EditandoVendaCadastradaComDoisPratosCadastrados() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave, VendaNaoCadastrada, ClienteNaoCadastrado {
		String [] info = new String[5];
		
		info[0] = "10/10/2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente, Cachorro Quente, Cachorro Quente";
		info[3] = "Pix";
		info[4] = "Fernando Marcos Vinicius Melo";
		
		gerenciaVendas.editarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaVendas().get(0).getId(), info, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes());
		
		assertEquals(0, BancoDeDados.getInstance().getListaProdutos().size(), "Verificando se os produtos sobresalentes da venda foram removidos da lista de produtos");
	}*/
	
	@Test
	void ExcluindoVendaCadastrada() throws VendaNaoCadastrada, ErroGrave {
		assertTrue(gerenciaVendas.excluirVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaVendas().get(0).getId()),
		"Tentando excluir uma venda cadastrada");
	}
	
	@Test
	void ExcluindoVendaNaoCadastrada() throws VendaNaoCadastrada, ErroGrave {
		assertThrows(VendaNaoCadastrada.class, () -> gerenciaVendas.excluirVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getListaIds(), "-999"),
		"Tentando excluir uma venda nao cadastrada");
	}
	
	@Test
	void ExcluindoVendaEmListaNaoInstanciada() throws VendaNaoCadastrada, ErroGrave {
		assertThrows(ErroGrave.class, () -> gerenciaVendas.excluirVenda(null, BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaVendas().get(0).getId()),
		"Tentando excluir uma venda em lista nao instanciada");
	}

	@Test
	void ExcluindoTresVendasCadastradas() throws VendaNaoCadastrada, ErroGrave, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ClienteNaoCadastrado {
String [] infoVenda = new String[3];
		
		infoVenda[0] = "Cachorro Quente";
		infoVenda[1] = "Pix";
		infoVenda[2] = "Fernando Marcos Vinicius Melo";
		
		gerenciaVendas.cadastrarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getCardapio(), infoVenda, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes());
		
		String codigoVenda2 = BancoDeDados.getInstance().getListaVendas().get(1).getId();
	
		infoVenda[0] = "Cachorro Quente";
		infoVenda[1] = "Pix";
		infoVenda[2] = "Fernando Marcos Vinicius Melo";
		
		gerenciaVendas.cadastrarVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getCardapio(), infoVenda, BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaClientes());
	
		String codigoVenda3 = BancoDeDados.getInstance().getListaVendas().get(2).getId();
		
		gerenciaVendas.excluirVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaVendas().get(0).getId());
		gerenciaVendas.excluirVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaVendas().get(0).getId());
		gerenciaVendas.excluirVenda(BancoDeDados.getInstance().getListaVendas(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaVendas().get(0).getId());
		
		assertEquals(5, BancoDeDados.getInstance().getListaVendas().size(), "Verificando se a lista esta vazia apos a exclusao dos tres vendas cadastradas");
	}
	
}
