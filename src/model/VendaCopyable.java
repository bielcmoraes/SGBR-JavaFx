package model;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.ErroGrave;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoHorarioInvalido;
import exceptions.PratoNaoCadastrado;
import exceptions.QuantidadeProdutosInsuficiente;
import exceptions.VendaNaoCadastrada;

/**Estrutura que contém as assinaturas dos metódos relacionados ao gerenciamento de vendas e utilizada para "resolver" o problema de herança multipla em Java.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 *
 */
public interface VendaCopyable {
	
	/**Assinatura do metódo cadastrarVenda
	 * 
	 * @param listaVendas Lista de vendas
	 * @param listaIds Lista de id's
	 * @param cardapio Lista de pratos
	 * @param info Entradas do usuário
	 * @param listaProdutos Lista de produtos
	 * @return true se a venda for cadastrada com sucesso e false se a venda não for cadastrada com sucesso
	 * @throws QuantidadeProdutosInsuficiente 
	 * @throws ErroGrave 
	 * @throws PratoNaoCadastrado 
	 */
	public boolean cadastrarVenda(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, ArrayList<Prato> cardapio, String [] info, HashMap<String, ArrayList<Produto>> listaProdutos) throws QuantidadeProdutosInsuficiente, PratoNaoCadastrado, ErroGrave;
	
	/**Assinatura do metódo editarVenda
	 * 
	 * @param listaVendas Lista de vendas
	 * @param cardapio Lista de pratos
	 * @param codigoVenda Id da venda que deseja editar
	 * @param info Entradas do usuário
	 * @param listaProdutos Lista de produtos
	 * @return true se a venda for editada com sucesso e false se a venda não for editada com sucesso	 
	 * @throws ErroGrave 
	 * @throws QuantidadeProdutosInsuficiente 
	 * @throws PratoNaoCadastrado 
	 * @throws FormatoHorarioInvalido 
	 * @throws FormatoDataInvalido 
	 * @throws VendaNaoCadastrada 
	 */
	public boolean editarVenda(ArrayList<Venda> listaVendas, ArrayList<Prato> cardapio, String codigoVenda, String [] info, HashMap<String, ArrayList<Produto>> listaProdutos) throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave, VendaNaoCadastrada;
	
	/**Assinatura do metódo excluirVenda
	 * 
	 * @param listaVendas Lista de vendas
	 * @param listaIds Lista de id's
	 * @param codigoVenda Id da venda que deseja excluir 
	 * @return true se a venda for excluida da lista de vendas com sucesso e false se a venda não for excluida da lista de vendas com sucesso	 
	 * @throws ErroGrave 
	 * @throws VendaNaoCadastrada 
	 */
	public boolean excluirVenda(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, String codigoVenda) throws VendaNaoCadastrada, ErroGrave;
}
