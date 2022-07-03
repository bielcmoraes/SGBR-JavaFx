package testes;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.ErroGrave;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoQuantidadeInvalido;
import exceptions.FornecedorNaoCadastrado;
import exceptions.PrecoInvalido;
import exceptions.ProdutoNaoCadastrado;
import exceptions.QuantidadeInvalida;
import model.BancoDeDados;
import model.GerenciaFornecedor;
import model.GerenciaProdutos;

class GerenciaProdutoTest {
	
	GerenciaProdutos gerenciaProduto = new GerenciaProdutos();
	GerenciaFornecedor gerenciaFornecedor = new GerenciaFornecedor();
	String codigoProduto;
	
	@Test
	void cadastrandoProdutoComDadosValidos() throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";
		assertTrue(gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando cadastrar um produto com dados validos");
	}
	
	@Test
	void cadastrandoProdutoComPrecoInvalido() {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "Dez";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";

		assertThrows(PrecoInvalido.class, () -> gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando cadastrar um produto com preco invalido");	
	}
	
	@Test
	void cadastrandoProdutoComPrecoNegativo() {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "-1";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";

		assertThrows(PrecoInvalido.class, () -> gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando cadastrar um produto com preco negativo");	
	}
	
	@Test
	void cadastrandoProdutoComFormatoDaQuantidadeInvalido() {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10";
		info[3] = "28/07/2022";
		info[4] = "Joao";

		assertThrows(FormatoQuantidadeInvalido.class, () -> gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando cadastrar um produto com formato da quantidade invalido");	
	}
	
	@Test
	void cadastrandoProdutoComQuantidadeInvalida() {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "Dez kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";

		assertThrows(QuantidadeInvalida.class, () -> gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando cadastrar um produto com quantidade invalida");	
	}
	
	@Test
	void cadastrandoProdutoComQuantidadeNegativa() {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "-1 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";

		assertThrows(QuantidadeInvalida.class, () -> gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando cadastrar um produto com quantidade negativa");	
	}
	
	@Test
	void cadastrandoProdutoComFormatoDaDataInvalido() {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "28 07 2022";
		info[4] = "Joao";

		assertThrows(FormatoDataInvalido.class, () -> gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando cadastrar um produto com formato da data invalido");	
	}
	
	@Test
	void cadastrandoProdutoComFornecedorNaoCadastrado() {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Antonio";

		assertThrows(FornecedorNaoCadastrado.class, () -> gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando cadastrar um produto com fornecedor nao cadastrado");	
	}
	
	@Test
	void cadastrandoProdutoEmListaNaoInstanciada() {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";

		assertThrows(ErroGrave.class, () -> gerenciaProduto.cadastrarProduto(null, BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando cadastrar um produto em lista nao instanciada");	
	}
	
	@Test
	void cadastrandoTresProdutosDiferentesComDadosValidos() throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";
		gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores());
		
		info[0] = "Carne";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";
		gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores());
		
		info[0] = "Peixe";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "08/01/2022";
		info[4] = "Joao";
		gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores());
		
		assertEquals(7, BancoDeDados.getInstance().getListaProdutos().size(), "Verificando tamanho das lista de produtos apos o cadastros de tres produtos diferentes");
	}
	
	@Test
	void cadastrandoTresProdutosIguaisComDadosValidos() throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";
		gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores());
		
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "02/04/2022";
		info[4] = "Joao";
		gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores());
		
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "08/01/2022";
		info[4] = "Joao";
		gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores());
		
		assertEquals(7, BancoDeDados.getInstance().getListaProdutos().size(), "Verificando tamanho das lista de produtos apos o cadastros de tres produtos iguais");
	}
	
	@BeforeEach
	void cadastrarProduto() throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave{
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";
		gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores());
		codigoProduto = BancoDeDados.getInstance().getListaProdutos().get("Frango").get(0).getId();
	}
	
	@Test
	void EditandoProdutoCadastradoComDadosValidos() throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";

		assertTrue(gerenciaProduto.editarProduto(BancoDeDados.getInstance().getListaProdutos(), codigoProduto, info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando editar um produto cadastrado com dados validos");	
	}
	
	@Test
	void EditandoProdutoCadastradoComPrecoInvalido() throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "Dez";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";

		assertThrows(PrecoInvalido.class, () -> gerenciaProduto.editarProduto(BancoDeDados.getInstance().getListaProdutos(), codigoProduto, info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando editar um produto cadastrado com preco invalido");	
	}
	
	@Test
	void EditandoProdutoCadastradoComPrecoNegativo() throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "-1";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";

		assertThrows(PrecoInvalido.class, () -> gerenciaProduto.editarProduto(BancoDeDados.getInstance().getListaProdutos(), codigoProduto, info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando editar um produto cadastrado com preco negativo");	
	}
	
	@Test
	void EditandoProdutoCadastradoComFormatoDaQuantidadeInvalido() throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10";
		info[3] = "28/07/2022";
		info[4] = "Joao";

		assertThrows(FormatoQuantidadeInvalido.class, () -> gerenciaProduto.editarProduto(BancoDeDados.getInstance().getListaProdutos(), codigoProduto, info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando editar um produto cadastrado com formato da quantidade invalido");	
	}
	
	@Test
	void EditandoProdutoCadastradoComQuantidadeInvalida() throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "Dez kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";

		assertThrows(QuantidadeInvalida.class, () -> gerenciaProduto.editarProduto(BancoDeDados.getInstance().getListaProdutos(), codigoProduto, info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando editar um produto cadastrado com quantidade invalida");	
	}
	
	@Test
	void EditandoProdutoCadastradoComQuantidadeNegativa() throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "-1 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";

		assertThrows(QuantidadeInvalida.class, () -> gerenciaProduto.editarProduto(BancoDeDados.getInstance().getListaProdutos(), codigoProduto, info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando editar um produto cadastrado com quantidade negativa");	
	}
	
	@Test
	void EditandoProdutoCadastradoComFormatoDaDataInvalido() throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "28 07 2022";
		info[4] = "Joao";

		assertThrows(FormatoDataInvalido.class, () -> gerenciaProduto.editarProduto(BancoDeDados.getInstance().getListaProdutos(), codigoProduto, info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando editar um produto cadastrado com formato da data invalido");	
	}
	
	@Test
	void EditandoProdutoCadastradoComFornecedorNaoCadastrado() throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Antonio";

		assertThrows(FornecedorNaoCadastrado.class, () -> gerenciaProduto.editarProduto(BancoDeDados.getInstance().getListaProdutos(), codigoProduto, info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando editar um produto cadastrado com fornecedor nao cadastrado");	
	}
	
	@Test
	void EditandoProdutoEmListaNaoInstanciada() throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		
		String [] info = new String[5] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";

		assertThrows(ErroGrave.class, () -> gerenciaProduto.editarProduto(null, codigoProduto, info, BancoDeDados.getInstance().getListaFornecedores()),
		"Tentando editar um produto cadastrado com fornecedor nao cadastrado");	
	}
	
	@Test
	void ExcluindoProdutoCadastrado() throws ProdutoNaoCadastrado, ErroGrave{

		assertTrue(gerenciaProduto.excluirProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), codigoProduto),
		"Tentando ecluir um produto cadastrado");	
	}
	/*
	@Test
	void ExcluindoProdutoNaoCadastrado() throws ProdutoNaoCadastrado, ErroGrave{

		assertThrows(ProdutoNaoCadastrado.class, () -> gerenciaProduto.excluirProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), "-999"),
		"Tentando excluir um produto nao cadastrado");	
	}*/
	
	@Test
	void ExcluindoProdutoEmListaNaoInstanciada() throws ProdutoNaoCadastrado, ErroGrave{

		assertThrows(ErroGrave.class, () -> gerenciaProduto.excluirProduto(null, BancoDeDados.getInstance().getListaIds(), codigoProduto),
		"Tentando excluir um produto em lista nao instanciada");
	}
	
	
	@Test
	void ExcluindoTresProdutosDiferentesCadastrados() throws ProdutoNaoCadastrado, ErroGrave, PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado{
		
		String [] info = new String[5] ;
		
		info[0] = "Carne";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "28/07/2022";
		info[4] = "Joao";
		gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores());
		String codigoProduto2 = BancoDeDados.getInstance().getListaProdutos().get("Carne").get(0).getId();
		
		info[0] = "Peixe";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "08/01/2022";
		info[4] = "Joao";
		gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores());
		String codigoProduto3 = BancoDeDados.getInstance().getListaProdutos().get("Peixe").get(0).getId();
		
		gerenciaProduto.excluirProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), codigoProduto);
		gerenciaProduto.excluirProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), codigoProduto2);
		gerenciaProduto.excluirProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), codigoProduto3);
		
		assertEquals(5, BancoDeDados.getInstance().getListaProdutos().size(), "Verificando tamanho das lista de produtos apos o exclusão de tres produtos diferentes");	
	}
	
	@Test
	void ExcluindoTresProdutosIguaisCadastrados() throws ProdutoNaoCadastrado, ErroGrave, PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado{
		
		String [] info = new String[5] ;
		
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "02/04/2022";
		info[4] = "Joao";
		gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores());
		String codigoProduto2 = BancoDeDados.getInstance().getListaProdutos().get("Frango").get(1).getId();
		
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "10 kg";
		info[3] = "08/01/2022";
		info[4] = "Joao";
		gerenciaProduto.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores());
		String codigoProduto3 = BancoDeDados.getInstance().getListaProdutos().get("Frango").get(2).getId();
		
		gerenciaProduto.excluirProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), codigoProduto);
		gerenciaProduto.excluirProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), codigoProduto2);
		gerenciaProduto.excluirProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), codigoProduto3);
		
		assertEquals(5, BancoDeDados.getInstance().getListaProdutos().size(), "Verificando tamanho das lista de produtos apos o exclusão de tres produtos iguais");
	}
}


