package view;

//NÃO ESTÁ FUNCIONANDO CORRETAMENTE


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
import model.Aluno.Genero;
import model.Metas;
import model.Nivel;
import model.Plano;
import view.Cad;

import javax.swing.border.BevelBorder;

public class Formulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPESO;
	private JTextField textField_ALTURA;
	private JTextField textField_DATANASCIMENTO;
	private JTextField textField_DATAINICIO;
	Genero generoSelecionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario(aluno);
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
	///MODIFIQUEI PARA STATIC
	private static Aluno aluno;
	
	public Formulario(Aluno aluno) {
		
		this.aluno = aluno;
		
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
		RoundedButtonRadios ganharMassa = new RoundedButtonRadios("",30);
		
		ganharMassa.setBounds(6, 183, 127, 21);
		ganharMassa.setBackground(new Color(92, 92, 92));
		panel_1.add(ganharMassa);
		ganharMassa.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		//==================OP_PERDERPESO====================//
		RoundedButtonRadios perderPeso = new RoundedButtonRadios("",30);
		perderPeso.setBounds(6, 183, 127, 21);
		perderPeso.setFont(new Font("Tahoma", Font.BOLD, 12));
		perderPeso.setBackground(new Color(92, 92, 92));
		panel_1_1.add(perderPeso);
		
		//==================OP_OUTRO====================//
		RoundedButtonRadios personalizada = new RoundedButtonRadios("",30);
		personalizada.setBounds(6, 183, 127, 21);
		personalizada.setFont(new Font("Tahoma", Font.BOLD, 12));
		personalizada.setBackground(new Color(92, 92, 92));
		panel_1_1_1.add(personalizada);
		
		//Todos os jbuttons estão em um só grupo,assim não é possivel o usuario selecionar mais de um
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(ganharMassa);
		grupo.add(perderPeso);
		grupo.add(personalizada);
		
		
		//==============================================//
		//=====================PLANO====================//
		//==============================================//
		
		//==================OP_MENSAL====================//
		RoundedButtonRadios planoMensal = new RoundedButtonRadios("MENSAL",30);
		planoMensal.setForeground(Color.WHITE);
		planoMensal.setFont(new Font("Tahoma", Font.BOLD, 12));
		planoMensal.setBackground(new Color(92, 92, 92));
		planoMensal.setBounds(10, 56, 198, 34);
		panel_3_2_1.add(planoMensal);
		
		//==================OP_BIMESTRAL====================//
		RoundedButtonRadios planoTrimenstral = new RoundedButtonRadios("TRIMENSTRAL",30);
		planoTrimenstral.setForeground(Color.WHITE);
		planoTrimenstral.setFont(new Font("Tahoma", Font.BOLD, 12));
		planoTrimenstral.setBackground(new Color(92, 92, 92));
		planoTrimenstral.setBounds(10, 102, 198, 34);
		panel_3_2_1.add(planoTrimenstral);
		
		//==================OP_BIMESTRAL====================//
		RoundedButtonRadios planoAnual = new RoundedButtonRadios("ANUAL",30);
		planoAnual.setForeground(Color.WHITE);
		planoAnual.setFont(new Font("Tahoma", Font.BOLD, 12));
		planoAnual.setBackground(new Color(92, 92, 92));
		planoAnual.setBounds(10, 149, 198, 34);
		panel_3_2_1.add(planoAnual);
		
		ButtonGroup grupoPlano = new ButtonGroup();
		
		grupoPlano.add(planoMensal);
		grupoPlano.add(planoTrimenstral);
		grupoPlano.add(planoAnual);
		

		//==============================================//
		//====================GENERO====================//
		//==============================================//
		
		//==================OP_MULHER====================//
		RoundedButtonRadios mulher = new RoundedButtonRadios("MULHER",30);
		
		mulher.setFont(new Font("Tahoma", Font.BOLD, 13));
		mulher.setForeground(new Color(255, 255, 255));
		mulher.setBackground(new Color(88, 88, 88));
		mulher.setBounds(6, 48, 134, 31);
		panel_3.add(mulher);
		
		//==================OP_HOMEM====================//
		RoundedButtonRadios homem = new RoundedButtonRadios("HOMEM",30);
		homem.setForeground(new Color(255, 255, 255));
		homem.setFont(new Font("Tahoma", Font.BOLD, 13));
		homem.setBackground(new Color(88, 88, 88));
		homem.setBounds(6, 91, 134, 31);
		panel_3.add(homem);
		
		ButtonGroup grupoGenero = new ButtonGroup();
		
		grupoGenero.add(homem);
		grupoGenero.add(mulher);
		
		
		//==============================================//
		//=================VOLTAR/SAIR==================//
		//==============================================//
		
		
		
		RoundedButtonSimples btnNewButton = new RoundedButtonSimples("CONTINUAR",20);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!ganharMassa.isSelected() && !perderPeso.isSelected() && !personalizada.isSelected() ) {
					JOptionPane.showMessageDialog(null,"Selecione uma das opções de metas");
					
					return;
				}else if(!homem.isSelected()&&!mulher.isSelected()){
					JOptionPane.showMessageDialog(null,"Selecione um dos generos");
					if(homem.isSelected()) {
						//CONECTADO AO ENUM
						generoSelecionado = Genero.MASCULINO;
					}else if(mulher.isSelected()) {
						generoSelecionado = Genero.FEMININO;
						
					}else {
						generoSelecionado = Genero.OUTRO;
					}
					return;
				}else if(!planoMensal.isSelected() && !planoTrimenstral.isSelected() && !planoAnual.isSelected()) {
					JOptionPane.showMessageDialog(null,"Selecione um plano");
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
				
				
				Aluno aluno = new Aluno(null,null,null,null, altura,peso,null, null, datanascimento,null, datainicio,datainicio, generoSelecionado);
				Alunocontroller.adicionarAluno(aluno);
					
				textField_ALTURA.setText("");
				textFieldPESO.setText("");
				textField_DATANASCIMENTO.setText("");
				textField_DATAINICIO.setText("");
				
					dispose();
					
					TelaEscolhaUsuario escolhaScreen = new TelaEscolhaUsuario();
					escolhaScreen.setVisible(true);
				
			
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

