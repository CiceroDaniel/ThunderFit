package view;
//ESSA TELA APARECERA PARA O ADM,COM TODAS AS PESSOAS CADASTRADAS
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Alunocontroller;
import model.Aluno;
import model.ModeloTabela;
import model.Tutor;

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

public class Tabelacadastrosdotutor extends JFrame {

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
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaCadastrosAdm frame = new TabelaCadastrosAdm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Tutor tutor;
	private Aluno aluno;
	
	public Tabelacadastrosdotutor(Tutor tutor,Aluno aluno) {
		this.tutor=tutor;
		this.aluno=aluno;
         ArrayList<Aluno> alunos;
         ModeloTabela modelotabela;
		//alunos.add();
		
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
				
				dispose();
				
				TelaEscolhaUsuario escolhaScreen = new TelaEscolhaUsuario(aluno, tutor, null);
				escolhaScreen.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(3, 18, 30, 30);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 49, 752, 584);
		contentPane.add(scrollPane);
		
		//-------------------------------------------------------------
		
        alunos = (ArrayList<Aluno>)Admcontroller.getAlunosCadastrados();
		modelotabela = new ModeloTabela(alunos);
		
		
		//--------------------------------------------------------------
		
		table = new JTable();
		table.setModel(modelotabela);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBackground(new Color(85, 85, 85));
		panel.setBounds(799, 49, 247, 260);
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
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 85, 76, 13);
		panel.add(lblNewLabel);
		
		lblNome = new JLabel("NOME");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(10, 12, 76, 13);
		panel.add(lblNome);
		
		campocpf = new JTextField();
		campocpf.setColumns(10);
		campocpf.setBounds(10, 179, 227, 30);
		panel.add(campocpf);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCpf.setBounds(10, 156, 45, 13);
		panel.add(lblCpf);	
		
		JButton btnNewButton = new JButton("PESQUISAR");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(204, 102, 204));
		btnNewButton.setBounds(137, 225, 100, 27);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String nome = camponome.getText();
				String email = campoemail.getText();
				String cpf = campocpf.getText();
				
				List<Aluno> resultado = Alunocontroller.buscaralunoController(nome,email,cpf);
				
				//ATUALIZA A TABELA
				table.setModel(new ModeloTabela(resultado));
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JButton btnListar = new JButton("LISTAR");
		btnListar.setForeground(new Color(255, 255, 255));
		btnListar.setBackground(new Color(204, 102, 204));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Aluno> todos = Alunocontroller.listaralunoController(aluno);
				
				//ATUALIZA A TABELA
				table.setModel(new ModeloTabela(todos));
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnListar.setBounds(10, 227, 100, 27);
		panel.add(btnListar);
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if(evt.getClickCount()==2) {
					int linha = table.getSelectedRow();
					if(linha >= 0) {
						Aluno alunoSelecionado = ((ModeloTabela) table.getModel()).getAlunotAt(linha);
						
						
						//ABRE A TELA DE EDIÇÃO E PASSA O ALUNO
						
						Selecionartreinos crud = new Selecionartreinos(alunoSelecionado, tutor);
						crud.setVisible(true);
					}
				}
			}
        });
	}
}