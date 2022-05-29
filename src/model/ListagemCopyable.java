package model;

import java.util.ArrayList;
import java.util.HashMap;

/**Estrutura que contém as assinaturas dos metódos relacionados a listagem e utilizada para "resolver" o problema de herança multipla em Java.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public interface ListagemCopyable {
	
	/**Assinatura do metódo mostrarCardapio
	 * 
	 * @param cardapio Lista de pratos
	 */
	public void mostrarCardapio(ArrayList<Prato> cardapio);
	
	/**Assinatura do metódo listarFornecedor
	 * 
	 * @param listaFornecedores Lista de fornecedores
	 */
	public void listarFornecedor(ArrayList<Fornecedor> listaFornecedores);
	
	/**Assinatura do metódo listarProduto
	 * 
	 * @param listaProdutos Lista de produtos
	 */
	public void listarProduto(HashMap<String, ArrayList<Produto>> listaProdutos);
	
	/**Assinatura do metódo listarUsuario
	 * 
	 * @param listaUsuarios Lista de usuários
	 */
	public void listarUsuario(ArrayList<Usuario> listaUsuarios);
	
	/**Assinatura do metódo listarVenda
	 * 
	 * @param listaVendas Lista de vendas
	 */
	public void listarVenda(ArrayList<Venda> listaVendas);
}