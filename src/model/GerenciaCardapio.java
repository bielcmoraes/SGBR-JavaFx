package model;


import java.util.ArrayList;
import java.util.HashMap;

import exceptions.ErroGrave;
import exceptions.FormatoIngredientesInvalido;
import exceptions.PratoNaoCadastrado;
import exceptions.PrecoInvalido;
import exceptions.ProdutoNaoCadastrado;
import exceptions.QuantidadeInvalida;

/**Classe responsável por implementar os metódos de cadastrar, editar e excluir pratos da classe CardapioCopyable.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 *
 */
public class GerenciaCardapio implements CardapioCopyable {
	
	/**
	 * O método é responsável por cadastrar um objeto do tipo Prato em uma ArrayList<Prato>.
	 * Esse cadastro só ocorre caso todos os dados passados atraves da String []
	 * possam ser convertidos para seus respectivos tipos correspondente.
	 * @param cardapio Lista de Pratos
	 * @param listaIds Lista de IDs
	 * @param listaProdutos Lista de Produtos
	 * @param info Lista com as entradas do usuario
	 * @return true caso o cadastro ocorra corretamente, false caso ocorra algum problema durante o processo.
	 * @throws ProdutoNaoCadastrado 
	 * @throws ErroGrave 
	 */
	@Override
	public boolean cadastrarPrato(ArrayList<Prato> cardapio, ArrayList<String> listaIds, HashMap<String, ArrayList<Produto>> listaProdutos, String [] info) throws 
	PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave {
		try {
			Double preco = null;
			try {
				preco = Double.parseDouble(info[1]);
			} catch (NumberFormatException e) {
				throw new PrecoInvalido();
			}
			
			if (preco < 0) {
				throw new PrecoInvalido();
			}
			
			String [] ingredientes = info[4].split(";");
			HashMap<String, ArrayList<Produto>> produtos = new HashMap<String, ArrayList<Produto>>();
			HashMap<String, Double> receita = new HashMap<String, Double>();
			
			if (ingredientes.length > 0 && ingredientes.length % 3 == 0) {
				for (int i = 2; i < ingredientes.length; i+=3) {
					if (listaProdutos.containsKey(ingredientes[i])) {
						produtos.put(ingredientes[i], listaProdutos.get(ingredientes[i]));
						Double quantidade = null;
						try {
							quantidade = Double.parseDouble(ingredientes[i-2]);
						} catch (NumberFormatException e) {
							throw new QuantidadeInvalida();
						}
						if (quantidade <= 0) {
							throw new QuantidadeInvalida();
						}
						receita.put(ingredientes[i], quantidade);
					} else {
						throw new ProdutoNaoCadastrado();
					}
				}
				
				Prato novoPrato = new Prato(listaIds, info[0], preco, info[2], info[3], produtos, receita);
				cardapio.add(novoPrato);
			} else {
				throw new FormatoIngredientesInvalido();
			}
			return true;
		} catch(ArrayIndexOutOfBoundsException e1) {
			throw new ErroGrave();
		} catch(NullPointerException e2) {
			throw new ErroGrave();
		}
	}
	/**
	 * O método é responsável por editar um objeto do tipo Prato em uma ArrayList<Prato>.
	 * Essa edição só ocorre caso todos os dados passados atraves da String []
	 * possam ser convertidos para seus respectivos tipos correspondente
	 * e o prato a ser editado possa ser encontrada na lista de pratos.
	 * @param cardapio Lista de Pratos
	 * @param listaProdutos Lista de Produtos
	 * @param codigoPrato Codigo do prato a ser editado
	 * @param info Lista com as entradas do usuario
	 * @return true caso a edição ocorra corretamente, false caso ocorra algum problema durante o processo.
	 * @throws ProdutoNaoCadastrado 
	 * @throws PratoNaoCadastrado 
	 */
	@Override
	public boolean editarPrato(ArrayList<Prato> cardapio, HashMap<String, ArrayList<Produto>> listaProdutos, String codigoPrato, String [] info) 
			throws PrecoInvalido, QuantidadeInvalida, ProdutoNaoCadastrado, FormatoIngredientesInvalido, ErroGrave, PratoNaoCadastrado {
		
		
		try {
			for(Prato prato : cardapio) {
				if(codigoPrato.equals(prato.getId())) {
					
					Double preco = null;
					try {
						preco = Double.parseDouble(info[1]);
					} catch (NumberFormatException e) {
						throw new PrecoInvalido();
					}
					
					if (preco < 0) {
						throw new PrecoInvalido();
					}
					
					String [] ingredientes = info[4].split(";");
					HashMap<String, ArrayList<Produto>> produtos = new HashMap<String, ArrayList<Produto>>();
					HashMap<String, Double> receita = new HashMap<String, Double>();
					
					if (ingredientes.length > 0 && ingredientes.length % 3 == 0) {
						for (int i = 2; i < ingredientes.length; i+=3) {
							if (listaProdutos.containsKey(ingredientes[i])) {
								produtos.put(ingredientes[i], listaProdutos.get(ingredientes[i]));
								Double quantidade = null;
								try {
									quantidade = Double.parseDouble(ingredientes[i-2]);
								} catch (NumberFormatException e) {
									throw new QuantidadeInvalida();
								}
								
								if (quantidade <= 0) {
									throw new QuantidadeInvalida();
								}
								receita.put(ingredientes[i], quantidade);
							} else {
								throw new ProdutoNaoCadastrado();
							}
						}
					
						prato.setNome(info[0]);
						prato.setPreco(preco);
						prato.setDescricao(info[2]);
						prato.setCategoria(info[3]);
						return true;
					} else {
						throw new FormatoIngredientesInvalido();
					}
				}
			}
			throw new PratoNaoCadastrado();
		} catch(ArrayIndexOutOfBoundsException e1) {
			throw new ErroGrave();
		} catch(NullPointerException e2) {
			throw new ErroGrave();
		}
	}
	/**
	 * O método é responsável por excluir um objeto do tipo Prato em uma ArrayList<Prato>.
	 * Essa exclusão só ocorre caso o prato a ser excluido possa ser encontrada na lista de pratos.
	 * @param cardapio Lista de Pratos
	 * @param listaIds Lista de IDs
	 * @param codigoPrato Codigo do prato a ser excluido
	 * @return true caso a exclusão ocorra corretamente, false caso ocorra algum problema durante o processo.
	 * @throws ErroGrave 
	 */
	@Override
	public boolean excluirPrato(ArrayList<Prato> cardapio, ArrayList<String> listaIds, String codigoPrato) 
			throws ErroGrave, PratoNaoCadastrado {
		
		try {
			for(Prato prato : cardapio) {
				if(codigoPrato.equals(prato.getId())) {
					int index = cardapio.indexOf(prato);
					cardapio.remove(index);
					return true;
				}
			}
			throw new PratoNaoCadastrado();
		} catch(ArrayIndexOutOfBoundsException e1) {
			throw new ErroGrave();
		} catch(NullPointerException e2) {
			throw new ErroGrave();
		}
	}
}
