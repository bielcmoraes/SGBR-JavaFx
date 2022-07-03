package testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PreCadastro.PreCadastro;
import exceptions.ErroGrave;
import exceptions.NaoEncontrado;
import model.BancoDeDados;
import model.GerenciaCliente;

class GerenciaClienteTest {
	
	PreCadastro pc = new PreCadastro();
	GerenciaCliente gc = new GerenciaCliente();
	String [] info = new String[4] ;
	String codigoCliente = "8848";
	@BeforeEach
	
	@Test
	void cadastrandoClienteEmListaNaoInstanciada() throws ErroGrave {
		info[0] = "Zezinho";
		info[1] = "373746667";
		info[2] = "zezinhobr@gmail.com";
		info[3] = "40028922";
		assertThrows(ErroGrave.class, () -> gc.cadastrarCliente(null, BancoDeDados.getInstance().getListaIds(), info));
	}
	
	@Test
	void adicionandoUmFornecedorNaLista() throws ErroGrave {
		info[0] = "Zezinho";
		info[1] = "373746667";
		info[2] = "zezinhobr@gmail.com";
		info[3] = "40028922";
		assertTrue(gc.cadastrarCliente(BancoDeDados.getInstance().getListaClientes(), BancoDeDados.getInstance().getListaIds(), info));
	}
	
	@Test
	void editandoClienteEmListaDeClientesNaoInstanciada() throws ErroGrave, NaoEncontrado {
		
		info[0] = "Zezinho alteracao";
		info[1] = "373746667";
		info[2] = "zezinhobr@hotmail.com";
		info[3] = "40038933";
		codigoCliente = BancoDeDados.getInstance().getListaClientes().get(0).getId();
		assertThrows(ErroGrave.class, () -> gc.editarCliente(null, codigoCliente, info));
	}
	
	@Test
	void editandoClienteVetorInfoNull() throws ErroGrave, NaoEncontrado {
		codigoCliente = BancoDeDados.getInstance().getListaClientes().get(0).getId();
		assertThrows(ErroGrave.class, () -> gc.editarCliente(BancoDeDados.getInstance().getListaClientes(), codigoCliente, null));
	}
	
	@Test
	void editandoClienteListaClientesEVetorInfoNull() throws ErroGrave, NaoEncontrado {
		assertThrows(ErroGrave.class, () -> gc.editarCliente(null, codigoCliente, null));
	}
	
	@Test
	void editanClienteComSucesso() throws ErroGrave, NaoEncontrado {
		info[0] = "Zezinho alteracao";
		info[1] = "373746667";
		info[2] = "zezinhobr@hotmail.com";
		info[3] = "40038933";
		codigoCliente = BancoDeDados.getInstance().getListaClientes().get(0).getId();
		assertTrue(gc.editarCliente(BancoDeDados.getInstance().getListaClientes(), codigoCliente, info));
	}
	
	@Test
	void excluindoClienteEmListaDeClienteNaoInstanciada() throws ErroGrave, NaoEncontrado {
		assertThrows(ErroGrave.class, () -> gc.excluirCliente(null, BancoDeDados.getInstance().getListaIds(),codigoCliente));
	}
	
	@Test
	void excluindoClienteListaIdsNull() throws ErroGrave, NaoEncontrado {
		codigoCliente = BancoDeDados.getInstance().getListaClientes().get(0).getId();
		assertThrows(ErroGrave.class, () -> gc.excluirCliente(BancoDeDados.getInstance().getListaClientes(), null, codigoCliente));
	}
	
	@Test
	void excluindoClienteCodigoClienteIncorreto() throws ErroGrave, NaoEncontrado {
		assertFalse(gc.excluirCliente(BancoDeDados.getInstance().getListaClientes(), BancoDeDados.getInstance().getListaIds(), codigoCliente));
	}
	
	@Test
	void excluindoClienteComSucesso() throws ErroGrave, NaoEncontrado {
		codigoCliente = BancoDeDados.getInstance().getListaClientes().get(0).getId();
		assertTrue(gc.excluirCliente(BancoDeDados.getInstance().getListaClientes(), BancoDeDados.getInstance().getListaIds(), codigoCliente));
	}
}
