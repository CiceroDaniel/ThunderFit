package view;
//ULTILIZADO PARA EDITAR TREINOS
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Aluno;
import model.Tutor;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Selecionartreinos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-37,94
	 */
	private final JPanel panel = new JPanel();
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblListaDeTreinos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selecionartreinos frame = new Selecionartreinos(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param tutor 
	 * @param alunoSelecionado 
	 */
	public Selecionartreinos(Aluno alunoSelecionado, Tutor tutor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1080,720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 70, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 52, 494, 565);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"SEGUNDA", "TER\u00C7A", "QUARTA", "QUINTA", "SEXTA", "SABADO"
			}
		));
		
		lblNewLabel = new JLabel("EDITOR DE TREINOS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(49, 10, 270, 32);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 20, 30, 30);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("SALVAR");
		btnNewButton_1.setBounds(49, 627, 85, 21);
		contentPane.add(btnNewButton_1);
		
		lblListaDeTreinos = new JLabel("LISTA DE TREINOS");
		lblListaDeTreinos.setForeground(Color.WHITE);
		lblListaDeTreinos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListaDeTreinos.setBounds(719, 10, 207, 32);
		contentPane.add(lblListaDeTreinos);
	}
}
