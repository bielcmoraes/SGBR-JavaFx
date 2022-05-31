package testes;

import static org.junit.jupiter.api.Assertions.*;
import junit.framework.*;
import org.junit.jupiter.api.Test;

import model.BancoDeDados;
import model.Login;
import model.Usuario;

public class LoginTest {
	
	@Test
	public void autenticaLoginListaUsuarioNull(){
		BancoDeDados bd = new BancoDeDados();
		Login lo = new Login(bd.getListaUsuarios());
		String login = "patati";
		String senha = "patata";
		assertNull(lo.autenticarLogin(null, login, senha), "Tentando logar com a lista de usuarios null");
	}
	
	@Test
	public void falhaAutenticaLogin() {
		BancoDeDados bd = new BancoDeDados();
		Login lo = new Login(bd.getListaUsuarios());
		String login = "patati";
		String  senha = "patata";
		assertNull(lo.autenticarLogin(bd.getListaUsuarios(), login, senha), "Tentando logar com informações incorretas");
	}
	
	@Test
	public void logandoComSucesso() {
		BancoDeDados bd = new BancoDeDados();
		Login lo = new Login(bd.getListaUsuarios());
		String login = "admin";
		String senha = "admin";
		Usuario logado = bd.getListaUsuarios().get(0);
		assertEquals(logado, lo.autenticarLogin(bd.getListaUsuarios(), login, senha),"Logando com sucesso");
	}

}
