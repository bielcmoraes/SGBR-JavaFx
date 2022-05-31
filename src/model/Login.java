package model;

import java.util.ArrayList;

/**Classe que contém os metódos necessários para que a autenticação de usuário ocorra, permitindo que somente os usuários cadastrados possam acessar 
 * o sistema.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 *
 */
public class Login {
	
	/**O contrutor instancia um objeto da classe Gerente e adiciona o objeto instanciado a lista de usuários caso a lista de usuários esteja vazia,
	 *possibilitando que, ao iniciar o sitema pela primeira vez, o login possa ser efetuado danto total acesso às funcionalidades do sistema ao
	 *primeiro usuário.
	 * 
	 * @param listaUsuarios Lista de usuários
	 */
	public Login(ArrayList<Usuario> listaUsuarios) {
		
		//Se a lista estiver vazia adicionamos o usuario "Master" na lista;
		if(listaUsuarios.isEmpty()) {
			Usuario primeiroUsuario = new Gerente();
			listaUsuarios.add(primeiroUsuario);
		}
	}
	
	/**Se a lista de usuários for diferente de null, percorre a lista e verifica se o login e senha fornecidos corresponde aos atributos de login e senha de
	 * um dos objetos que compõem a lista de usuários, emseguida retorna esse objeto. Caso a lista de usuários tenha valor igual a null ou não exista na
	 * lista nenhum objeto com informações correspondentes as armazenadas no vetor infoLogin o metódo retorna null.
	 * 
	 * @param listaUsuarios Lista de Usuários
	 * @param infoLogin Entrada de usuário (login e senha)
	 * @return objeto do tipo Usuario (pode ser da classe Gerente ou Funcionario) caso a autenticação ocorra com sucesso e null caso a autenticação 
	 * não ocorra com sucesso
	 */
	public Usuario autenticarLogin(ArrayList<Usuario> listaUsuarios, String login, String senha) {
		
		try {
			//Tente validar o login
			for(Usuario usuario: listaUsuarios) {
				if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
					return usuario;
				}
			}
		}catch(NullPointerException a) {
			return null;
		}
		return null;	
	}	
}
