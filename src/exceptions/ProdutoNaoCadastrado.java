package exceptions;
/**Classe utilizada para representar excecoes quando o produto nao esta cadastrado
 * 
 *@author Gabriel Moraes e Luis Fernando Cintra
 *@see Exception
 */
public class ProdutoNaoCadastrado extends Exception{
	/**O construtor inicializa o construtor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 */
	public ProdutoNaoCadastrado() {
		super();
	}
	/**Metodo responsavel por transformar a excecao em String
	 * 
	 */
	@Override
	public String toString() {
		return "Produto nao cadastrado!";
	}
}