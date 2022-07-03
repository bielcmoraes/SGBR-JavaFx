package testes;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PreCadastro.PreCadastro;
import exceptions.ErroGrave;
import exceptions.NaoEncontrado;
import model.BancoDeDados;
import model.Fornecedor;
import model.GerenciaFornecedor;

class GerenciaFornecedorTest {
	
	PreCadastro pc = new PreCadastro();
	GerenciaFornecedor gf = new GerenciaFornecedor();
	ArrayList<String> produtos = new ArrayList<String>();
	@BeforeEach
	
	@Test
	void cadastrandoFornecedorEmListaNaoInstanciada() throws ErroGrave {
		
		String [] info = new String[3] ;
		info[0] = "Fornecedor1";
		info[1] = "373746667";
		info[2] = "Rua Bonita";
		assertThrows(ErroGrave.class, () -> gf.cadastrarFornecedor(null, BancoDeDados.getInstance().getListaIds(), info, produtos));
	}
	
	@Test
	void adicionandoUmFornecedorNaLista() throws ErroGrave {
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String [] info = new String[3] ;
		info[0] = "Fornecedor1";
		info[1] = "373746667";
		info[2] = "Rua Bonita";
		assertTrue(gf.cadastrarFornecedor(BancoDeDados.getInstance().getListaFornecedores(), BancoDeDados.getInstance().getListaIds(), info, produtos));
	}
	
	@Test
	void editandoFornecedorEmListaDeFornecedoresNaoInstanciada() throws ErroGrave, NaoEncontrado {
		String codigoFornecedor = "88778";
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertFalse(gf.editarFornecedor(null, codigoFornecedor, info, produtos), "Tentando cadastrar fornecedor em lista não instanciada");
	}
	
	@Test
	void editandoFornecedorVetorInfoNull() throws ErroGrave, NaoEncontrado {
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		assertFalse(gf.editarFornecedor(BancoDeDados.getInstance().getListaFornecedores(), codigoFornecedor, null, produtos), "Tentando cadastrar fornecedor com vetor de informações null");
	}
	
	@Test
	void editandoFornecedorListaFornecedoresEVetorInfoNull() throws ErroGrave, NaoEncontrado {
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		assertFalse(gf.editarFornecedor(null, codigoFornecedor, null, produtos), "Tentando cadastrar fornecedor com lista de fornecedores e vetor de informações null");
	}
	
	@Test
	void editandoFonecedorComCodigoFornecedorIncorreto() throws ErroGrave, NaoEncontrado {
		GerenciaFornecedor gf = new GerenciaFornecedor();
		Fornecedor f1 = new Fornecedor(BancoDeDados.getInstance().getListaIds(), "Menino Maluquinho", "989876765", "Rua da esquerda", produtos);
		BancoDeDados.getInstance().getListaFornecedores().add(f1);
		String codigoFornecedor = "99999999999";
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertFalse(gf.editarFornecedor(BancoDeDados.getInstance().getListaFornecedores(), codigoFornecedor, info, produtos), "Tentando editar fornecedor com codigo de fornecedor incorreto");
	}
	
	@Test
	void editanfoFornecedorComSucesso() throws ErroGrave, NaoEncontrado {
		GerenciaFornecedor gf = new GerenciaFornecedor();
		Fornecedor f1 = new Fornecedor(BancoDeDados.getInstance().getListaIds(), "Menino Maluquinho", "989876765", "Rua da esquerda", produtos);
		BancoDeDados.getInstance().getListaFornecedores().add(f1);
		String codigoFornecedor = BancoDeDados.getInstance().getListaFornecedores().get(0).getId();
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertTrue(gf.editarFornecedor(BancoDeDados.getInstance().getListaFornecedores(), codigoFornecedor, info, produtos), "Editando Fornecedor com sucesso");
	}
	
	@Test
	void excluindoFornecedorEmListaDeFornecedoresNaoInstanciada() throws ErroGrave, NaoEncontrado {
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		assertThrows(ErroGrave.class, () -> gf.excluirFornecedor(null, BancoDeDados.getInstance().getListaIds(), codigoFornecedor),"Excluindo fornecedor com lista de fornecedores não instanciada");
	}
	
	@Test
	void excluindoFornecedorListaIdsNull() throws ErroGrave, NaoEncontrado {
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		assertFalse(gf.excluirFornecedor(BancoDeDados.getInstance().getListaFornecedores(), null, codigoFornecedor), "Excluindo fornecedor com lista de ids null");
	}
	
	@Test
	void excluindoFornecedorCodigoFornecedorIncorreto() throws ErroGrave, NaoEncontrado {
		GerenciaFornecedor gf = new GerenciaFornecedor();
		Fornecedor f1 = new Fornecedor(BancoDeDados.getInstance().getListaIds(), "Bruxa do 71", "893373485", "Vila do Chaves", produtos);
		BancoDeDados.getInstance().getListaFornecedores().add(f1);
		String codigoFornecedor = "99999999999";
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertFalse(gf.excluirFornecedor(BancoDeDados.getInstance().getListaFornecedores(), BancoDeDados.getInstance().getListaIds(), codigoFornecedor));
		
	}
	
	@Test
	void excluindoFornecedorComSucesso() throws ErroGrave, NaoEncontrado {
		GerenciaFornecedor gf = new GerenciaFornecedor();
		Fornecedor f1 = new Fornecedor(BancoDeDados.getInstance().getListaIds(), "Bruxa do 71", "893373485", "Vila do Chaves", produtos);
		BancoDeDados.getInstance().getListaFornecedores().add(f1);
		String codigoFornecedor = BancoDeDados.getInstance().getListaFornecedores().get(0).getId();
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertTrue(gf.excluirFornecedor(BancoDeDados.getInstance().getListaFornecedores(), BancoDeDados.getInstance().getListaIds(), codigoFornecedor), "Excluindo fornecedor com sucesso");
	}
}
