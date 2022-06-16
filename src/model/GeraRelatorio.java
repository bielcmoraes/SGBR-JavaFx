package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Table;

import exceptions.ErroGrave;
import exceptions.ProdutoNaoCadastrado;
import exceptions.RelatorioNaoGerado;

/**Classe respónsavel por implementar os métodos de gerar relatórios PDF que foram especificados na classe GeraRelatoriosCopyable.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class GeraRelatorio implements GeraRelatoriosCopyable {
	
	/*O método gera uma tabela do estoque total por meio do metódo estoqueTotal da classe GeraTabela e passa a tabela para o modelo de relatório 
	 * que gera o relatório e retorna true. Trata erros relacionadoas a criação do documento lançando uma excessão do tipo RelatorioNaoGerado.
	 * 
	 * @return Boolean true
	 * @throws RelatorioNaoGerado
	 * @throws ErroGrave
	 */
	@Override
	public boolean estoqueTotal(HashMap<String, ArrayList<Produto>> listaProdutos) throws RelatorioNaoGerado, ErroGrave {
		
		try{
			GeraTabela tabela = new GeraTabela();
			Table info = tabela.estoqueTotal(listaProdutos);
			new Relatorio(info, "Relatorio de estoque total");
			return true;
			
		} catch (DocumentException e) {
			throw new RelatorioNaoGerado("Relatorio de estoque total");
            
        } catch (FileNotFoundException e) {
        	throw new RelatorioNaoGerado("Relatorio de estoque total");
        	
        }
	}
	
	/*O método gera uma tabela do estoque pro produto através do metódo estoquePorProduto da classe GeraTabela e passa a tabela para o modelo de
	 * relatório que gera o relatório e retorna true. Trata erros relacionadoas a criação do documento lançando uma excessão do tipo RelatorioNaoGerado.
	 * 
	 * @return Boolean true
	 * @throws RelatorioNaoGerado
	 * @throws ErroGrave
	 */
	@Override
	public boolean estoquePorProduto(HashMap<String, ArrayList<Produto>> listaProdutos) throws RelatorioNaoGerado, ErroGrave {
		try {
			GeraTabela tabela = new GeraTabela();
			Table info = tabela.estoquePorProduto(listaProdutos);
			new Relatorio(info, "Relatorio de estoque por produto");
			return true;
			
		} catch (DocumentException e) {
			throw new RelatorioNaoGerado("Relatorio de estoque por produto");
			
        } catch (FileNotFoundException e) {
        	throw new RelatorioNaoGerado("Relatorio de estoque por produto");        	
        }
		
	}
	
	/*O método gera duas tabelas: uma do estoque com os produtos vencidos e outra com os produtos que faltam no máximo sete dias
	 * para vencer, através dos métodos estoqueProdutosVencidos e estoqueProdutosPertoDeVencer da classe GerarTabela, respectivamente. 
	 * Passa as tabelas para o modelo de relatório que gera um relatório com ambas tabelas e retorna true. Trata erros relacionadoas a 
	 * criação do documento lançando uma excessão do tipo RelatorioNaoGerado.
	 * 
	 * @return Boolean true
	 * @throws RelatorioNaoGerado
	 * @throws ErroGrave
	 */
	@Override
	public boolean estoqueProdutosPertoDeVencer(HashMap<String, ArrayList<Produto>> listaProdutos) throws ErroGrave, RelatorioNaoGerado {
		
		try{
			GeraTabela tabela = new GeraTabela();
			Table info1 = tabela.estoqueProdutosVencidos(listaProdutos);
			Table info2 = tabela.estoqueProdutosPertoDeVencer(listaProdutos);
			new Relatorio(info1, info2, "Produtos do estoque vencidos e próximos de vencer");
			return true;
			
		} catch (DocumentException e) {
			throw new RelatorioNaoGerado("Produtos do estoque vencidos e próximos de vencer"); 
            
        } catch (FileNotFoundException e) {
        	throw new RelatorioNaoGerado("Produtos do estoque vencidos e próximos de vencer"); 
        }
	}
	
	/*O método gera uma tabela dos fornecedores por produto através do metódo fornecedorPorProduto da classe GeraTabela e passa a tabela para o modelo de
	 * relatório que gera o relatório e retorna true. Trata erros relacionadoas a criação do documento lançando uma excessão do tipo RelatorioNaoGerado.
	 * 
	 * @return Boolean true
	 * @throws RelatorioNaoGerado
	 * @throws ErroGrave
	 */
	@Override
	public boolean fornecedorPorProduto(HashMap<String, ArrayList<Produto>> listaProdutos) throws RelatorioNaoGerado, ErroGrave {
		
		try{
			GeraTabela tabela = new GeraTabela();
			Table info = tabela.fornecedorPorProduto(listaProdutos);
			new Relatorio(info, "Relatorio de fornecedor por produto");
			return true;
			
		}catch (DocumentException e) {
        	throw new RelatorioNaoGerado("Relatorio de fornecedor por produto"); 
            
        } catch (FileNotFoundException e) {
        	throw new RelatorioNaoGerado("Relatorio de fornecedor por produto"); 
        	
        }
		
	}
	
	/*O método gera uma tabela dos fornecedores por fornecedor através do metódo fornecedorPorFornecedor da classe GeraTabela e passa a tabela para 
	 * o modelo de relatório que gera o relatório e retorna true. Trata erros relacionadoas a criação do documento lançando uma excessão do tipo 
	 * RelatorioNaoGerado.
	 *
	 * @return Boolean true
	 * @throws RelatorioNaoGerado
	 * @throws ErroGrave
	 */
	@Override
	public boolean fornecedorPorFornecedor(ArrayList<Fornecedor> listaFornecedores) throws RelatorioNaoGerado, ErroGrave {
		
		try {
			GeraTabela tabela = new GeraTabela();
			Table info = tabela.fornecedorPorFornecedor(listaFornecedores);
			new Relatorio(info, "Relatorio de fornecedor por fornecedor");
			return true;
			
		} catch (DocumentException e) {
			throw new RelatorioNaoGerado("Relatorio de fornecedor por fornecedor"); 
            
        } catch (FileNotFoundException e) {
			throw new RelatorioNaoGerado("Relatorio de fornecedor por fornecedor"); 
        	
        }
	}
	
	/*O método gera uma tabela de vendas total através do metódo vendasTotal da classe GeraTabela e passa a tabela para o modelo de relatório
	 * que gera o relatório e retorna true. Trata erros relacionadoas a criação do documento lançando uma excessão do tipo RelatorioNaoGerado.
	 * 
	 * @return Boolean true
	 * @throws RelatorioNaoGerado
	 * @throws ErroGrave
	 */
	@Override
	public boolean vendasTotal(ArrayList<Venda> listaVendas) throws ErroGrave, RelatorioNaoGerado {
		
		try{
			GeraTabela tabela = new GeraTabela();
			Table info = tabela.vendasTotal(listaVendas);
			new Relatorio(info, "Relatorio total de vendas");
			return true;
			
		} catch (DocumentException e) {
			throw new RelatorioNaoGerado("Relatorio total de vendas"); 
            
        } catch (FileNotFoundException e) {
			throw new RelatorioNaoGerado("Relatorio total de vendas"); 
        	
        }
	}
	
	/*O método gera três tabelas: uma tabela contendo as vendas diárias, outra tabela contendo as vendas semanais e uma terceira contendo as vendas
	 * mensais, através do métodos vendasDiarias, vendasSemanal e  vendasMensais, respectivamente, da classe GeraTabela. Passa as tabelas para o
	 * três modelos de relatórios distindos que geram um relatório para cada periodo das vendas e retorna true ao final das operações. Trata erros
	 * relacionadoas a criação do documento lançando uma excessão do tipo RelatorioNaoGerado, caso uma escessão do tipo RelatorioNaoGerado seja
	 * lançada retorna false.
	 * 
	 * @return Boolean true
	 * @throws RelatorioNaoGerado
	 * @throws ErroGrave
	 */
	@Override
	public boolean vendasPorPeriodo(ArrayList<Venda> listaVendas) throws ErroGrave {
		GeraTabela tabela = new GeraTabela();
		
		try {
			
			try {
				//Relatorio de vendas diárias
				Table info = tabela.vendasDiarias(listaVendas);
				new Relatorio(info, "Relatorio de vendas diarias");
				
			} catch (DocumentException e) {
				throw new RelatorioNaoGerado("Relatorio de vendas diarias");
	            
	        } catch (FileNotFoundException e) {
	        	throw new RelatorioNaoGerado("Relatorio de vendas diarias");
	        	
	        }
			
			try {
				//Relatorio de vendas semanais
				Table info = tabela.vendasSemanal(listaVendas);
				new Relatorio(info,"Relatorio de vendas semanais");
				
			} catch (DocumentException e) {
				throw new RelatorioNaoGerado("Relatorio de vendas semanais");
	            
	        } catch (FileNotFoundException e) {
	        	throw new RelatorioNaoGerado("Relatorio de vendas semanais");
	        	
	        }
			
			try {
				
				//Relatorio de vendas mensais
				Table info = tabela.vendasMensais(listaVendas);
				new Relatorio(info, "Relatorio de vendas mensais");
			}catch (DocumentException e) {
				throw new RelatorioNaoGerado("Relatorio de vendas mensais");
	            
	        } catch (FileNotFoundException e) {
	        	throw new RelatorioNaoGerado("Relatorio de vendas mensais");
	        	
	        }
			return true;
			
		}catch(RelatorioNaoGerado r) {
			return false;
		}
	}
	
	/*O método gera uma tabela de vendas por tipo de prato através do metódo vendasPorTipoDePrato da classe GeraTabela e passa a tabela para
	 * o modelo de relatório que gera o relatório e retorna true. Trata erros relacionadoas a criação do documento lançando uma excessão do
	 * tipo RelatorioNaoGerado.
	 * 
	 * @return Boolean true
	 * @throws RelatorioNaoGerado
	 * @throws ErroGrave
	 */
	@Override
	public boolean vendasPorTipoDePrato(ArrayList<Venda> listaVendas) throws ErroGrave, RelatorioNaoGerado {
		
		try{
			GeraTabela tabela = new GeraTabela();
			Table info = tabela.vendasPorTipoDePrato(listaVendas);
			new Relatorio(info, "Relatorio de vendas por tipo de prato");
			return true;
			
		} catch (DocumentException e) {
			throw new RelatorioNaoGerado("Relatorio de vendas por tipo de prato");
            
        } catch (FileNotFoundException e) {
        	throw new RelatorioNaoGerado("Relatorio de vendas por tipo de prato");
        	
        } 
	}
	
	public boolean notaFiscal(Venda venda) throws RelatorioNaoGerado {
		
		try {
			new Relatorio(venda);
			return true;
		} catch (DocumentException e) {
			throw new RelatorioNaoGerado("Nota fiscal não gerada");
		} catch (FileNotFoundException e) {
			throw new RelatorioNaoGerado("Nota fiscal não gerada");
		}
		
	}

}
