package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;

import controller.Alunocontroller;
import model.Aluno;
import model.Plano;

import javax.swing.border.BevelBorder;

public class Subtela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPESO;
	private JTextField textField_ALTURA;
	private JTextField textField_DATANASCIMENTO;
	private JTextField textField_DATAINICIO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subtela frame = new Subtela();
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
	//===========================ARREDONDAR BORDAS DOS BOTÕES===============================//
	
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
	
	//===========================ARREDONDAR BORDAS DOS PAINEIS===============================//
	
	public class RoundedPanelSimples extends JPanel{
		private int arc;
		
		public RoundedPanelSimples(int arc) {
			this.arc=arc;
			setOpaque(false);
		}
		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			
			g2.setColor(getBackground());
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			g2.fillRoundRect(0, 0, getWidth(),getHeight(), arc, arc);
			g2.dispose();
			
			super.paintComponent(g);
		}
	}
	
	//===========================ARREDONDAR BORDAS DOS BOTÕES RADIO===============================//
	public class RoundedButtonRadios extends JRadioButton{
		private int arc;
		
		public RoundedButtonRadios(String text,int arc) {
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
	
	
	
	public Subtela() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setForeground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(71, 71, 71));
		panel.setBounds(20, 48, 1019, 583);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInformaesPessoais = new JLabel("INFORMAÇÕES PESSOAIS");
		lblInformaesPessoais.setForeground(new Color(255, 102, 204));
		lblInformaesPessoais.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInformaesPessoais.setBounds(10, 22, 341, 25);
		panel.add(lblInformaesPessoais);
		
		JLabel lblNosDeTodas = new JLabel("Preencha todas as informações");
		lblNosDeTodas.setForeground(Color.WHITE);
		lblNosDeTodas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNosDeTodas.setBounds(10, 57, 341, 25);
		panel.add(lblNosDeTodas);
		
		JLabel lblParaQuePossamos = new JLabel("vamos criar seu cronograma");
		lblParaQuePossamos.setForeground(Color.WHITE);
		lblParaQuePossamos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblParaQuePossamos.setBounds(10, 74, 341, 25);
		panel.add(lblParaQuePossamos);
		
		
		//==============================================//
		//====================PAINEIS===================//
		//==============================================//
		
		RoundedPanelSimples painel_roxo = new RoundedPanelSimples(30);
		painel_roxo.setBackground(new Color(213, 162, 211));
		painel_roxo.setBounds(25, 109, 508, 344);
		panel.add(painel_roxo);
		painel_roxo.setLayout(null);
		//painel branco ganhar massa
		RoundedPanelSimples panel_1 = new RoundedPanelSimples(30);
		panel_1.setBounds(20, 87, 139, 210);
		painel_roxo.add(panel_1);
		panel_1.setLayout(null);
		
		RoundedPanelSimples panel_2 = new RoundedPanelSimples(30);
		panel_2.setBackground(new Color(255, 102, 153));
		panel_2.setBounds(6, 10, 127, 29);
		panel_1.add(panel_2);
		
		RoundedPanelSimples panel_1_1 = new RoundedPanelSimples(30);
		panel_1_1.setBounds(182, 87, 139, 210);
		painel_roxo.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		RoundedPanelSimples panel_1_2_1 = new RoundedPanelSimples(30);
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setToolTipText("");
		panel_1_2_1.setBackground(new Color(255, 102, 153));
		panel_1_2_1.setBounds(-156, 10, 127, 32);
		panel_1_1.add(panel_1_2_1);
		
		RoundedPanelSimples panel_1_1_1 = new RoundedPanelSimples(30);
		panel_1_1_1.setBounds(346, 87, 139, 210);
		painel_roxo.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		RoundedPanelSimples panel_2_1_1 = new RoundedPanelSimples(30);
		panel_2_1_1.setBackground(new Color(255, 102, 153));
		panel_2_1_1.setBounds(6, 10, 127, 29);
		panel_1_1_1.add(panel_2_1_1);
		
		RoundedPanelSimples panel_2_1 = new RoundedPanelSimples(30);
		panel_2_1.setBackground(new Color(255, 102, 153));
		panel_2_1.setBounds(6, 10, 127, 29);
		panel_1_1.add(panel_2_1);
		
		RoundedPanelSimples panel_3 = new RoundedPanelSimples(30);
		panel_3.setBackground(new Color(213, 162, 211));
		panel_3.setBounds(551, 109, 146, 140);
		panel.add(panel_3);
		panel_3.setLayout(null);

		RoundedPanelSimples panel_1_2 = new RoundedPanelSimples(30);
		panel_1_2.setToolTipText("");
		panel_1_2.setBackground(new Color(255, 102, 153));
		panel_1_2.setBounds(20, 24, 465, 40);
		painel_roxo.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		RoundedPanelSimples panel_3_1 = new RoundedPanelSimples(30);
		panel_3_1.setBackground(new Color(213, 162, 211));
		panel_3_1.setBounds(707, 109, 146, 140);
		panel.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		RoundedPanelSimples panel_3_1_1 = new RoundedPanelSimples(30);
		panel_3_1_1.setBackground(new Color(213, 162, 211));
		panel_3_1_1.setBounds(863, 109, 146, 140);
		panel.add(panel_3_1_1);
		panel_3_1_1.setLayout(null);
		
		RoundedPanelSimples panel_3_2 = new RoundedPanelSimples(30);
		panel_3_2.setBackground(new Color(213, 162, 211));
		panel_3_2.setBounds(551, 259, 218, 194);
		panel.add(panel_3_2);
		panel_3_2.setLayout(null);
		
		RoundedPanelSimples panel_4 = new RoundedPanelSimples(30);
		panel_4.setBackground(new Color(255, 102, 153));
		panel_4.setBounds(10, 10, 198, 32);
		panel_3_2.add(panel_4);
		
		RoundedPanelSimples panel_3_2_1 = new RoundedPanelSimples(30);
		panel_3_2_1.setBackground(new Color(213, 162, 211));
		panel_3_2_1.setBounds(791, 259, 218, 194);
		panel.add(panel_3_2_1);
		panel_3_2_1.setLayout(null);
		
		RoundedPanelSimples panel_5 = new RoundedPanelSimples(30);
		panel_5.setBackground(new Color(255, 102, 153));
		panel_5.setBounds(10, 10, 198, 32);
		panel_3_2_1.add(panel_5);
		
		
		JLabel lblMeta = new JLabel("GANHAR PESO");
		panel_2.add(lblMeta);
		lblMeta.setForeground(Color.WHITE);
		lblMeta.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblGenero_1 = new JLabel("META");
		lblGenero_1.setForeground(Color.WHITE);
		lblGenero_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGenero_1.setBounds(200, 10, 63, 25);
		panel_1_2_1.add(lblGenero_1);
		
		JLabel lblDataDeInicio = new JLabel("PERDER PESO");
		panel_2_1.add(lblDataDeInicio);
		lblDataDeInicio.setForeground(Color.WHITE);
		lblDataDeInicio.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblDataDeNascimento = new JLabel("OUTRO");
		panel_2_1_1.add(lblDataDeNascimento);
		lblDataDeNascimento.setForeground(Color.WHITE);
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblGenero = new JLabel("META");
		lblGenero.setBounds(200, 10, 63, 25);
		panel_1_2.add(lblGenero);
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		JLabel lblGenero_2 = new JLabel("GENERO");
		lblGenero_2.setForeground(Color.WHITE);
		lblGenero_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGenero_2.setBounds(10, 10, 92, 25);
		panel_3.add(lblGenero_2);
		
		JLabel lblPeso = new JLabel("PESO");
		lblPeso.setBounds(10, 10, 92, 25);
		panel_3_1.add(lblPeso);
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblAltura = new JLabel("ALTURA");
		lblAltura.setBounds(10, 10, 92, 25);
		panel_3_1_1.add(lblAltura);
		lblAltura.setForeground(Color.WHITE);
		lblAltura.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("DATA");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4.add(lblNewLabel_1);
		
		JLabel datadenascimento = new JLabel("DATA DE NASCIMENTO");
		datadenascimento.setForeground(Color.WHITE);
		datadenascimento.setFont(new Font("Tahoma", Font.BOLD, 15));
		datadenascimento.setBounds(10, 51, 198, 25);
		panel_3_2.add(datadenascimento);
		
		JLabel datadeinicio = new JLabel("DATA DE INICIO");
		datadeinicio.setForeground(Color.WHITE);
		datadeinicio.setFont(new Font("Tahoma", Font.BOLD, 15));
		datadeinicio.setBounds(10, 115, 198, 25);
		panel_3_2.add(datadeinicio);
		
		JLabel lblNewLabel_1_1 = new JLabel("PLANO");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_5.add(lblNewLabel_1_1);
		
		
		//==============================================//
		//==============================================//
		//==============================================//
		
		//==============================================//
		//=================BOTÃOESCOLHA=================//
		//==============================================//
		
		//==================OP_GANHARPESO====================//
		RoundedButtonRadios OganharPeso = new RoundedButtonRadios("",30);
		
		OganharPeso.setBounds(6, 183, 127, 21);
		OganharPeso.setBackground(new Color(92, 92, 92));
		panel_1.add(OganharPeso);
		OganharPeso.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		//==================OP_PERDERPESO====================//
		RoundedButtonRadios OPperderpeso = new RoundedButtonRadios("",30);
		OPperderpeso.setBounds(6, 183, 127, 21);
		OPperderpeso.setFont(new Font("Tahoma", Font.BOLD, 12));
		OPperderpeso.setBackground(new Color(92, 92, 92));
		panel_1_1.add(OPperderpeso);
		
		//==================OP_OUTRO====================//
		RoundedButtonRadios Opsaudavel = new RoundedButtonRadios("",30);
		Opsaudavel.setBounds(6, 183, 127, 21);
		Opsaudavel.setFont(new Font("Tahoma", Font.BOLD, 12));
		Opsaudavel.setBackground(new Color(92, 92, 92));
		panel_1_1_1.add(Opsaudavel);
		
		//Todos os jbuttons estão em um só grupo,assim não é possivel o usuario selecionar mais de um
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(OganharPeso);
		grupo.add(OPperderpeso);
		grupo.add(Opsaudavel);
		
		
		//==============================================//
		//=====================PLANO====================//
		//==============================================//
		
		//==================OP_MENSAL====================//
		RoundedButtonRadios opmensal = new RoundedButtonRadios("MENSAL",30);
		opmensal.setForeground(Color.WHITE);
		opmensal.setFont(new Font("Tahoma", Font.BOLD, 12));
		opmensal.setBackground(new Color(92, 92, 92));
		opmensal.setBounds(10, 56, 198, 34);
		panel_3_2_1.add(opmensal);
		
		//==================OP_BIMESTRAL====================//
		RoundedButtonRadios opbimestral = new RoundedButtonRadios("BIMESTRAL",30);
		opbimestral.setForeground(Color.WHITE);
		opbimestral.setFont(new Font("Tahoma", Font.BOLD, 12));
		opbimestral.setBackground(new Color(92, 92, 92));
		opbimestral.setBounds(10, 102, 198, 34);
		panel_3_2_1.add(opbimestral);
		
		//==================OP_BIMESTRAL====================//
		RoundedButtonRadios optrimestral = new RoundedButtonRadios("TRIMESTRAL",30);
		optrimestral.setForeground(Color.WHITE);
		optrimestral.setFont(new Font("Tahoma", Font.BOLD, 12));
		optrimestral.setBackground(new Color(92, 92, 92));
		optrimestral.setBounds(10, 149, 198, 34);
		panel_3_2_1.add(optrimestral);
		
		ButtonGroup grupoPlano = new ButtonGroup();
		
		grupoPlano.add(opmensal);
		grupoPlano.add(opbimestral);
		grupoPlano.add(optrimestral);
		

		//==============================================//
		//====================GENERO====================//
		//==============================================//
		
		//==================OP_MULHER====================//
		RoundedButtonRadios OPMULHER = new RoundedButtonRadios("MULHER",30);
		
		OPMULHER.setFont(new Font("Tahoma", Font.BOLD, 13));
		OPMULHER.setForeground(new Color(255, 255, 255));
		OPMULHER.setBackground(new Color(88, 88, 88));
		OPMULHER.setBounds(6, 48, 134, 31);
		panel_3.add(OPMULHER);
		
		//==================OP_HOMEM====================//
		RoundedButtonRadios OPHOMEM = new RoundedButtonRadios("HOMEM",30);
		OPHOMEM.setForeground(new Color(255, 255, 255));
		OPHOMEM.setFont(new Font("Tahoma", Font.BOLD, 13));
		OPHOMEM.setBackground(new Color(88, 88, 88));
		OPHOMEM.setBounds(6, 91, 134, 31);
		panel_3.add(OPHOMEM);
		
		ButtonGroup grupoGenero = new ButtonGroup();
		
		grupoGenero.add(OPMULHER);
		grupoGenero.add(OPHOMEM);
		
		
		//==============================================//
		//=================VOLTAR/SAIR==================//
		//==============================================//
		
		
		RoundedButtonSimples btnNewButton = new RoundedButtonSimples("CONTINUAR",20);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!OganharPeso.isSelected() && !OPperderpeso.isSelected() && !Opsaudavel.isSelected() ) {
					JOptionPane.showMessageDialog(null,"Selecione todas as opções e preencha todos os campos");
					return;
				}else if(!OPMULHER.isSelected()&&!OPHOMEM.isSelected()){
					return;
				}else if(!opmensal.isSelected() && !opbimestral.isSelected() && !optrimestral.isSelected()) {
					return;		
				}
				if(textFieldPESO.getText().trim().isEmpty()||
				   textField_ALTURA.getText().trim().isEmpty()||
				   textField_DATANASCIMENTO.getText().trim().isEmpty()||
				   textField_DATAINICIO.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Preencha todos os campos");
				return;
				}
				
				//VALIDAR PESO E ALTURA
				
				double peso = 0;
				double altura = 0;
				
				try {
					peso = Double.parseDouble(textFieldPESO.getText());
					altura = Double.parseDouble(textField_ALTURA.getText());
					
				}catch(NumberFormatException ex){
					
					JOptionPane.showMessageDialog(null,"Peso e altura devem ser numeros");
				return;
				}
				
				String datanascimento = textField_DATANASCIMENTO.getText();
				String datainicio = textField_DATAINICIO.getText();
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				sdf.setLenient(false);
				/*
				try {
					Date dataNasc = sdf.parse(datanascimento);
					Date dataIni = sdf.parse(datainicio);
					
				}catch(ParseException ex) {
					return;
				}*/
				
				Aluno aluno = new Aluno(null,null,null,null,altura,peso,datanascimento,datainicio);
				Alunocontroller.adicionarAluno(aluno);
					
					dispose();
					
					Login loginScreen = new Login();
					loginScreen.setVisible(true);
				
			
		}
	});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 102, 153));
		btnNewButton.setBounds(499, 527, 129, 25);
		panel.add(btnNewButton);
		
		RoundedButtonSimples btnNewButton_1 = new RoundedButtonSimples("VOLTAR",20);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Cad cadScreen =  new Cad();
				cadScreen.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(255, 102, 153));
		btnNewButton_1.setBounds(360, 527, 129, 25);
		panel.add(btnNewButton_1);

		//==============================================//
		//==============CAIXAS DE TEXTO=================//
		//==============================================//
	
		textFieldPESO = new JTextField();
		textFieldPESO.setBounds(26, 64, 96, 47);
		panel_3_1.add(textFieldPESO);
		textFieldPESO.setColumns(10);
		
		textField_ALTURA = new JTextField();
		textField_ALTURA.setBounds(25, 65, 96, 45);
		panel_3_1_1.add(textField_ALTURA);
		textField_ALTURA.setColumns(10);

		textField_DATANASCIMENTO = new JTextField();
		textField_DATANASCIMENTO.setBounds(10, 74, 198, 32);
		panel_3_2.add(textField_DATANASCIMENTO);
		textField_DATANASCIMENTO.setColumns(10);
		
		textField_DATAINICIO = new JTextField();
		textField_DATAINICIO.setColumns(10);
		textField_DATAINICIO.setBounds(10, 136, 198, 32);
		panel_3_2.add(textField_DATAINICIO);
		
		//==============================================//
		//==============================================//
		//==============================================//
		
		
		//FAZER CACULO DE IMC
		//VERIFICAR GENERO
				
	}
}

