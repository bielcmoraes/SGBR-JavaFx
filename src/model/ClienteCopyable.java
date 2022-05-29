package model;

import java.util.ArrayList;

import exceptions.ErroGrave;
import exceptions.NaoEncontrado;

public interface ClienteCopyable {
	
	public boolean cadastrarCliente(ArrayList<Cliente> listaClientes, ArrayList<String> listaIds, String [] info) throws ErroGrave;
	
	public boolean editarCliente(ArrayList<Cliente> listaClientes, String codigoCliente, String [] info) throws ErroGrave, NaoEncontrado;
	
	public boolean excluirCliente(ArrayList<Cliente> listaClientes, ArrayList<String> listaIds, String codigoCliente) throws ErroGrave, NaoEncontrado;
}
