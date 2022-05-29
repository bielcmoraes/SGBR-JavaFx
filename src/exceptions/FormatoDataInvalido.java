package exceptions;

/**Classe utilizada para representar excecoes quando o formato da data esta invalido
 * 
 *@author Gabriel Moraes e Luis Fernando Cintra
 *@see Exception
 */
public class FormatoDataInvalido extends Exception{
	/**O construtor inicializa o construtor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 */
	public FormatoDataInvalido() {
		super();

	}
	/**Metodo responsavel por transformar a excecao em String
	 * 
	 */
	@Override
	public String toString() {
		return "Formato da data invalido!";
	}
	
}