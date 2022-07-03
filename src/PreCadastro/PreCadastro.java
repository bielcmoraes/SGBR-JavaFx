package PreCadastro;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.ClienteNaoCadastrado;
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
import model.Cliente;
import model.Fornecedor;
import model.GerenciaCardapio;
import model.GerenciaCliente;
import model.GerenciaFornecedor;
import model.GerenciaProdutos;
import model.GerenciaVendas;
import model.Prato;
import model.Produto;
import model.Venda;

public class PreCadastro {
	
	public void PreCadastrarProdutos (HashMap<String, ArrayList<Produto>> listaProdutos, ArrayList<String> listaIds, ArrayList<Fornecedor> listaFornecedor) {
		
		
		String [] info = new String[5];
		info[0] = "Batata"; //nome;
		info[1] = "10"; //preco;
		info[2] = "300 kg"; //quantidade;
		info[3] = "10/10/2022"; //validade;
		info[4] = "Joao, Maria"; //fornecedores;
		try {
			GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
			gerenciaProdutos.cadastrarProduto(listaProdutos, listaIds, info, listaFornecedor);
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Leite";//nome;
		info[1] = "12";//preco;
		info[2] = "200 l";//quantidade;
		info[3] = "20/10/2022";//validade;
		info[4] = "Maria";//fornecedores;
		try {
			GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
			gerenciaProdutos.cadastrarProduto(listaProdutos, listaIds, info, listaFornecedor);
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Leite";//nome;
		info[1] = "12";//preco;
		info[2] = "300 l";//quantidade;
		info[3] = "28/10/2021";//validade;
		info[4] = "Joao, Maria";//fornecedores;
		try {
			GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
			gerenciaProdutos.cadastrarProduto(listaProdutos, listaIds, info, listaFornecedor);
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Pao";//nome;
		info[1] = "0.5";//preco;
		info[2] = "10 un.";//quantidade;
		info[3] = "15/09/2022";//validade;
		info[4] = "Jose";//fornecedores;
		try {
			GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
			gerenciaProdutos.cadastrarProduto(listaProdutos, listaIds, info, listaFornecedor);
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Pao";//nome;
		info[1] = "0.5";//preco;
		info[2] = "1 un.";//quantidade;
		info[3] = "15/09/2022";//validade;
		info[4] = "Jose";//fornecedores;
		try {
			GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
			gerenciaProdutos.cadastrarProduto(listaProdutos, listaIds, info, listaFornecedor);
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Pao";//nome;
		info[1] = "0.5";//preco;
		info[2] = "1 un.";//quantidade;
		info[3] = "02/09/2021";//validade;
		info[4] = "Jose";//fornecedores;
		try {
			GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
			gerenciaProdutos.cadastrarProduto(listaProdutos, listaIds, info, listaFornecedor);
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Pao";//nome;
		info[1] = "0.5";//preco;
		info[2] = "1 un.";//quantidade;
		info[3] = "01/09/2020";//validade;
		info[4] = "Jose";//fornecedores;
		try {
			GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
			gerenciaProdutos.cadastrarProduto(listaProdutos, listaIds, info, listaFornecedor);
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Salsicha";//nome;
		info[1] = "2";//preco;
		info[2] = "50 un.";//quantidade;
		info[3] = "20/08/2022";//validade;
		info[4] = "Jose";//fornecedores;
		try {
			GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
			gerenciaProdutos.cadastrarProduto(listaProdutos, listaIds, info, listaFornecedor);
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Salsicha";//nome;
		info[1] = "2";//preco;
		info[2] = "10 un.";//quantidade;
		info[3] = "25/10/2022";//validade;
		info[4] = "Jose";//fornecedores;
		try {
			GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
			gerenciaProdutos.cadastrarProduto(listaProdutos, listaIds, info, listaFornecedor);
		} catch (PrecoInvalido | FormatoQuantidadeInvalido | QuantidadeInvalida | FormatoDataInvalido
				| FornecedorNaoCadastrado | ErroGrave e) {
			System.out.println(e.toString());
		}
	}
	
	public void PreCadastrarFornecedores (ArrayList<Fornecedor> listaFornecedor, ArrayList<String> listaIds){
		
		String [] info = new String[3];
		info[0] = "Joao";//nome;
		info[1] = "77.994.900/0001-26";//cnpj;
		info[2] = "Rua A";//endereco;
		try {
			GerenciaFornecedor gerenciaFornecedor = new GerenciaFornecedor();
			gerenciaFornecedor.cadastrarFornecedor(listaFornecedor, listaIds, info, new ArrayList<String>());
		} catch (ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Maria";//nome;
		info[1] = "37.889.838/0001-98";//cnpj;
		info[2] = "Rua B";//endereco;
		try {
			GerenciaFornecedor gerenciaFornecedor = new GerenciaFornecedor();
			gerenciaFornecedor.cadastrarFornecedor(listaFornecedor, listaIds, info, new ArrayList<String>());
		} catch (ErroGrave e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Jose";//nome;
		info[1] = "29.742.904/0001-74";//cnpj;
		info[2] = "Rua C";//endereco;
		try {
			GerenciaFornecedor gerenciaFornecedor = new GerenciaFornecedor();
			gerenciaFornecedor.cadastrarFornecedor(listaFornecedor, listaIds, info, new ArrayList<String>());
		} catch (ErroGrave e) {
			System.out.println(e.toString());
		}
	}
	
	public void PreCadastrarPratos (ArrayList<Prato> cardapio, ArrayList<String> listaIds, HashMap<String, ArrayList<Produto>> listaProdutos) {
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		String [] info = new String[5];
		
		info[0] = "Cachorro Quente";//nome;
		info[1] = "12";//preco;
		info[2] = "Cachorro Quente Simples";//descricao;
		info[3] = "Lanche";//categoria;
		info[4] = "1;un;Salsicha;1;un;Pao;";//ingredientes;
		
		try {
			gerenciaCardapio.cadastrarPrato(cardapio, listaIds, listaProdutos, info);
		} catch (PrecoInvalido | QuantidadeInvalida | ProdutoNaoCadastrado | FormatoIngredientesInvalido
				| ErroGrave e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
		info[0] = "Pure de Batata";//nome;
		info[1] = "5";//preco;
		info[2] = "Pure de Batata Simples";//descricao;
		info[3] = "Lanche";//categoria;
		info[4] = "0.5;kg;Batata;0.5;l;Leite;";//ingredientes;

		try {
			gerenciaCardapio.cadastrarPrato(cardapio, listaIds, listaProdutos, info);
		} catch (PrecoInvalido | QuantidadeInvalida | ProdutoNaoCadastrado | FormatoIngredientesInvalido
				| ErroGrave e) {
			System.out.println(e.toString());
		}
	
	}
	
	public void preCadastrarClientes(ArrayList<Cliente> listaClientes, ArrayList<String> listaIds) {
		GerenciaCliente gerenciaCliente = new GerenciaCliente();
		
		String[] info = new String[4];
		
		info[0] = "Fernando Marcos Vinicius Melo";
		info[1] = "882.581.314-78";
		info[2] = "fernando_marcos_melo@termakui.com.br";
		info[3] = "(93) 2887-3478";
		
		try {
			gerenciaCliente.cadastrarCliente(listaClientes, listaIds, info);
		} catch (ErroGrave e) {
			e.printStackTrace();
		}
		
		info[0] = "Vinicius Lorenzo Elias Freitas";
		info[1] = "291.765.959-94";
		info[2] = "viniciuslorenzofreitas@simsvale.com.br";
		info[3] = "(55) 3554-7198";
		
		try {
			gerenciaCliente.cadastrarCliente(listaClientes, listaIds, info);
		} catch (ErroGrave e) {
			e.printStackTrace();
		}
	}
	
	public void preCadastrarVendas(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, ArrayList<Prato> cardapio, HashMap<String, ArrayList<Produto>> listaProdutos, ArrayList<Cliente> listaClientes) {
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] info = new String[3];
		
		info[0] = "Cachorro Quente";
		info[1] = "Pix";
		info[2] = "Fernando Marcos Vinicius Melo";
		
		try {
			gerenciaVendas.cadastrarVenda(listaVendas, listaIds, cardapio, info, listaProdutos, listaClientes);
		} catch (PratoNaoCadastrado | QuantidadeProdutosInsuficiente | ErroGrave | ClienteNaoCadastrado e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Pure de Batata";
		info[1] = "Dinheiro";
		info[2] = "Vinicius Lorenzo Elias Freitas";
		
		try {
			gerenciaVendas.cadastrarVenda(listaVendas, listaIds, cardapio, info, listaProdutos, listaClientes);
		} catch (PratoNaoCadastrado | QuantidadeProdutosInsuficiente | ErroGrave | ClienteNaoCadastrado e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Cachorro Quente, Pure de Batata";
		info[1] = "Cart�o";
		info[2] = "Fernando Marcos Vinicius Melo";
		
		try {
			gerenciaVendas.cadastrarVenda(listaVendas, listaIds, cardapio, info, listaProdutos, listaClientes);
		} catch (PratoNaoCadastrado | QuantidadeProdutosInsuficiente | ErroGrave | ClienteNaoCadastrado e) {
			System.out.println(e.toString());
		}
		
		info[0] = "Pure de Batata, Cachorro Quente";
		info[1] = "Dinheiro";
		info[2] = "Vinicius Lorenzo Elias Freitas";

		try {
			gerenciaVendas.cadastrarVenda(listaVendas, listaIds, cardapio, info, listaProdutos, listaClientes);
		} catch (PratoNaoCadastrado | QuantidadeProdutosInsuficiente | ErroGrave | ClienteNaoCadastrado e) {
			System.out.println(e.toString());
		}
		
	}
}
