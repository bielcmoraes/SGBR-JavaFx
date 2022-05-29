
package model;

import java.util.ArrayList;

/**Classe abstrata Usuario, onde são contidos, valores e metódos necessarios para implementação de outras classes.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 * @see Entidade
 */
public abstract class Usuario extends Entidade{
	private String nome;
	private String login;
	private String senha;
	
	
	/**O construtor inicializa o costrutor vazio da classe herdada e atribui valores pré-definidos aos atributos da classe.
	 */
	public Usuario() {
		super();
		this.nome = "Master";
		this.login = "admin";
		this.senha = "admin";
	}
	
	/**O construtor inicializa o construtor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro. 
	 * 
	 * @param listaIds Lista de id's
	 * @param nome Nome do usuario
	 * @param login Login do usuário
	 * @param senha Senha do usuário
	 */
	public Usuario(ArrayList<String> listaIds, String nome, String login, String senha) {
		super(listaIds);
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	
	/**Metódo para retorno de nome do usuário.
	 * @return String Nome do usuário*/
	public String getNome() {
		return nome;
	}
	
	/**Metódo para alterar o nome do usuário.
	 * @param nome Novo nome do usuário*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**Metódo para retorno de login do usuário.
	 * @return String Login do usuário*/
	public String getLogin() {
		return login;
	}
	
	/**Metódo para retorno de senha do usuário.
	 * @return String Senha do usuário*/
	public String getSenha() {
		return senha;
	}
	
	/**Metódo para alterar a senha do usuário.
	 * @param senha Nova senha do usuário*/
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
