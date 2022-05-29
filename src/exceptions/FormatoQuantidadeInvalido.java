package exceptions;

/**Classe utilizada para representar excecoes quando o formato da quantidade esta invalido
 * 
 *@author Gabriel Moraes e Luis Fernando Cintra
 *@see Exception
 */
public class FormatoQuantidadeInvalido extends Exception{
	/**O construtor inicializa o construtor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 */
	public FormatoQuantidadeInvalido() {
		super();

	}
	/**Metodo responsavel por transformar a excecao em String
	 * 
	 */
	@Override
	public String toString() {
		return "Formato da quantidade invalido!";
	}
	
}


