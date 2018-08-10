package visual;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class InterfaceVisual {
	
	private JFrame frame;
	String nomeArquivoCliente;
	JLabel nomeArquivoClienteLabel = null;
	String nomeArquivoTexto;
	JLabel nomeArquivoTextoLabel = null;
	String tipoTexto;
	String nomeChaveCodigo;
	JButton btnConfirmar = new JButton("Confirmar");
	JButton jbtnCarregarRedacoes = new JButton("Carregar Redações");


	JTextField campoCodigo;
	/**
	 * Launch the application.
	 */
	
	public String getTipoTexto() {
		return tipoTexto;
	}
	public void setTipoTexto(String tipoTexto) {
		this.tipoTexto = tipoTexto;
	}
	
	public String getNomeArquivoCliente() {
		return nomeArquivoCliente;
	}
	public String getNomeArquivoTexto() {
		return nomeArquivoTexto;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceVisual window = new InterfaceVisual();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceVisual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 705, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton jbtnCarregarClientes = new JButton("Carregar Clientes");
		jbtnCarregarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.setDialogTitle("Escolha o arquivo de Clientes:");
				int ret = chooser.showOpenDialog(null);
				if (ret==JFileChooser.APPROVE_OPTION) {
					nomeArquivoCliente = chooser.getSelectedFile().getAbsolutePath();
					nomeArquivoClienteLabel.setText("Arquivo: " + nomeArquivoCliente);
					jbtnCarregarRedacoes.setEnabled(true);
				}
			}
		});
		jbtnCarregarClientes.setBounds(45, 38, 181, 29);
		frame.getContentPane().add(jbtnCarregarClientes);
		
		
		JLabel lblArquivoCliente = new JLabel("Arquivo: ");
		lblArquivoCliente.setBounds(259, 39, 547, 25);
		frame.getContentPane().add(lblArquivoCliente);
		nomeArquivoClienteLabel = lblArquivoCliente;
		
		
	
		jbtnCarregarRedacoes.setEnabled(false);
		jbtnCarregarRedacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.setDialogTitle("Escolha o arquivo de Redações:");
				int ret = chooser.showOpenDialog(null);
				if (ret==JFileChooser.APPROVE_OPTION) {
					nomeArquivoTexto = chooser.getSelectedFile().getAbsolutePath();
					nomeArquivoTextoLabel.setText("Arquivo: " + nomeArquivoTexto);
					btnConfirmar.setEnabled(true);
				}
			}
		});
		jbtnCarregarRedacoes.setBounds(45, 96, 181, 29);
		frame.getContentPane().add(jbtnCarregarRedacoes);
		
		JLabel lblArquivoTexto = new JLabel("Arquivo: ");
		lblArquivoTexto.setBounds(259, 97, 547, 25);
		frame.getContentPane().add(lblArquivoTexto);
		nomeArquivoTextoLabel = lblArquivoTexto;
		
		String[] options = {"Selecione um Tipo","Contrato", "Procuracao", "Recibo"};
		JComboBox comboBox = new JComboBox(options);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				if (!((String)cb.getSelectedItem()).equals("Selecione um Tipo"))
					tipoTexto = (String)cb.getSelectedItem();
			}
		});
		comboBox.setBounds(45, 196, 181, 29);
		frame.getContentPane().add(comboBox);
		
		
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nomeChaveCodigo = campoCodigo.getText();
								
			}
		});
		btnConfirmar.setBounds(295, 224, 181, 29);
		frame.getContentPane().add(btnConfirmar);
		
		campoCodigo = new JTextField();
		campoCodigo.setBounds(45, 268, 30, 26);
		frame.getContentPane().add(campoCodigo);
		campoCodigo.setColumns(10);
		
		JLabel lblIndomrOCdigo = new JLabel("Informe o código do Cliente:");
		lblIndomrOCdigo.setBounds(45, 254, 271, 15);
		frame.getContentPane().add(lblIndomrOCdigo);
		
		JLabel lblInfomeOTipo = new JLabel("Informe o tipo de Redação");
		lblInfomeOTipo.setBounds(46, 169, 288, 15);
		frame.getContentPane().add(lblInfomeOTipo);
		
	}
}
