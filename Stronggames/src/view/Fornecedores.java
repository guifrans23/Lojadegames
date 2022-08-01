package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fornecedores extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fornecedores dialog = new Fornecedores();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Fornecedores() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedores.class.getResource("/img/logo.png")));
		setModal(true);
		setTitle("Strongames - Fornecedores");
		setBounds(100, 100, 730, 427);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fornecedor");
		lblNewLabel.setBounds(10, 21, 73, 17);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(88, 19, 275, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/pesquisa.png")));
		lblNewLabel_1.setBounds(363, -101, 48, 48);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Id");
		lblNewLabel_2.setBounds(10, 49, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CNPJ");
		lblNewLabel_3.setBounds(10, 96, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(50, 50, 127, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(50, 93, 436, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Site");
		lblNewLabel_4.setBounds(10, 124, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(40, 121, 651, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fone");
		lblNewLabel_5.setBounds(10, 183, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Contato");
		lblNewLabel_6.setBounds(250, 183, 46, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setBounds(10, 150, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("CEP");
		lblNewLabel_8.setBounds(10, 208, 46, 14);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Endere\u00E7o");
		lblNewLabel_9.setBounds(369, 211, 81, 14);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Bairro");
		lblNewLabel_10.setBounds(10, 240, 46, 14);
		getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Cidade");
		lblNewLabel_11.setBounds(284, 240, 46, 14);
		getContentPane().add(lblNewLabel_11);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA", "MG", "ES", "RJ", "SP", "PR", "SC", "RS", "MS", "MT", "GO", "DF"}));
		comboBox.setBounds(606, 236, 83, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_12 = new JLabel("UF");
		lblNewLabel_12.setBounds(548, 240, 48, 14);
		getContentPane().add(lblNewLabel_12);
		
		textField_4 = new JTextField();
		textField_4.setBounds(40, 180, 205, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(297, 180, 394, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(66, 237, 208, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(40, 208, 205, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(50, 149, 641, 20);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(428, 209, 263, 20);
		getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(340, 237, 198, 20);
		getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(167, 338, -92, 81);
		getContentPane().add(textArea);
		
		JLabel lblNewLabel_13 = new JLabel("OBS:");
		lblNewLabel_13.setBounds(10, 285, 46, 17);
		getContentPane().add(lblNewLabel_13);
		
		JList list = new JList();
		list.setBounds(60, 291, 59, -21);
		getContentPane().add(list);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(40, 281, 352, 75);
		getContentPane().add(textArea_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setToolTipText("Alterar");
		btnNewButton.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/alterar.png")));
		btnNewButton.setBounds(489, 292, 64, 64);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setToolTipText("Excluir");
		btnNewButton_1.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/delete.png")));
		btnNewButton_1.setBounds(568, 292, 64, 64);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setToolTipText("Adicionar");
		btnNewButton_2.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/add.png")));
		btnNewButton_2.setBounds(410, 292, 64, 64);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Buscar CEP");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBounds(255, 208, 108, 23);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/pesquisa.png")));
		lblNewLabel_14.setBounds(383, 11, 48, 48);
		getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/ID.png")));
		lblNewLabel_15.setToolTipText("ID");
		lblNewLabel_15.setBounds(177, 50, 32, 32);
		getContentPane().add(lblNewLabel_15);

	}
}
