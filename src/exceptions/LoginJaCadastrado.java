package exceptions;
/**Classe utilizada para representar excecoes quando o login ja esta cadastrado
 * 
 *@author Gabriel Moraes e Luis Fernando Cintra
 *@see Exception
 */
public class LoginJaCadastrado extends Exception{
	/**O construtor inicializa o construtor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 */
	public LoginJaCadastrado() {
		super();
	}
	/**Metodo responsavel por transformar a excecao em String
	 * 
	 */
	@Override
	public String toString() {
		return "Esse login já existe.\n Tente novamente!";
	}
}
