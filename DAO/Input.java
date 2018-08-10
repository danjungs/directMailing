package DAO;

import java.util.ArrayList;
import java.io.*;

import modelo.*;

public class Input {
	
	String arquivoClientes = "";
	String arquivoTextos = "";

	public String getArquivoTextos() {
		return arquivoTextos;
	}

	public void setArquivoTextos(String arquivoTextos) {
		this.arquivoTextos = arquivoTextos;
	}

	public String getArquivoClientes() {
		return arquivoClientes;
	}

	public void setArquivoClientes(String arquivo) {
		this.arquivoClientes = arquivo;
	}

	public ArrayList<Cliente> consultaClientes (){
		ArrayList<Cliente> acessos = new ArrayList<Cliente>();
		
		try {
			InputStream is = new FileInputStream (arquivoClientes);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);		
			Cliente a;
			
			String s = br.readLine(); // primeira linha
			
			while (s != null) {
				 if (!s.equals("**************************"))
				 {				 
					 a = new Cliente();
					 a.setCodigo(s.substring(8));				 
					 s = br.readLine();
					 a.setNome(s.substring(6));
					 s = br.readLine();
					 a.setProfissao(s.substring(11));
					 s = br.readLine();
					 a.setEndereco(s.substring(10));
					 s = br.readLine();
					 a.setEmail(s.substring(7));
					 acessos.add(a);	 
				 }
				 s = br.readLine();
			 }		
			 br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acessos; 
	}
	
	public ArrayList<Texto> getTextos(){
		ArrayList<Texto> acessos = new ArrayList<Texto>();
		
		try {
			InputStream is = new FileInputStream (arquivoTextos);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);		
			Texto a;
			
			String s = br.readLine(); // primeira linha
			
			while (s != null) {
				 if (!s.equals("********************************"))
				 {	
					 String buffer = "";
					 a = new Texto();
					 a.setTipo(s.substring(17));				 
					 s = br.readLine();				// linha de "********************************
					 s = br.readLine();
					 buffer = buffer + "\n" + s;
					 s = br.readLine();
					 buffer = buffer + "\n" + s;
					 s = br.readLine();
					 buffer = buffer + "\n" + s;		 
					 a.setTexto(buffer);
					 acessos.add(a);	 
				 }
				 s = br.readLine();
			 }		
			 br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acessos; 
	}
	
}