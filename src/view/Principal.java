package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.Canvas;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JSplitPane;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import model.Aluno;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Aluno aluno;

	/**
	 * Create the frame.
	 */
	
	//METODO ADICIONAR IMAGEM AO BOTÃO
	public void setImageBotao(JButton botao,String caminho,int largura,int altura) {
		ImageIcon icon = new ImageIcon(getClass().getResource(caminho));
		Image img = icon.getImage().getScaledInstance(largura,altura,Image.SCALE_SMOOTH);
		botao.setIcon(new ImageIcon(img));
		botao.setHorizontalTextPosition(SwingConstants.RIGHT);
		botao.setIconTextGap(10);
	}
	
	
	public Principal(Aluno aluno) {
		setResizable(false);
		setBackground(new Color(224, 188, 233));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1080,720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("TREINADORES DISPONIVEIS");
		lblNewLabel_2.setForeground(new Color(255, 102, 204));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(34, 59, 294, 54);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(85, 85, 85));
		panel.setBounds(29, 113, 1006, 507);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JButton btnMetas = new JButton("METAS");
		btnMetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			dispose();
			
			Meta metaScreen = new Meta(aluno);
			metaScreen.setVisible(true);
			
			}
		});
		btnMetas.setHorizontalAlignment(SwingConstants.LEFT);
		btnMetas.setForeground(Color.WHITE);
		btnMetas.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMetas.setBackground(new Color(213, 148, 237));
		btnMetas.setBounds(382, 51, 310, 109);
		panel.add(btnMetas);
		
		JButton btnNewButton_CRONOGRAMA = new JButton("CRONOGRAMA");
		btnNewButton_CRONOGRAMA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Cronograma cronogramaScreen = new Cronograma(aluno);
				cronogramaScreen.setVisible(true);
				
			}
		});
		btnNewButton_CRONOGRAMA.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_CRONOGRAMA.setForeground(Color.WHITE);
		btnNewButton_CRONOGRAMA.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_CRONOGRAMA.setBackground(new Color(213, 148, 237));
		btnNewButton_CRONOGRAMA.setBounds(382, 191, 310, 109);
		panel.add(btnNewButton_CRONOGRAMA);
		
		JButton btnPacote = new JButton("PACOTE");
		btnPacote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Pacote pacoteScreen = new Pacote(aluno);
				pacoteScreen.setVisible(true);
			}
		});
		btnPacote.setHorizontalAlignment(SwingConstants.LEFT);
		btnPacote.setForeground(Color.WHITE);
		btnPacote.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPacote.setBackground(new Color(213, 148, 237));
		btnPacote.setBounds(382, 331, 134, 109);
		panel.add(btnPacote);
		
		Canvas canvas_1_2 = new Canvas();
		canvas_1_2.setBackground(new Color(40, 40, 40));
		canvas_1_2.setBounds(742, 82, 233, 204);
		panel.add(canvas_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("PROGRESSO");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(812, 51, 96, 25);
		panel.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(40, 40, 40));
		panel_2.setBounds(22, 51, 323, 109);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("NOME:");
		lblNewLabel_6.setBounds(121, 11, 78, 14);
		panel_2.add(lblNewLabel_6);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_6_1 = new JLabel("HORARIO:");
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_1.setBounds(121, 36, 78, 14);
		panel_2.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("DIAS DA SEMANA:");
		lblNewLabel_6_1_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_1_1.setBounds(121, 61, 126, 14);
		panel_2.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_INSTRUTOR = new JLabel("");
		lblNewLabel_INSTRUTOR.setBounds(30, 11, 94, 86);
		panel_2.add(lblNewLabel_INSTRUTOR);
		ImageIcon originalIcon1=new ImageIcon(getClass().getResource("/img/Perfil.jpeg"));
		Image originalImage1 = originalIcon1.getImage();
		Image resizideImage1 = originalImage1.getScaledInstance(60,60,Image.SCALE_SMOOTH);
		ImageIcon resizideIcon1 = new ImageIcon(resizideImage1);
		lblNewLabel_INSTRUTOR.setIcon(resizideIcon1);
	
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(40, 40, 40));
		panel_2_1.setBounds(22, 191, 323, 109);
		panel.add(panel_2_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("NOME:");
		lblNewLabel_6_2.setForeground(Color.WHITE);
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_2.setBounds(121, 11, 78, 14);
		panel_2_1.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("HORARIO:");
		lblNewLabel_6_1_2.setForeground(Color.WHITE);
		lblNewLabel_6_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_1_2.setBounds(121, 36, 78, 14);
		panel_2_1.add(lblNewLabel_6_1_2);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("DIAS DA SEMANA:");
		lblNewLabel_6_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_1_1_1.setBounds(121, 61, 126, 14);
		panel_2_1.add(lblNewLabel_6_1_1_1);
		
		JLabel lblNewLabel_instrutorw2 = new JLabel("");
		lblNewLabel_instrutorw2.setBounds(30, 11, 90, 90);
		panel_2_1.add(lblNewLabel_instrutorw2);
		ImageIcon originalIcon2=new ImageIcon(getClass().getResource("/img/Perfil.jpeg"));
		Image originalImage2 = originalIcon2.getImage();
		Image resizideImage2 = originalImage2.getScaledInstance(60,60,Image.SCALE_SMOOTH);
		ImageIcon resizideIcon2 = new ImageIcon(resizideImage1);
		lblNewLabel_instrutorw2.setIcon(resizideIcon2);
	
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(40, 40, 40));
		panel_2_1_1.setBounds(22, 331, 323, 109);
		panel.add(panel_2_1_1);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("NOME:");
		lblNewLabel_6_2_1.setForeground(Color.WHITE);
		lblNewLabel_6_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_2_1.setBounds(121, 11, 78, 14);
		panel_2_1_1.add(lblNewLabel_6_2_1);
		
		JLabel lblNewLabel_6_1_2_1 = new JLabel("HORARIO:");
		lblNewLabel_6_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_1_2_1.setBounds(121, 36, 78, 14);
		panel_2_1_1.add(lblNewLabel_6_1_2_1);
		
		JLabel lblNewLabel_6_1_1_1_1 = new JLabel("DIAS DA SEMANA:");
		lblNewLabel_6_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_1_1_1_1.setBounds(121, 61, 126, 14);
		panel_2_1_1.add(lblNewLabel_6_1_1_1_1);
		
		JLabel lblNewLabel_INSTRUTOR3 = new JLabel("");
		lblNewLabel_INSTRUTOR3.setBounds(30, 11, 90, 90);
		panel_2_1_1.add(lblNewLabel_INSTRUTOR3);
		ImageIcon originalIcon3=new ImageIcon(getClass().getResource("/img/Perfil.jpeg"));
		Image originalImage3 = originalIcon3.getImage();
		Image resizideImage3 = originalImage3.getScaledInstance(60,60,Image.SCALE_SMOOTH);
		ImageIcon resizideIcon3 = new ImageIcon(resizideImage1);
		lblNewLabel_INSTRUTOR3.setIcon(resizideIcon3);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 1079, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("___________________________________________________________________________________________________");
		lblNewLabel.setBounds(0, 11, 1114, 32);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 102, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel link = new JLabel("THUNDERFIT");
		link.setBounds(48, 0, 140, 38);
		panel_1.add(link);
		link.setForeground(new Color(255, 102, 204));
		link.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(link);
		/*
		link.addMouseListener(new MouseAdapter() {	
			@Override
            public void mouseClicked(MouseEvent e) {
				dispose();
				
				Login loginScreen = new Login(aluno);
				loginScreen.setVisible(true);
		}
		});
		*/
		
		//System.out.println(getClass().getResource("img/perfilicone.jpg"));
		
		JButton btnNewButton_perfil = new JButton("");
		btnNewButton_perfil.setBounds(1030, 4, 30, 30);
		panel_1.add(btnNewButton_perfil);
		
		setImageBotao(btnNewButton_perfil,"/img/perfilicone.jpg",30,30);
		
		btnNewButton_perfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Perfil perfilScreen = new Perfil(aluno);
				perfilScreen.setVisible(true);
				
			}
		});
		
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(0, 645, 1079, 38);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("THUNDERFIT");
		lblNewLabel_1_1.setBounds(485, 2, 137, 30);
		panel_1_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(255, 102, 204));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		//panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnPagamento, canvas, canvas_1, canvas_1_1, btnMetas, btnNewButton_1_1, btnPacote, btnNewButton, lblNewLabel_1_1}));
		
		JLabel lblNewLabel_2_1 = new JLabel("@THUNDERFIT_ACADEMY");
		lblNewLabel_2_1.setBounds(30, 0, 204, 38);
		panel_1_1.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("+55 9881234-5678");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(895, 3, 174, 38);
		panel_1_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("__________________________________________________________________________________________________");
		lblNewLabel_4.setForeground(new Color(255, 102, 204));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(0, 617, 1079, 32);
		contentPane.add(lblNewLabel_4);
		
		
		JButton btnNewButton_notificação = new JButton("");
		//setImageBotao(btnNewButton_notificação,"img/EMAIL.jpeg",30,30);
		btnNewButton_notificação.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_notificação.setBounds(1005, 59, 30, 30);
		contentPane.add(btnNewButton_notificação);
		
		
	}
}
