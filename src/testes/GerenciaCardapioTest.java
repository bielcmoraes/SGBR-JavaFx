package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.ErroGrave;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoIngredientesInvalido;
import exceptions.FormatoQuantidadeInvalido;
import exceptions.FornecedorNaoCadastrado;
import exceptions.PratoNaoCadastrado;
import exceptions.PrecoInvalido;
import exceptions.ProdutoNaoCadastrado;
import exceptions.QuantidadeInvalida;
import model.BancoDeDados;
import model.GerenciaCardapio;
import model.GerenciaFornecedor;
import model.GerenciaProdutos;

class GerenciaCardapioTest {
	
	GerenciaFornecedor gerenciaFornecedores = new GerenciaFornecedor();
	GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
	GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
	String codigoPrato;
	
	@Test
	void cadastrandoPratoComDadosValidos() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave {
		
		String [] info = new String[5];
		
		info[0] = "Cachorro Quente";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "1;un;Salsicha;1;un;Pao;";
		
		assertTrue(gerenciaCardapio.cadastrarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaProdutos(), info),
		"Tentando cadastrar um prato com dados validos");
	}
	
	@Test
	void cadastrandoPratoComPrecoInvalido() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave {
		
		String [] info = new String[5];
		
		info[0] = "Cachorro Quente";
		info[1] = "Dois";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "1;un;Salsicha;1;un;Pao;";
		
		assertThrows(PrecoInvalido.class, () -> gerenciaCardapio.cadastrarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaProdutos(), info),
		"Tentando cadastrar um prato com preco invalido");
	}
	
	@Test
	void cadastrandoPratoComPrecoNegativo() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave {
		
		String [] info = new String[5];
		
		info[0] = "Cachorro Quente";
		info[1] = "-1";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "1;un;Salsicha;1;un;Pao;";
		
		assertThrows(PrecoInvalido.class, () -> gerenciaCardapio.cadastrarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaProdutos(), info),
		"Tentando cadastrar um prato com preco negativo");
	}
	
	@Test
	void cadastrandoPratoComQuantidadeDoPrimeiroIngredienteInvalida() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave {
		
		String [] info = new String[5];
		
		info[0] = "Cachorro Quente";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "uma;un;Salsicha;1;un;Pao;";
		
		assertThrows(QuantidadeInvalida.class, () -> gerenciaCardapio.cadastrarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaProdutos(), info),
		"Tentando cadastrar um prato com quantidade do primeiro ingrediente invalida");
	}
	
	@Test
	void cadastrandoPratoComQuantidadeDoPrimeiroIngredienteNegativa() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave {
		
		String [] info = new String[5];
		
		info[0] = "Cachorro Quente";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "-1;un;Salsicha;1;un;Pao;";
		
		assertThrows(QuantidadeInvalida.class, () -> gerenciaCardapio.cadastrarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaProdutos(), info),
		"Tentando cadastrar um prato com quantidade do primeiro ingrediente negativa");
	}
	
	@Test
	void cadastrandoPratoComProdutoNaoCadastrado() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave {
		
		String [] info = new String[5];
		
		info[0] = "Cachorro Quente";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "1;un;SalsichaVegana;1;un;Pao;";
		
		assertThrows(ProdutoNaoCadastrado.class, () -> gerenciaCardapio.cadastrarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaProdutos(), info),
		"Tentando cadastrar um prato com produto nao cadastrado");
	}
	
	@Test
	void cadastrandoPratoComFormatoDosIngredientesInvalido() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave {
		
		String [] info = new String[5];
		
		info[0] = "Cachorro Quente";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "Uma salsicha e um pao";
		
		assertThrows(FormatoIngredientesInvalido.class, () -> gerenciaCardapio.cadastrarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaProdutos(), info),
		"Tentando cadastrar um prato com formato dos ingredientes invalido");
	}
	
	@Test
	void cadastrandoPratoEmListaNaoInstanciada() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave {
		
		String [] info = new String[5];
		
		info[0] = "Cachorro Quente";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "1;un;Salsicha;1;un;Pao;";
		
		assertThrows(ErroGrave.class, () -> gerenciaCardapio.cadastrarPrato(null, BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaProdutos(), info),
		"Tentando cadastrar um prato em uma lista nao instanciada");
	}
	/*
	@Test
	void cadastrandoTresPratoComDadosValidos() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave {
		
		String [] info = new String[5];
		
		info[0] = "Cachorro Quente Duplo";
		info[1] = "3";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "2;un;Salsicha;1;un;Pao;";
		
		gerenciaCardapio.cadastrarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaProdutos(), info);
		
		info[0] = "Cachorro Quente Triplo";
		info[1] = "4";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "3;un;Salsicha;1;un;Pao;";
		
		gerenciaCardapio.cadastrarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaProdutos(), info);
		
		assertEquals(3, BancoDeDados.getInstance().getCardapio().size(), "Verificando tamanho do cardapio apos o cadastros de tres pratos");
	}
	*/
	
	@BeforeEach
	void cadastrarPrato() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave {
		String [] info = new String[5];
		
		info[0] = "Cachorro Quente";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "1;un;Salsicha;1;un;Pao;";
		
		gerenciaCardapio.cadastrarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaProdutos(), info);
		
		codigoPrato = BancoDeDados.getInstance().getCardapio().get(0).getId();
	}
	
	@Test
	void editandoPratoCadastradoComDadosValidos() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave, PratoNaoCadastrado {
		String [] info = new String[5];
		
		info[0] = "Dogao";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "1;un;Salsicha;1;un;Pao;";
		
		assertTrue(gerenciaCardapio.editarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaProdutos(), codigoPrato, info),
		"Tentando editar um prato cadastrado com os dados validos");
	}
	
	@Test
	void editandoPratoCadastradoComPrecoInvalido() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave, PratoNaoCadastrado {
		String [] info = new String[5];
		
		info[0] = "Dogao";
		info[1] = "Dois";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "1;un;Salsicha;1;un;Pao;";
		
		assertThrows(PrecoInvalido.class, () -> gerenciaCardapio.editarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaProdutos(), codigoPrato, info),
		"Tentando editar um prato cadastrado com preco invalido");
	}
	
	@Test
	void editandoPratoCadastradoComPrecoNegativo() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave, PratoNaoCadastrado {
		String [] info = new String[5];
		
		info[0] = "Dogao";
		info[1] = "-1";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "1;un;Salsicha;1;un;Pao;";
		
		assertThrows(PrecoInvalido.class, () -> gerenciaCardapio.editarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaProdutos(), codigoPrato, info),
		"Tentando editar um prato cadastrado com preco negativo");
	}
	
	@Test
	void editandoPratoCadastradoComQuantidadeInvalida() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave, PratoNaoCadastrado {
		String [] info = new String[5];
		
		info[0] = "Dogao";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "uma;un;Salsicha;1;un;Pao;";
		
		assertThrows(QuantidadeInvalida.class, () -> gerenciaCardapio.editarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaProdutos(), codigoPrato, info),
		"Tentando editar um prato cadastrado com quantidade invalida");
	}
	
	@Test
	void editandoPratoCadastradoComQuantidadeDoPrimeiroIngredienteNegativa() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave, PratoNaoCadastrado {
		String [] info = new String[5];
		
		info[0] = "Dogao";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "-1;un;Salsicha;1;un;Pao;";
		
		assertThrows(QuantidadeInvalida.class, () -> gerenciaCardapio.editarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaProdutos(), codigoPrato, info),
		"Tentando editar um prato cadastrado com quantidade do primeiro ingrediente negativa");
	}
	
	@Test
	void editandoPratoCadastradoComFormatoDoIngredienteInvalido() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave, PratoNaoCadastrado {
		String [] info = new String[5];
		
		info[0] = "Dogao";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "Uma salsicha e um pao";
		
		assertThrows(FormatoIngredientesInvalido.class, () -> gerenciaCardapio.editarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaProdutos(), codigoPrato, info),
		"Tentando editar um prato cadastrado com formato dos ingredientes invalido");
	}
	
	@Test
	void editandoPratoEmListaNaoInstanciada() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave, PratoNaoCadastrado {
		String [] info = new String[5];
		
		info[0] = "Dogao";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "1;un;Salsicha;1;un;Pao;";
		
		assertThrows(ErroGrave.class, () -> gerenciaCardapio.editarPrato(null, BancoDeDados.getInstance().getListaProdutos(), codigoPrato, info),
		"Tentando editar um prato em lista nao instanciada");
	}
	
	@Test
	void editandoPratoNaoCadastrado() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave, PratoNaoCadastrado {
		String [] info = new String[5];
		
		info[0] = "Dogao";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "1;un;Salsicha;1;un;Pao;";
		
		assertThrows(PratoNaoCadastrado.class, () -> gerenciaCardapio.editarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaProdutos(), "-999", info),
		"Tentando editar um prato nao cadastrado");
	}
	
	@Test
	void editandoPratoComPrimeiroIngredienteNaoCadastrado() throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave, PratoNaoCadastrado {
		String [] info = new String[5];
		
		info[0] = "Dogao";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "1;un;SalsichaVegana;1;un;Pao;";
		
		assertThrows(ProdutoNaoCadastrado.class, () -> gerenciaCardapio.editarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaProdutos(), codigoPrato, info),
		"Tentando editar um prato com primeiro ingrediente nao cadastrado");
	}
	
	@Test
	void ExcluindoPratoCadastrado() throws ErroGrave, PratoNaoCadastrado {
		assertTrue(gerenciaCardapio.excluirPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), codigoPrato),
		"Tentando excluir um prato cadastrado");
	}
	
	@Test
	void ExcluindoPratoEmListaNaoInstanciada() throws ErroGrave, PratoNaoCadastrado {
		assertThrows(ErroGrave.class, () -> gerenciaCardapio.excluirPrato(null, BancoDeDados.getInstance().getListaIds(), codigoPrato),
		"Tentando excluir um prato em uma lista nao instanciada");
	}
	
	@Test
	void ExcluindoPratoNaoCadastrado() throws ErroGrave, PratoNaoCadastrado {
		assertThrows(PratoNaoCadastrado.class, () -> gerenciaCardapio.excluirPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), "-999"),
		"Tentando excluir um prato nao cadastrado");
	}
	
	@Test
	void ExcluindoTresPratosCadastrados() throws ErroGrave, PratoNaoCadastrado, PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido {
		String [] info = new String[5];
		
		info[0] = "Cachorro Duplo";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "2;un;Salsicha;1;un;Pao;";
		
		gerenciaCardapio.cadastrarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaProdutos(), info);
		
		String codigoPrato2 = BancoDeDados.getInstance().getCardapio().get(1).getId();
		
		info[0] = "Cachorro Triplo";
		info[1] = "2";
		info[2] = "Cachorro quente simples";
		info[3] = "Lanche";
		info[4] = "3;un;Salsicha;1;un;Pao;";
		
		gerenciaCardapio.cadastrarPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), BancoDeDados.getInstance().getListaProdutos(), info);
		
		String codigoPrato3 = BancoDeDados.getInstance().getCardapio().get(2).getId();
		
		gerenciaCardapio.excluirPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), codigoPrato);
		gerenciaCardapio.excluirPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), codigoPrato2);
		gerenciaCardapio.excluirPrato(BancoDeDados.getInstance().getCardapio(), BancoDeDados.getInstance().getListaIds(), codigoPrato3);
		
		assertEquals(3, BancoDeDados.getInstance().getCardapio().size(),
		"Verificando se a lista esta vazia apos a exclusao dos tres pratos cadastrados");
	}
	
}
