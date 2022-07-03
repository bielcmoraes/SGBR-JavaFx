package model;

import java.util.ArrayList;

import exceptions.ErroGrave;
import exceptions.NaoEncontrado;

/**Classe responsável por implementar os metódos de cadastrar, editar e excluir .
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class GerenciaFornecedor {
	
	/**O método instancia um objeto do tipo Fornecedor utilizando as entradas do usuário que estão armazenadas em info. Se a lista de fornecedores 
	 * e o vetor que armazena as entradas do usuário não forem null o objeto do tipo fornecedor que foi instanciado é adicionado na 
	 * lista de fornecedores e é retornado true. Caso a lista de fornecedores seja igual a null uma excessão é gerada.
	 * 
	 * @throws ErroGrave 
	 */
	public boolean cadastrarFornecedor(ArrayList<Fornecedor> listaFornecedores, ArrayList<String> listaIds, String [] info, ArrayList<String> produtos) throws ErroGrave {
		
		Fornecedor novoFornecedor = new Fornecedor(listaIds, info[0], info[1], info[2], produtos);
		
			try {
				listaFornecedores.add(novoFornecedor);
				return true;
			} 
			catch(ArrayIndexOutOfBoundsException a){
				throw new ErroGrave();
			}catch( NullPointerException a) {
				throw new ErroGrave();
			}	
	}
	
	/**O método, caso a lista de fornecedores e o vetor que armazena as entradas do usuário forem diferentes null, percorre a lista de fornecedores 
	 * e verifica se existe um objeto na lista quem tem o atributo de id igual ao codigo de fornecedor que é passado como parâmetro. Se existir um
	 * fornecedor com o id igual ao código de fornecedor as informações são substituidas pelos novos valores que passados pelo usuário através do 
	 * vetor info. As substituições das informações são feitas utilizando os metódos de setters presentes na classe Fornecedor e é retornado true.
	 * 
	 */
	public boolean editarFornecedor(ArrayList<Fornecedor> listaFornecedores, String fornecedorId, String [] info, ArrayList<String> produtos) throws ErroGrave, NaoEncontrado {
		if(listaFornecedores != null) {
			
			for(Fornecedor f1 : listaFornecedores) {
				if(fornecedorId.equals(f1.getId())) {
					f1.setNome(info[0]);
					f1.setCnpj(info[1]);
					f1.setEndereco(info[2]);
					f1.setProdutos(produtos);
					return true;
				}
			}
		}
	return false;	
	
				
	}
	
	/**Se a lista de fornecedores e a lista de id's forem diferentes de null, um for each percorre os objetos da lista de fornecedores e verifica se
	 * o atributo de id dos objetos armazenados na lista é igual ao codigo de fornecedor que foi passado como parâmetro. Se o id do objeto for igual
	 * ao código de fornecedor o objeto é removido da lista de fornecedores, seu id é removido da lista de id's e a função retorna true. Caso não exista
	 * um fornecedor com id igual ao código de fornecedor que foi passado como parâmetro uma excessão para objeto não encontrado é lançada. Se a lista de 
	 * fornecedores ou a lista de id's tiverem valor null uma excessão específica para esse tipo de erro é lançada.
	 * @throws ErroGrave 
	 * @throws NaoEncontrado 
	 */
	public boolean excluirFornecedor(ArrayList<Fornecedor> listaFornecedores, ArrayList<String> listaIds, String codigoFornecedor) throws ErroGrave {
			
			try {
				for(Fornecedor fornecedor : listaFornecedores) {
					if(fornecedor.getId().equals(codigoFornecedor)) {
						int index = listaFornecedores.indexOf(fornecedor);
						listaFornecedores.remove(index);
						listaIds.remove(codigoFornecedor);
						return true;
					}
				}
			}catch(ArrayIndexOutOfBoundsException a){
				throw new ErroGrave();
			}catch( NullPointerException a) {
				throw new ErroGrave();
			}
		return false;
	}

}
