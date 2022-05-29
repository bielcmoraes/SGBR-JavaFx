package exceptions;
/**Classe utilizada para representar excecoes quando o fornecedor nao esta cadastrado
 * 
 *@author Gabriel Moraes e Luis Fernando Cintra
 *@see Exception
 */
public class FornecedorNaoCadastrado extends Exception{
	/**O construtor inicializa o construtor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 */
	public FornecedorNaoCadastrado() {
		super();

	}
	/**Metodo responsavel por transformar a excecao em String
	 * 
	 */
	@Override
	public String toString() {
		return "Fornecedor nao cadastrado!";
	}
	
}