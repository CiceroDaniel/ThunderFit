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
		
		JButton btnNewButton_Cliente = new JButton("Aluno");
		btnNewButton_Cliente.setBounds(113, 194, 212, 259);
		contentPane.add(btnNewButton_Cliente);
		
		/* // Ação do link (redireciona para a tela de login)
		linkParaLoginCadastro.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				dispose();
				
				Login loginScreen = new Login();
				loginScreen.setVisible(true);
			}
		});*/
		
		//BOTÃO DO CLIENTE
		btnNewButton_Cliente.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				
				Cad cadastroClienteScreen = new Cad();
				cadastroClienteScreen.setVisible(true);
			}
		});
		

		//BOYÃO DE INSTRUTOR
		JButton btnNewButton_Instrutor = new JButton("New button");
		btnNewButton_Instrutor.setBounds(424, 194, 212, 259);
		contentPane.add(btnNewButton_Instrutor);
		
		//BOTÃO DO ADM
		JButton btnNewButton_ADM = new JButton("New button");
		btnNewButton_ADM.setBounds(737, 194, 212, 259);
		contentPane.add(btnNewButton_ADM);
		
		JLabel lblNewLabel = new JLabel("ESCOLHA DE USUARIO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(412, 43, 262, 34);
		contentPane.add(lblNewLabel);
	}
}
