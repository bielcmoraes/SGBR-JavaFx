package model;

import java.util.ArrayList;

import exceptions.ErroGrave;
import exceptions.NaoEncontrado;

public class GerenciaCliente implements ClienteCopyable{

	@Override
	public boolean cadastrarCliente(ArrayList<Cliente> listaClientes, ArrayList<String> listaIds, String[] info) throws ErroGrave {
		
		Cliente novoCliente = new Cliente(info[0], info[1], info[2], info[3]);
		
		try {
			listaClientes.add(novoCliente);
			return true;
			
		}catch(ArrayIndexOutOfBoundsException a){
			throw new ErroGrave();
		}catch( NullPointerException a) {
			throw new ErroGrave();
		}
	}

	@Override
	public boolean editarCliente(ArrayList<Cliente> listaClientes, String codigoCliente, String[] info) throws ErroGrave, NaoEncontrado {
		
		try {
			for(Cliente cliente : listaClientes) {
				if(cliente.getId().equals(codigoCliente)) {
					cliente.setNome(info[0]);
					cliente.setCpf(info[1]);
					cliente.setEmail(info[2]);
					cliente.setTelefone(info[3]);
					return true;
					
				}else {
					throw new NaoEncontrado("Cliente");
				}
			}
		}catch(ArrayIndexOutOfBoundsException a){
			throw new ErroGrave();
		}catch( NullPointerException a) {
			throw new ErroGrave();
		}
		return false;
	}

	@Override
	public boolean excluirCliente(ArrayList<Cliente> listaClientes, ArrayList<String> listaIds, String codigoCliente) throws ErroGrave, NaoEncontrado {
		
		try {
			for(Cliente cliente : listaClientes) {
				if(cliente.getId().equals(codigoCliente)) {
					int index = listaClientes.indexOf(cliente);
					listaClientes.remove(index);
					listaIds.remove(codigoCliente);
					return true;
					
				}else {
					throw new NaoEncontrado("Cliente");
				}
			}
		}catch(ArrayIndexOutOfBoundsException a){
			throw new ErroGrave();
		}catch( NullPointerException a) {
			throw new ErroGrave();
		}
		
	return false;
	}

}
