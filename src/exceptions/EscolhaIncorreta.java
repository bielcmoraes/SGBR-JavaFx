package exceptions;

/**Classe utilizada para representar excecoes quando a escolha do usuario esta incorreta
 *@author Gabriel Moraes e Luis Fernando Cintra
 *@see Exception
 */
public class EscolhaIncorreta extends Exception {
	/**O construtor inicializa o construtor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 */
	public EscolhaIncorreta() {
		super();
	}
	/**Metodo responsavel por transformar a excecao em String
	 * 
	 */
	@Override
	public String toString() {
		return "Opção incorreta. \nEscolha uma opção válida!";
	}
}
