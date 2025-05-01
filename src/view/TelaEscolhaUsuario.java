package view;

//TELA DE ESCOLHA PARA USUARIO,ADM,INSTRUTOR

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Aluno;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;

public class TelaEscolhaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	
	/*
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEscolhaUsuario frame = new TelaEscolhaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	
	private Aluno aluno;
	
	public TelaEscolhaUsuario(Aluno aluno) {
		setResizable(false);
		
		this.aluno=aluno;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080,720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_Cliente = new JButton("       ALUNO");
		btnNewButton_Cliente.setBackground(new Color(204, 102, 255));
		btnNewButton_Cliente.setForeground(new Color(255, 255, 255));
		btnNewButton_Cliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_Cliente.setBounds(113, 143, 418, 132);
		contentPane.add(btnNewButton_Cliente);
		
		//BOTÃO DO CLIENTE//ALUNO
		
		btnNewButton_Cliente.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				
				Login LoginScreen = new Login(aluno);
				LoginScreen.setVisible(true);
			}
		});
		

		//BOTÃO DE INSTRUTOR
		JButton btnNewButton_Adm = new JButton("       ADM");
		btnNewButton_Adm.setForeground(new Color(255, 255, 255));
		btnNewButton_Adm.setBackground(new Color(204, 102, 255));
		btnNewButton_Adm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Cad cadScreen = new Cad(aluno);
				cadScreen.setVisible(true);
				
			}
		});
		btnNewButton_Adm.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_Adm.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Adm.setBounds(113, 303, 418, 132);
		contentPane.add(btnNewButton_Adm);
		
		//BOTÃO DO ADM
		JButton btnNewButton_Instrutor = new JButton("       INSTRUTOR");
		btnNewButton_Instrutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				CadAdmInstrutor cadAdmInstrutorScreen = new  CadAdmInstrutor();
				cadAdmInstrutorScreen.setVisible(true);
				
			}
		});
		btnNewButton_Instrutor.setForeground(new Color(255, 255, 255));
		btnNewButton_Instrutor.setBackground(new Color(204, 102, 255));
		btnNewButton_Instrutor.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_Instrutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Instrutor.setBounds(113, 459, 418, 132);
		contentPane.add(btnNewButton_Instrutor);
		
		JLabel lblNewLabel = new JLabel("ESCOLHA DE USUARIO");
		lblNewLabel.setBackground(new Color(204, 102, 255));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(113, 71, 262, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1066, 38);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("THUNDERFIT");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setForeground(new Color(255, 102, 204));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(42, 5, 145, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("______________________________________________________________________________________________________________________________________________");
		lblNewLabel_1.setForeground(new Color(255, 153, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(0, 20, 1094, 20);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 645, 1066, 38);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("THUNDERFIT");
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1.setForeground(new Color(255, 102, 204));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(463, 6, 140, 30);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("@THUNDERFIT_ACADEMY");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(30, 0, 204, 38);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("+55 9881234-5678");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(896, -1, 170, 40);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("__________________________________________________________________________________________________________________________________________");
		lblNewLabel_1_1.setForeground(new Color(255, 153, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(0, 628, 1094, 20);
		contentPane.add(lblNewLabel_1_1);
	
		
		JLabel logo = new JLabel("");
		logo.setBounds(566, 143, 468, 440);
		contentPane.add(logo);
		
		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/img/LOGOthunderfit.jpg"));
		Image originalImage = originalIcon.getImage();
		Image resizideImage = originalImage.getScaledInstance(500,590,Image.SCALE_SMOOTH);
		ImageIcon resizideIcon = new ImageIcon(resizideImage);
		logo.setIcon(resizideIcon);
		
		
	}
}
