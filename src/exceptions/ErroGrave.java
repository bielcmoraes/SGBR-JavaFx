package exceptions;

/**Classe utilizada para representar excecoes quando a listas nao esta instanciada ou o indice procurado nao é encontrado
 * 
 *@author Gabriel Moraes e Luis Fernando Cintra
 *@see Exception
 */
public class ErroGrave extends Exception {
	/**O construtor inicializa o construtor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 */
	public ErroGrave() {
		super();
	}
	/**Metodo responsavel por transformar a excecao em String
	 * 
	 */
	@Override
	public String toString() {
		return "Erro./n Reinicie o sistema!!!";
	}
}
