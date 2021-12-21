package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acoes.AcoesCliente;
import modelos.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtCidade;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon("/Users/ralf/Documents/Java/Java Avançado/Banco2/src/bibliotecas/imagem.png"));
		lblImagem.setBounds(159, 6, 128, 128);
		contentPane.add(lblImagem);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(21, 159, 61, 16);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(21, 201, 61, 16);
		contentPane.add(lblIdade);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(21, 239, 61, 16);
		contentPane.add(lblCidade);
		
		txtNome = new JTextField();
		txtNome.setBounds(69, 154, 358, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(69, 196, 358, 26);
		contentPane.add(txtIdade);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(69, 234, 358, 26);
		contentPane.add(txtCidade);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String nome = txtNome.getText();
					int idade = Integer.parseInt(txtIdade.getText());
					String cidade = txtCidade.getText();
					
					Cliente c = new Cliente(0, nome, idade, cidade);
					
					AcoesCliente.cadastrar(c);
					
					table.setModel(AcoesCliente.listar());
					
					txtNome.setText("");
					txtIdade.setText("");
					txtCidade.setText("");
					
					
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar");
				}
				
			}
		});
		btnCadastrar.setBounds(170, 272, 117, 29);
		contentPane.add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(21, 331, 410, 195);
		contentPane.add(scrollPane);
		
		table = new JTable(AcoesCliente.listar());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Obter a linha selecionada
				int linha = table.getSelectedRow();
				
				// Obter o código do cliente
				int codigo = Integer.parseInt(table.getValueAt(linha, 0).toString());
				
				// Efetuar a exclusão
				AcoesCliente.remover(codigo);
				
				// Atualizar tabela
				table.setModel(AcoesCliente.listar());
				
				JOptionPane.showMessageDialog(null, "Mensagem excluida com sucesso!");
			}
		});
		
		scrollPane.setViewportView(table);
	}
}
