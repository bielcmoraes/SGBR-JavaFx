package model;

import java.util.ArrayList;
import java.util.HashMap;

/**Classe para objetos do tipo Prato, onde são contidos, valores e metódos necessarios para implementação da classe.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 * @see Entidade
 */
public class Prato extends Entidade{
	
	// Attributes
	private String nome;
	private Double preco;
	private String descricao;
	private String categoria;
	private HashMap<String, ArrayList<Produto>> produtos;
	private HashMap<String, Double> receita;
	
	/**O construtor inicializa o costrutor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro. 
	 * 
	 * @param listaIds Lista de id's
	 * @param nome Nome do prato
	 * @param preco Preço do prato
	 * @param descricao Descrição do prato
	 * @param categoria Categoria do prato
	 * @param produtos Produtos que compõem o prato
	 * @param receita Ingredientes e quantidade utilizado no produto
	 */
	public Prato(ArrayList<String> listaIds, String nome, Double preco, String descricao, String categoria, HashMap<String, ArrayList<Produto>> produtos, HashMap<String, Double> receita) {
		
		super(listaIds);
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.categoria = categoria;
		this.produtos = produtos;
		this.receita = receita;
	}
	
	/**Metódo para retorno de nome do prato.
	 * @return String Nome do prato*/
	public String getNome() {
		return nome;
	}
	
	/**Metódo para alterar o nome do prato.
	 * @param nome Novo nome do prato*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**Metódo para retorno de preço do prato.
	 * @return Double Preço do prato*/
	public Double getPreco() {
		return preco;
	}
	
	/**Metódo para alterar o preço do prato.
	 * @param preco Novo preço do prato*/
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	/**Metódo para retorno de descrição do prato.
	 * @return String Descrição do prato*/
	public String getDescricao() {
		return descricao;
	}
	
	/**Metódo para alterar a descrição do prato.
	 * @param descricao Nova descrição do prato*/
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**Metódo para retorno de categoria do prato.
	 * @return String Categoria do prato*/
	public String getCategoria() {
		return categoria;
	}
	
	/**Metódo para alterar a categoria do prato.
	 * @param categoria Nova categoria do prato*/
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**Metódo para retorno de lista de produtos utilizados no prato.
	 * @return produtos Lista de produtos*/
	public HashMap<String, ArrayList<Produto>> getProdutos() {
		return produtos;
	}

	/**Metódo para alterar a lista de produtos utilizados no prato.
	 * @param produtos Novos produtos do prato*/
	public void setProdutos(HashMap<String, ArrayList<Produto>> produtos) {
		this.produtos = produtos;
	}

	/**Metódo para retorno de lista da receita do prato.
	 * @return receita Receita do prato*/
	public HashMap<String, Double> getReceita() {
		return receita;
	}

	/**Metódo para alterar a receita do prato.
	 * @param receita Nova receita do prato*/
	public void setReceita(HashMap<String, Double> receita) {
		this.receita = receita;
	}

	public String getProdutosToString() {
		
		String produtosTemp = "";
		for(String produto : receita.keySet()) { 
			produtosTemp += produto + ", ";
		}
		
		produtosTemp = produtosTemp.substring(0, produtosTemp.length()-2);
		return produtosTemp;
	}
	
	public String toString() {
		return this.nome;
		
	}
}
