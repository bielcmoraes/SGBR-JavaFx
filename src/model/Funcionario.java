package model;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.ErroGrave;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoHorarioInvalido;
import exceptions.PratoNaoCadastrado;
import exceptions.QuantidadeProdutosInsuficiente;
import exceptions.VendaNaoCadastrada;
import view.ListagemView;
/**Classe para objetos do tipo Funcionario, onde são contidos, valores e metódos necessários para a implementação da classe.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 * @see Usuario
 */
public class Funcionario extends Usuario implements VendaCopyable, ListagemCopyable{
	
	/**O construtor inicializa o costrutor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 * @param listaIds Lista de id's
	 * @param nome Nome do funcionário
	 * @param login Login do funcionário
	 * @param senha Senha do funcionário
	 */
	public Funcionario(ArrayList<String> listaIds, String nome, String login, String senha) {
		super(listaIds, nome, login, senha);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaVendas e retornar o método cadastrarVenda.
	 * @param listaVendas Lista de vendas
	 * @param listaIds Lista de id's
	 * @param cardapio Cardapio (lista de pratos)
	 * @param info Entradas do usuário
	 * @return Boolean cadastrarVenda
	 * @throws ErroGrave 
	 * @throws QuantidadeProdutosInsuficiente 
	 * @throws PratoNaoCadastrado 
	 */
	@Override
	public boolean cadastrarVenda(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, ArrayList<Prato> cardapio,
			String[] info, HashMap<String, ArrayList<Produto>> listaProdutos) throws PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave {
		GerenciaVendas gerenciamentoVendas = new GerenciaVendas();
		return gerenciamentoVendas.cadastrarVenda(listaVendas, listaIds, cardapio, info, listaProdutos);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaVendas e retornar o método editarVenda.
	 * @param listaVendas Lista de vendas
	 * @param cardapio Cardapio (lista de pratos)
	 * @param codigoVenda Id da venda que deseja editar
	 * @param info Entradas do Usuario
	 * @return Boolean editarVenda
	 * @throws ErroGrave 
	 * @throws QuantidadeProdutosInsuficiente 
	 * @throws PratoNaoCadastrado 
	 * @throws FormatoHorarioInvalido 
	 * @throws FormatoDataInvalido 
	 * @throws VendaNaoCadastrada 
	 */
	@Override
	public boolean editarVenda(ArrayList<Venda> listaVendas, ArrayList<Prato> cardapio, String codigoVenda,
			String[] info, HashMap<String, ArrayList<Produto>> listaProdutos) throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave, VendaNaoCadastrada {
		GerenciaVendas gerenciamentoVendas = new GerenciaVendas();
		return gerenciamentoVendas.editarVenda(listaVendas, cardapio, codigoVenda, info, listaProdutos);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaVendas e retornar o método excluirVenda.
	 * @param listaVendas Lista de vendas
	 * @param listaIds Lista de ids
	 * @param codigoVenda Id da venda que deseja editar
	 * @return Boolean excluirVenda
	 * @throws ErroGrave 
	 * @throws VendaNaoCadastrada 
	 */
	@Override
	public boolean excluirVenda(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, String codigoVenda) throws VendaNaoCadastrada, ErroGrave {
		GerenciaVendas gerenciamentoVendas = new GerenciaVendas();
		return gerenciamentoVendas.excluirVenda(listaVendas, listaIds, codigoVenda);
	}
	
	/**Metódo para instanciar um objeto do tipo ListagemView.
	 * @param cardapio Cardapio (lista de pratos)
	 */
	@Override
	public void mostrarCardapio(ArrayList<Prato> cardapio) {
		ListagemView listagemView = new ListagemView();
		listagemView.mostrarCardapio(cardapio);
	}
	
	/**Metódo para instanciar um objeto do tipo ListagemView.
	 * @param listarFornecedor Lista de Fornecedores
	 */
	@Override
	public void listarFornecedor(ArrayList<Fornecedor> listaFornecedores) {
		ListagemView listagemView = new ListagemView();
		listagemView.listarFornecedor(listaFornecedores);
	}
	
	/**Metódo para instanciar um objeto do tipo ListagemView.
	 * @param listarProduto Lista de produtos
	 * @return Lista de produtos
	 */
	@Override
	public void listarProduto(HashMap<String, ArrayList<Produto>> listaProdutos) {
		ListagemView listagemView = new ListagemView();
		listagemView.listarProduto(listaProdutos);	
	}
	
	/**Metódo para instanciar um objeto do tipo ListagemView e retornar o método listarUsuario.
	 * @param listaUsuarios Lista de usuários
	 */
	@Override
	public void listarUsuario(ArrayList<Usuario> listaUsuarios) {
		ListagemView listagemView = new ListagemView();
		listagemView.listarUsuario(listaUsuarios);
	}
	
	/**Metódo para instanciar um objeto do tipo ListagemView e retornar o método listarVenda.
	 * @param listaVendas Lista de vendas
	 */
	@Override
	public void listarVenda(ArrayList<Venda> listaVendas) {
		ListagemView listagemView = new ListagemView();
		listagemView.listarVenda(listaVendas);
	}
		
}
