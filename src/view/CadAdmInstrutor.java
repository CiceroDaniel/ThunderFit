package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Alunocontroller;
import model.Aluno;
import view.Cad.RoundedButtonSimples;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class CadAdmInstrutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeAdmInstrutor;
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
	private JPasswordField passwordFieldAdmInstrutor;
	private JTextField textFieldEmailAdmInstrutor;
	private JLabel lblNome_2;
	private JLabel lblNewLabel_linha;
	private JLabel lblNewLabel_ImageFundo;
	private JLabel lblNewLabel_IconSenha;
	private JLabel lblNewLabel_IconEmail;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_IconPerfil;
	private JLabel linkParaLoginCadastroInstrutor;
	private JTextField Campocpf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadAdmInstrutor frame = new CadAdmInstrutor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public class RoundedButtonSimples extends JButton{
		private int arc;
		
		public RoundedButtonSimples(String text,int arc) {
			super(text);
			this.arc=arc;
			
			setContentAreaFilled(false);
			setFocusPainted(false);
			setBorderPainted(false);
			setOpaque(false);
		}
		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			
			g2.setColor(getBackground());
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			g2.fillRoundRect(0, 0, getWidth(),getHeight(), arc, arc);
			super.paintComponent(g);
			g2.dispose();
	}
		
		@Override
		protected void paintBorder(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setColor(getForeground());
			g2.setStroke(new BasicStroke(1.5f));
			g2.drawRoundRect(0,0,getWidth()-1,getHeight()-1,arc,arc);
			g2.dispose();
		}
	}

	/**
	 * Create the frame.
	 */
	public CadAdmInstrutor() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080,720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO ADM/INSTRUTOR");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(87, 48, 310, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("____________");
		lblNewLabel_1.setForeground(new Color(255, 102, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(159, 64, 166, 66);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNome_2 = new JLabel("NOME");
		lblNome_2.setForeground(Color.WHITE);
		lblNome_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome_2.setBounds(51, 122, 51, 52);
		contentPane.add(lblNome_2);
		
		JLabel lblNewLabel_linha = new JLabel("____");
		lblNewLabel_linha.setForeground(new Color(204, 102, 255));
		lblNewLabel_linha.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_linha.setBounds(51, 126, 166, 57);
		contentPane.add(lblNewLabel_linha);
		
		textFieldNomeAdmInstrutor = new JTextField();
		textFieldNomeAdmInstrutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldNomeAdmInstrutor.setColumns(10);
		textFieldNomeAdmInstrutor.setBounds(51, 174, 380, 33);
		contentPane.add(textFieldNomeAdmInstrutor);
		
		JLabel lblNome = new JLabel("EMAIL");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(51, 205, 51, 47);
		contentPane.add(lblNome);
		
		JLabel lblNewLabel_3 = new JLabel("____");
		lblNewLabel_3.setForeground(new Color(204, 102, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(51, 206, 166, 52);
		contentPane.add(lblNewLabel_3);
		
		textFieldEmailAdmInstrutor = new JTextField();
		textFieldEmailAdmInstrutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldEmailAdmInstrutor.setColumns(10);
		textFieldEmailAdmInstrutor.setBounds(51, 252, 380, 33);
		contentPane.add(textFieldEmailAdmInstrutor);
		
		JLabel lblNewLabel_2 = new JLabel("____");
		lblNewLabel_2.setForeground(new Color(204, 102, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(51, 298, 166, 25);
		contentPane.add(lblNewLabel_2);
		
		passwordFieldAdmInstrutor = new JPasswordField();
		passwordFieldAdmInstrutor.setBounds(51, 331, 380, 33);
		contentPane.add(passwordFieldAdmInstrutor);
		
		JLabel linkParaLoginCadastroAdmInstrutor = new JLabel("JÁ TEM UMA CONTA?FAÇA LOGIN AQUI");
		linkParaLoginCadastroAdmInstrutor.setForeground(Color.BLUE);
		linkParaLoginCadastroAdmInstrutor.setFont(new Font("Tahoma", Font.BOLD, 10));
		linkParaLoginCadastroAdmInstrutor.setBounds(51, 449, 294, 33);
		contentPane.add(linkParaLoginCadastroAdmInstrutor);
		
		JLabel lblNewLabel_4 = new JLabel("THUNDERFIT");
		lblNewLabel_4.setForeground(new Color(255, 102, 204));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_4.setBackground(new Color(153, 0, 255));
		lblNewLabel_4.setBounds(586, 144, 280, 126);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("______________________");
		lblNewLabel_5.setForeground(new Color(204, 102, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(579, 197, 294, 66);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblAcompanheSeuProgresso = new JLabel("acompanhe seu progresso");
		lblAcompanheSeuProgresso.setForeground(Color.WHITE);
		lblAcompanheSeuProgresso.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAcompanheSeuProgresso.setBounds(584, 281, 284, 47);
		contentPane.add(lblAcompanheSeuProgresso);
		
		JLabel lblEPreparesePara = new JLabel("e prepare-se para conquistar");
		lblEPreparesePara.setForeground(Color.WHITE);
		lblEPreparesePara.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEPreparesePara.setBounds(579, 303, 294, 47);
		contentPane.add(lblEPreparesePara);
		
		JLabel lblSeusResultados = new JLabel("seus resultados!!");
		lblSeusResultados.setForeground(Color.WHITE);
		lblSeusResultados.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSeusResultados.setBounds(641, 336, 170, 47);
		contentPane.add(lblSeusResultados);
		
		lblNewLabel_ImageFundo = new JLabel("New label");
		ImageIcon originalIcon1 = new ImageIcon(getClass().getResource("/img/walpaper1.jpg"));
	    Image originalImage1 =  originalIcon1.getImage();
	    Image resizedImage1 = originalImage1.getScaledInstance(1080, 720, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon1 = new ImageIcon(resizedImage1);
		lblNewLabel_ImageFundo.setIcon(resizedIcon1);
		lblNewLabel_ImageFundo.setBounds(459, -61, 607, 760);
		contentPane.add(lblNewLabel_ImageFundo);
		
		lblNewLabel_IconSenha = new JLabel("New label");
		ImageIcon originalIcon2 = new ImageIcon(getClass().getResource("/img/SENHA.jpeg"));
		Image originalImage2 = originalIcon2.getImage();
		Image resizedImage2 = originalImage2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon2 = new ImageIcon(resizedImage2);
		lblNewLabel_IconSenha.setIcon(resizedIcon2);
		lblNewLabel_IconSenha.setBounds(10, 324, 45, 45);
		contentPane.add(lblNewLabel_IconSenha);
		
		lblNewLabel_IconEmail = new JLabel("New label");
		ImageIcon originalIcon3 = new ImageIcon(getClass().getResource("/img/EMAIL.jpeg"));
		Image originalImage3 = originalIcon3.getImage();
		Image resizideImage3= originalImage3.getScaledInstance(40, 40,Image.SCALE_SMOOTH);
		ImageIcon resizedIcon3 = new ImageIcon(resizideImage3);
		lblNewLabel_IconEmail.setIcon(resizedIcon3);
		lblNewLabel_IconEmail.setBounds(10, 245, 50, 50);
		contentPane.add(lblNewLabel_IconEmail);
		
		lblNewLabel_IconPerfil = new JLabel("");
		ImageIcon originalIcon4 = new ImageIcon(getClass().getResource("/img/PERFIL.jpeg"));
		Image originalImage4 = originalIcon4.getImage();
		Image resizideImage4 = originalImage4.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon resizideIcon4 = new ImageIcon(resizideImage4);
		lblNewLabel_IconPerfil.setIcon(resizideIcon4);
		lblNewLabel_IconPerfil.setBounds(13, 163, 35, 50);
		contentPane.add(lblNewLabel_IconPerfil);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSenha.setBounds(51, 288, 65, 40);
		contentPane.add(lblSenha);
		
		
		
		
		//================================================================//
				//=============================BOTÕES=============================//
				//================================================================//
			
				
				RoundedButtonSimples btnCadastro = new RoundedButtonSimples("CADASTRO",20);
				btnCadastro.setForeground(new Color(255, 255, 255));
				btnCadastro.setBackground(new Color(204, 102, 255));
				btnCadastro.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnCadastro.setBounds(187, 499, 114, 33);
				contentPane.add(btnCadastro);
				
				Campocpf = new JTextField();
				Campocpf.setFont(new Font("Tahoma", Font.BOLD, 15));
				Campocpf.setColumns(10);
				Campocpf.setBounds(51, 406, 380, 33);
				contentPane.add(Campocpf);
				
				JLabel lblNewLabel_2_1 = new JLabel("____");
				lblNewLabel_2_1.setForeground(new Color(204, 102, 255));
				lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel_2_1.setBounds(51, 357, 166, 57);
				contentPane.add(lblNewLabel_2_1);
				
				JLabel lblNome_2_1 = new JLabel("CPF");
				lblNome_2_1.setForeground(Color.WHITE);
				lblNome_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNome_2_1.setBounds(51, 357, 51, 52);
				contentPane.add(lblNome_2_1);
				
				JLabel lblNewLabel_6 = new JLabel("New label");
				lblNewLabel_6.setBounds(10, 402, 45, 45);
				contentPane.add(lblNewLabel_6);
				
				
				
				//AÇÃO DO BOTÃO
				
				//=============================CADASTRAR=============================//
				
				//FALTA ARRUMAR
				
				btnCadastro.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						 // Captura os valores dos campos de texto
						String nome=textFieldNomeAdmInstrutor.getText();
						String email=textFieldEmailAdmInstrutor.getText();
						String senha= new String(passwordFieldAdmInstrutor.getPassword());
						String cpf = null;
				
						
		                if(nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
		              	
		                	JOptionPane.showMessageDialog(btnCadastro,"Preencha todos os campos");
		                	
		                }else if(!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$")){
		                	
		                	JOptionPane.showMessageDialog(btnCadastro,"	Verifique as informações");	
							
		                }else if(Alunocontroller.verificarAlunoExistente(email)){
		                	JOptionPane.showMessageDialog(btnCadastro,"	Já existe um usuario com esse email");	
		               	
						}else{
							
						// Cria um objeto aluno com os dados fornecidos
						Aluno aluno = new Aluno(nome,email,senha,cpf);	
						Alunocontroller.adicionarAluno(aluno);//CHAMA O METODO DA CLASSE ALUNOCONTROLLER	
							
						//alunos.add(aluno);
							
						 JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
			                
			                // Limpa os campos
			                textFieldEmailAdmInstrutor.setText("");  
			                textFieldNomeAdmInstrutor.setText("");    
			                passwordFieldAdmInstrutor.setText("");
			                
			                
			                dispose();
			                //ta pegando as informações do aluno nome,email e senha e mandando para a subtela
			                Formulario subtelaScreen = new Formulario(aluno);
			                subtelaScreen.setVisible(true);
			                
						
					}
				}
				});
				
				
				
				//================================================================//
				//================================================================//
				//================================================================//
	}

}
