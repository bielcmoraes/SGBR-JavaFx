package model;

import java.util.ArrayList;
import java.util.HashMap;

import com.lowagie.text.Table;

import exceptions.ErroGrave;
import exceptions.RelatorioNaoGerado;

/**Estrutura que contém as assinaturas dos metódos relacionados a funcionalidade de gerar relatórios PDF e utilizada para "resolver" o problema de
 * herança multipla em Java.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 *
 */
public interface GeraRelatoriosCopyable {
	
	
	/* Assinatura do método estoqueTotal
	 * @param listaProdutos HashMap de Produtos
	 * @throws RelatorioNaoGerado
	 * @throws ErroGrave
	 */
	public boolean estoqueTotal(HashMap<String, ArrayList<Produto>> listaProdutos) throws RelatorioNaoGerado, ErroGrave;
	
	/* Assinatura do método estoquePorProduto
	 * @param listaProdutos HashMap de Produtos
	 * @throws RelatorioNaoGerado
	 * @throws ErroGrave
	 */
	public boolean estoquePorProduto(HashMap<String, ArrayList<Produto>> listaProdutos) throws RelatorioNaoGerado, ErroGrave;
	
	/* Assinatura do método estoqueProdutosPertoDeVencer
	 * @param listaProdutos HashMap de Produtos
	 * @throws ErroGrave
	 * @throws RelatorioNaoGerado
	 */
	public boolean estoqueProdutosPertoDeVencer(HashMap<String, ArrayList<Produto>> listaProdutos) throws ErroGrave, RelatorioNaoGerado;
	
	/* Assinatura do método fornecedorPorProduto
	 * @param listaProdutos HashMap de Produtos
	 * @throws RelatorioNaoGerado
	 * @throws ErroGrave
	 */
	public boolean fornecedorPorProduto(HashMap<String, ArrayList<Produto>> listaProdutos) throws RelatorioNaoGerado, ErroGrave;
	
	/* Assinatura do método fornecedorPorFornecedor
	 * @param listaFornecedores Lista de Fornecedores
	 * @throws RelatorioNaoGerado
	 * @throws ErroGrave
	 */
	public boolean fornecedorPorFornecedor(ArrayList<Fornecedor> listaFornecedores) throws RelatorioNaoGerado, ErroGrave;
	
	/* Assinatura do método vendasTotal
	 * @param listaVendas Lista de Vendas
	 * @throws ErroGrave
	 * @throws RelatorioNaoGerado
	 */
	public boolean vendasTotal(ArrayList<Venda> listaVendas) throws ErroGrave, RelatorioNaoGerado;
	
	/* Assinatura do método vendasPorPeriodo
	 * @param listaVendas Lista de Vendas
	 * @throws ErroGrave
	 */
	public boolean vendasPorPeriodo(ArrayList<Venda> listaVendas) throws ErroGrave;
	
	/* Assinatura do método vendasPorTipoDePrato
	 * @param listaVendas Lista de Vendas
	 * @throws ErroGrave
	 * @throws RelatorioNaoGerado
	 */
	public boolean vendasPorTipoDePrato(ArrayList<Venda> listaVendas) throws ErroGrave, RelatorioNaoGerado;
	
}
