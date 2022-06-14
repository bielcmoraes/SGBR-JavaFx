package controller;

public class IdObjetoSelecionado {
	private static IdObjetoSelecionado instancia;
	private String id;
	
	private IdObjetoSelecionado() {
	}
	
	public static synchronized IdObjetoSelecionado getInstance() {
		if(instancia == null) {
			instancia = new IdObjetoSelecionado();
		}
		return instancia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
