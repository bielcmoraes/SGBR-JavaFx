package exceptions;
/**Classe utilizada para representar excecoes quando o relatorio nao é gerado
 * 
 *@author Gabriel Moraes e Luis Fernando Cintra
 *@see Exception
 */
public class RelatorioNaoGerado extends Exception{
	
private String relatorio;
	/**O construtor inicializa o construtor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 */
	public RelatorioNaoGerado(String relatorio) {
		super();
		this.relatorio = relatorio;
	}
	/**Metodo responsavel por transformar a excecao em String
	 * 
	 */
	@Override
	public String toString() {
		return relatorio + "não gerado!";
	}
}