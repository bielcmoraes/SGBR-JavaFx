package model;

import java.util.ArrayList;

/**Classe para objetos do tipo Gerente, onde são contidos, valores e metódos necessários para a implementação da classe.
 * 
 * @author Gabriel Morae
 * @author Luis Fernando Cintra
 * @see Usuario
 */
public class Gerente extends Usuario  {
	
	/**O construtor vazio inicializa o construtor vazio da classe herdada. Necessario para intanciar um representante da classe com informações de id, login e senha pré estabelecidas.
	 */
	public Gerente() {
		super();
	}
	
	/**O construtor inicializa o costrutor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 * @param listaIds Lista de id's
	 * @param nome Nome do funcionário
	 * @param login Login do funcionário
	 * @param senha Senha do funcionário
	 */
	public Gerente(ArrayList<String> listaIds, String nome, String login, String senha) {
		super(listaIds, nome, login, senha);
	}
}