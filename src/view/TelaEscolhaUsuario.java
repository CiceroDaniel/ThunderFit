package view;

//TELA DE ESCOLHA PARA USUARIO,ADM,INSTRUTOR

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;

public class TelaEscolhaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
	}

	/**
	 * Create the frame.
	 */
	public TelaEscolhaUsuario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080,720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_Cliente = new JButton("       ALUNO");
		btnNewButton_Cliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_Cliente.setBounds(113, 143, 418, 132);
		contentPane.add(btnNewButton_Cliente);
		
		//BOTÃO DO CLIENTE//ALUNO
		
		btnNewButton_Cliente.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				
				Login LoginScreen = new Login();
				LoginScreen.setVisible(true);
			}
		});
		

		//BOYÃO DE INSTRUTOR
		JButton btnNewButton_Adm = new JButton("       ADM");
		btnNewButton_Adm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Cad cadScreen = new Cad();
				cadScreen.setVisible(true);
				
			}
		});
		btnNewButton_Adm.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_Adm.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Adm.setBounds(113, 303, 418, 132);
		contentPane.add(btnNewButton_Adm);
		
		//BOTÃO DO ADM
		JButton btnNewButton_Instrutor = new JButton("       INSTRUTOR");
		btnNewButton_Instrutor.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_Instrutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Instrutor.setBounds(113, 459, 418, 132);
		contentPane.add(btnNewButton_Instrutor);
		
		JLabel lblNewLabel = new JLabel("ESCOLHA DE USUARIO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(412, 43, 262, 34);
		contentPane.add(lblNewLabel);
	}
}
