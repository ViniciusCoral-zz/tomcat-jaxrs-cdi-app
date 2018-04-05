package br.com.coral.jaxrs_cdi;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteDAO {
	
	private List<Cliente> clientes;
	
	public ClienteDAO() {
		if(clientes != null) return;
		clientes = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			clientes.add(new Cliente(i, "Coral" + i));			
		}
	}
	
	public Cliente getCliente(int id) {
		Cliente c;
		try {
			c = clientes.get(id);
		} catch (Exception e) {
			return null;
		}
		
		return c;
	}
	
	public void cadastrar(String nome) {
		int proximoIndice = clientes.size();
		clientes.add(new Cliente(proximoIndice, nome));
	}

}
