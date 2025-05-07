package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Aluno;
import model.Plano;

import java.awt.Color;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pacote extends JFrame {
	
	//METODO ADICIONAR IMAGEM AO BOTÃO
			public void setImageBotao(JButton botao,String caminho,int largura,int altura) {
				ImageIcon icon = new ImageIcon(getClass().getResource(caminho));
				Image img = icon.getImage().getScaledInstance(largura,altura,Image.SCALE_SMOOTH);
				botao.setIcon(new ImageIcon(img));
				botao.setHorizontalTextPosition(SwingConstants.RIGHT);
				botao.setIconTextGap(10);
			}


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
		panel.setBounds(45, 138, 319, 315);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 102, 153));
		panel_3.setBounds(10, 11, 297, 40);
		panel.add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(71, 71, 71));
		panel_2.setBounds(374, 138, 319, 315);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(255, 102, 153));
		panel_3_1.setBounds(10, 11, 297, 40);
		panel_2.add(panel_3_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(71, 71, 71));
		panel_2_1.setBounds(703, 138, 319, 315);
		contentPane.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBackground(new Color(255, 102, 153));
		panel_3_1_1.setBounds(10, 11, 297, 40);
		panel_2_1.add(panel_3_1_1);
		
		
		
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("MENSAL");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(111, 15, 116, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("TRIMESTRAL");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(92, 15, 150, 14);
		panel_3_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("ANUAL");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_2_1.setBounds(121, 16, 150, 14);
		panel_3_1_1.add(lblNewLabel_2_2_1);
	
	
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("INFORMAÇÕES DOS PACOTES");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(56, 74, 308, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("PACOTE:ANUAL");
		lblNewLabel_5_2_1.setForeground(Color.WHITE);
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2_1.setBounds(20, 75, 287, 27);
		panel_2_1.add(lblNewLabel_5_2_1);
		
		JLabel lblNewLabel_5 = new JLabel("PACOTE:MENSAL");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(20, 75, 287, 27);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_2 = new JLabel("PACOTE:TRIMESTRAL");
		lblNewLabel_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2.setBounds(22, 73, 287, 27);
		panel_2.add(lblNewLabel_5_2);
		
		
		
		
		
		
		
		JLabel VALOERMENSAL = new JLabel("VALOR:"+Plano.planoMensal.getValor());
		VALOERMENSAL.setForeground(Color.WHITE);
		VALOERMENSAL.setFont(new Font("Tahoma", Font.BOLD, 15));
		VALOERMENSAL.setBounds(20, 114, 287, 27);
		panel.add(VALOERMENSAL);
		
		JLabel VALORTRIMESTRAL = new JLabel("VALOR:"+Plano.planoTrimestral.getValor());
		VALORTRIMESTRAL.setForeground(Color.WHITE);
		VALORTRIMESTRAL.setFont(new Font("Tahoma", Font.BOLD, 15));
		VALORTRIMESTRAL.setBounds(20, 110, 287, 27);
		panel_2.add(VALORTRIMESTRAL);
		
		JLabel VALORANUAL = new JLabel("VALOR:"+Plano.planoAnual.getValor());
		VALORANUAL.setForeground(Color.WHITE);
		VALORANUAL.setFont(new Font("Tahoma", Font.BOLD, 15));
		VALORANUAL.setBounds(20, 112, 287, 27);
		panel_2_1.add(VALORANUAL);
	
		
		
		
		
		
		
		JButton btnNewButton_perfil = new JButton("");
		btnNewButton_perfil.setIconTextGap(10);
		btnNewButton_perfil.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton_perfil.setBounds(1030, 4, 30, 30);
		panel_1.add(btnNewButton_perfil);
		setImageBotao(btnNewButton_perfil,"/img/iconemenu.jpg",30,30);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(71, 71, 71));
		panel_4.setBounds(45, 502, 648, 88);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel NOME = new JLabel("NOME:"+aluno.getNome());
		NOME.setForeground(Color.WHITE);
		NOME.setFont(new Font("Tahoma", Font.BOLD, 15));
		NOME.setBounds(10, 10, 287, 27);
		panel_4.add(NOME);
		
		JLabel EMAIL = new JLabel("EMAIL:"+aluno.getEmail());
		EMAIL.setForeground(Color.WHITE);
		EMAIL.setFont(new Font("Tahoma", Font.BOLD, 15));
		EMAIL.setBounds(10, 47, 287, 27);
		panel_4.add(EMAIL);
		
		JLabel PACOTE = new JLabel("PACOTE:"+aluno.getPlano());
		PACOTE.setForeground(Color.WHITE);
		PACOTE.setFont(new Font("Tahoma", Font.BOLD, 15));
		PACOTE.setBounds(327, 10, 287, 27);
		panel_4.add(PACOTE);
		btnNewButton_perfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Principal principalScreen = new Principal(aluno, null);
				principalScreen.setVisible(true);

				btnNewButton_perfil.setBounds(1030, 4, 30, 30);
				panel_1.add(btnNewButton_perfil);
				
			}
		});
	}
}
