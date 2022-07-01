package model;

import java.util.ArrayList;
import java.util.HashMap;

import PreCadastro.PreCadastro;

/**Classe responsável por instanciar todos os ArrayList's que são utilizados no programa.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 *
 */
public class BancoDeDados {
	
	private ArrayList<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
	private ArrayList<Prato> cardapio = new ArrayList<Prato>();
	private HashMap<String, ArrayList<Produto>> listaProdutos = new HashMap<String, ArrayList<Produto>>();
	private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private ArrayList<Venda> listaVendas = new ArrayList<Venda>();
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private ArrayList<String> listaIds = new ArrayList<String>();
	
	private static BancoDeDados instancia;
	
	
	
	private BancoDeDados() {
		PreCadastro preCadastro = new PreCadastro();
		preCadastro.PreCadastrarFornecedores(listaFornecedores, listaIds);
		preCadastro.PreCadastrarProdutos(listaProdutos, listaIds, listaFornecedores);
		preCadastro.PreCadastrarPratos(cardapio, listaIds, listaProdutos);
		preCadastro.preCadastrarClientes(listaClientes, listaIds);
		preCadastro.preCadastrarVendas(listaVendas, listaIds, cardapio, listaProdutos, listaClientes);
	}
	
	public static synchronized BancoDeDados getInstance() {
		if(instancia == null) {
			instancia = new BancoDeDados();
		}
		return instancia;
	}
	
	/**Metódo para retorno da lista de fornecedores
	 * @return Retorna o atributo privado listaFornecedores*/
	public ArrayList<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}
	
	/**Metódo para retorno da lista de produtos
	 * @return Retorna o atributo privado listaProdutos*/
	public HashMap<String, ArrayList<Produto>> getListaProdutos() {
		return listaProdutos;
	}
	
	/**Metódo para retorno da lista de Usuarios
	 * @return Retorna o atributo privado listaUsuarios*/
	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	
	/**Metódo para retorno da lista de vendas
	 * @return Retorna o atributo privado listaVendas*/
	public ArrayList<Venda> getListaVendas() {
		return listaVendas;
	}
	
	/**Metódo para retorno da lista de pratos
	 * @return Retorna o atributo privado cardapio*/
	public ArrayList<Prato> getCardapio() {
		return cardapio;
	}
	
	/**Metódo para retorno da lista de clientes
	 * @return Retorna o atributo privado listaClientes*/
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	/**Metódo para retorno da lista de id's
	 * @return Retorna o atributo privado listaIds*/
	public ArrayList<String> getListaIds() {
		return listaIds;
	}
	
}
