package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblStatus2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setResizable(false);
		setTitle("Stronggames - Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(39, 56, 46, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(39, 118, 46, 17);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(95, 63, 193, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(95, 118, 193, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("acessar");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
	
		});
		btnNewButton.setBounds(299, 202, 89, 23);
		contentPane.add(btnNewButton);
		
		lblStatus2 = new JLabel("");
		lblStatus2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStatus2.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));
		lblStatus2.setToolTipText("Db - ");
		lblStatus2.setBounds(27, 186, 56, 58);
		contentPane.add(lblStatus2);
	}


//fim do construtor

//Criação de um Objeto para acessar a camada Model
DAO dao = new DAO();
private JLabel lblStatus;

/**
 * Método usado para verificar o status do server
 */
private void status( ){
	try {
		// Abrir conexão
		Connection con = dao.conectar();
		if (con == null) {
		lblStatus2.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));	
		}
		else {
			lblStatus2.setIcon(new ImageIcon(Login.class.getResource("/img/dbon.png")));
		}
	} catch (Exception e) {
		System.out.println(e);
	}
}
}//fim do construtor
