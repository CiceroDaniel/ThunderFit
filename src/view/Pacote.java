package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Aluno;

import java.awt.Color;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pacote extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pacote frame = new Pacote(aluno);
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
	private static Aluno aluno;
	
	public Pacote(Aluno aluno) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 1066, 38);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("____________________________________________________________________________________________________");
		lblNewLabel.setForeground(new Color(255, 102, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 11, 1088, 32);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("THUNDERFIT");
		lblNewLabel_1.setForeground(new Color(255, 102, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(48, 0, 140, 38);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_menu = new JButton("");
		btnNewButton_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Principal principalScreen = new Principal(aluno);
				principalScreen.setVisible(true);
				
			}
		});
		btnNewButton_menu.setBounds(1030, 4, 30, 30);
		panel_1.add(btnNewButton_menu);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(0, 643, 1066, 38);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("THUNDERFIT");
		lblNewLabel_1_1.setForeground(new Color(255, 102, 204));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(507, 2, 137, 30);
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("@THUNDERFIT_ACADEMY");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(30, 0, 204, 38);
		panel_1_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("+55 9881234-5678");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(892, 0, 174, 38);
		panel_1_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("_________________________________________________________________________________________________");
		lblNewLabel_4.setForeground(new Color(255, 102, 204));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(0, 615, 1077, 32);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(71, 71, 71));
		panel.setBounds(43, 89, 319, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 102, 153));
		panel_3.setBounds(10, 11, 297, 40);
		panel.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("MENSAL");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(111, 15, 116, 14);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(71, 71, 71));
		panel_2.setBounds(372, 89, 319, 382);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(255, 102, 153));
		panel_3_1.setBounds(10, 11, 297, 40);
		panel_2.add(panel_3_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("BIMESTRAL");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(92, 15, 150, 14);
		panel_3_1.add(lblNewLabel_2_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(71, 71, 71));
		panel_2_1.setBounds(701, 89, 319, 382);
		contentPane.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBackground(new Color(255, 102, 153));
		panel_3_1_1.setBounds(10, 11, 297, 40);
		panel_2_1.add(panel_3_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("TRIMESTRAL");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_2_1.setBounds(87, 15, 150, 14);
		panel_3_1_1.add(lblNewLabel_2_2_1);
		
		JButton btnPagamento = new JButton("PAGAMENTO");
		btnPagamento.setBackground(new Color(204, 102, 204));
		btnPagamento.setForeground(new Color(255, 255, 255));
		btnPagamento.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPagamento.setBounds(548, 590, 143, 23);
		contentPane.add(btnPagamento);
		
		JButton btnEscolher = new JButton("ESCOLHER");
		btnEscolher.setForeground(Color.WHITE);
		btnEscolher.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEscolher.setBackground(new Color(204, 102, 204));
		btnEscolher.setBounds(372, 590, 143, 23);
		contentPane.add(btnEscolher);
	}
}
