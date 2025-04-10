package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Subtela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
	public Subtela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setForeground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VAMOS TE CONHECER MELHOR!!!");
		lblNewLabel.setBounds(24, 20, 341, 25);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(71, 71, 71));
		panel.setBounds(24, 70, 1007, 576);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblGenero = new JLabel("GENERO");
		lblGenero.setBounds(60, 114, 84, 25);
		panel.add(lblGenero);
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JRadioButton OPgeneroHomem = new JRadioButton("Homem");
		OPgeneroHomem.setFont(new Font("Tahoma", Font.BOLD, 12));
		OPgeneroHomem.setBounds(60, 185, 103, 21);
		panel.add(OPgeneroHomem);
		
		JRadioButton OPgeneroMulher = new JRadioButton("Mulher");
		OPgeneroMulher.setFont(new Font("Tahoma", Font.BOLD, 12));
		OPgeneroMulher.setBounds(60, 145, 103, 21);
		panel.add(OPgeneroMulher);
		
		JLabel lblDataDeNascimento = new JLabel("DATA DE NASCIMENTO");
		lblDataDeNascimento.setBounds(324, 114, 243, 25);
		panel.add(lblDataDeNascimento);
		lblDataDeNascimento.setForeground(Color.WHITE);
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblAltura = new JLabel("ALTURA");
		lblAltura.setForeground(Color.WHITE);
		lblAltura.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAltura.setBounds(60, 310, 92, 25);
		panel.add(lblAltura);
		
		JLabel lblPeso = new JLabel("PESO");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPeso.setBounds(60, 229, 92, 25);
		panel.add(lblPeso);
		
		JLabel lblDataDeInicio = new JLabel("DATA DE INICIO");
		lblDataDeInicio.setForeground(Color.WHITE);
		lblDataDeInicio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDataDeInicio.setBounds(324, 229, 243, 25);
		panel.add(lblDataDeInicio);
		
		JLabel lblMeta = new JLabel("META");
		lblMeta.setForeground(Color.WHITE);
		lblMeta.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMeta.setBounds(719, 114, 76, 25);
		panel.add(lblMeta);
		
		JLabel lblInformaesPessoais = new JLabel("INFORMAÇÕES PESSOAIS");
		lblInformaesPessoais.setForeground(new Color(255, 102, 204));
		lblInformaesPessoais.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInformaesPessoais.setBounds(10, 10, 341, 25);
		panel.add(lblInformaesPessoais);
		
		JLabel lblNosDeTodas = new JLabel("Preencha todas as informaçõe");
		lblNosDeTodas.setForeground(Color.WHITE);
		lblNosDeTodas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNosDeTodas.setBounds(10, 45, 341, 25);
		panel.add(lblNosDeTodas);
		
		JLabel lblParaQuePossamos = new JLabel("vamos criar seu cronogramama");
		lblParaQuePossamos.setForeground(Color.WHITE);
		lblParaQuePossamos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblParaQuePossamos.setBounds(10, 66, 341, 25);
		panel.add(lblParaQuePossamos);
		
		textField = new JTextField();
		textField.setBounds(60, 264, 96, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(60, 347, 96, 33);
		panel.add(textField_1);
	}
}
