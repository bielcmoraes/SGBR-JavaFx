package exceptions;

public class ClienteNaoCadastrado extends Exception{

	public ClienteNaoCadastrado() {
		super();
	}

	@Override
	public String toString() {
		return "Cliente nao cadastrado!";
	}
}