package testes;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PreCadastro.PreCadastro;
import exceptions.ErroGrave;
import model.BancoDeDados;
import model.GerenciaCliente;

class GerenciaClienteTest {
	
	PreCadastro pc = new PreCadastro();
	GerenciaCliente gc = new GerenciaCliente();
	@BeforeEach
	
	@Test
	void cadastrandoClienteEmListaNaoInstanciada() throws ErroGrave {
		String [] info = new String[4] ;
		info[0] = "Zezinho";
		info[1] = "373746667";
		info[2] = "zezinhobr@gmail.com";
		info[3] = "40028922";
		
		assertThrows(ErroGrave.class, () -> gc.cadastrarCliente(BancoDeDados.getInstance().getListaClientes(), BancoDeDados.getInstance().getListaIds(), info));
	}

}
