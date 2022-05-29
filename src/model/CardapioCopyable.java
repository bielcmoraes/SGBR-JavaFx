package model;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.ErroGrave;
import exceptions.FormatoIngredientesInvalido;
import exceptions.PratoNaoCadastrado;
import exceptions.PrecoInvalido;
import exceptions.ProdutoNaoCadastrado;
import exceptions.QuantidadeInvalida;

/**Estrutura que contém as assinaturas dos metódos relacionados ao gerenciamento do cardápio e utilizada para "resolver" o problema de herança multipla em Java.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 *
 */
public interface CardapioCopyable {
	
	/**Assinatura do metódo cadastrarPrato
	 * 
	 * @param cardapio Lista de pratos
	 * @param listaIds Lista de id's
	 * @param listaProdutos Lista de Produtos
	 * @param info Entradas do usuário
	 * @return true se o prato for cadastrado com sucesso e false se o prato não for cadastrado com sucesso
	 * @throws ProdutoNaoCadastrado 
	 * @throws ErroGrave 
	 * @throws FormatoIngredientesInvalido 
	 * @throws QuantidadeInvalida 
	 * @throws PrecoInvalido 
	 */
	public boolean cadastrarPrato(ArrayList<Prato> cardapio, ArrayList<String> listaIds, HashMap<String, ArrayList<Produto>> listaProdutos, String [] info) throws NumberFormatException, ProdutoNaoCadastrado, PrecoInvalido, QuantidadeInvalida, FormatoIngredientesInvalido, ErroGrave;
	
	/**Assinatura do metódo editarPrato
	 * 
	 * @param cardapio Lista de pratos
	 * @param listaProdutos Lista de Produtos
	 * @param codigoPrato Id do prato que deseja editar
	 * @param info Entradas do usuário
	 * @return true se o prato for editado com sucesso e false se o prato não for editado com sucesso
	 * @throws ProdutoNaoCadastrado 
	 * @throws ErroGrave 
	 * @throws FormatoIngredientesInvalido 
	 * @throws QuantidadeInvalida 
	 * @throws PrecoInvalido 
	 * @throws PratoNaoCadastrado 
	 */
	public boolean editarPrato(ArrayList<Prato> cardapio, HashMap<String, ArrayList<Produto>> listaProdutos, String codigoPrato, String [] info) throws ProdutoNaoCadastrado, PrecoInvalido, QuantidadeInvalida, FormatoIngredientesInvalido, ErroGrave, PratoNaoCadastrado;
	
	/**Assinatura do metódo excluirPrato
	 * 
	 * @param cardapio Lista de pratos
	 * @param listaIds Lista de id's
	 * @param codigoPrato Id do prato que deseja excluir
	 * @return true se o prato for excluido do cardápio com sucesso e false se o prato não for excluido do cardápio com sucesso
	 * @throws PratoNaoCadastrado 
	 * @throws ErroGrave 
	 */
	public boolean excluirPrato(ArrayList<Prato> cardapio, ArrayList<String> listaIds, String codigoPrato) throws ErroGrave, PratoNaoCadastrado;
}
