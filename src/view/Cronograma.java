package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Aluno;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class Cronograma extends JFrame {
	
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
					Cronograma frame = new Cronograma(aluno);
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
	
	public Cronograma(Aluno aluno) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1080,720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 95, 95));
		panel.setBounds(32, 58, 998, 548);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setToolTipText("SEGUNDA");
		
		
		
		panel_1.setBounds(38, 74, 291, 197);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEGUNDA");
		lblNewLabel.setBounds(96, 5, 98, 25);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel);
		
		JLabel lblTreinoDo = new JLabel("TREINO:");
		lblTreinoDo.setForeground(Color.WHITE);
		lblTreinoDo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTreinoDo.setBounds(10, 28, 271, 25);
		panel_1.add(lblTreinoDo);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setToolTipText("SEGUNDA");
		panel_1_1.setForeground(Color.WHITE);
		panel_1_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1_1.setBounds(38, 319, 291, 197);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblTera = new JLabel("TERÇA");
		lblTera.setBounds(112, 5, 66, 25);
		lblTera.setForeground(Color.WHITE);
		lblTera.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1_1.add(lblTera);
		
		JLabel lblTreinoPerna = new JLabel("TREINO:");
		lblTreinoPerna.setForeground(Color.WHITE);
		lblTreinoPerna.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTreinoPerna.setBounds(10, 27, 271, 25);
		panel_1_1.add(lblTreinoPerna);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setToolTipText("SEGUNDA");
		panel_1_2.setForeground(Color.WHITE);
		panel_1_2.setBackground(SystemColor.activeCaptionBorder);
		panel_1_2.setBounds(355, 74, 291, 197);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblQuarta = new JLabel("QUARTA");
		lblQuarta.setBounds(104, 5, 83, 25);
		lblQuarta.setForeground(Color.WHITE);
		lblQuarta.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1_2.add(lblQuarta);
		
		JLabel lblTreinoDeAbdomen = new JLabel("TREINO:");
		lblTreinoDeAbdomen.setForeground(Color.WHITE);
		lblTreinoDeAbdomen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTreinoDeAbdomen.setBounds(10, 30, 271, 25);
		panel_1_2.add(lblTreinoDeAbdomen);
		
		JLabel lblCronograma = new JLabel("CRONOGRAMA");
		lblCronograma.setForeground(Color.WHITE);
		lblCronograma.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCronograma.setBounds(25, 26, 166, 25);
		panel.add(lblCronograma);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setToolTipText("SEGUNDA");
		panel_1_2_1.setForeground(Color.WHITE);
		panel_1_2_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1_2_1.setBounds(355, 319, 291, 197);
		panel.add(panel_1_2_1);
		panel_1_2_1.setLayout(null);
		
		JLabel lblQuinta = new JLabel("QUINTA");
		lblQuinta.setBounds(105, 5, 80, 25);
		lblQuinta.setForeground(Color.WHITE);
		lblQuinta.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1_2_1.add(lblQuinta);
		
		JLabel lblTreinoDeAbdomen_1 = new JLabel("TREINO:");
		lblTreinoDeAbdomen_1.setForeground(Color.WHITE);
		lblTreinoDeAbdomen_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTreinoDeAbdomen_1.setBounds(10, 27, 271, 25);
		panel_1_2_1.add(lblTreinoDeAbdomen_1);
		
		JPanel panel_1_2_1_1 = new JPanel();
		panel_1_2_1_1.setToolTipText("SEGUNDA");
		panel_1_2_1_1.setForeground(Color.WHITE);
		panel_1_2_1_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1_2_1_1.setBounds(668, 74, 291, 197);
		panel.add(panel_1_2_1_1);
		panel_1_2_1_1.setLayout(null);
		
		JLabel lblSexta = new JLabel("SEXTA");
		lblSexta.setBounds(113, 5, 64, 25);
		lblSexta.setForeground(Color.WHITE);
		lblSexta.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1_2_1_1.add(lblSexta);
		
		JLabel lblTreinoDeAbdomen_2 = new JLabel("TREINO:");
		lblTreinoDeAbdomen_2.setForeground(Color.WHITE);
		lblTreinoDeAbdomen_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTreinoDeAbdomen_2.setBounds(10, 28, 271, 25);
		panel_1_2_1_1.add(lblTreinoDeAbdomen_2);
		
		JPanel panel_1_2_1_1_1 = new JPanel();
		panel_1_2_1_1_1.setToolTipText("SEGUNDA");
		panel_1_2_1_1_1.setForeground(Color.WHITE);
		panel_1_2_1_1_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1_2_1_1_1.setBounds(668, 319, 291, 197);
		panel.add(panel_1_2_1_1_1);
		panel_1_2_1_1_1.setLayout(null);
		
		JLabel lblSabado = new JLabel("SABADO");
		lblSabado.setBounds(103, 5, 84, 25);
		lblSabado.setForeground(Color.WHITE);
		lblSabado.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1_2_1_1_1.add(lblSabado);
		
		JLabel lblTreinoDeAbdomen_2_1 = new JLabel("TREINO:");
		lblTreinoDeAbdomen_2_1.setForeground(Color.WHITE);
		lblTreinoDeAbdomen_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTreinoDeAbdomen_2_1.setBounds(10, 27, 271, 25);
		panel_1_2_1_1_1.add(lblTreinoDeAbdomen_2_1);
		
		Panel panel_1_3 = new Panel();
		panel_1_3.setLayout(null);
		panel_1_3.setBackground(Color.BLACK);
		panel_1_3.setBounds(0, 2, 1066, 38);
		contentPane.add(panel_1_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("THUNDERFIT");
		lblNewLabel_1_1.setForeground(new Color(255, 102, 204));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(48, 0, 140, 38);
		panel_1_3.add(lblNewLabel_1_1);
		
		JButton btnNewButton_MENU = new JButton("");
		btnNewButton_MENU.setBounds(1026, 0, 30, 30);
		panel_1_3.add(btnNewButton_MENU);
		
		JLabel lblNewLabel_1 = new JLabel("________________________________________________________________________________________________");
		lblNewLabel_1.setForeground(new Color(255, 102, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(1, 2, 1064, 46);
		panel_1_3.add(lblNewLabel_1);
		
		Panel panel_1_1_1 = new Panel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(Color.BLACK);
		panel_1_1_1.setBounds(0, 645, 1066, 38);
		contentPane.add(panel_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("THUNDERFIT");
		lblNewLabel_1_1_1.setForeground(new Color(255, 102, 204));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(475, 2, 137, 30);
		panel_1_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("@THUNDERFIT_ACADEMY");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(30, 0, 204, 38);
		panel_1_1_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("+55 9881234-5678");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(892, 0, 174, 38);
		panel_1_1_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("________________________________________________________________________________________________");
		lblNewLabel_4.setForeground(new Color(255, 102, 204));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(0, 617, 1076, 32);
		contentPane.add(lblNewLabel_4);
		
		setImageBotao(btnNewButton_MENU,"/img/iconemenu.jpg",30,30);
		btnNewButton_MENU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Principal principalScreen = new Principal(aluno, null);
				principalScreen.setVisible(true);
			}
		});
	}
}
