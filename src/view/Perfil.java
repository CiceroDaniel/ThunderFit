package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Alunocontroller;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import model.Aluno;

public class Perfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Aluno aluno;//importando aluno e suas informações compartilha a mesma referencia em quase todas as tela
	
	
	/*


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil(aluno);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	
	//METODO ADICIONAR IMAGEM AO BOTÃO
		public void setImageBotao(JButton botao,String caminho,int largura,int altura) {
			ImageIcon icon = new ImageIcon(getClass().getResource(caminho));
			Image img = icon.getImage().getScaledInstance(largura,altura,Image.SCALE_SMOOTH);
			botao.setIcon(new ImageIcon(img));
			botao.setHorizontalTextPosition(SwingConstants.RIGHT);
			botao.setIconTextGap(10);
		}
	
	
	public Perfil(Aluno aluno) {//chamando aluno

		this.aluno=aluno;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080,720);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(41, 41, 41));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1066, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("THUNDERFIT");
		lblNewLabel_2.setBounds(42, 5, 145, 29);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 102, 204));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		JLabel lblNewLabel = new JLabel("______________________________________________________________________________________________________________________________________________");
		lblNewLabel.setForeground(new Color(255, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(0, 22, 1094, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("__________________________________________________________________________________________________________________________________________");
		lblNewLabel_1.setForeground(new Color(255, 153, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(0, 630, 1094, 20);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 645, 1066, 38);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("THUNDERFIT");
		lblNewLabel_2_1.setBounds(463, 6, 140, 30);
		panel_1.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1.setForeground(new Color(255, 102, 204));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(213, 148, 237));
		panel_2.setBounds(29, 67, 1002, 131);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2_2_1_3_1_1 = new JLabel("VAMOS COMEÇAR O NOSSO DIA!!");
		lblNewLabel_2_2_1_3_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2_1_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_1_3_1_1.setBounds(140, 50, 256, 15);
		panel_2.add(lblNewLabel_2_2_1_3_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("___________");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1.setBounds(140, 27, 107, 20);
		panel_2.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_Nome = new JLabel("OI "+aluno.getNome());
		lblNewLabel_Nome.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_Nome.setForeground(Color.WHITE);
		lblNewLabel_Nome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_Nome.setBounds(140, 24, 107, 15);
		panel_2.add(lblNewLabel_Nome);
		
		JLabel lblNewLabel_2_2_1_3_1_1_1 = new JLabel("EMAIL:"+aluno.getEmail());
		lblNewLabel_2_2_1_3_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2_1_3_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_1_3_1_1_1.setBounds(140, 80, 256, 15);
		panel_2.add(lblNewLabel_2_2_1_3_1_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(79, 79, 79));
		panel_2_1.setBounds(29, 240, 320, 300);
		contentPane.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBackground(new Color(0, 0, 0));
		panel_2_1_2.setBounds(0, 0, 321, 42);
		panel_2_1.add(panel_2_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("__________________________________________________________________________________________________________________________________________");
		lblNewLabel_1_1_1.setForeground(new Color(255, 153, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(0, 25, 337, 20);
		panel_2_1_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("INFORMAÇÕES");
		lblNewLabel_2_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_2.setBounds(92, 11, 145, 29);
		panel_2_1_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("DATA DE INICIO");
		lblNewLabel_2_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2_1.setBounds(10, 66, 145, 15);
		panel_2_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("PESO DE NASCIMENTO");
		lblNewLabel_2_2_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2_1_1.setBounds(10, 118, 145, 15);
		panel_2_1.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("FREQUENCIA");
		lblNewLabel_2_2_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2_1_1_1.setBounds(10, 172, 145, 15);
		panel_2_1.add(lblNewLabel_2_2_1_1_1);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("PACOTE");
		lblNewLabel_2_2_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2_1_2.setBounds(165, 67, 145, 15);
		panel_2_1.add(lblNewLabel_2_2_1_2);
		
		JLabel lblNewLabel_2_2_1_3 = new JLabel("VALOR");
		lblNewLabel_2_2_1_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2_1_3.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2_1_3.setBounds(165, 119, 145, 15);
		panel_2_1.add(lblNewLabel_2_2_1_3);
		
		JLabel DATADEINICIO = new JLabel(""+aluno.getDatainicio());	
		DATADEINICIO.setForeground(new Color(255, 255, 255));
		
		DATADEINICIO.setFont(new Font("Tahoma", Font.BOLD, 15));
		DATADEINICIO.setBounds(10, 84, 103, 24);
		panel_2_1.add(DATADEINICIO);
		
		JLabel DATADENASCIMENTO = new JLabel(""+aluno.getDatanascimento());
		DATADENASCIMENTO.setForeground(Color.WHITE);
		DATADENASCIMENTO.setFont(new Font("Tahoma", Font.BOLD, 15));
		DATADENASCIMENTO.setBounds(10, 138, 103, 24);
		panel_2_1.add(DATADENASCIMENTO);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(79, 79, 79));
		panel_2_1_1.setBounds(428, 240, 261, 141);
		contentPane.add(panel_2_1_1);
		panel_2_1_1.setLayout(null);
		
		JPanel panel_2_1_2_1 = new JPanel();
		panel_2_1_2_1.setLayout(null);
		panel_2_1_2_1.setBackground(Color.BLACK);
		panel_2_1_2_1.setBounds(0, 0, 261, 42);
		panel_2_1_1.add(panel_2_1_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("__________________________________________________________________________________________________________________________________________");
		lblNewLabel_1_1.setForeground(new Color(255, 153, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(0, 24, 279, 20);
		panel_2_1_2_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("PERFIL DE SAUDE");
		lblNewLabel_2_2_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_2.setBounds(58, 11, 145, 29);
		panel_2_1_2_1.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("PESO      ALTURA      IMC");
		lblNewLabel_2_2_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_2_1.setBounds(37, 54, 196, 29);
		panel_2_1_1.add(lblNewLabel_2_2_2_1);
		
		JLabel PESO = new JLabel(""+aluno.getPeso());
		PESO.setForeground(Color.WHITE);
		PESO.setFont(new Font("Tahoma", Font.BOLD, 15));
		PESO.setBounds(43, 78, 38, 42);
		panel_2_1_1.add(PESO);
		
		JLabel ALTURA = new JLabel(""+aluno.getAltura());
		ALTURA.setForeground(Color.WHITE);
		ALTURA.setFont(new Font("Tahoma", Font.BOLD, 15));
		ALTURA.setBounds(120, 78, 38, 42);
		panel_2_1_1.add(ALTURA);
		
		JLabel IMC = new JLabel("<dynamic>");
		IMC.setForeground(Color.WHITE);
		IMC.setFont(new Font("Tahoma", Font.BOLD, 15));
		IMC.setBounds(176, 78, 57, 42);
		panel_2_1_1.add(IMC);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setBackground(new Color(79, 79, 79));
		panel_2_1_1_1.setBounds(787, 240, 244, 249);
		contentPane.add(panel_2_1_1_1);
		panel_2_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_2_2_1_3_1 = new JLabel("PRODUTIVIDADE");
		lblNewLabel_2_2_1_3_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_1_3_1.setBounds(71, 11, 119, 15);
		panel_2_1_1_1.add(lblNewLabel_2_2_1_3_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("___________");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(83, 185, 107, 20);
		panel_2_1_1_1.add(lblNewLabel_1_2);
		
		
		JButton btnNewButtonMenu = new JButton("");
		setImageBotao(btnNewButtonMenu,"/img/iconemenu.jpg",30,30);	
		btnNewButtonMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Principal principalScreen = new Principal(aluno);
				principalScreen.setVisible(true);
				
			}
		});
		btnNewButtonMenu.setBounds(1026, 5, 30, 30);
		panel.add(btnNewButtonMenu);
		
		JButton btnNewButton_LOGOUT = new JButton("");
		btnNewButton_LOGOUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_LOGOUT.setBounds(1024, 605, 30, 30);
		contentPane.add(btnNewButton_LOGOUT);
	
	}
}
