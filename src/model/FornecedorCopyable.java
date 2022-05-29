package model;

import java.util.ArrayList;

import exceptions.ErroGrave;
import exceptions.NaoEncontrado;

/**Estrutura que contém as assinaturas dos metódos relacionados ao gerenciamento de fornecedor e utilizada para "resolver" o problema de
 * herança multipla em Java.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 *
 */
public interface FornecedorCopyable {
	
	/* Assinatura do metódo cadastrarFornecedor
	 * 
	 * @param listaFornecedores Lista de Fornecedores
	 * @param listaIds Lista de id's
	 * @param info Entradas do usuário
	 * @return true se o fornecedor for cadastrado com sucesso
	 * @throws ErroGrave 
	 */
	public boolean cadastrarFornecedor(ArrayList<Fornecedor> listaFornecedores, ArrayList<String> listaIds, String [] info) throws ErroGrave;
	
	/* Assinatura do metódo editarFornecedor
	 * 
	 * @param listaFornecedores Lista de Fornecedores
	 * @param codigoFornecedor Id do fornecedor que deseja editar
	 * @param info Entradas do usuário
	 * @return true se o fornecedor for editado com sucesso
	 * @throws ErroGrave 
	 * @throws NaoEncontrado 
	 */
	public boolean editarFornecedor(ArrayList<Fornecedor> listaFornecedores, String codigoFornecedor, String [] info) throws ErroGrave, NaoEncontrado;
	
	/**Assinatura do metódo editarFornecedor
	 * 
	 * @param listaFornecedores Lista de Fornecedores
	 * @param listaIds Lista de id's
	 * @param codigoFornecedor Id do fornecedor que deseja excluir
	 * @return true se o fornecedor for excluido com sucesso
	 * @throws ErroGrave 
	 * @throws NaoEncontrado 
	 */
	public boolean excluirFornecedor(ArrayList<Fornecedor> listaFornecedores, ArrayList<String> listaIds, String codigoFornecedor) throws ErroGrave, NaoEncontrado;
}
