package model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import exceptions.ClienteNaoCadastrado;
import exceptions.ErroGrave;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoHorarioInvalido;
import exceptions.PratoNaoCadastrado;
import exceptions.QuantidadeProdutosInsuficiente;
import exceptions.VendaNaoCadastrada;

/**Classe responsável por implementar os metódos de cadastrar, editar e excluir vendas da classe VendaCopyable.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 *
 */
public class GerenciaVendas {
	/**
	 * O método é responsável por cadastrar um objeto do tipo Venda em uma ArrayList<Venda>.
	 * Esse cadastro só ocorre caso todos os dados passados atraves da String []
	 * possam ser convertidos para seus respectivos tipos correspondente.
	 * @param listaVendas Lista de Vendas
	 * @param listaIds Lista de IDs
	 * @param cardapio Lista de Pratos
	 * @param info Lista com as entradas do usuario
	 * @param listaProdutos Lista de produtos
	 * @return true caso o cadastro ocorra corretamente, false caso ocorra algum problema durante o processo.
	 * @throws QuantidadeProdutosInsuficiente 
	 * @throws PratoNaoCadastrado 
	 * @throws ClienteNaoCadastrado 
	 */
	public boolean cadastrarVenda(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, ArrayList<Prato> cardapio, String [] info, HashMap<String, ArrayList<Produto>> listaProdutos, ArrayList<Cliente> listaClientes)
			throws PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave, ClienteNaoCadastrado {
		
		ArrayList<Prato> pratos = new ArrayList<Prato>();
		for (String pratoNome : info[0].split(", ")) {
			for (Prato prato : cardapio) {
				if (pratoNome.equals(prato.getNome())) {
					pratos.add(prato);
				}
			}
		}
		
		if (pratos.size() != info[0].split(", ").length) {
			throw new PratoNaoCadastrado();
		}
		
		HashMap<String, Double> ingredientesTotal = new HashMap<String, Double>();
		for (Prato prato : pratos) {
			for (String produto : prato.getReceita().keySet()) {
				if (ingredientesTotal.containsKey(produto)) {
					ingredientesTotal.put(produto, ingredientesTotal.get(produto) + prato.getReceita().get(produto));
				} else {
					ingredientesTotal.put(produto, prato.getReceita().get(produto));
				}
			}
		}
		
		HashMap<String, Double> estoqueTotal = new HashMap<String, Double>();
		for (String produto : listaProdutos.keySet()) {
			ArrayList<Produto> estoque = listaProdutos.get(produto);
			Double quantidadeTotal = 0.0;
			for (Produto item : estoque) {
				quantidadeTotal += item.getQuantidade();
			}
			estoqueTotal.put(produto, quantidadeTotal);
		}
		
		for (String produto : ingredientesTotal.keySet()) {
			if (estoqueTotal.get(produto) < ingredientesTotal.get(produto)) {
				throw new QuantidadeProdutosInsuficiente();
			}
		}
		
		for (String produto : ingredientesTotal.keySet()) {
			ArrayList<Produto> estoque = listaProdutos.get(produto);
			Collections.sort(estoque, new ComparadorDeValidadeProduto());
			Double quantUsada = ingredientesTotal.get(produto);
			while (quantUsada > 0) {
				Double quantRestante = estoque.get(0).getQuantidade() - quantUsada;
				if (quantRestante > 0) {
					estoque.get(0).setQuantidade(quantRestante);
					break;
				} else {
					quantUsada = quantUsada - estoque.get(0).getQuantidade();
					estoque.remove(0);
					if (listaProdutos.get(produto).size() <= 0) {
						listaProdutos.remove(produto);
					}
					if (quantRestante == 0) {
						break;
					}
				} 
			}
		}
		
		
		Double precoTotal = 0.0;
		for (Prato prato : pratos) {
			precoTotal += prato.getPreco();
		}
		
		Cliente cliente = null;
		for (Cliente clienteTemp: listaClientes) {
			if (clienteTemp.getNome().equals(info[2])) {
				cliente = clienteTemp;
				break;
			}
		}
		
		if (cliente == null) {
			throw new ClienteNaoCadastrado();
		}
		
		Venda novaVenda = new Venda(listaIds, pratos, precoTotal, info[1], cliente);
		
		
		try {
			listaVendas.add(novaVenda);
			return true;
		} catch(ArrayIndexOutOfBoundsException e1) {
			throw new ErroGrave();
		} catch(NullPointerException e2) {
			throw new ErroGrave();
		}
	}
	/**
	 * O método é responsável por editar um objeto do tipo Venda em uma ArrayList<Venda>.
	 * Essa edição só ocorre caso todos os dados passados atraves da String []
	 * possam ser convertidos para seus respectivos tipos correspondente
	 * e a venda a ser editada possa ser encontrada na lista de vendas.
	 * @param listaVendas Lista de Vendas
	 * @param cardapio Lista de Pratos
	 * @param codigoVenda Codigo da Venda a ser editada
	 * @param info Lista com as entradas do usuario
	 * @param listaProdutos Lista de produtos
	 * @return true caso a edição ocorra corretamente, false caso ocorra algum problema durante o processo.
	 * @throws VendaNaoCadastrada 
	 * @throws ClienteNaoCadastrado 
	 */
	public boolean editarVenda(ArrayList<Venda> listaVendas, ArrayList<Prato> cardapio, String codigoVenda, String [] info, HashMap<String, ArrayList<Produto>> listaProdutos, ArrayList<Cliente> listaClientes) 
			throws FormatoDataInvalido, FormatoHorarioInvalido, PratoNaoCadastrado, QuantidadeProdutosInsuficiente, ErroGrave, VendaNaoCadastrada, ClienteNaoCadastrado{
		
		try {
			for(Venda venda : listaVendas) {
				if(codigoVenda.equals(venda.getId())) {

					DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dia;
					try {
						dia = LocalDate.parse(info[0], formatoData);
					} catch (java.time.format.DateTimeParseException a) {
						throw new FormatoDataInvalido();
					}
					
					DateTimeFormatter formatoHorario = DateTimeFormatter.ofPattern("HH:mm");
					LocalTime horario;
					try {
						horario = LocalTime.parse(info[1], formatoHorario);
					} catch (java.time.format.DateTimeParseException a) {
						throw new FormatoHorarioInvalido();
					}

					ArrayList<Prato> pratos = new ArrayList<Prato>();
					for (String pratoNome : info[2].split(", ")) {
						for (Prato prato : cardapio) {
							if (pratoNome.equals(prato.getNome())) {
								pratos.add(prato);
							}
						}
					}
	
					if (pratos.size() != info[2].split(", ").length) {
						throw new PratoNaoCadastrado();
					}
					
					HashMap<String, Double> ingredientesTotal = new HashMap<String, Double>();
					for (Prato prato : pratos) {
						for (String produto : prato.getReceita().keySet()) {
							if (ingredientesTotal.containsKey(produto)) {
								ingredientesTotal.put(produto, ingredientesTotal.get(produto) + prato.getReceita().get(produto));
							} else {
								ingredientesTotal.put(produto, prato.getReceita().get(produto));
							}
						}
					}
					
					ArrayList<Prato> pratosRemovidos = venda.getPratos();
					HashMap<String, Double> ingredientesRemovidos = new HashMap<String, Double>();
					for (Prato prato : pratosRemovidos) {
						for (String produto : prato.getReceita().keySet()) {
							if (ingredientesRemovidos.containsKey(produto)) {
								ingredientesRemovidos.put(produto, ingredientesRemovidos.get(produto) + prato.getReceita().get(produto));
							} else {
								ingredientesRemovidos.put(produto, prato.getReceita().get(produto));
							}
						}
					}
					
					for (String produto : ingredientesRemovidos.keySet()) {
						if (ingredientesTotal.containsKey(produto)) {
							Double restante = ingredientesTotal.get(produto) - ingredientesRemovidos.get(produto);
							if (restante <= 0) {
								ingredientesTotal.remove(produto);
							} else {
								ingredientesTotal.put(produto, restante);
							}
						}
					}
					
					HashMap<String, Double> estoqueTotal = new HashMap<String, Double>();
					for (String produto : listaProdutos.keySet()) {
						ArrayList<Produto> estoque = listaProdutos.get(produto);
						Double quantidadeTotal = 0.0;
						for (Produto item : estoque) {
							quantidadeTotal += item.getQuantidade();
						}
						estoqueTotal.put(produto, quantidadeTotal);
					}
					
					for (String produto : ingredientesTotal.keySet()) {
						if (estoqueTotal.get(produto) < ingredientesTotal.get(produto)) {
							throw new QuantidadeProdutosInsuficiente();
						}
					}
					
					for (String produto : ingredientesTotal.keySet()) {
						ArrayList<Produto> estoque = listaProdutos.get(produto);
						Collections.sort(estoque, new ComparadorDeValidadeProduto());
						Double quantUsada = ingredientesTotal.get(produto);
						while (quantUsada > 0) {
							Double quantRestante = estoque.get(0).getQuantidade() - quantUsada;
							if (quantRestante > 0) {
								estoque.get(0).setQuantidade(quantRestante);
								break;
							} else {
								quantUsada = quantUsada - estoque.get(0).getQuantidade();
								estoque.remove(0);
								if (listaProdutos.get(produto).size() <= 0) {
									listaProdutos.remove(produto);
								}
								if (quantRestante == 0) {
									break;
								}
							} 
						}
					}
					
					Double precoTotal = 0.0;
					for (Prato prato : pratos) {
						precoTotal += prato.getPreco();
					}
					
					Cliente cliente = null;
					for (Cliente clienteTemp: listaClientes) {
						if (clienteTemp.getNome().equals(info[5])) {
							cliente = clienteTemp;
							break;
						}
					}
					
					if (cliente == null) {
						throw new ClienteNaoCadastrado();
					}
					
					venda.setData(dia);
					venda.setHorario(horario);
					venda.setPratos(pratos);
					venda.setPrecoTotal(precoTotal);
					venda.setMetodoDePagamento(info[3]);
					venda.setCliente(cliente);
					
					return true;
				}
			}
			throw new VendaNaoCadastrada();
		} catch(ArrayIndexOutOfBoundsException e1) {
			throw new ErroGrave();
		} catch(NullPointerException e2) {
			throw new ErroGrave();
		}
	}
	/**
	 * O método é responsável por excluir um objeto do tipo Venda em uma ArrayList<Venda>.
	 * Essa exclusão só ocorre caso a venda a ser excluido possa ser encontrada na lista de vendas.
	 * @param listaVendas Lista de Vendas
	 * @param listaIds Lista de IDs
	 * @param codigoVenda Codigo da Venda a ser excluida
	 * @return true caso a exclusão ocorra corretamente, false caso ocorra algum problema durante o processo.
	 */
	public boolean excluirVenda(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, String codigoVenda) 
			throws VendaNaoCadastrada, ErroGrave {
		
		try {
			for(Venda venda : listaVendas) {
				if(codigoVenda.equals(venda.getId())) {
					int index = listaVendas.indexOf(venda);
					listaVendas.remove(index);
					return true;
				}
			}
			throw new VendaNaoCadastrada();
		} catch(ArrayIndexOutOfBoundsException e1) {
			throw new ErroGrave();
		} catch(NullPointerException e2) {
			throw new ErroGrave();
		}
	}
	
	
}
