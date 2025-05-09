package view;
//ESSA TELA APARECERA PARA O ADM,COM TODAS AS PESSOAS CADASTRADAS
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Admcontroller;
import controller.Alunocontroller;
import model.Aluno;
import model.ModeloTabela;

import javax.swing.JTree;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TabelaCadastrosAdm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField camponome;
	private JButton btnNewButton_1;
	private JTable table;
	private JPanel panel;
	private JTextField campoemail;
	private JLabel lblNewLabel;
	private JLabel lblNome;
	private JTextField campocpf;
	private JLabel lblCpf;
	
	

	private final Admcontroller admcontroller;
	
	public TabelaCadastrosAdm(Admcontroller admcontroller) {
		
		this.admcontroller=admcontroller;
		
         List<Aluno> alunos = admcontroller.listaralunoController(null); 
         ModeloTabela modelotabela = new ModeloTabela(alunos);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080,720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton_1 = new JButton("SAIR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(3, 18, 30, 30);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 49, 752, 584);
		contentPane.add(scrollPane);
		

		List<Aluno> alunosFiltrados = admcontroller.filtrarAlunos(nomeFiltro,emailFiltro,cpfFiltro);
		ModeloTabela modeloFiltrado = new ModeloTabela(alunosFiltrados);
		table.setModel(modeloFiltrado);
		
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBounds(799, 47, 247, 276);
		contentPane.add(panel);
		panel.setLayout(null);
		
		camponome = new JTextField();
		camponome.setBounds(10, 35, 227, 30);
		panel.add(camponome);
		camponome.setColumns(10);
		
		campoemail = new JTextField();
		campoemail.setColumns(10);
		campoemail.setBounds(10, 108, 227, 30);
		panel.add(campoemail);
		
		lblNewLabel = new JLabel("EMAIL");
		lblNewLabel.setBounds(10, 85, 45, 13);
		panel.add(lblNewLabel);
		
		lblNome = new JLabel("NOME");
		lblNome.setBounds(10, 12, 45, 13);
		panel.add(lblNome);
		
		campocpf = new JTextField();
		campocpf.setColumns(10);
		campocpf.setBounds(10, 179, 227, 30);
		panel.add(campocpf);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 156, 45, 13);
		panel.add(lblCpf);	
		
		JButton btnNewButton = new JButton("PESQUISAR");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String nomeFiltro = camponome.getText();
				String emailFiltro = campoemail.getText();
				String cpfFiltro = campocpf.getText();
				
				List<Aluno>alunosFiltrados = admcontroller.filtrarAlunos(nomeFiltro,emailFiltro,cpfFiltro)
				ModeloTabela modelofiltrado = new ModeloTabela(alunosFiltrados);
				table.setModel(modeloFiltrado);
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 7));
		btnNewButton.setBounds(10, 239, 100, 27);
		panel.add(btnNewButton);
		
		JButton PAGAMENTO = new JButton("PAGAMENTO");
		PAGAMENTO.setFont(new Font("Tahoma", Font.PLAIN, 7));
		PAGAMENTO.setBounds(130, 240, 107, 25);
		panel.add(PAGAMENTO);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 7));
		btnExcluir.setBounds(939, 345, 107, 25);
		contentPane.add(btnExcluir);
		
		btnExcluir.addActionListener(new ActionListener()){
			public void actionPerformed(ActionEvent e) {
				if(selectedRow != -1) {
					Aluno alunoSelecionado = alunos.get(selectedRow);
					admcontroller.excluirAluno(alunoSelecionado);
					modeloTabela.fireTableDataChanged();
				}
			}
		});	
		JButton EDITAR = new JButton("EDITAR");
		EDITAR.setFont(new Font("Tahoma", Font.PLAIN, 7));
		EDITAR.setBounds(799, 346, 107, 25);
		contentPane.add(EDITAR);
		
		EDITAR.addActionListener(new ActionListener()){
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table.getSelectedRow();
				
				if(selectedRow != -1) {
					Aluno alunoSelecionado = alunos.get(selectedRow);
					
				}
			}
		});	
		

	}
}
