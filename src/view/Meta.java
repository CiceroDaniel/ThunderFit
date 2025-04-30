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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Meta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Meta frame = new Meta(aluno);
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
	
	public Meta(Aluno aluno) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1080,720);
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
		
		JLabel lblNewLabel_menu = new JLabel("____________________________________________________________________________________________________");
		lblNewLabel_menu.setForeground(new Color(255, 102, 204));
		lblNewLabel_menu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_menu.setBounds(0, 11, 1088, 32);
		panel_1.add(lblNewLabel_menu);
		
		JLabel lblNewLabel_1 = new JLabel("THUNDERFIT");
		lblNewLabel_1.setForeground(new Color(255, 102, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(48, 0, 140, 38);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_perfil = new JButton("");
		btnNewButton_perfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Principal principalScreen = new Principal(aluno);
			    principalScreen.setVisible(true);
				
			}
		});
		btnNewButton_perfil.setBounds(1030, 4, 30, 30);
		panel_1.add(btnNewButton_perfil);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(0, 645, 1066, 38);
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
		lblNewLabel_4.setBounds(0, 618, 1077, 32);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(69, 105, 333, 342);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_Nome = new JLabel("NOME:");
		lblNewLabel_Nome.setBounds(10, 57, 67, 25);
		panel.add(lblNewLabel_Nome);
		lblNewLabel_Nome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_Nome.setForeground(new Color(255, 255, 255));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 102, 153));
		panel_2.setBounds(10, 11, 313, 37);
		panel.add(panel_2);
		
		JLabel lblNewLabel_Nome_1 = new JLabel("NOME:");
		lblNewLabel_Nome_1.setForeground(Color.WHITE);
		lblNewLabel_Nome_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_Nome_1.setBounds(10, 57, 67, 25);
		panel_2.add(lblNewLabel_Nome_1);
		
		JLabel lblNewLabel_Nome_2 = new JLabel("INFORMAÇÕES");
		lblNewLabel_Nome_2.setForeground(Color.WHITE);
		lblNewLabel_Nome_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_Nome_2.setBounds(80, 5, 193, 25);
		panel_2.add(lblNewLabel_Nome_2);
		
		JLabel lblNewLabel_Nome_3 = new JLabel("DATA DE INICIO:");
		lblNewLabel_Nome_3.setForeground(Color.WHITE);
		lblNewLabel_Nome_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_Nome_3.setBounds(10, 181, 169, 25);
		panel.add(lblNewLabel_Nome_3);
		
		JLabel lblNewLabel_Nome_3_1 = new JLabel("PESO INCIAL:");
		lblNewLabel_Nome_3_1.setForeground(Color.WHITE);
		lblNewLabel_Nome_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_Nome_3_1.setBounds(10, 258, 169, 25);
		panel.add(lblNewLabel_Nome_3_1);
		
		JLabel lblNewLabel_Nome_4 = new JLabel("IDADE INICIAL:");
		lblNewLabel_Nome_4.setForeground(Color.WHITE);
		lblNewLabel_Nome_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_Nome_4.setBounds(10, 116, 169, 25);
		panel.add(lblNewLabel_Nome_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(51, 51, 51));
		panel_3.setBounds(472, 105, 333, 182);
		contentPane.add(panel_3);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(255, 102, 153));
		panel_2_1.setBounds(10, 11, 313, 37);
		panel_3.add(panel_2_1);
		
		JLabel lblNewLabel_Nome_1_1 = new JLabel("NOME:");
		lblNewLabel_Nome_1_1.setForeground(Color.WHITE);
		lblNewLabel_Nome_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_Nome_1_1.setBounds(10, 57, 67, 25);
		panel_2_1.add(lblNewLabel_Nome_1_1);
		
		JLabel lblNewLabel_Nome_2_1 = new JLabel("META");
		lblNewLabel_Nome_2_1.setForeground(Color.WHITE);
		lblNewLabel_Nome_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_Nome_2_1.setBounds(120, 5, 67, 25);
		panel_2_1.add(lblNewLabel_Nome_2_1);
		
		JLabel lblNewLabel_Nome_4_1 = new JLabel("META:");
		lblNewLabel_Nome_4_1.setForeground(Color.WHITE);
		lblNewLabel_Nome_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_Nome_4_1.setBounds(10, 59, 169, 25);
		panel_3.add(lblNewLabel_Nome_4_1);
		
		JLabel lblNewLabel_Nome_4_1_1 = new JLabel("PESO FINAL:");
		lblNewLabel_Nome_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_Nome_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_Nome_4_1_1.setBounds(10, 108, 169, 25);
		panel_3.add(lblNewLabel_Nome_4_1_1);
		
		JButton btnNewButton = new JButton("ATUALIZAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(204, 102, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(498, 580, 133, 27);
		contentPane.add(btnNewButton);
	}
}
