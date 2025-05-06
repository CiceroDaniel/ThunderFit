package view;


//FAZER UMA CAIXA DE TEXTO PARA CPF

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Alunocontroller;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.Aluno;//chama a classe aluno que esta no outro pacote
import model.Tutor;
import controller.Alunocontroller;
import javax.swing.SwingConstants;

import services.*;

public class Cad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Campodenome;
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
	private JPasswordField Camposenha;
	private JTextField Campoemail;
	private JLabel lblNome_2;
	private JLabel lblNewLabel_linha;
	private JLabel lblNewLabel_ImageFundo;
	private JLabel lblNewLabel_IconSenha;
	private JLabel lblNewLabel_IconEmail;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_IconPerfil;
	private JLabel linkParaLoginCadastroInstrutor;
	


	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JPasswordField campocpf;
	private JLabel IMAGEMCPF;
	private JTextField campoCpf;
	private JLabel lblAdmnistrador;
	private JButton btnNewButton_LOGOUT;

	
	private Aluno aluno;
	private Tutor tutor;

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
			g2.setStroke(new BasicStroke(0.0f));
			g2.drawRoundRect(0,0,getWidth()-1,getHeight()-1,arc,arc);
			g2.dispose();
		}
	}
	
	//METODO ADICIONAR IMAGEM AO BOTÃO
	public void setImageBotao(JButton botao,String caminho,int largura,int altura) {
		ImageIcon icon = new ImageIcon(getClass().getResource(caminho));
		Image img = icon.getImage().getScaledInstance(largura,altura,Image.SCALE_SMOOTH);
		botao.setIcon(new ImageIcon(img));
		botao.setHorizontalTextPosition(SwingConstants.RIGHT);
		botao.setIconTextGap(10);
	}
	

	
	public Cad(Aluno aluno,Tutor tutor) {
		
		this.aluno=aluno;
		this.tutor = tutor;
		
		setResizable(false);
		setBackground(new Color(224, 188, 233));
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
		
		Campodenome = new JTextField();
		Campodenome.setFont(new Font("Tahoma", Font.BOLD, 15));
		Campodenome.setBounds(58, 193, 380, 33);
		contentPane.add(Campodenome);
		Campodenome.setColumns(10);
	
		
		Camposenha = new JPasswordField();
		Camposenha.setBounds(58, 348, 380, 33);
		contentPane.add(Camposenha);
		
		Campoemail = new JTextField();
		Campoemail.setFont(new Font("Tahoma", Font.BOLD, 15));
		Campoemail.setColumns(10);
		Campoemail.setBounds(58, 270, 380, 33);
		contentPane.add(Campoemail);

		campoCpf = new JTextField();
		campoCpf.setFont(new Font("Tahoma", Font.BOLD, 15));
		campoCpf.setColumns(10);
		campoCpf.setBounds(58, 421, 380, 33);
		contentPane.add(campoCpf);
		
		
		//================================================================//
		//================================================================//
		//================================================================//
		
		//================================================================//
		//=============================TEXTOS=============================//
		//================================================================//
				
		
		JLabel lblNewLabel = new JLabel("CADASTRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(187, 56, 134, 66);
		contentPane.add(lblNewLabel);
		
		lblNome = new JLabel("EMAIL");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(58, 227, 51, 33);
		contentPane.add(lblNome);
		
		lblNewLabel_1 = new JLabel("____________");
		lblNewLabel_1.setForeground(new Color(255, 102, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(166, 72, 166, 66);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("____");
		lblNewLabel_2.setForeground(new Color(204, 102, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(58, 160, 62, 25);
		contentPane.add(lblNewLabel_2);
		
		lblSenha = new JLabel("SENHA");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSenha.setBounds(58, 296, 62, 52);
		contentPane.add(lblSenha);
		
		lblNewLabel_3 = new JLabel("____");
		lblNewLabel_3.setForeground(new Color(204, 102, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(58, 258, 166, 52);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("THUNDERFIT");
		lblNewLabel_4.setBackground(new Color(153, 0, 255));
		lblNewLabel_4.setForeground(new Color(255, 102, 204));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_4.setBounds(596, 160, 280, 126);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("______________________");
		lblNewLabel_5.setForeground(new Color(204, 102, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(589, 213, 294, 66);
		contentPane.add(lblNewLabel_5);
		
		lblExploreSeusTreinosacompanhe = new JLabel("Explore seus treinos,");
		lblExploreSeusTreinosacompanhe.setForeground(Color.WHITE);
		lblExploreSeusTreinosacompanhe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblExploreSeusTreinosacompanhe.setBounds(631, 268, 210, 47);
		contentPane.add(lblExploreSeusTreinosacompanhe);
		
		lblAcompanheSeuProgresso = new JLabel("acompanhe seu progresso");
		lblAcompanheSeuProgresso.setForeground(Color.WHITE);
		lblAcompanheSeuProgresso.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAcompanheSeuProgresso.setBounds(594, 297, 284, 47);
		contentPane.add(lblAcompanheSeuProgresso);
		
		lblEPreparesePara = new JLabel("e prepare-se para conquistar");
		lblEPreparesePara.setForeground(Color.WHITE);
		lblEPreparesePara.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEPreparesePara.setBounds(589, 319, 294, 47);
		contentPane.add(lblEPreparesePara);
		
		lblSeusResultados = new JLabel("seus resultados!!");
		lblSeusResultados.setForeground(Color.WHITE);
		lblSeusResultados.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSeusResultados.setBounds(651, 352, 170, 47);
		contentPane.add(lblSeusResultados);
		
		lblNome_2 = new JLabel("NOME");
		lblNome_2.setForeground(Color.WHITE);
		lblNome_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome_2.setBounds(58, 140, 51, 52);
		contentPane.add(lblNome_2);
		
		lblNewLabel_linha = new JLabel("____");
		lblNewLabel_linha.setForeground(new Color(204, 102, 255));
		lblNewLabel_linha.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_linha.setBounds(58, 160, 166, 57);
		contentPane.add(lblNewLabel_linha);
		
		//================================================================//
		//================================================================//
		//================================================================//
		
		//================================================================//
		//=============================BOTÕES=============================//
		//================================================================//
	
		
		RoundedButtonSimples btnCadastro = new RoundedButtonSimples("CADASTRO",20);
		btnCadastro.setForeground(new Color(255, 255, 255));
		btnCadastro.setBackground(new Color(204, 102, 255));
		btnCadastro.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastro.setBounds(187, 499, 114, 33);
		contentPane.add(btnCadastro);
		
		
		
		//AÇÃO DO BOTÃO
		
		//=============================CADASTRAR=============================//
		
		btnCadastro.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				 // Captura os valores dos campos de texto
				String nome=Campodenome.getText();
				String email=Campoemail.getText();
				String senha= new String(Camposenha.getPassword());
				String cpf = campoCpf.getText();
				
				

				
                if(nome.isEmpty() || email.isEmpty() || senha.isEmpty() || cpf.isEmpty()) {
              	
                	JOptionPane.showMessageDialog(btnCadastro,"Preencha todos os campos");
                	
                	
                	
                }else{
                	
                	try {
                		
                	}catch(IllegalArgumentException ex) {
                		JOptionPane.showMessageDialog(btnCadastro,"Verifique as informações do email");
                		return;
                	}
                
					
             /*   if(Alunocontroller.verificarAlunoExistente(email)){//ele chama o alunocontroller
                	JOptionPane.showMessageDialog(btnCadastro,"	Já existe um usuario com esse email");	
               	
				}else{
					}*/
                	
                	
				// Cria um objeto aluno com os dados fornecidos
				Aluno aluno = new Aluno(nome, email, senha, cpf);		
				 JOptionPane.showMessageDialog(null,aluno.gerarCredenciaisCadastro());
	                
	                // Limpa os campos
	                Campoemail.setText("");  
	                Campodenome.setText("");    
	                Camposenha.setText("");
	                campoCpf.setText("");
	                
	                
	                dispose();
	                //ta pegando as informações do aluno nome,email e senha e mandando para a subtela
	                Formulario formularioScreen = new Formulario(aluno,tutor);
	                formularioScreen.setVisible(true);
	                
				
			}
		}
	
});
			
		
		
		
		
		//================================================================//
		//================================================================//
		//================================================================//
		
		//================================================================//
		//=============================IMAGENS============================//
		//================================================================//
		
		
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
		lblNewLabel_IconSenha.setBounds(10, 342, 45, 45);
		contentPane.add(lblNewLabel_IconSenha);
		
		lblNewLabel_IconEmail = new JLabel("New label");
		ImageIcon originalIcon3 = new ImageIcon(getClass().getResource("/img/EMAIL.jpeg"));
		Image originalImage3 = originalIcon3.getImage();
		Image resizideImage3= originalImage3.getScaledInstance(40, 40,Image.SCALE_SMOOTH);
		ImageIcon resizedIcon3 = new ImageIcon(resizideImage3);
		lblNewLabel_IconEmail.setIcon(resizedIcon3);
		lblNewLabel_IconEmail.setBounds(10, 263, 50, 50);
		contentPane.add(lblNewLabel_IconEmail);
		
		lblNewLabel_IconPerfil = new JLabel("");
		ImageIcon originalIcon4 = new ImageIcon(getClass().getResource("/img/PERFIL.jpeg"));
		Image originalImage4 = originalIcon4.getImage();
		Image resizideImage4 = originalImage4.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon resizideIcon4 = new ImageIcon(resizideImage4);
		lblNewLabel_IconPerfil.setIcon(resizideIcon4);
		lblNewLabel_IconPerfil.setBounds(15, 181, 35, 50);
		contentPane.add(lblNewLabel_IconPerfil);
		
		//================================================================//
		//===============================LINK=============================//
		//================================================================//
		
		JLabel linkParaLoginCadastro = new JLabel("JÁ TEM UMA CONTA?FAÇA LOGIN AQUI");
		linkParaLoginCadastro.setFont(new Font("Tahoma", Font.BOLD, 10));
		linkParaLoginCadastro.setBounds(58, 456, 294, 33);
		linkParaLoginCadastro.setForeground(Color.BLUE);
		contentPane.add(linkParaLoginCadastro);
		
		
		 // Ação do link (redireciona para a tela de login)
		linkParaLoginCadastro.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				dispose();
				
				Loginaluno loginScreen = new Loginaluno(aluno);
				loginScreen.setVisible(true);
			}
		});

		
		lblNewLabel_6 = new JLabel("____");
		lblNewLabel_6.setForeground(new Color(204, 102, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(58, 313, 62, 25);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("____");
		lblNewLabel_7.setForeground(new Color(204, 102, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(58, 236, 62, 25);
		contentPane.add(lblNewLabel_7);
		
		JLabel CPF = new JLabel("CPF");
		CPF.setForeground(Color.WHITE);
		CPF.setFont(new Font("Tahoma", Font.BOLD, 15));
		CPF.setBounds(58, 373, 62, 52);
		contentPane.add(CPF);
		
		JLabel lblNewLabel_2_1 = new JLabel("____");
		lblNewLabel_2_1.setForeground(new Color(204, 102, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(58, 391, 62, 25);
		contentPane.add(lblNewLabel_2_1);
		
		IMAGEMCPF = new JLabel("CPF");
		IMAGEMCPF.setForeground(new Color(255, 128, 192));
		IMAGEMCPF.setFont(new Font("Tahoma", Font.BOLD, 20));
		IMAGEMCPF.setBounds(10, 413, 45, 45);
		contentPane.add(IMAGEMCPF);
		
		lblAdmnistrador = new JLabel("ADMNISTRADOR");
		lblAdmnistrador.setForeground(Color.BLUE);
		lblAdmnistrador.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAdmnistrador.setBounds(27, 640, 100, 33);
		contentPane.add(lblAdmnistrador);
		
		
		JLabel linkParaLoginCadastroTutor = new JLabel("CADASTRO DE TUTOR");
		linkParaLoginCadastroTutor.setForeground(Color.BLUE);
		linkParaLoginCadastroTutor.setFont(new Font("Tahoma", Font.BOLD, 10));
		linkParaLoginCadastroTutor.setBounds(27, 619, 262, 33);
		contentPane.add(linkParaLoginCadastroTutor);
		
		btnNewButton_LOGOUT = new JButton("");
		setImageBotao(btnNewButton_LOGOUT,"/img/LOGOUT.jpeg",30,30);
		btnNewButton_LOGOUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				TelaEscolhaUsuario escolhaScreen = new TelaEscolhaUsuario(aluno,tutor);
				escolhaScreen.setVisible(true);
			}
		});
		btnNewButton_LOGOUT.setIconTextGap(10);
		btnNewButton_LOGOUT.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton_LOGOUT.setBounds(10, 10, 30, 30);
		contentPane.add(btnNewButton_LOGOUT);
	
		//CONCERTE O CADTUTOR
		
		
		
		linkParaLoginCadastroTutor.addMouseListener(new MouseAdapter() {
			@Override	
			public void mouseClicked(MouseEvent e) {
				dispose();
				
				Cadtutor cadAdmScreen = new Cadtutor(tutor);
				cadAdmScreen.setVisible(true);
			}
		});
		
		
		
		
		
		/*
		linkParaLoginCadastroAdm.addMouseListener(new MouseAdapter() {
			@Override	
			public void mouseClicked(MouseEvent e) {
				dispose();
				
				Cadtutor cadAdmScreen = new Cadtutor();
				cadAdmScreen.setVisible(true);
			}
		});
		*/
		
	}
}
