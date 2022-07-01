package controller;

public class Ingrediente {
	private String nome;
	private String medida;
	private String quantidade;
	
	public Ingrediente(String nome, String medida,String quantidade) {
		super();
		this.nome = nome;
		this.medida = medida;
		this.quantidade = quantidade;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}
	
}
