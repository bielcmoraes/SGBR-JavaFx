package model;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.ErroGrave;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoQuantidadeInvalido;
import exceptions.FornecedorNaoCadastrado;
import exceptions.PrecoInvalido;
import exceptions.ProdutoNaoCadastrado;
import exceptions.QuantidadeInvalida;

/**Estrutura que contém as assinaturas dos metódos relacionados ao gerenciamento de produto e utilizada para "resolver" o problema de herança multipla em Java.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 *
 */
public interface ProdutoCopyable {
	
	/**Assinatura do metódo cadastrarProduto
	 * 
	 * @param listaProdutos Lista de produtos
	 * @param listaIds Lista de id's
	 * @param info Entradas do usuário
	 * @param listaFornecedor Lista de forncedores
	 * @return true se o produto for cadastrado com sucesso e false se o produto não for cadastrado com sucesso
	 * @throws ErroGrave 
	 * @throws FornecedorNaoCadastrado 
	 * @throws FormatoDataInvalido 
	 * @throws QuantidadeInvalida 
	 * @throws FormatoQuantidadeInvalido 
	 * @throws PrecoInvalido 
	 */
	public boolean cadastrarProduto(HashMap<String, ArrayList<Produto>> listaProdutos, ArrayList<String> listaIds, String [] info, ArrayList<Fornecedor> listaFornecedor) throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave;
	
	/**Assinatura do metódo editarProduto
	 * 
	 * @param listaProdutos Lista de produtos
	 * @param codigoProduto Id do produto que deseja editar
	 * @param info Entrada do usuário
	 * @param listaFornecedor Lista de forncedores
	 * @return true se o produto for editado com sucesso e false se o produto não for editado com sucesso
	 * @throws ErroGrave 
	 * @throws FornecedorNaoCadastrado 
	 * @throws FormatoDataInvalido 
	 * @throws QuantidadeInvalida 
	 * @throws FormatoQuantidadeInvalido 
	 * @throws PrecoInvalido 
	 */
	public boolean editarProduto(HashMap<String, ArrayList<Produto>> listaProdutos, String codigoProduto, String [] info, ArrayList<Fornecedor> listaFornecedor) throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave;
	
	/**Assinatura do metódo excluirProduto
	 * 
	 * @param listaProdutos Lista de produtos
	 * @param listaIds Lista de id's
	 * @param codigoProduto Id do produto que deseja excluir
	 * @return true se o produto for excluido da lista de produtos com sucesso e false se o produto não for excluido da lista de produtos com sucesso
	 * @throws ErroGrave 
	 * @throws ProdutoNaoCadastrado 
	 */
	public boolean excluirProduto(HashMap<String, ArrayList<Produto>> listaProdutos, ArrayList<String> listaIds, String codigoProduto) throws ProdutoNaoCadastrado, ErroGrave;
}
