package modelo;

import java.util.ArrayList;

public class Acessos {
	
	ArrayList<Cliente> clientes = null;
	ArrayList<Texto> textos = null;

		
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Texto> getTextos() {
		return textos;
	}

	public void setTextos(ArrayList<Texto> textos) {
		this.textos = textos;
	}

	public Cliente getCadastro (String codigo){
		
		boolean achei = false;
		int i = 0;
		
		while (!achei && (i < clientes.size())){
			if (clientes.get(i).getCodigo().equals(codigo)) achei = true;
			i++;
		}
		if (achei){
			i--;
			return clientes.get(i);
		}
		//else { JOptionPane.showMessageDialog(null, "Acesso inexistente"); }
		return null;
	}
	
	public Texto getTexto (String tipo){
		
		boolean achei = false;
		int i = 0;
		
		while (!achei && (i < textos.size())){
			if (textos.get(i).getTipo().equals(tipo)) achei = true;
			i++;
		}
		if (achei){
			i--;
			return textos.get(i);
		}
		//else { JOptionPane.showMessageDialog(null, "Acesso inexistente"); }
		return null;
	}

}