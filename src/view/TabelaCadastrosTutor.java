package view;
//ESSA TELA APARECERA PARA O ADM,COM TODAS AS PESSOAS CADASTRADAS
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTree;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TabelaCadastrosTutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaCadastrosTutor frame = new TabelaCadastrosTutor();
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
	public TabelaCadastrosTutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080,720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOME", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(38, 66, 986, 563);
		contentPane.add(table);
		
		textField = new JTextField();
		textField.setBounds(37, 18, 868, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("PAGAMENTO");
		btnNewButton.setBounds(916, 19, 112, 27);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("SAIR");
		btnNewButton_1.setBounds(515, 649, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
