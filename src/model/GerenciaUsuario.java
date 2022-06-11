package model;

import java.util.ArrayList;

import exceptions.ErroGrave;
import exceptions.EscolhaIncorreta;
import exceptions.LoginJaCadastrado;
import exceptions.NaoEncontrado;

/**Classe responsável por implementar os metódos de cadastrar, editar e excluir usuário que foram especificados na classe UsuarioCopyable.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 *
 */
public class GerenciaUsuario implements UsuarioCopyable {
	
	/**Se a lista de usuários e a lista de id's não tiverem valor null, é verificado se o objeto cadastrado será do tipo Gerente ou do tipo Funcionario
	 * através da informação fornecida pelo usuário ("1" para Gerente e "2" para Funcionario), depois a lista de usuários é percorrida para verificar
	 * se existe algum objeto na lista com o login igual ao login armazenado no vetor info, se não existir um login cadastrado igual ao login fornecido 
	 * um objeto do resppectivo tipo (Gerente ou Funcionário) é instanciado e armazenado na lista de usuários e o metódo retorna true. Caso exista um login cadastrado igual ao 
	 *login fornecido, ou apção que determina o tipo de objeto que será instanciado seja diferente de "1" ou "2" ou a lista de usuários e a lista de id's
	 *estejam com valor igual a null o mmetódo retorna false.
	 * @throws EscolhaIncorreta 
	 * @throws LoginJaCadastrado 
	 * @throws ErroGrave 
	 */
	@Override
	public boolean cadastrarUsuario(ArrayList<Usuario> listaUsuarios, ArrayList<String> listaIds, String [] infoUsuario) throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave {
			
		try {
			//Cria um novo Gerente e adiciona na lista
			if(infoUsuario[1].equals("Gerente")) {
				
				for(Usuario usuario: listaUsuarios) {
					if(usuario.getLogin().equals(infoUsuario[2])) {
						throw new LoginJaCadastrado(); 
					}
				}
				Usuario novoUsuario = new Gerente(listaIds, infoUsuario[0], infoUsuario[2], infoUsuario[3]);
				listaUsuarios.add(novoUsuario);
				return true;
			}
			//Cria um novo Funcionario e adiciona na lista
			else if(infoUsuario[1].equals("Funcionário")) {
				
				for(Usuario usuario: listaUsuarios) {
					if(usuario.getLogin().equals(infoUsuario[2])) {
						throw new LoginJaCadastrado();
					}
				}
				
				Usuario novoUsuario = new Funcionario(listaIds, infoUsuario[0], infoUsuario[2], infoUsuario[3]);
				listaUsuarios.add(novoUsuario);
				return true;
				
			}else {
				throw new EscolhaIncorreta();
			}
		}catch(NullPointerException n) {
			throw new ErroGrave();
		}
	}
	
	/**O método, caso a lista de usuário e o vetor que armazena as informações necessária para a edição forem diferentes null, percorre a lista de 
	 * usuarios e verifica se existe um objeto na lista quem tem o atributo de id igual ao codigo de usuário que é passado como parâmetro. Se existir um
	 * usuário, seja ele do tipo Gerente ou do tipo Funcionario, com o id igual ao código de fornecedor as informações são substituidas pelos novos 
	 * valores que passados pelo usuário através do vetor info. As substituições das informações são feitas utilizando os metódos de setters presentes
	 * na classe Usuario e é retornado true.
	 * Caso não exista um usuário com id igual ao codigo de usuário ou a lista de usuários e o vetor info tiverem valor null, o metódo retorna false. 
	 * @throws NaoEncontrado 
	 * @throws ErroGrave 
	 */
	@Override
	public boolean editarUsuario(ArrayList<Usuario> listaUsuarios, String codigoUsuario, String [] info) throws ErroGrave {
		
		try {
			for(Usuario usuario : listaUsuarios) {
				if(usuario.getId().equals(codigoUsuario)) {
					usuario.setNome(info[0]);
					usuario.setSenha(info[1]);
					return true;
				}
			}
		}catch(NullPointerException n) {
			throw new ErroGrave();
		}
		return false;
	}
	
	/**Se existir um usuário com atributo de id igual ao códido de usuário passado como parâmetro do método e a lista de usuários juntamente com a lista
	 * de id's forem diferentes de null, o respectivo usuário é removido da lista de usuários, seu id é removido da lista de id's e o metódo retorna true.
	 * Caso as condições citadas anteriormente não forem satisfeitas o metódo retorna false.
	 * @throws ErroGrave 
	 * @throws NaoEncontrado 
	 * 
	 */
	@Override
	public boolean excluirUsuario(ArrayList<Usuario> listaUsuarios, ArrayList<String> listaIds, String codigoUsuario) throws ErroGrave {
		
		try {
			for(Usuario usuario : listaUsuarios) {
				if(usuario.getId().equals(codigoUsuario)) {
					int index = listaUsuarios.indexOf(usuario);
					listaUsuarios.remove(index);
					listaIds.remove(codigoUsuario);
					return true;
				}
			}
		}catch(NullPointerException n) {
			throw new ErroGrave();
		}
		return false;
	}

}
