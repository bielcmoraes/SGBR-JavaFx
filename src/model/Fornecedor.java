package model;

import java.util.ArrayList;

/**Classe para objetos do tipo Fornecedor, onde são contidos, valores e metódos necessarios para implementação da classe.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 * @see Entidade
 */
public class Fornecedor extends Entidade{
	
	private String nome;
	private String cnpj;
	private String endereco;
	private ArrayList<String> produtos;
	private String produtosToString;
	
	/**O construtor inicializa o costrutor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 * @param listaIds Lista de id's
	 * @param nome Nome do fornecedor
	 * @param cnpj CNPJ do fornecedor
	 * @param endereco Endereço do fornecedor
	 */
	public Fornecedor(ArrayList<String> listaIds, String nome, String cnpj, String endereco) {
		super(listaIds);
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.produtos = new ArrayList<String>();
	}
	
	/**Metódo para retorno de nome do fornecedor
	 * @return String Nome do fornecedor*/
	public String getNome() {
		return nome;
	}
	
	/**Metódo para alterar o nome do fornecedor
	 * @param nome Novo nome do fornecedor*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**Metódo para retorno de CNPJ do fornecedor
	 * @return String CNPJ do fornecedor*/
	public String getCnpj() {
		return cnpj;
	}
	
	/**Metódo para alterar CNPJ do fornecedor
	 * @param cnpj Novo CNPJ do fornecedor*/
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	/**Metódo para retorno de endereço do fornecedor
	 * @return String Endereço do Fornecedor*/
	public String getEndereco() {
		return endereco;
	}
	
	/**Metódo para alterar endereço do fornecedor
	 * @param endereco Novo endereço do fornecedor*/
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<String> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<String> produtos) {
		this.produtos = produtos;
	}

	public String getProdutosToString() {
		
		String produtosTemp = "";
		for(String produto : produtos) {
			produtosTemp += produto + ", ";
		}
		
		produtosToString = produtosTemp.substring(0, produtosTemp.length()-2);
		return produtosToString;
	}
	
	@Override
	public String toString() {
		return getNome();
		
	}

}
