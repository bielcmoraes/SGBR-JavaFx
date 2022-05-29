package exceptions;
/**Classe utilizada para representar excecoes quando o alvo nao é encontrado
 * 
 *@author Gabriel Moraes e Luis Fernando Cintra
 *@see Exception
 */
public class NaoEncontrado extends Exception{
	/**O construtor inicializa o construtor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 */
	private String objeto;
	public NaoEncontrado(String objeto) {
		super();
		this.objeto = objeto;
	}
	/**Metodo responsavel por transformar a excecao em String
	 * 
	 */
	@Override
	public String toString() {
		return objeto + " não encontrado";
	}
}
