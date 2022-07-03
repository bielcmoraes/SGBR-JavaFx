package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import exceptions.ErroGrave;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoQuantidadeInvalido;
import exceptions.FornecedorNaoCadastrado;
import exceptions.PrecoInvalido;
import exceptions.ProdutoNaoCadastrado;
import exceptions.QuantidadeInvalida;

/**Classe responsável por implementar os metódos de cadastrar, editar e excluir produto que foram especificados na classe ProdutoCopyable.
 * 
 *  @author Gabriel Moraes
 *  @author Luis Fernando Cintra
 *
 */
public class GerenciaProdutos {
	/**
	 * O método é responsável por cadastrar um objeto do tipo Produto em uma ArrayList<Produto>.
	 * Esse cadastro só ocorre caso todos os dados passados atraves da String []
	 * possam ser convertidos para seus respectivos tipos correspondente.
	 * @param listaProdutos Lista de Produtos
	 * @param listaIds Lista de IDs
	 * @param info Lista com as entradas do usuario
	 * @param listaFornecedor Lista de fornecedores
	 * @return true caso o cadastro ocorra corretamente, false caso ocorra algum problema durante o processo
	 */
	public boolean cadastrarProduto(HashMap<String, ArrayList<Produto>> listaProdutos, ArrayList<String> listaIds, String [] info, ArrayList<Fornecedor> listaFornecedor) 
			throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave{
		
		Double preco;
		info[1] = info[1].replace("R$ ", "");
		try {
			
			preco = Double.parseDouble(info[1]);
		} catch (java.lang.NumberFormatException e) {
			throw new PrecoInvalido();
		}
		
		if (preco < 0) {
			throw new PrecoInvalido();
		}
		
		String [] info2 = info[2].split(" ");
		
		if (info2.length != 2) {
			throw new FormatoQuantidadeInvalido();
		}
		
		Double quantidade;
		try {
			quantidade = Double.parseDouble(info2[0]);
		} catch (java.lang.NumberFormatException e) {
			throw new QuantidadeInvalida();
		}
		
		if (quantidade <= 0.0) {
			throw new QuantidadeInvalida();
		}
		
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate validade;
		try {
			validade = LocalDate.parse(info[3], formatoData);
		} catch (java.time.format.DateTimeParseException a) {
			throw new FormatoDataInvalido();
		}
		
		
		ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		
		//Verifica se o nome do fornecedor passado está na lista de fornecedores.
		//Se o nome for igual adiciona o fornecedor à lista.
		for (String fornecedorNome : info[4].split(", ")) {
			for (Fornecedor fornecedor : listaFornecedor) {
				if (fornecedorNome.equals(fornecedor.getNome())) {
					fornecedores.add(fornecedor);
				}
			}
		}
		
		//Garante que os fornecedores adicionados estejam na lista de fornecedores
		if (fornecedores.size() != info[4].split(", ").length) {
			throw new FornecedorNaoCadastrado();
		}
		
		Produto novoProduto = new Produto(listaIds, info[0], preco, quantidade, info2[1], validade, fornecedores);

		try {
			if (!listaProdutos.containsKey(novoProduto.getNome())) {
				//Cria uma nova key na HashMap e adiciona o produto;
				listaProdutos.put(novoProduto.getNome(), new ArrayList<Produto>());
				
				//Adiciona o produto ao fornecedor indicado
				for (String fornecedorNome : info[4].split(", ")) {
					for (Fornecedor fornecedor : listaFornecedor) {
						if (fornecedorNome.equals(fornecedor.getNome()) && !fornecedor.getProdutos().contains(novoProduto.getNome())) {
							fornecedor.getProdutos().add(novoProduto.getNome());
						}
					}
				}
			}
			//Adiciona o produto a uma key ja existente da HashMap
			listaProdutos.get(novoProduto.getNome()).add(novoProduto);
			return true;
		} catch(ArrayIndexOutOfBoundsException e1) {
			throw new ErroGrave();
		} catch(NullPointerException e2) {
			throw new ErroGrave();
		}
	}
	/**
	 * O método é reponsavel por editar as informações de um objeto do tipo Produto já cadastrado em uma ArrayList<Produto>.
	 * Essa edição só ocorre caso todos os dados passados atraves da String [] 
	 * possam ser convertidos para seus respectivos tipos correspondente
	 * e o produto a ser editado possa ser encontrado na lista de produtos.
	 * @param listaProdutos Lista de Produtos
	 * @param codigoProduto Código do Produto a ser editado
	 * @param info Lista com as entradas do usuario
	 * @param listaFornecedor Lista de fornecedores
	 * @return true caso a edição ocorra corretamente, false caso ocorra algum problema durante o processo
	 */
	public boolean editarProduto(HashMap<String, ArrayList<Produto>> listaProdutos, String codigoProduto, String [] info, ArrayList<Fornecedor> listaFornecedor) 
			throws PrecoInvalido, FormatoQuantidadeInvalido, QuantidadeInvalida, FormatoDataInvalido, FornecedorNaoCadastrado, ErroGrave {
		
		try {
			for(ArrayList<Produto> estoque : listaProdutos.values()) {
				for(Produto produto : estoque) {
					if(codigoProduto.equals(produto.getId())) {
						
						Double preco;
						try {
							preco = Double.parseDouble(info[1]);
						} catch (java.lang.NumberFormatException a) {
							throw new PrecoInvalido();
						}
						
						if (preco < 0) {
							throw new PrecoInvalido();
						}
						
						String [] info2 = info[2].split(" ");
						
						if (info2.length != 2) {
							throw new FormatoQuantidadeInvalido();
						}
						
						Double quantidade;
						try {
							quantidade = Double.parseDouble(info2[0]);
						} catch (java.lang.NumberFormatException a) {
							throw new QuantidadeInvalida();
						}
						
						if (quantidade <= 0.0) {
							throw new QuantidadeInvalida();
						}
						
						DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate validade;
						try {
							validade = LocalDate.parse(info[3], formatoData);
						} catch (java.time.format.DateTimeParseException a) {
							throw new FormatoDataInvalido();
						}
						
						ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
						for (String fornecedorNome : info[4].split(", ")) {
							for (Fornecedor fornecedor : listaFornecedor) {
								if (fornecedorNome.equals(fornecedor.getNome())) {
									fornecedores.add(fornecedor);
								}
							}
						}
						
						//Garante que os fornecedores estejam na lista de fornecedores
						if (fornecedores.size() != info[4].split(", ").length) {
							throw new FornecedorNaoCadastrado();
						}
						
						produto.setNome(info[0]);
						produto.setPreco(preco);
						produto.setQuantidade(quantidade);
						produto.setUnidadeDeMedida(info2[1]);
						produto.setValidade(validade);
						produto.setFornecedores(fornecedores);
			
						return true;
					}
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e1) {
			throw new ErroGrave();
		} catch(NullPointerException e2) {
			throw new ErroGrave();
		}
		return false;
	}
	/**
	 * O método é reponsavel por excluir um objeto do tipo Produto já cadastrado em uma ArrayList<Produto>.
	 * Essa exclusão só ocorre caso o produto a ser excluido seja encontrado na lista de produtos.
	 * @param listaProdutos Lista de Produtos
	 * @param listaIds Lista de IDs
	 * @param codigoProduto Código do Produto a ser editado
	 * @return true caso a edição ocorra corretamente, false caso ocorra algum problema durante o processo
	 */
	public boolean excluirProduto(HashMap<String, ArrayList<Produto>> listaProdutos, ArrayList<String> listaIds, String codigoProduto) 
	throws ErroGrave {
		
		try {
			for(ArrayList<Produto> estoque : listaProdutos.values()) {
				for(Produto produto : estoque) {
					if(codigoProduto.equals(produto.getId())) {
						int index = estoque.indexOf(produto);
						estoque.remove(index);
						if (estoque.size() <= 0) {
							listaProdutos.remove(produto.getNome());
						}
						return true;
					}
				}
			}
			return false;
		}
		catch(ArrayIndexOutOfBoundsException e1) {
			throw new ErroGrave();
		} catch(NullPointerException e2) {
			throw new ErroGrave();
		}
	}
}
