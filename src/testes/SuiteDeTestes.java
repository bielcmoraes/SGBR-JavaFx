package testes;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	BancoDeDadosTest.class,
	GeraRelatorioTest.class,
	GeraTabelaTest.class,
	GerenciaCardapioTest.class,
	GerenciaFornecedorTest.class,
	GerenciaProdutoTest.class,
	GerenciaUsuarioTest.class,
	GerenciaVendaTest.class,
	LoginTest.class
})

class SuiteDeTestes {
}
