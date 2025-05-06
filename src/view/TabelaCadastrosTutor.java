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

import javax.swing.JTree;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TabelaCadastrosTutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JTable table;
	
	private ArrayList<Aluno> alunos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaCadastrosTutor frame = new TabelaCadastrosTutor();
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
	public TabelaCadastrosTutor() {

		alunos = new ArrayList<>();
		//alunos.add();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080,720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(37, 18, 868, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("PESQUISAR");
		btnNewButton.setBounds(916, 19, 112, 27);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("SAIR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(3, 18, 30, 30);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 70, 991, 545);
		contentPane.add(scrollPane);
		
		
		ModeloTabela modelotabela = new ModeloTabela(alunos);
		
		table = new JTable();
		table.setModel(modelotabela);
		scrollPane.setViewportView(table);
  
		
		JButton ATUALIZAR = new JButton("ATUALIZAR");
		ATUALIZAR.setBounds(39, 639, 90, 25);
		contentPane.add(ATUALIZAR);
		
		JButton EXCLUIR = new JButton("EXCLUIR");
		EXCLUIR.setBounds(161, 639, 90, 25);
		contentPane.add(EXCLUIR);
		
		JButton PAGAMENTO = new JButton("PAGAMENTO");
		PAGAMENTO.setBounds(938, 639, 90, 25);
		contentPane.add(PAGAMENTO);
	}
}
