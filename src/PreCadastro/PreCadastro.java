package PreCadastro;

import exceptions.ErroGrave;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoIngredientesInvalido;
import exceptions.FormatoQuantidadeInvalido;
import exceptions.FornecedorNaoCadastrado;
import exceptions.PratoNaoCadastrado;
import exceptions.PrecoInvalido;
import exceptions.ProdutoNaoCadastrado;
import exceptions.QuantidadeInvalida;
import exceptions.QuantidadeProdutosInsuficiente;
import model.BancoDeDados;
import model.GerenciaCardapio;
import model.GerenciaFornecedor;
import model.GerenciaProdutos;
import model.GerenciaVendas;

public class PreCadastro {
	
	public void PreCadastrarProdutos (BancoDeDados bancoDeDados) {
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		
		String [] info = new String[5];
		info[0] = "Batata";//nome;
		info[1] = "10";//preco;
		info[2] = "100 kg";//quantidade;
		info[3] = "10/10/2022";//validade;
		info[4] = "Joao, Maria";//fornecedores;
		try {
			gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info, bancoDeDados.getListaFornecedores());
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Leite";//nome;
		info[1] = "12";//preco;
		info[2] = "30 l";//quantidade;
		info[3] = "20/10/2022";//validade;
		info[4] = "Maria";//fornecedores;
		try {
			gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info, bancoDeDados.getListaFornecedores());
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Pao";//nome;
		info[1] = "0.5";//preco;
		info[2] = "1 un";//quantidade;
		info[3] = "15/09/2022";//validade;
		info[4] = "Jose";//fornecedores;
		try {
			gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info, bancoDeDados.getListaFornecedores());
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Pao";//nome;
		info[1] = "0.5";//preco;
		info[2] = "1 un";//quantidade;
		info[3] = "02/09/2021";//validade;
		info[4] = "Jose";//fornecedores;
		try {
			gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info, bancoDeDados.getListaFornecedores());
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Pao";//nome;
		info[1] = "0.5";//preco;
		info[2] = "1 un";//quantidade;
		info[3] = "01/09/2020";//validade;
		info[4] = "Jose";//fornecedores;
		try {
			gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info, bancoDeDados.getListaFornecedores());
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Salsicha";//nome;
		info[1] = "2";//preco;
		info[2] = "50 un";//quantidade;
		info[3] = "20/08/2022";//validade;
		info[4] = "Jose";//fornecedores;
		try {
			gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info, bancoDeDados.getListaFornecedores());
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Salsicha";//nome;
		info[1] = "2";//preco;
		info[2] = "10 un";//quantidade;
		info[3] = "25/10/2022";//validade;
		info[4] = "Jose";//fornecedores;
		try {
			gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info, bancoDeDados.getListaFornecedores());
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
	}
	
	public void PreCadastrarFornecedores (BancoDeDados bancoDeDados){
		GerenciaFornecedor gerenciaFornecedor = new GerenciaFornecedor();
		
		String [] info = new String[3];
		info[0] = "Joao";//nome;
		info[1] = "77.994.900/0001-26";//cnpj;
		info[2] = "Rua A";//endereco;
		try {
			gerenciaFornecedor.cadastrarFornecedor(bancoDeDados.getListaFornecedores(), bancoDeDados.getListaIds(), info);
		} catch (ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Maria";//nome;
		info[1] = "37.889.838/0001-98";//cnpj;
		info[2] = "Rua B";//endereco;
		try {
			gerenciaFornecedor.cadastrarFornecedor(bancoDeDados.getListaFornecedores(), bancoDeDados.getListaIds(), info);
		} catch (ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Jose";//nome;
		info[1] = "37.889.838/0001-98";//cnpj;
		info[2] = "Rua C";//endereco;
		try {
			gerenciaFornecedor.cadastrarFornecedor(bancoDeDados.getListaFornecedores(), bancoDeDados.getListaIds(), info);
		} catch (ErroGrave e) {
			System.out.println(e.toString());
		}
	}
	
	public void PreCadastrarPratos (BancoDeDados bancoDeDados) {
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		String [] info = new String[5];
		
		info[0] = "Cachorro Quente";//nome;
		info[1] = "12";//preco;
		info[2] = "Cachorro Quente Simples";//descricao;
		info[3] = "Lanche";//categoria;
		info[4] = "1;un;Salsicha;1;un;Pao;";//ingredientes;

		try {
			gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), info);
		} catch (PrecoInvalido | QuantidadeInvalida | ProdutoNaoCadastrado | FormatoIngredientesInvalido
				| ErroGrave e1) {
			System.out.println(e1.toString());
		}

		
		info[0] = "Pure de Batata";//nome;
		info[1] = "5";//preco;
		info[2] = "Pure de Batata Simples";//descricao;
		info[3] = "Acompanhamento";//categoria;
		info[4] = "0.5;kg;Batata;0.5;l;Leite;";//ingredientes;

		try {
			gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), info);
		} catch (PrecoInvalido | QuantidadeInvalida | ProdutoNaoCadastrado | FormatoIngredientesInvalido
				| ErroGrave e) {
			System.out.println(e.toString());
		}
	
	}
	
	public void preCadastrarVendas(BancoDeDados bancoDeDados) {
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] info = new String[2];
		
		info[0] = "Cachorro Quente";
		info[1] = "Pix";
		
		try {
			gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), info, bancoDeDados.getListaProdutos());
		} catch (PratoNaoCadastrado | QuantidadeProdutosInsuficiente | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Pure de Batata";
		info[1] = "Dinheiro";
		
		try {
			gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), info, bancoDeDados.getListaProdutos());
		} catch (PratoNaoCadastrado | QuantidadeProdutosInsuficiente | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Cachorro Quente, Pure de Batata";
		info[1] = "Credito";
		
		try {
			gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), info, bancoDeDados.getListaProdutos());
		} catch (PratoNaoCadastrado | QuantidadeProdutosInsuficiente | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Pure de Batata, Cachorro Quente";
		info[1] = "Dinheiro";

		try {
			gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), info, bancoDeDados.getListaProdutos());
		} catch (PratoNaoCadastrado | QuantidadeProdutosInsuficiente | ErroGrave e) {
			System.out.println(e.toString());
		}
		
	}
}
