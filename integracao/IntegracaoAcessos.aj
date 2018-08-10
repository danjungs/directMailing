package integracao;

import org.apache.commons.mail.EmailException;

import modelo.*;
import DAO.*;
import visual.*;

public aspect IntegracaoAcessos {
	
	Acessos acessos = new Acessos();
	String textoFinal;
	Cliente a;
	Texto b;
	
	pointcut inicio1(): set(String InterfaceVisual.nomeArquivoCliente);
	pointcut inicio2(): set(String InterfaceVisual.nomeArquivoTexto);
	pointcut redacao():	set(String InterfaceVisual.nomeChaveCodigo);
	pointcut envio():   set(String textoFinal);
	
	//	Adiciona ao ArrayList de Clientes do objeto acessos as informações dos clientes do arquivo informado
	after(InterfaceVisual iv): inicio1() && target(iv){
		Input in = new Input();
		in.setArquivoClientes(iv.getNomeArquivoCliente());
		acessos.setClientes(in.consultaClientes());
	}
	
	//	Adiciona ao ArrayList de Textos do objeto acessos os textos do arquivo informado
	after(InterfaceVisual iv): inicio2() && target(iv){
		Input in = new Input();
		in.setArquivoTextos(iv.getNomeArquivoTexto());
		acessos.setTextos(in.getTextos());
	}
	
	//  Chama a função para juntar a mala direta com os atributos do cliente
	after(InterfaceVisual iv,String codigo): redacao() && args(codigo) && target(iv){
		Gerador ger = new Gerador();
		String redacao = iv.getTipoTexto();
		System.out.println("Selecionado: " + codigo + " " + redacao);
		a = acessos.getCadastro(codigo);
		b = acessos.getTexto(redacao);
		textoFinal = ger.geraTexto(a,b.getTexto());
	}
	
	//	envio do texto por email
	after(): envio(){
		Gerador ger = new Gerador();
		try {
			ger.mandaEmail(a.getEmail(),textoFinal);
		} catch (EmailException e) {
			System.out.println("Email não enviado.");
			e.printStackTrace();
		}
	
	}
	//	gera PDF do texto
	after(): envio(){
		Gerador ger = new Gerador();
		ger.geraPDF(textoFinal);
	}
}
