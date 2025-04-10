package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.Canvas;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JSplitPane;
import java.awt.Panel;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setBackground(new Color(224, 188, 233));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979,631);
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
		panel.setBounds(29, 113, 906, 419);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("AGENDAR");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(213, 148, 237));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(735, 23, 130, 110);
		panel.add(btnNewButton);
		
		JButton btnPagamento = new JButton("PAGAMENTO");
		btnPagamento.setForeground(new Color(255, 255, 255));
		btnPagamento.setBackground(new Color(213, 148, 237));
		btnPagamento.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		btnPagamento.setBounds(735, 143, 134, 114);
		panel.add(btnPagamento);
		
		JButton btnMetas = new JButton("METAS");
		btnMetas.setHorizontalAlignment(SwingConstants.LEFT);
		btnMetas.setForeground(Color.WHITE);
		btnMetas.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMetas.setBackground(new Color(213, 148, 237));
		btnMetas.setBounds(382, 23, 310, 109);
		panel.add(btnMetas);
		
		JButton btnNewButton_1_1 = new JButton("CRONOGRAMA");
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(new Color(213, 148, 237));
		btnNewButton_1_1.setBounds(382, 146, 310, 109);
		panel.add(btnNewButton_1_1);
		
		JButton btnPacote = new JButton("PACOTE");
		btnPacote.setHorizontalAlignment(SwingConstants.LEFT);
		btnPacote.setForeground(Color.WHITE);
		btnPacote.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPacote.setBackground(new Color(213, 148, 237));
		btnPacote.setBounds(382, 283, 127, 109);
		panel.add(btnPacote);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(40, 40, 40));
		canvas.setBounds(22, 23, 323, 109);
		panel.add(canvas);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(new Color(40, 40, 40));
		canvas_1.setBounds(22, 138, 323, 109);
		panel.add(canvas_1);
		
		Canvas canvas_1_1 = new Canvas();
		canvas_1_1.setBackground(new Color(40, 40, 40));
		canvas_1_1.setBounds(22, 253, 323, 109);
		panel.add(canvas_1_1);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 963, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("________________________________________________________________________________________");
		lblNewLabel.setBounds(0, 11, 978, 32);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 102, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("THUNDERFIT");
		lblNewLabel_1.setBounds(48, 0, 140, 38);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 102, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(0, 554, 963, 38);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("THUNDERFIT");
		lblNewLabel_1_1.setBounds(430, 5, 137, 30);
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
		lblNewLabel_2_1_1.setBounds(780, -1, 174, 38);
		panel_1_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("________________________________________________________________________________________");
		lblNewLabel_4.setForeground(new Color(255, 102, 204));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(0, 526, 978, 32);
		contentPane.add(lblNewLabel_4);
		
		
	}
}
