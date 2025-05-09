package view;

//TELA DE ESCOLHA PARA USUARIO,ADM,INSTRUTOR

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Admcontroller;
import controller.Alunocontroller;
import controller.Tutorcontroller;
import model.Administrador;
import model.Aluno;
import model.Tutor;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;

public class TelaEscolhaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
////ARREDONDAR BORDAS DO BOTÃO

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
	
	private Aluno aluno;
	private Tutor tutor;
	private Administrador adm;
	private final Alunocontroller alunocontroller;
	private final Tutorcontroller tutorcontroller;
	private final Admcontroller admcontroller;
	
	public TelaEscolhaUsuario(Aluno aluno,Tutor tutor,Administrador adm,Alunocontroller alunocontroller,Tutorcontroller tutorcontroller,Admcontroller admcontroller) {
		setResizable(false);
		this.alunocontroller = alunocontroller;
		this.tutorcontroller = tutorcontroller;
		this.admcontroller=admcontroller;
		this.adm=adm;
		this.aluno=aluno;
		this.tutor=tutor;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080,720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RoundedButtonSimples btnNewButton_Cliente = new RoundedButtonSimples("       ALUNO",20);
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
				
				Loginaluno LoginScreen = new Loginaluno(aluno,tutor,alunocontroller, tutorcontroller, admcontroller);
				LoginScreen.setVisible(true);
			}
		});
		

		//BOTÃO DE INSTRUTOR
		RoundedButtonSimples btnNewButton_Adm = new RoundedButtonSimples("       ADM",20);
		btnNewButton_Adm.setForeground(new Color(255, 255, 255));
		btnNewButton_Adm.setBackground(new Color(204, 102, 255));
		btnNewButton_Adm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				CadAluno cadScreen = new CadAluno(aluno, tutor,adm, alunocontroller, tutorcontroller, admcontroller);
				cadScreen.setVisible(true);
				
			}
		});
		btnNewButton_Adm.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_Adm.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Adm.setBounds(113, 303, 418, 132);
		contentPane.add(btnNewButton_Adm);
	
		RoundedButtonSimples btnNewButton_Instrutor = new RoundedButtonSimples("       INSTRUTOR",20);
		btnNewButton_Instrutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Logintutor logintutorscreen = new  Logintutor(aluno,tutor,alunocontroller, tutorcontroller, admcontroller);
				logintutorscreen.setVisible(true);
				
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
		logo.setBounds(614, 162, 385, 343);
		contentPane.add(logo);
		
		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/img/LOGOthunderfit.jpg"));
		Image originalImage = originalIcon.getImage();
		Image resizideImage = originalImage.getScaledInstance(400,400,Image.SCALE_SMOOTH);
		ImageIcon resizideIcon = new ImageIcon(resizideImage);
		logo.setIcon(resizideIcon);
		
		
	}
}
