package testes;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.ErroGrave;
import exceptions.NaoEncontrado;
import model.BancoDeDados;
import model.Fornecedor;
import model.GerenciaFornecedor;

class GerenciaFornecedorTest {
	
	@Test
	void cadastrandoFornecedorEmListaNaoInstanciada() throws ErroGrave {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String [] info = new String[3] ;
		info[0] = "Fornecedor1";
		info[1] = "373746667";
		info[2] = "Rua Bonita";
		assertThrows(ErroGrave.class, () -> gf.cadastrarFornecedor(null, bd.getListaIds(), info));
	}
	
	@Test
	void adicionandoUmFornecedorNaListaVazia() throws ErroGrave {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String [] info = new String[3] ;
		info[0] = "Fornecedor1";
		info[1] = "373746667";
		info[2] = "Rua Bonita";
		assertTrue(gf.cadastrarFornecedor(bd.getListaFornecedores(), bd.getListaIds(), info));
	}
	
	@Test
	void cadastrandoVariosFornecedores() throws ErroGrave {
		
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String [] info = new String[3] ;
		info[0] = "Gabriel";
		info[1] = "40028922";
		info[2] = "Rua de cima";
		gf.cadastrarFornecedor(bd.getListaFornecedores(), bd.getListaIds(), info);
		gf.cadastrarFornecedor(bd.getListaFornecedores(), bd.getListaIds(), info);
		gf.cadastrarFornecedor(bd.getListaFornecedores(), bd.getListaIds(), info);
		
		assertSame(3, bd.getListaFornecedores().size(), "Cadastrando 3 fornecedores");
	}
	
	@Test
	void editandoFornecedorEmListaDeFornecedoresNaoInstanciada() throws ErroGrave, NaoEncontrado {
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertThrows(ErroGrave.class, () -> gf.editarFornecedor(null, codigoFornecedor, info), "Tentando cadastrar fornecedor em lista não instanciada");
	}
	
	@Test
	void editandoFornecedorVetorInfoNull() throws ErroGrave, NaoEncontrado {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		assertFalse(gf.editarFornecedor(bd.getListaFornecedores(), codigoFornecedor, null), "Tentando cadastrar fornecedor com vetor de informações null");
	}
	
	@Test
	void editandoFornecedorListaFornecedoresEVetorInfoNull() throws ErroGrave, NaoEncontrado {
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		assertThrows(ErroGrave.class, () -> gf.editarFornecedor(null, codigoFornecedor, null), "Tentando cadastrar fornecedor com lista de fornecedores e vetor de informações null");
	}
	
	@Test
	void editandoFonecedorComCodigoFornecedorIncorreto() throws ErroGrave, NaoEncontrado {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		Fornecedor f1 = new Fornecedor(bd.getListaIds(), "Menino Maluquinho", "989876765", "Rua da esquerda");
		bd.getListaFornecedores().add(f1);
		String codigoFornecedor = "99999999999";
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertThrows(NaoEncontrado.class, () -> gf.editarFornecedor(bd.getListaFornecedores(), codigoFornecedor, info), "Tentando editar fornecedor com codigo de fornecedor incorreto");
	}
	@Test
	void editanfoFornecedorComSucesso() throws ErroGrave, NaoEncontrado {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		Fornecedor f1 = new Fornecedor(bd.getListaIds(), "Menino Maluquinho", "989876765", "Rua da esquerda");
		bd.getListaFornecedores().add(f1);
		String codigoFornecedor = bd.getListaFornecedores().get(0).getId();
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertTrue(gf.editarFornecedor(bd.getListaFornecedores(), codigoFornecedor, info), "Editando Fornecedor com sucesso");
	}
	
	@Test
	void excluindoFornecedorEmListaDeFornecedoresNaoInstanciada() throws ErroGrave, NaoEncontrado {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		assertThrows(ErroGrave.class, () -> gf.excluirFornecedor(null, bd.getListaIds(), codigoFornecedor),"Excluindo fornecedor com lista de fornecedores não instanciada");
	}
	
	@Test
	void excluindoFornecedorListaIdsNull() throws ErroGrave, NaoEncontrado {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		assertFalse(gf.excluirFornecedor(bd.getListaFornecedores(), null, codigoFornecedor), "Excluindo fornecedor com lista de ids null");
	}
	
	@Test
	void excluindoFornecedorCodigoFornecedorIncorreto() throws ErroGrave, NaoEncontrado {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		Fornecedor f1 = new Fornecedor(bd.getListaIds(), "Bruxa do 71", "893373485", "Vila do Chaves");
		bd.getListaFornecedores().add(f1);
		String codigoFornecedor = "99999999999";
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertThrows(NaoEncontrado.class, () -> gf.excluirFornecedor(bd.getListaFornecedores(), bd.getListaIds(), codigoFornecedor));
		
	}
	
	@Test
	void excluindoFornecedorComSucesso() throws ErroGrave, NaoEncontrado {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		Fornecedor f1 = new Fornecedor(bd.getListaIds(), "Bruxa do 71", "893373485", "Vila do Chaves");
		bd.getListaFornecedores().add(f1);
		String codigoFornecedor = bd.getListaFornecedores().get(0).getId();
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertTrue(gf.excluirFornecedor(bd.getListaFornecedores(), bd.getListaIds(), codigoFornecedor), "Excluindo fornecedor com sucesso");
	}
}
