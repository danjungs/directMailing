package modelo;

import org.apache.commons.mail.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFileChooser;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Gerador {
	
	public String geraTexto(Cliente cliente,String texto){
		String redacao = texto;
		String tagNome = "<NOME>";
		String tagProfissao = "<PROFISSAO>";
		String tagEndereco = "<ENDERECO>";
		
			if (redacao.contains(tagNome))
				redacao = redacao.replaceAll(tagNome, cliente.getNome());
				
			if (redacao.contains(tagProfissao))
				redacao = redacao.replaceAll(tagProfissao, cliente.getProfissao());
			
			if (redacao.contains(tagEndereco))
				redacao = redacao.replaceAll(tagEndereco, cliente.getEndereco());
			
		return redacao;
	}
	
	public void mandaEmail(String destino,String texto) throws EmailException{
		SimpleEmail mail = new SimpleEmail();
		mail.setFrom("aulas.orlando@gmail.com", "Aulas do Orlando");
		mail.setSubject("Teste");
		mail.setMsg(texto);
		//mail.setSSLOnConnect(true);
		mail.setSSL(true);
		mail.setTLS(true);		
		mail.setAuthentication("aulas.orlando@gmail.com", "clp#20171");
		//mail.setHostName("smtp.mail.yahoo.com.br");
		mail.setHostName("smtp.gmail.com");
		mail.setSmtpPort(465);
		mail.addTo("danieljungstedt@gmail.com", "Daniel");
		mail.send();
		System.out.println("Email enviado com sucesso.");		
	}
	
	public void geraPDF(String texto){
		 Document document = new Document();
		 String arquivo = null;
	        try {
	        	JFileChooser chooser = new JFileChooser();
	    		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    		chooser.setDialogTitle("Escolha o arquivo:");
	    		int ret = chooser.showOpenDialog(null);
	    		if (ret==JFileChooser.APPROVE_OPTION)
	    			arquivo= chooser.getSelectedFile().getAbsolutePath();
	            PdfWriter.getInstance(document, new FileOutputStream(arquivo+".pdf"));
	            document.open();

	            // adicionando um parágrafo com fonte diferente ao arquivo
	            document.add(new Paragraph(texto, FontFactory.getFont(FontFactory.COURIER, 12)));

	        } catch(DocumentException de) {
	            System.err.println(de.getMessage());
	        } catch(IOException ioe) {
	            System.err.println(ioe.getMessage());
	        } finally {
	            document.close();
	        }
	    System.out.println("PDF gerado com sucesso.");	
	}
}
