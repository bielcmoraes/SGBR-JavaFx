package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**Classe para objetos do tipo Venda, onde são contidos, valores e metódos necessarios para implementação da classe.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 * @see Entidade
 */
public class Venda extends Entidade{
	
	// Attributes
	private LocalDate data;
	private LocalTime horario;
	private ArrayList<Prato> pratos;
	private Double precoTotal;
	private String metodoDePagamento;
	private Cliente cliente;
	
	/**O construtor inicializa o construtor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro. 

	 * 
	 * @param listaIds Lista de id's
	 * @param data Data da venda
	 * @param horario Horário da venda
	 * @param pratos Pratos quem foram vendidos
	 * @param precoTotal Preço total da venda
	 * @param metodoDePagamento Forma de pagamento da venda
	 */
	public Venda(ArrayList<String> listaIds, ArrayList<Prato> pratos, Double precoTotal, String metodoDePagamento, Cliente cliente) {
		
		super(listaIds);
		this.data = LocalDate.now();
		this.horario = LocalTime.now();
		this.pratos = pratos;
		this.precoTotal = precoTotal;
		this.metodoDePagamento = metodoDePagamento;
		this.cliente = cliente;
	}

	/**Metódo para retorno de data da venda.
	 * @return LocalDate Data da venda*/
	public LocalDate getData() {
		return data;
	}
	
	/**Metódo para alterar a data da venda.
	 * @param data Nova data da venda*/
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	/**Metódo para retorno de horário da venda.
	 * @return LocalTime Horário da venda*/
	public LocalTime getHorario() {
		return horario;
	}
	
	/**Metódo para alterar o horário da venda.
	 * @param horario Novo horário da venda*/
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	/**Metódo para retorno de lista com pratos vendidos.
	 * @return Lista de pratos da venda*/
	public ArrayList<Prato> getPratos() {
		return pratos;
	}
	
	/**Metódo para alterar a lista de pratos da venda.
	 * @param pratos Nova lista de pratos da venda*/
	public void setPratos(ArrayList<Prato> pratos) {
		this.pratos = pratos;
	}
	
	/**Metódo para retorno de preço total da venda.
	 * @return Double Preço da venda*/
	public Double getPrecoTotal() {
		return precoTotal;
	}
	
	/**Metódo para alterar o preço total da venda.
	 * @param precoTotal Novo preço total da venda*/
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	/**Metódo para retorno de forma de pagamento da venda.
	 * @return String Forma de pagamento da venda*/
	public String getMetodoDePagamento() {
		return metodoDePagamento;
	}
	
	/**Metódo para alterar o metódo de pagamento da venda.
	 * @param metodoDePagamento	Nova forma de pagamento da venda*/
	public void setMetodoDePagamento(String metodoDePagamento) {
		this.metodoDePagamento = metodoDePagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}

