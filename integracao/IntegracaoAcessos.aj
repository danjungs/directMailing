package integracao;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import modelo.*;
import DAO.*;

public aspect IntegracaoAcessos {

	
	public static void main(String[] args) {
		Acessos acessos = new Acessos();
		Input in = new Input();
		
		String ArquivoC = null;
		String ArquivoT = null;
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setDialogTitle("Escolha o arquivo de Clientes:");
		int ret = chooser.showOpenDialog(null);
		if (ret==JFileChooser.APPROVE_OPTION) {
			ArquivoC = chooser.getSelectedFile().getAbsolutePath();
		}
		in.setArquivoClientes(ArquivoC);
		
		JFileChooser chooserT = new JFileChooser();
		chooserT.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooserT.setDialogTitle("Escolha o arquivo de Textos:");
		int retT = chooserT.showOpenDialog(null);
		if (retT==JFileChooser.APPROVE_OPTION) {
			ArquivoT = chooserT.getSelectedFile().getAbsolutePath();
		}
		in.setArquivoTextos(ArquivoT);
		
		acessos.setTextos(in.getTextos());
		acessos.setClientes(in.consultaClientes());
		Cliente a = acessos.getCadastro("4");
		//System.out.println(a.getCodigo());
		//System.out.println(a.getNome());
		//System.out.println(a.getProfissao());
		//System.out.println(a.getEndereco());
		//System.out.println(a.getEmail());
		Texto b = acessos.getTexto("Contrato");
		//System.out.println(b.getTipo());
		System.out.println(b.getTexto());
		
	}

}
