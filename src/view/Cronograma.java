package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class Cronograma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cronograma frame = new Cronograma();
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
	public Cronograma() {
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
		
		JLabel lblNewLabel = new JLabel("SEGUNDA");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setToolTipText("SEGUNDA");
		panel_1_1.setForeground(Color.WHITE);
		panel_1_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1_1.setBounds(38, 319, 291, 197);
		panel.add(panel_1_1);
		
		JLabel lblTera = new JLabel("TERÇA");
		lblTera.setForeground(Color.WHITE);
		lblTera.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1_1.add(lblTera);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setToolTipText("SEGUNDA");
		panel_1_2.setForeground(Color.WHITE);
		panel_1_2.setBackground(SystemColor.activeCaptionBorder);
		panel_1_2.setBounds(355, 74, 291, 197);
		panel.add(panel_1_2);
		
		JLabel lblQuarta = new JLabel("QUARTA");
		lblQuarta.setForeground(Color.WHITE);
		lblQuarta.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1_2.add(lblQuarta);
		
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
		
		JLabel lblQuinta = new JLabel("QUINTA");
		lblQuinta.setForeground(Color.WHITE);
		lblQuinta.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1_2_1.add(lblQuinta);
		
		JPanel panel_1_2_1_1 = new JPanel();
		panel_1_2_1_1.setToolTipText("SEGUNDA");
		panel_1_2_1_1.setForeground(Color.WHITE);
		panel_1_2_1_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1_2_1_1.setBounds(668, 74, 291, 197);
		panel.add(panel_1_2_1_1);
		
		JLabel lblSexta = new JLabel("SEXTA");
		lblSexta.setForeground(Color.WHITE);
		lblSexta.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1_2_1_1.add(lblSexta);
		
		JPanel panel_1_2_1_1_1 = new JPanel();
		panel_1_2_1_1_1.setToolTipText("SEGUNDA");
		panel_1_2_1_1_1.setForeground(Color.WHITE);
		panel_1_2_1_1_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1_2_1_1_1.setBounds(668, 319, 291, 197);
		panel.add(panel_1_2_1_1_1);
		
		JLabel lblSabado = new JLabel("SABADO");
		lblSabado.setForeground(Color.WHITE);
		lblSabado.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1_2_1_1_1.add(lblSabado);
		
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
		btnNewButton_MENU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Principal principalScreen = new Principal();
				principalScreen.setVisible(true);
			}
		});
	}
}
