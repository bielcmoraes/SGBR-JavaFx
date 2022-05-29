package model;

import java.util.ArrayList;
import java.util.Random;

/**Classe abstrata que contém um atributo id, além dos metódos necessarios para que o id seja único e utilizado nas classes necessarias.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 *
 */
public abstract class Entidade {
	
	// Attributes
	private String id;
	
	/**O construtor recebe como parâmetro a lista de id's e ,utilizando a biblioteca Random, gera um id aleatório entre 0 e 10000 que não está na lista de id's.
	 * @param listaIds Lista de id's*/
	public Entidade (ArrayList<String> listaIds) {
		Random aleatorio = new Random();
		do {
			this.id = Integer.toString(aleatorio.nextInt(10000));
		}while(listaIds.contains(id) != false);
		
	}
	
	/**O construtor vazio é necessário para atribuir um id ao usuario que for instanciado com construtor vazio na classe Usuario.
	 */
	public Entidade () {
		this.id = "99999";
	}
	
	/**Metódo para retorno do id
	 * 
	 * @return String - Id
	 */
	public String getId() {
		return id;
	}
}
