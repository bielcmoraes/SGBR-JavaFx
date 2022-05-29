package exceptions;
/**Classe utilizada para representar excecoes quando o formato do ingrediente esta invalido
 * 
 *@author Gabriel Moraes e Luis Fernando Cintra
 *@see Exception
 */
public class FormatoIngredientesInvalido extends Exception{
	/**O construtor inicializa o construtor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 */
	public FormatoIngredientesInvalido() {
		super();

	}
	/**Metodo responsavel por transformar a excecao em String
	 * 
	 */
	@Override
	public String toString() {
		return "Formato dos ingredientes invalido!";
	}
	
}


