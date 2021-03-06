package model;

import java.util.ArrayList;

/**Classe para objetos do tipo Funcionario, onde são contidos, valores e metódos necessários para a implementação da classe.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 * @see Usuario
 */
public class Funcionario extends Usuario {
	
	/**O construtor inicializa o costrutor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 * @param listaIds Lista de id's
	 * @param nome Nome do funcionário
	 * @param login Login do funcionário
	 * @param senha Senha do funcionário
	 */
	public Funcionario(ArrayList<String> listaIds, String nome, String login, String senha) {
		super(listaIds, nome, login, senha);
	}
}
