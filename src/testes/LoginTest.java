package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import model.BancoDeDados;
import model.Login;
import model.Usuario;

public class LoginTest {
	
	@Test
	public void autenticaLoginListaUsuarioNull(){
		Login lo = new Login(BancoDeDados.getInstance().getListaUsuarios());
		String login = "patati";
		String senha = "patata";
		assertNull(lo.autenticarLogin(null, login, senha), "Tentando logar com a lista de usuarios null");
	}
	
	@Test
	public void falhaAutenticaLogin() {
		Login lo = new Login(BancoDeDados.getInstance().getListaUsuarios());
		String login = "patati";
		String  senha = "patata";
		assertNull(lo.autenticarLogin(BancoDeDados.getInstance().getListaUsuarios(), login, senha), "Tentando logar com informações incorretas");
	}
	
	@Test
	public void logandoComSucesso() {
		Login lo = new Login(BancoDeDados.getInstance().getListaUsuarios());
		String login = "admin";
		String senha = "admin";
		Usuario logado = BancoDeDados.getInstance().getListaUsuarios().get(0);
		assertEquals(logado, lo.autenticarLogin(BancoDeDados.getInstance().getListaUsuarios(), login, senha),"Logando com sucesso");
	}

}
