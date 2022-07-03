package testes;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	//BancoDeDadosTest.class,
	GeraRelatorioTest.class,
	GeraTabelaTest.class,
	GerenciaVendaTest.class,
	GerenciaProdutoTest.class,
	GerenciaCardapioTest.class,
	GerenciaFornecedorTest.class,
	GerenciaUsuarioTest.class,
	LoginTest.class
})

class SuiteDeTestes {
}
