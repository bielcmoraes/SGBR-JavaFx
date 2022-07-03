package model;

import java.util.ArrayList;

import exceptions.ErroGrave;
import exceptions.NaoEncontrado;

/**Classe responsável por implementar os metódos de cadastrar, editar e excluir cliente.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class GerenciaCliente {
	
	/**O método instancia um objeto do tipo Cliente utilizando as entradas do usuário que estão armazenadas em info. Se a lista de clientes 
	 * e o vetor que armazena as entradas do usuário não forem null o objeto do tipo Cliente que foi instanciado é adicionado na 
	 * lista de clientes e é retornado true. Caso a lista de clientes seja igual a null uma excessão é gerada.
	 * 
	 * @throws ErroGrave 
	 */
	public boolean cadastrarCliente(ArrayList<Cliente> listaClientes, ArrayList<String> listaIds, String[] info) throws ErroGrave {
		
		Cliente novoCliente = new Cliente(listaIds, info[0], info[1], info[2], info[3]);
			
		try {
			listaClientes.add(novoCliente);
			return true;
			
		}catch(ArrayIndexOutOfBoundsException a){
			throw new ErroGrave();
		}catch( NullPointerException a) {
			throw new ErroGrave();
		}
	}
	
	/**O método, caso a lista de clientes e o vetor que armazena as entradas do usuário forem diferentes null, percorre a lista de clientes 
	 * e verifica se existe um objeto na lista quem tem o atributo de id igual ao codigo de fornecedor que é passado como parâmetro. Se existir um
	 * cliente com o id igual ao código de cliente as informações são substituidas pelos novos valores que passados pelo usuário através do 
	 * vetor info. As substituições das informações são feitas utilizando os metódos de setters presentes na classe Cliente e é retornado true.
	 * 
	 */
	public boolean editarCliente(ArrayList<Cliente> listaClientes, String codigoCliente, String[] info) throws ErroGrave, NaoEncontrado {
		
		if(listaClientes != null) {
			
			for(Cliente cliente : listaClientes) {
				if(cliente.getId().equals(codigoCliente)) {
					cliente.setNome(info[0]);
					cliente.setCpf(info[1]);
					cliente.setEmail(info[2]);
					cliente.setTelefone(info[3]);
					return true;
					
				}
			}
		}
		return false;
		}
	
	/**Se a lista de clientes e a lista de id's forem diferentes de null, um for each percorre os objetos da lista de clientes e verifica se
	 * o atributo de id dos objetos armazenados na lista é igual ao codigo de cliente que foi passado como parâmetro. Se o id do objeto for igual
	 * ao código de cliente o objeto é removido da lista de clientes, seu id é removido da lista de id's e a função retorna true. Se a lista de 
	 * clientes ou a lista de id's tiverem valor null uma excessão específica para esse tipo de erro é lançada.
	 * @throws ErroGrave
	 */
	public boolean excluirCliente(ArrayList<Cliente> listaClientes, ArrayList<String> listaIds, String codigoCliente) throws ErroGrave, NaoEncontrado {
		
		try {
			for(Cliente cliente : listaClientes) {
				if(cliente.getId().equals(codigoCliente)) {
					int index = listaClientes.indexOf(cliente);
					listaClientes.remove(index);
					listaIds.remove(codigoCliente);
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
