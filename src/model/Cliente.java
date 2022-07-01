package model;

import java.util.ArrayList;

public class Cliente extends Entidade{

	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private ArrayList<Venda> compras;
	
	
	//Construtores
	public Cliente(String nome, String cpf, String email, String telefone) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.compras = new ArrayList<Venda>();
	}
	
	//Metodos
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public ArrayList<Venda> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Venda> compras) {
		this.compras = compras;
	}
	
	public String toString() {
		return this.nome;
	}
}
