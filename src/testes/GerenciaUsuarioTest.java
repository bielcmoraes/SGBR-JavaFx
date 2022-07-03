package testes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PreCadastro.PreCadastro;
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
	
	PreCadastro pc = new PreCadastro();
	GerenciaUsuario gu = new GerenciaUsuario();
	@BeforeEach
	
	@Test
	void cadastrandoGerenteComListaUsuarioNaoInstanciada() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave {
		String [] info = new String[4];
		info[0] = "User1";
		info[1] = "Gerente";
		info[2] = "login";
		info[3] = "senha";
		assertThrows(ErroGrave.class, () -> gu.cadastrarUsuario(null, BancoDeDados.getInstance().getListaIds(), info), "Cadastrando gerente com lista de gerente não instanciada");
	}

	@Test
	void cadastrandoFuncionarioComListaUsuarioNaoInstanciada() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave {
		String [] info = new String[4];
		info[0] = "User1";
		info[1] = "Funcionario";
		info[2] = "login";
		info[3] = "senha";
		assertThrows(ErroGrave.class, () -> gu.cadastrarUsuario(null, BancoDeDados.getInstance().getListaIds(), info),"Cadastrando funcionario com lista de funcionarios não instanciada");
	}
	
	@Test
	void cadastrandoGerenteComListaIdsNaoInstanciada() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave {
		String [] info = new String[4];
		info[0] = "User1";
		info[1] = "Gerente";
		info[2] = "login";
		info[3] = "senha";
		assertThrows(ErroGrave.class, () -> gu.cadastrarUsuario(BancoDeDados.getInstance().getListaUsuarios(), null, info), "Cadastrando gerente com lista de Ids não instanciada");	
	}
	
	@Test
	void cadastrandoFuncionarioComListaIdsNaoInstanciada() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave {
		String [] info = new String[4];
		info[0] = "User1";
		info[1] = "Funcionario";
		info[2] = "login";
		info[3] = "senha";
		assertThrows(ErroGrave.class, () -> gu.cadastrarUsuario(BancoDeDados.getInstance().getListaUsuarios(), null, info),"Cadastrando funcionario com lista de Ids não instanciada");
	}
	
	@Test
	void cadastrandoVariosGerentesMesmoLogin() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave{
		Usuario g1 = new Gerente();
		String [] info = new String[4];
		info[0] = "User1";
		info[1] = "Gerente";
		info[2] = "admin";
		info[3] = "admin";
		
		BancoDeDados.getInstance().getListaUsuarios().add(g1);
		assertThrows(LoginJaCadastrado.class, () -> gu.cadastrarUsuario(BancoDeDados.getInstance().getListaUsuarios(), BancoDeDados.getInstance().getListaIds(), info), "Cadastrando gerente com mesmo login");	
	}
	
	@Test
	void cadastrandoVariosFuncionariosMesmoLogin() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave{
		Usuario f1 = new Funcionario(BancoDeDados.getInstance().getListaIds(), "Abacaxi", "admin", "admin");
		BancoDeDados.getInstance().getListaUsuarios().add(f1);
		
		String [] info = new String[4];
		info[0] = "User1";
		info[1] = "Funcionario";
		info[2] = "admin";
		info[3] = "admin";
		assertThrows(LoginJaCadastrado.class, () -> gu.cadastrarUsuario(BancoDeDados.getInstance().getListaUsuarios(), BancoDeDados.getInstance().getListaIds(), info), "Cadastrando funcionario com mesmo login");
	}
	
	@Test
	void cadastrandoComOpcaoErrada() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave {
		String [] info = new String[4];
		info[0] = "Pernalonga";
		info[1] = "6";
		info[2] = "velhinho";
		info[3] = "queqha";
		assertThrows(EscolhaIncorreta.class, () -> gu.cadastrarUsuario(BancoDeDados.getInstance().getListaUsuarios(), BancoDeDados.getInstance().getListaIds(), info), "Cadastrando gerente com sucesso");
	}
	
	
	@Test
	void cadastrandoGerenteComSucesso() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave{
		String [] info = new String[4];
		info[0] = "Pernalonga";
		info[1] = "Gerente";
		info[2] = "velhinho";
		info[3] = "queqha";
		assertTrue(gu.cadastrarUsuario(BancoDeDados.getInstance().getListaUsuarios(), BancoDeDados.getInstance().getListaIds(), info), "Cadastrando gerente com sucesso");
		
	}
	
	@Test
	void cadastrandoFuncionarioComSucesso() throws EscolhaIncorreta, LoginJaCadastrado, ErroGrave{
		String [] info = new String[4];
		info[0] = "Patolino";
		info[1] = "Funcionario";
		info[2] = "omago";
		info[3] = "pato";
		assertTrue(gu.cadastrarUsuario(BancoDeDados.getInstance().getListaUsuarios(), BancoDeDados.getInstance().getListaIds(), info), "Cadastrando gerente com mesmo login");
		
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
		Gerente g1 = new Gerente();
		BancoDeDados.getInstance().getListaUsuarios().add(g1);
		String codigoUsuario = "99999999999";
		
		String[] info = new String[2];
		info[0] = "Editado";
		info[1] = "abacate";
		
		assertFalse(gu.editarUsuario(BancoDeDados.getInstance().getListaUsuarios(), codigoUsuario, info), "Editando usuario com lista de usuario null");
	}
	
	@Test
	void editandoUsuarioComSucesso() throws NaoEncontrado, ErroGrave {
		Gerente g1 = new Gerente();
		BancoDeDados.getInstance().getListaUsuarios().add(g1);
		String codigoUsuario = BancoDeDados.getInstance().getListaUsuarios().get(0).getId();
		String[] info = new String[2];
		info[0] = "Editado";
		info[1] = "abacate";
		
		assertTrue(gu.editarUsuario(BancoDeDados.getInstance().getListaUsuarios(), codigoUsuario, info), "Editando usuario com lista de usuario null");
	}
	
	@Test
	void removendoUsuarioListaUsuarioNull() throws ErroGrave, NaoEncontrado {
		String codigoUsuario = "76676";
		assertThrows(ErroGrave.class, () -> gu.excluirUsuario(null, BancoDeDados.getInstance().getListaIds(), codigoUsuario), "Excluindo usuario com lista de usuarios null");
	}
	
	@Test
	void removendoUsuarioListaIdsNull() throws ErroGrave, NaoEncontrado {
		String codigoUsuario = "76676";
	assertFalse(gu.excluirUsuario(BancoDeDados.getInstance().getListaUsuarios(), null, codigoUsuario), "Excluindo usuario com lista de ids null");
	}
	
	@Test
	void removendoUsuarioCodigoUsuarioIncorreto() throws ErroGrave, NaoEncontrado {
		Gerente g1 = new Gerente();
		BancoDeDados.getInstance().getListaUsuarios().add(g1);
		String codigoUsuario = "7667699999";
		assertFalse(gu.excluirUsuario(BancoDeDados.getInstance().getListaUsuarios(), BancoDeDados.getInstance().getListaIds(), codigoUsuario), "Excluindo usuario com codigo de usuario incorreto");
	}
	
	@Test
	void removendoUsuarioComSucesso() throws ErroGrave, NaoEncontrado {
		Gerente g1 = new Gerente();
		BancoDeDados.getInstance().getListaUsuarios().add(g1);
		String codigoUsuario = BancoDeDados.getInstance().getListaUsuarios().get(0).getId();
	assertTrue(gu.excluirUsuario(BancoDeDados.getInstance().getListaUsuarios(), BancoDeDados.getInstance().getListaIds(), codigoUsuario), "Excluindo usuario com sucesso");
	}
}
