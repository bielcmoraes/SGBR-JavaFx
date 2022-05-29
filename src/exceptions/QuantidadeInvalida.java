package exceptions;
/**Classe utilizada para representar excecoes quando a quantidade é invalida
 * 
 *@author Gabriel Moraes e Luis Fernando Cintra
 *@see Exception
 */
public class QuantidadeInvalida extends Exception{
	/**O construtor inicializa o construtor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 */
	public QuantidadeInvalida() {
		super();

	}
	/**Metodo responsavel por transformar a excecao em String
	 * 
	 */
	@Override
	public String toString() {
		return "Quantidade invalida!";
	}
	
}


