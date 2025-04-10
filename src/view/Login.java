package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Aluno;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import java.awt.Canvas;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JLabel lblNome;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblSenha;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblExploreSeusTreinosacompanhe;
	private JLabel lblAcompanheSeuProgresso;
	private JLabel lblEPreparesePara;
	private JLabel lblSeusResultados;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel linkparalogin;
	private JLabel lblNewLabel_iconeEmail;
	private JLabel lblNewLabel_iconeSenha;
	private JLabel lblNewLabel_walpaper2;
	
	 // Lista de clientes cadastrados
	
   //private ArrayList<Cliente> clientes = Cad.getClientes();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080,720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setForeground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		//================================================================//
		//=============================CAIXAS=============================//
		//================================================================//
		
		//CAIXA PRA INFORMAR EMAIL
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(58, 234, 380, 33);
		textFieldUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		//CAIXA PRA INFORMAR SENHA
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(58, 330, 380, 33);
		contentPane.add(passwordField);
		
		//================================================================//
		//================================================================//
		//================================================================//
		
		//================================================================//
		//=============================EVENTO=============================//
		//================================================================//
		
		 JButton btnLogin = new JButton("LOGIN");
	        btnLogin.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	           
	                String email = textFieldUsuario.getText();
	                String senha = new String(passwordField.getPassword());
	                
                   //TESTAR SE O LOGIN É VALIDO
	                boolean loginValido = false;
	                
                // Verifica se algum cliente cadastrado tem o email e senha corretos
	                for (Aluno aluno : Cad.getAlunos()) {//VERIFICA A LISTA DE PESSOAS CADASTRADAS
	                    if (aluno.getEmail().equals(email) && aluno.getSenha().equals(senha)) {
	                        loginValido = true;
	                        break;
	                    }
	                }

	                if (loginValido) {
	                    JOptionPane.showMessageDialog(btnLogin, "Bem vindo!");

	                    // Direciona para a tela principal após o login
	                    dispose();
	                    
	                    Principal principalScreen = new Principal();
	                    principalScreen.setVisible(true);

	                } else {
	                    JOptionPane.showMessageDialog(btnLogin, "Email ou senha incorretos.", "Erro", JOptionPane.WARNING_MESSAGE);
	                }
	            }
	            
	        });
	                
	            
	        btnLogin.setBounds(186, 448, 114, 33);
	        btnLogin.setForeground(new Color(255, 255, 255));
	        btnLogin.setBackground(new Color(204, 102, 255));
	        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
	        contentPane.add(btnLogin);
	    
 		
		btnLogin.setBounds(187, 487, 114, 33);
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(204, 102, 255));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnLogin);
		
		//================================================================//
		//================================================================//
		//================================================================//
		
		
		//================================================================//
		//=============================TEXTOS=============================//
		//================================================================//
		
		JLabel lblNewLabel = new JLabel("LOGIN USER");
		lblNewLabel.setBounds(179, 60, 134, 66);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel);
		
		lblNome = new JLabel("EMAIL");
		lblNome.setBounds(58, 171, 51, 52);
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNome);
		
		lblNewLabel_4 = new JLabel("THUNDERFIT");
		lblNewLabel_4.setBounds(596, 160, 280, 126);
		lblNewLabel_4.setForeground(new Color(255, 102, 204));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblNewLabel_4);
		
		lblExploreSeusTreinosacompanhe = new JLabel("Explore seus treinos,");
		lblExploreSeusTreinosacompanhe.setBounds(631, 268, 210, 47);
		lblExploreSeusTreinosacompanhe.setForeground(Color.WHITE);
		lblExploreSeusTreinosacompanhe.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblExploreSeusTreinosacompanhe);
		
		lblAcompanheSeuProgresso = new JLabel("acompanhe seu progresso");
		lblAcompanheSeuProgresso.setBounds(594, 297, 284, 47);
		lblAcompanheSeuProgresso.setForeground(Color.WHITE);
		lblAcompanheSeuProgresso.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblAcompanheSeuProgresso);
		
		lblEPreparesePara = new JLabel("e prepare-se para conquistar");
		lblEPreparesePara.setBounds(589, 319, 294, 47);
		lblEPreparesePara.setForeground(Color.WHITE);
		lblEPreparesePara.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblEPreparesePara);
		
		lblSeusResultados = new JLabel("seus resultados!!");
		lblSeusResultados.setBounds(651, 352, 170, 47);
		lblSeusResultados.setForeground(Color.WHITE);
		lblSeusResultados.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblSeusResultados);
		
		lblNewLabel_1 = new JLabel("____________");
		lblNewLabel_1.setBounds(166, 72, 166, 66);
		lblNewLabel_1.setForeground(new Color(255, 102, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("____");
		lblNewLabel_2.setBounds(58, 273, 166, 66);
		lblNewLabel_2.setForeground(new Color(204, 102, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2);
		
		lblSenha = new JLabel("SENHA");
		lblSenha.setBounds(58, 267, 62, 52);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblSenha);
		
		lblNewLabel_3 = new JLabel("____");
		lblNewLabel_3.setBounds(58, 175, 166, 66);
		lblNewLabel_3.setForeground(new Color(204, 102, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_5 = new JLabel("______________________");
		lblNewLabel_5.setBounds(589, 213, 294, 66);
		lblNewLabel_5.setForeground(new Color(204, 102, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_5);
		
		//================================================================//
		//================================================================//
		//================================================================//
		
		//================================================================//
		//==========================IMAGENS===============================//
		//================================================================//
		
		/*
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\UFCA\\Downloads\\WhatsApp Image 2025-04-03 at 13.58.32.jpeg"));
		lblNewLabel_6.setBounds(463, 0, 500, 725);
		contentPane.add(lblNewLabel_6);
		

		lblNewLabel_9 = new JLabel("New label");
		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/img/email.jpeg"));
		Image originalImage = originalIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		lblNewLabel_9.setIcon(resizedIcon);
		lblNewLabel_9.setBounds(5, 227, 50, 50);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_12 = new JLabel("New label");
		ImageIcon originalIcon2 = new ImageIcon(getClass().getResource("/img/senha.jpeg"));
		Image originalImage2 = originalIcon2.getImage();
		Image resizedImage2 = originalImage2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon2 = new ImageIcon(resizedImage2);
		lblNewLabel_12.setIcon(resizedIcon2);
		lblNewLabel_12.setBounds(5, 321, 45, 45); 
		contentPane.add(lblNewLabel_12);
		*/
		
		//================================================================//
		//================================================================//
		//================================================================//
		
		
		linkparalogin = new JLabel("AINDA NÃO TEM UM CADASTRO?CLIQUE AQUI");
		linkparalogin.setFont(new Font("Tahoma", Font.BOLD, 10));
		linkparalogin.setBounds(58, 398, 380, 13);
		linkparalogin.setForeground(Color.BLUE);
		contentPane.add(linkparalogin);
		
		lblNewLabel_iconeEmail = new JLabel("");
		ImageIcon originalIcon1 = new ImageIcon(getClass().getResource("/img/EMAIL.jpeg"));
		Image originalImage1 = originalIcon1.getImage();
		Image resizideImage1 = originalImage1.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon resizideIcon1 = new ImageIcon(resizideImage1);
		lblNewLabel_iconeEmail.setIcon(resizideIcon1);
		lblNewLabel_iconeEmail.setBounds(15, 225, 50, 50);
		contentPane.add(lblNewLabel_iconeEmail);
		
		lblNewLabel_iconeSenha = new JLabel("");
		ImageIcon originalIcon2 = new ImageIcon(getClass().getResource("/img/SENHA.jpeg"));
		Image originalImage2 = originalIcon2.getImage();
		Image resizideImage2 = originalImage2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon resizideIcon2 = new ImageIcon(resizideImage2);
		lblNewLabel_iconeSenha.setIcon(resizideIcon2);
		lblNewLabel_iconeSenha.setBounds(15, 320, 50, 50);
		contentPane.add(lblNewLabel_iconeSenha);
		
		lblNewLabel_walpaper2 = new JLabel("New label");
		ImageIcon originalIcon3 = new ImageIcon(getClass().getResource("/img/walpaper2.jpg"));
		Image originalImage3 = originalIcon3.getImage();
		Image resizideImage3 = originalImage3.getScaledInstance(700,700, Image.SCALE_SMOOTH);
		ImageIcon resizideIcon3 = new ImageIcon(resizideImage3);
		lblNewLabel_walpaper2.setIcon(resizideIcon3);
		lblNewLabel_walpaper2.setBounds(460, -7, 625, 708);
		contentPane.add(lblNewLabel_walpaper2);
		
		// Adicionando o MouseListener para redirecionar para a tela de cadastro
		
		linkparalogin.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				
				Cad cadScreen = new Cad();
				cadScreen.setVisible(true);
		}
	});
	
		//================================================================//
		//================================================================//
		//================================================================//
		
	            }
	        }
