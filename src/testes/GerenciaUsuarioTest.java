package testes;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.ErroGrave;
import exceptions.EscolhaIncorreta;
import exceptions.LoginJaCadastrado;
import exceptions.NaoEncontrado;
import model.BancoDeDados;
import model.Funcionario;
import model.GerenciaUsuario;
import model.Gerente;
import model.Usuario;

class GerenciaUsuarioTest {
	
	@Test
	void cadastrandoGerenteComListaUsuarioNaoInstanciada() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave {
		BancoDeDados bd  = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		String [] info = new String[4];
		info[0] = "User1";
		info[1] = "1";
		info[2] = "login";
		info[3] = "senha";
		assertThrows(ErroGrave.class, () -> gu.cadastrarUsuario(null, bd.getListaIds(), info), "Cadastrando gerente com lista de gerente não instanciada");
	}

	@Test
	void cadastrandoFuncionarioComListaUsuarioNaoInstanciada() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave {
		BancoDeDados bd  = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		String [] info = new String[4];
		info[0] = "User1";
		info[1] = "2";
		info[2] = "login";
		info[3] = "senha";
		assertThrows(ErroGrave.class, () -> gu.cadastrarUsuario(null, bd.getListaIds(), info),"Cadastrando funcionario com lista de funcionarios não instanciada");
	}
	
	@Test
	void cadastrandoGerenteComListaIdsNaoInstanciada() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave {
		BancoDeDados bd  = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		String [] info = new String[4];
		info[0] = "User1";
		info[1] = "1";
		info[2] = "login";
		info[3] = "senha";
		assertThrows(ErroGrave.class, () -> gu.cadastrarUsuario(bd.getListaUsuarios(), null, info), "Cadastrando gerente com lista de Ids não instanciada");	
	}
	
	@Test
	void cadastrandoFuncionarioComListaIdsNaoInstanciada() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave {
		BancoDeDados bd  = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		String [] info = new String[4];
		info[0] = "User1";
		info[1] = "2";
		info[2] = "login";
		info[3] = "senha";
		assertThrows(ErroGrave.class, () -> gu.cadastrarUsuario(bd.getListaUsuarios(), null, info),"Cadastrando funcionario com lista de Ids não instanciada");
	}
	
	@Test
	void cadastrandoVariosGerentesMesmoLogin() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave{
		BancoDeDados bd  = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		Usuario g1 = new Gerente();
		String [] info = new String[4];
		info[0] = "User1";
		info[1] = "1";
		info[2] = "admin";
		info[3] = "admin";
		
		bd.getListaUsuarios().add(g1);
		assertThrows(LoginJaCadastrado.class, () -> gu.cadastrarUsuario(bd.getListaUsuarios(), bd.getListaIds(), info), "Cadastrando gerente com mesmo login");	
	}
	
	@Test
	void cadastrandoVariosFuncionariosMesmoLogin() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave{
		BancoDeDados bd  = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		Usuario f1 = new Funcionario(bd.getListaIds(), "Abacaxi", "admin", "admin");
		bd.getListaUsuarios().add(f1);
		
		String [] info = new String[4];
		info[0] = "User1";
		info[1] = "2";
		info[2] = "admin";
		info[3] = "admin";
		assertThrows(LoginJaCadastrado.class, () -> gu.cadastrarUsuario(bd.getListaUsuarios(), bd.getListaIds(), info), "Cadastrando funcionario com mesmo login");
	}
	
	@Test
	void cadastrandoComOpcaoErrada() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave {
		BancoDeDados bd  = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		String [] info = new String[4];
		info[0] = "Pernalonga";
		info[1] = "6";
		info[2] = "velhinho";
		info[3] = "queqha";
		assertThrows(EscolhaIncorreta.class, () -> gu.cadastrarUsuario(bd.getListaUsuarios(), bd.getListaIds(), info), "Cadastrando gerente com sucesso");
	}
	
	
	@Test
	void cadastrandoGerenteComSucesso() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave{
		BancoDeDados bd  = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		String [] info = new String[4];
		info[0] = "Pernalonga";
		info[1] = "1";
		info[2] = "velhinho";
		info[3] = "queqha";
		assertTrue(gu.cadastrarUsuario(bd.getListaUsuarios(), bd.getListaIds(), info), "Cadastrando gerente com sucesso");
		
	}
	
	@Test
	void cadastrandoFuncionarioComSucesso() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave{
		BancoDeDados bd  = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		String [] info = new String[4];
		info[0] = "Patolino";
		info[1] = "2";
		info[2] = "omago";
		info[3] = "pato";
		assertTrue(gu.cadastrarUsuario(bd.getListaUsuarios(), bd.getListaIds(), info), "Cadastrando gerente com mesmo login");
		
	}
	
	@Test
	void editandoUsuarioListaUsuarioNull() throws NaoEncontrado, ErroGrave {
		GerenciaUsuario gu = new GerenciaUsuario();
		String codigoUsuario = "37469";
		
		String[] info = new String[2];
		info[0] = "Editado";
		info[1] = "abacate";
		
		assertThrows(ErroGrave.class, () -> gu.editarUsuario(null, codigoUsuario, info), "Editando usuario com lista de usuario null");
	}
	
	@Test
	void editandoUsuarioCodigoUsuarioIncorreto() throws NaoEncontrado, ErroGrave {
		BancoDeDados bd = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		Gerente g1 = new Gerente();
		bd.getListaUsuarios().add(g1);
		String codigoUsuario = "99999999999";
		
		String[] info = new String[2];
		info[0] = "Editado";
		info[1] = "abacate";
		
		assertThrows(NaoEncontrado.class, () -> gu.editarUsuario(bd.getListaUsuarios(), codigoUsuario, info), "Editando usuario com lista de usuario null");
	}
	
	@Test
	void editandoUsuarioComSucesso() throws NaoEncontrado, ErroGrave {
		BancoDeDados bd = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		Gerente g1 = new Gerente();
		bd.getListaUsuarios().add(g1);
		String codigoUsuario = bd.getListaUsuarios().get(0).getId();
		String[] info = new String[2];
		info[0] = "Editado";
		info[1] = "abacate";
		
		assertTrue(gu.editarUsuario(bd.getListaUsuarios(), codigoUsuario, info), "Editando usuario com lista de usuario null");
	}
	
	@Test
	void removendoUsuarioListaUsuarioNull() throws ErroGrave, NaoEncontrado {
		BancoDeDados bd = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		String codigoUsuario = "76676";
		assertThrows(ErroGrave.class, () -> gu.excluirUsuario(null, bd.getListaIds(), codigoUsuario), "Excluindo usuario com lista de usuarios null");
	}
	
	@Test
	void removendoUsuarioListaIdsNull() throws ErroGrave, NaoEncontrado {
		BancoDeDados bd = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		String codigoUsuario = "76676";
	assertFalse(gu.excluirUsuario(bd.getListaUsuarios(), null, codigoUsuario), "Excluindo usuario com lista de ids null");
	}
	
	@Test
	void removendoUsuarioCodigoUsuarioIncorreto() throws ErroGrave, NaoEncontrado {
		BancoDeDados bd = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		Gerente g1 = new Gerente();
		bd.getListaUsuarios().add(g1);
		String codigoUsuario = "7667699999";
		assertThrows(NaoEncontrado.class, () -> gu.excluirUsuario(bd.getListaUsuarios(), bd.getListaIds(), codigoUsuario), "Excluindo usuario com codigo de usuario incorreto");
	}
	
	@Test
	void removendoUsuarioComSucesso() throws ErroGrave, NaoEncontrado {
		BancoDeDados bd = new BancoDeDados();
		GerenciaUsuario gu = new GerenciaUsuario();
		Gerente g1 = new Gerente();
		bd.getListaUsuarios().add(g1);
		String codigoUsuario = bd.getListaUsuarios().get(0).getId();
	assertTrue(gu.excluirUsuario(bd.getListaUsuarios(), bd.getListaIds(), codigoUsuario), "Excluindo usuario com sucesso");
	}
}
