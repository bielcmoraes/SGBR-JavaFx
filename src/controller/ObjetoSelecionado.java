package controller;

import model.Entidade;

public class ObjetoSelecionado {
	private static ObjetoSelecionado instancia;
	private Entidade obj;
	
	private ObjetoSelecionado() {
	}
	
	public static synchronized ObjetoSelecionado getInstance() {
		if(instancia == null) {
			instancia = new ObjetoSelecionado();
		}
		return instancia;
	}

	public Entidade getObj() {
		return obj;
	}

	public void setObj(Entidade obj) {
		this.obj = obj;
	}


}
