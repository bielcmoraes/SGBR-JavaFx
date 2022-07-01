package model;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.ClienteNaoCadastrado;
import exceptions.ErroGrave;
import exceptions.EscolhaIncorreta;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoHorarioInvalido;
import exceptions.FormatoIngredientesInvalido;
import exceptions.FormatoQuantidadeInvalido;
import exceptions.FornecedorNaoCadastrado;
import exceptions.LoginJaCadastrado;
import exceptions.ProdutoNaoCadastrado;
import exceptions.QuantidadeInvalida;
import exceptions.QuantidadeProdutosInsuficiente;
import exceptions.RelatorioNaoGerado;
import exceptions.VendaNaoCadastrada;
import exceptions.NaoEncontrado;
import exceptions.PratoNaoCadastrado;
import exceptions.PrecoInvalido;

/**Classe para objetos do tipo Gerente, onde são contidos, valores e metódos necessários para a implementação da classe.
 * 
 * @author Gabriel Morae
 * @author Luis Fernando Cintra
 * @see Usuario
 */
public class Gerente extends Usuario implements FornecedorCopyable, UsuarioCopyable, ProdutoCopyable, CardapioCopyable, VendaCopyable, GeraRelatoriosCopyable{
	
	/**O construtor vazio inicializa o construtor vazio da classe herdada. Necessario para intanciar um representante da classe com informações de id, login e senha pré estabelecidas.
	 */
	public Gerente() {
		super();
	}
	
	/**O construtor inicializa o costrutor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 * @param listaIds Lista de id's
	 * @param nome Nome do funcionário
	 * @param login Login do funcionário
	 * @param senha Senha do funcionário
	 */
	public Gerente(ArrayList<String> listaIds, String nome, String login, String senha) {
		super(listaIds, nome, login, senha);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaFornecedor e retornar o método cadastrarFornecedor.
	 * @param listaFornecedores Lista de fornecedores
	 * @param listaIds Lista de id's
	 * @param info Entradas do Usuario
	 * @return Boolean cadastrarFornecedor
	 * @throws ErroGrave 
	 */
	@Override
	public boolean cadastrarFornecedor(ArrayList<Fornecedor> listaFornecedores, ArrayList<String> listaIds, String[] info) throws ErroGrave {
		
		GerenciaFornecedor gerenciamentoFornecedor = new GerenciaFornecedor();
		return gerenciamentoFornecedor.cadastrarFornecedor(listaFornecedores, listaIds, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaFornecedor e retornar o método editarFornecedor.
	 * @param listaFornecedores Lista de fornecedores
	 * @param codigoFornecedor Id do fornecedor que deseja editar
	 * @param info Entradas do Usuario
	 * @return Boolean editarFornecedor
	 * @throws ErroGrave 
	 * @throws NaoEncontrado 
	 */
	@Override
	public boolean editarFornecedor(ArrayList<Fornecedor> listaFornecedores, String codigoFornecedor, String [] info) throws ErroGrave, NaoEncontrado {
		
		GerenciaFornecedor gerenciamentoFornecedor = new GerenciaFornecedor();
		return gerenciamentoFornecedor.editarFornecedor(listaFornecedores, codigoFornecedor, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaFornecedor e retornar o método excluirFornecedor.
	 * @param listaFornecedores Lista de fornecedores
	 * @param listaIds Lista de id's
	 * @param codigoFornecedor Id do fornecedor que deseja excluir
	 * @return Boolean excluirFornecedor
	 * @throws NaoEncontrado 
	 * @throws ErroGrave 
	 */
	@Override
	public boolean excluirFornecedor(ArrayList<Fornecedor> listaFornecedores,ArrayList<String> listaIds, String codigoFornecedor) throws ErroGrave, NaoEncontrado {
		
		GerenciaFornecedor gerenciamentoFornecedor = new GerenciaFornecedor();
		return gerenciamentoFornecedor.excluirFornecedor(listaFornecedores, listaIds, codigoFornecedor);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaUsuario e retornar o método cadastrarUsuario.
	 * @param listarFornecedores Lista de usuarios
	 * @param listaIds Lista de id's
	 * @param info Entradas do usuario
	 * @return Boolean cadastrarUsuario
	 * @throws EscolhaIncorreta, LoginJaCadastrado 
	 * @throws ErroGrave 
	 */
	@Override
	public boolean cadastrarUsuario(ArrayList<Usuario> listaUsuarios, ArrayList<String> listaIds, String [] info) throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave {
		GerenciaUsuario gerenciamentoUsuario = new GerenciaUsuario();
		return gerenciamentoUsuario.cadastrarUsuario(listaUsuarios, listaIds, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaUsuario e retornar o método editarUsuario.
	 * @param listarFornecedores Lista de usuarios
	 * @param codigoUsuario Id do usuario que deseja editar
	 * @param info Entradas do usuario
	 * @return Boolean editarUsuario
	 * @throws ErroGrave 
	 * @throws NaoEncontrado 
	 */
	@Override
	public boolean editarUsuario(ArrayList<Usuario> listaUsuarios, String codigoUsuario, String [] info) throws NaoEncontrado, ErroGrave {
		
		//Istancia o gerenciamento de usuario
		GerenciaUsuario gerenciamentoUsuario = new GerenciaUsuario();
		return gerenciamentoUsuario.editarUsuario(listaUsuarios, codigoUsuario, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaUsuario e retornar o método excluirUsuario.
	 * @param listarFornecedores Lista de usuarios
	 * @param listaIds Lista de id's
	 * @param codigoUsuario Id do usuário que deseja excluir
	 * @return Boolean excluirUsuario
	 * @throws NaoEncontrado 
	 * @throws ErroGrave 
	 */
	@Override
	public boolean excluirUsuario(ArrayList<Usuario> listaUsuarios, ArrayList<String> listaIds, String codigoUsuario) throws ErroGrave, NaoEncontrado {
		GerenciaUsuario gerenciamentoUsuario = new GerenciaUsuario();
		return gerenciamentoUsuario.excluirUsuario(listaUsuarios, listaIds, codigoUsuario);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaProdutos e retornar o método cadastrarProduto.
	 * @param listaProdutos Lista de produtos
	 * @param listaIds Lista de id's
	 * @param info Entradas do usuário
	 * @return Boolean cadastrarProduto
	 * @throws ErroGrave 
	 * @throws FornecedorNaoCadastrado 
	 * @throws FormatoDataInvalido 
	 * @throws QuantidadeInvalida 
	 * @throws FormatoQuantidadeInvalido 
	 * @throws PrecoInvalido 
	 */
	@Override
	public boolean cadastrarProduto(HashMap<String, ArrayList<Produto>> listaProdutos, ArrayList<String> listaIds, String [] info, ArrayList<Fornecedor> listaFornecedor) throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		GerenciaProdutos gerenciamentoProdutos = new GerenciaProdutos();
		return gerenciamentoProdutos.cadastrarProduto(listaProdutos, listaIds, info, listaFornecedor);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaProdutos e retornar o método editarProduto.
	 * @param listaProdutos Lista de produtos
	 * @param codigoProduto Id do produto que deseja editar
	 * @param info Entradas do usuário
	 * @return Boolean editarProduto
	 * @throws ErroGrave 
	 * @throws FornecedorNaoCadastrado 
	 * @throws FormatoDataInvalido 
	 * @throws QuantidadeInvalida 
	 * @throws FormatoQuantidadeInvalido 
	 * @throws PrecoInvalido 
	 */
	@Override
	public boolean editarProduto(HashMap<String, ArrayList<Produto>> listaProdutos,  String codigoProduto, String [] info, ArrayList<Fornecedor> listaFornecedor) throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		GerenciaProdutos gerenciamentoProdutos = new GerenciaProdutos();
		return gerenciamentoProdutos.editarProduto(listaProdutos, codigoProduto, info, listaFornecedor);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaProdutos e retornar o método excluirProduto.
	 * @param listaProdutos Lista de produtos
	 * @param listaIds Lista de id's
	 * @param codigoProduto Id do produto que deseja excluir
	 * @return Boolean excluirProduto
	 * @throws ErroGrave 
	 * @throws ProdutoNaoCadastrado 
	 */
	@Override
	public boolean excluirProduto(HashMap<String, ArrayList<Produto>> listaProdutos, ArrayList<String> listaIds, String codigoProduto) throws ProdutoNaoCadastrado, ErroGrave {
		GerenciaProdutos gerenciamentoProdutos = new GerenciaProdutos();
		return gerenciamentoProdutos.excluirProduto(listaProdutos, listaIds, codigoProduto);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaCardapio e retornar o método cadastrarPrato.
	 * @param cardapio Lista de pratos
	 * @param listaIds Lista de id's
	 * @param listaProdutos Lista de produtos
	 * @param info Entradas do usuário
	 * @return Boolean cadastrarPrato
	 * @throws ProdutoNaoCadastrado 
	 * @throws ErroGrave 
	 * @throws FormatoIngredientesInvalido 
	 * @throws QuantidadeInvalida 
	 * @throws PrecoInvalido 
	 */
	@Override
	public boolean cadastrarPrato(ArrayList<Prato> cardapio, ArrayList<String> listaIds, HashMap<String, ArrayList<Produto>> listaProdutos, String [] info) throws NumberFormatException, ProdutoNaoCadastrado, PrecoInvalido, QuantidadeInvalida, FormatoIngredientesInvalido, ErroGrave{
		GerenciaCardapio gerenciamentoCardapio = new GerenciaCardapio();
		return gerenciamentoCardapio.cadastrarPrato(cardapio, listaIds, listaProdutos, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaCardapio e retornar o método editarPrato.
	 * @param cardapio Lista de pratos
	 * @param listaProdutos Lista de produtos
	 * @param codigoPrato Id do prato que deseja editar
	 * @param info Entradas do usuário
	 * @return Boolean editarPrato
	 * @throws ProdutoNaoCadastrado 
	 * @throws PratoNaoCadastrado 
	 * @throws ErroGrave 
	 * @throws FormatoIngredientesInvalido 
	 * @throws QuantidadeInvalida 
	 * @throws PrecoInvalido 
	 */
	@Override
	public boolean editarPrato(ArrayList<Prato> cardapio, HashMap<String, ArrayList<Produto>> listaProdutos, String codigoPrato, String [] info) throws ProdutoNaoCadastrado, PrecoInvalido, QuantidadeInvalida, FormatoIngredientesInvalido, ErroGrave, PratoNaoCadastrado {
		GerenciaCardapio gerenciamentoCardapio = new GerenciaCardapio();
		return gerenciamentoCardapio.editarPrato(cardapio, listaProdutos, codigoPrato, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaCardapio e retornar o método excluirPrato.
	 * @param cardapio Lista de pratos
	 * @param listaIds Lista de id's
	 * @param codigoPrato Id do prato que deseja editar
	 * @return Boolean excluirPrato
	 * @throws PratoNaoCadastrado 
	 * @throws ErroGrave 
	 */
	@Override
	public boolean excluirPrato(ArrayList<Prato> cardapio, ArrayList<String> listaIds, String codigoPrato) throws ErroGrave, PratoNaoCadastrado {
		GerenciaCardapio gerenciamentoCardapio = new GerenciaCardapio();
		return gerenciamentoCardapio.excluirPrato(cardapio, listaIds, codigoPrato);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaVendas e retornar o método cadastrarVenda.
	 * @param listaVendas Lista de vendas
	 * @param listaIds Lista de id's
	 * @param cardapio Cardapio (lista de pratos)
	 * @param info Entradas do Usuario
	 * @return Boolean cadastrarVenda
	 * @throws ErroGrave 
	 * @throws QuantidadeProdutosInsuficiente 
	 * @throws PratoNaoCadastrado 
	 * @throws ClienteNaoCadastrado 
	 */
	@Override
	public boolean cadastrarVenda(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, ArrayList<Prato> cardapio,
			String[] info, HashMap<String, ArrayList<Produto>> listaProdutos, ArrayList<Cliente> listaClientes) throws PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave, ClienteNaoCadastrado {
		GerenciaVendas gerenciamentoVendas = new GerenciaVendas();
		return gerenciamentoVendas.cadastrarVenda(listaVendas, listaIds, cardapio, info, listaProdutos, listaClientes);
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
	
	/**Metódo para instanciar um objeto do tipo GeraRelatorio e retornar o método estoqueTotal.
	 * @param listaProdutos HashMap de produtos
	 */
	@Override
	public boolean estoqueTotal(HashMap<String, ArrayList<Produto>> listaProdutos) throws RelatorioNaoGerado, ErroGrave {
		GeraRelatorio relatorio = new GeraRelatorio();
		return relatorio.estoqueTotal(listaProdutos);
		
	}
	
	/**Metódo para instanciar um objeto do tipo GeraRelatorio e retornar o método estoquePorProduto.
	 * @param listaProdutos HashMap de produtos
	 */
	@Override
	public boolean estoquePorProduto(HashMap<String, ArrayList<Produto>> listaProdutos) throws RelatorioNaoGerado, ErroGrave {
		GeraRelatorio relatorio = new GeraRelatorio();
		return relatorio.estoquePorProduto(listaProdutos);
		
	}
	
	/**Metódo para instanciar um objeto do tipo GeraRelatorio e retornar o método estoqueProdutosPertoDeVencer.
	 * @param listaProdutos HashMap de produtos
	 */
	@Override
	public boolean estoqueProdutosPertoDeVencer(HashMap<String, ArrayList<Produto>> listaProdutos) throws ErroGrave, RelatorioNaoGerado {
		GeraRelatorio relatorio = new GeraRelatorio();
		return relatorio.estoqueProdutosPertoDeVencer(listaProdutos);
		
	}
	
	/**Metódo para instanciar um objeto do tipo GeraRelatorio e retornar o método fornecedorPorProduto.
	 * @param listaProdutos HashMap de produtos
	 */
	@Override
	public boolean fornecedorPorProduto(HashMap<String, ArrayList<Produto>> listaProdutos) throws RelatorioNaoGerado, ErroGrave {
		GeraRelatorio relatorio = new GeraRelatorio();
		return relatorio.fornecedorPorProduto(listaProdutos);
		
	}
	
	/**Metódo para instanciar um objeto do tipo GeraRelatorio e retornar o método fornecedorPorFornecedor.
	 * @param listaFornecedores Lista de fornecedores
	 */
	@Override
	public boolean fornecedorPorFornecedor(ArrayList<Fornecedor> listaFornecedores) throws RelatorioNaoGerado, ErroGrave {
		GeraRelatorio relatorio = new GeraRelatorio();
		return relatorio.fornecedorPorFornecedor(listaFornecedores);
		
	}
	
	/**Metódo para instanciar um objeto do tipo GeraRelatorio e retornar o método vendasTotal.
	 * @param listaVendas Lista de vendas
	 */
	@Override
	public boolean vendasTotal(ArrayList<Venda> listaVendas) throws ErroGrave, RelatorioNaoGerado {
		GeraRelatorio relatorio = new GeraRelatorio();
		return relatorio.vendasTotal(listaVendas);
		
	}
	
	/**Metódo para instanciar um objeto do tipo GeraRelatorio e retornar o método vendasPorPeriodo.
	 * @param listaVendas Lista de vendas
	 */
	@Override
	public boolean vendasPorPeriodo(ArrayList<Venda> listaVendas) throws ErroGrave {
		GeraRelatorio relatorio = new GeraRelatorio();
		return relatorio.vendasPorPeriodo(listaVendas);
		
	}
	
	/**Metódo para instanciar um objeto do tipo GeraRelatorio e retornar o método vendasPorTipoDePrato.
	 * @param listaVendas Lista de vendas
	 */
	@Override
	public boolean vendasPorTipoDePrato(ArrayList<Venda> listaVendas) throws ErroGrave, RelatorioNaoGerado {
		GeraRelatorio relatorio = new GeraRelatorio();
		return relatorio.vendasPorTipoDePrato(listaVendas);
		
	}



}