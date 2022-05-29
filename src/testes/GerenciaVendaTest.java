package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

	BancoDeDados bancoDeDados = new BancoDeDados();
	GerenciaFornecedor gerenciaFornecedores = new GerenciaFornecedor();
	GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
	GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
	GerenciaVendas gerenciaVendas = new GerenciaVendas();
	String codigoVenda;
	
	@BeforeEach
	void CadastrandoVenda() throws ErroGrave, PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ProdutoNaoCadastrado, FormatoIngredientesInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente {
		String [] infoFornecedor = new String[3];
		infoFornecedor[0] = "Joao";
		infoFornecedor[1] = "77.994.900/0001-26";
		infoFornecedor[2] = "Rua A";
		gerenciaFornecedores.cadastrarFornecedor(bancoDeDados.getListaFornecedores(), bancoDeDados.getListaIds(), infoFornecedor);
		
		String [] infoProduto = new String[5] ;
		infoProduto[0] = "Pao";
		infoProduto[1] = "1";
		infoProduto[2] = "3 un";
		infoProduto[3] = "28/07/2022";
		infoProduto[4] = "Joao";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto, bancoDeDados.getListaFornecedores());
		
		infoProduto[0] = "Salsicha";
		infoProduto[1] = "1";
		infoProduto[2] = "3 un";
		infoProduto[3] = "28/07/2022";
		infoProduto[4] = "Joao";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto, bancoDeDados.getListaFornecedores());
	
		String [] infoPrato = new String[5];
		
		infoPrato[0] = "Cachorro Quente";
		infoPrato[1] = "2";
		infoPrato[2] = "Cachorro quente simples";
		infoPrato[3] = "Lanche";
		infoPrato[4] = "1;un;Salsicha;1;un;Pao;";
		
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		infoPrato[0] = "Cachorro Quente Duplo";
		infoPrato[1] = "3";
		infoPrato[2] = "Cachorro quente com 2 salsichas";
		infoPrato[3] = "Lanche";
		infoPrato[4] = "2;un;Salsicha;1;un;Pao;";
		
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String [] infoVenda = new String[2];
		
		infoVenda[0] = "Cachorro Quente";
		infoVenda[1] = "Pix";
		
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda, bancoDeDados.getListaProdutos());
	
		codigoVenda = bancoDeDados.getListaVendas().get(0).getId();
	}
	
	@Test
	void CadastrandoVendaDeUmPratoCadastrado() throws PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[2];
		
		info[0] = "Cachorro Quente";
		info[1] = "Pix";
		
		assertTrue(gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), info, bancoDeDados.getListaProdutos()),
		"Tentando cadastrar uma venda de um prato cadastrado");
	}
	
	@Test
	void CadastrandoVendaDeUmPratoNaoCadastrado() throws PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[2];
		
		info[0] = "Cachorro Quente Vegano";
		info[1] = "Pix";
		
		assertThrows(PratoNaoCadastrado.class, () -> gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), info, bancoDeDados.getListaProdutos()),
		"Tentando cadastrar uma venda de um prato nao cadastrado");
	}
	
	@Test
	void CadastrandoVendaComQuantidadeDeProdutosInsuficiente() throws PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[2];
		
		info[0] = "Cachorro Quente, Cachorro Quente Duplo";
		info[1] = "Pix";
		
		assertThrows(QuantidadeProdutosInsuficiente.class, () -> gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), info, bancoDeDados.getListaProdutos()),
		"Tentando cadastrar uma venda com quantidade de produtos insuficiente");
	}
	
	@Test
	void CadastrandoVendaEmListaNaoInstanciada() throws PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[2];
		
		info[0] = "Cachorro Quente";
		info[1] = "Pix";
		
		assertThrows(ErroGrave.class, () -> gerenciaVendas.cadastrarVenda(null, bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), info, bancoDeDados.getListaProdutos()),
		"Tentando cadastrar uma venda em uma lista nao instanciada");
	}
	
	@Test
	void CadastrandoTresVendasComProdutosCadastrados() throws PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[2];
		
		info[0] = "Cachorro Quente";
		info[1] = "Pix";
		
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), info, bancoDeDados.getListaProdutos());
		
		info[0] = "Cachorro Quente";
		info[1] = "Pix";
		
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), info, bancoDeDados.getListaProdutos());
		
		assertEquals(0, bancoDeDados.getListaProdutos().size(), "Verificando se os produtos utilizados na venda estam sendo removidos da lista de produtos");
		
	}
	
	@Test
	void EditandoVendaCadastradaComPratoCadastrado() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave, VendaNaoCadastrada {
		String [] info = new String[4];
		
		info[0] = "10/10/2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente";
		info[3] = "Pix";

		assertTrue(gerenciaVendas.editarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getCardapio(), codigoVenda, info, bancoDeDados.getListaProdutos()),
		"Tentando editar uma venda cadastrada com um prato cadastrado");
		
	}
	
	@Test
	void EditandoVendaNaoCadastradaComPratoCadastrado() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[4];
		
		info[0] = "10/10/2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente";
		info[3] = "Pix";

		assertThrows(VendaNaoCadastrada.class, () -> gerenciaVendas.editarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getCardapio(), "-999", info, bancoDeDados.getListaProdutos()),
		"Tentando editar uma venda nao cadastrada com um prato cadastrado");	
	}
	
	@Test
	void EditandoVendaCadastradaComPratoNaoCadastrado() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[4];
		
		info[0] = "10/10/2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente Vegano";
		info[3] = "Pix";

		assertThrows(PratoNaoCadastrado.class, () -> gerenciaVendas.editarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getCardapio(), codigoVenda, info, bancoDeDados.getListaProdutos()),
		"Tentando editar uma venda cadastrada com um prato nao cadastrado");	
	}
	
	@Test
	void EditandoVendaCadastradaComFormatoDaDataInvalido() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[4];
		
		info[0] = "10 10 2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente";
		info[3] = "Pix";

		assertThrows(FormatoDataInvalido.class, () -> gerenciaVendas.editarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getCardapio(), codigoVenda, info, bancoDeDados.getListaProdutos()),
		"Tentando editar uma venda cadastrada com formato da data invalido");	
	}
	
	@Test
	void EditandoVendaCadastradaComFormatoDoHorarioInvalido() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[4];
		
		info[0] = "10/10/2022";
		info[1] = "10 10";
		info[2] = "Cachorro Quente";
		info[3] = "Pix";

		assertThrows(FormatoHorarioInvalido.class, () -> gerenciaVendas.editarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getCardapio(), codigoVenda, info, bancoDeDados.getListaProdutos()),
		"Tentando editar uma venda cadastrada com formato do horario invalido");	
	}
	
	@Test
	void EditandoVendaCadastradaComQuantidadeDeProdutosInsuficiente() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[4];
		
		info[0] = "10/10/2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente Duplo, Cachorro Quente Duplo";
		info[3] = "Pix";

		assertThrows(QuantidadeProdutosInsuficiente.class, () -> gerenciaVendas.editarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getCardapio(), codigoVenda, info, bancoDeDados.getListaProdutos()),
		"Tentando editar uma venda cadastrada com quantidade de produtos insuficientes");	
	}
	
	@Test
	void EditandoVendaEmListaNaoInstanciada() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		String [] info = new String[4];
		
		info[0] = "10/10/2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente";
		info[3] = "Pix";

		assertThrows(ErroGrave.class, () -> gerenciaVendas.editarVenda(null, bancoDeDados.getCardapio(), codigoVenda, info, bancoDeDados.getListaProdutos()),
		"Tentando editar uma venda em uma lista nao instanciada");	
	}
	
	@Test
	void EditandoVendaCadastradaComDoisPratosCadastrados() throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave, VendaNaoCadastrada {
		String [] info = new String[4];
		
		info[0] = "10/10/2022";
		info[1] = "10:10";
		info[2] = "Cachorro Quente, Cachorro Quente, Cachorro Quente";
		info[3] = "Pix";
		
		gerenciaVendas.editarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getCardapio(), codigoVenda, info, bancoDeDados.getListaProdutos());
		
		assertEquals(0, bancoDeDados.getListaProdutos().size(), "Verificando se os produtos sobresalentes da venda foram removidos da lista de produtos");
	}
	
	@Test
	void ExcluindoVendaCadastrada() throws VendaNaoCadastrada, ErroGrave {
		assertTrue(gerenciaVendas.excluirVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), codigoVenda),
		"Tentando excluir uma venda cadastrada");
	}
	
	@Test
	void ExcluindoVendaNaoCadastrada() throws VendaNaoCadastrada, ErroGrave {
		assertThrows(VendaNaoCadastrada.class, () -> gerenciaVendas.excluirVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), "-999"),
		"Tentando excluir uma venda nao cadastrada");
	}
	
	@Test
	void ExcluindoVendaEmListaNaoInstanciada() throws VendaNaoCadastrada, ErroGrave {
		assertThrows(ErroGrave.class, () -> gerenciaVendas.excluirVenda(null, bancoDeDados.getListaIds(), codigoVenda),
		"Tentando excluir uma venda em lista nao instanciada");
	}

	@Test
	void ExcluindoTresVendasCadastradas() throws VendaNaoCadastrada, ErroGrave, PratoNaoCadastrado, QuantidadeProdutosInsuficiente {
String [] infoVenda = new String[2];
		
		infoVenda[0] = "Cachorro Quente";
		infoVenda[1] = "Pix";
		
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda, bancoDeDados.getListaProdutos());
		
		String codigoVenda2 = bancoDeDados.getListaVendas().get(1).getId();
	
		infoVenda[0] = "Cachorro Quente";
		infoVenda[1] = "Pix";
		
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda, bancoDeDados.getListaProdutos());
	
		String codigoVenda3 = bancoDeDados.getListaVendas().get(2).getId();
		
		gerenciaVendas.excluirVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), codigoVenda);
		gerenciaVendas.excluirVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), codigoVenda2);
		gerenciaVendas.excluirVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), codigoVenda3);
		
		assertEquals(0, bancoDeDados.getListaVendas().size(), "Verificando se a lista esta vazia apos a exclusao dos tres vendas cadastradas");
	}
	
}
