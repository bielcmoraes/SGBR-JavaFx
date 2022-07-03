package model;

import java.util.ArrayList;

/**Classe para objetos do tipo Cliente, onde são contidos, valores e metódos necessarios para implementação da classe.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 * @see Entidade
 */
public class Cliente extends Entidade{

	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private ArrayList<Venda> compras;
	
	
	//Construtores
	
	/**O construtor inicializa o costrutor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 * @param listaIds Lista de id's
	 * @param nome Nome do cliente
	 * @param cpf CPF do cliente
	 * @param email Email do cliente
	 * @param telefone Telefone do cliente
	 */
	public Cliente(ArrayList<String> listaIds, String nome, String cpf, String email, String telefone) {
		
		super(listaIds);
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.compras = new ArrayList<Venda>();
	}
	
	//Metodos
	
	/**Metódo para retorno de nome do cliente
	 * @return String Nome do cliente*/
	public String getNome() {
		return nome;
	}
	
	/**Metódo para alterar o nome do cliente
	 * @param nome Novo nome do cliente*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**Metódo para retorno de cpf do cliente
	 * @return String Cpf do cliente*/
	public String getCpf() {
		return cpf;
	}
	
	/**Metódo para alterar o cpf do cliente
	 * @param nome Novo cpf do cliente*/
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**Metódo para retorno de email do cliente
	 * @return String Email do cliente*/
	public String getEmail() {
		return email;
	}
	
	/**Metódo para alterar o email do cliente
	 * @param nome Novo email do cliente*/
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**Metódo para retorno de telefone do cliente
	 * @return String Telefone do cliente*/
	public String getTelefone() {
		return telefone;
	}
	
	/**Metódo para alterar o telefone do cliente
	 * @param nome Novo telefone do cliente*/
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**Metódo para retorno da lista de compras do cliente
	 * @return ArrayList Lista de compras do cliente*/
	public ArrayList<Venda> getCompras() {
		return compras;
	}
	
	/**Metódo para alterar a lista de compras do cliente
	 * @param nome Nova lista de compras do cliente*/
	public void setCompras(ArrayList<Venda> compras) {
		this.compras = compras;
	}
	
	public String toString() {
		return this.nome;
	}
}
