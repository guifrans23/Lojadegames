package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
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

		txtLogin = new JTextField();
		txtLogin.setBounds(95, 63, 193, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(95, 118, 193, 20);
		contentPane.add(txtSenha);

		JButton txtacessar = new JButton("acessar");
		txtacessar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtacessar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtacessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}

		});
		txtacessar.setBounds(295, 196, 89, 23);
		contentPane.add(txtacessar);

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
	private void status() {
		try {
			// Abrir conexão
			Connection con = dao.conectar();
			if (con == null) {
				lblStatus2.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));
			} else {
				lblStatus2.setIcon(new ImageIcon(Login.class.getResource("/img/dbon.png")));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Método usado para autenticar um usuário
	 */
	private void logar() {
		// validação da senha (captura segura)
		String capturaSenha = new String(txtSenha.getPassword());
		// validação
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o seu Login");
			txtLogin.requestFocus();
		} else if (txtSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Digite a sua senha");
			txtSenha.requestFocus();
		} else {
			// lógica principal
			String read = "select * from usuarios where login=? and senha = md5(?)";
			try {
				// abrir a conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(read);
				// Setar os argumentos (login e senha)
				// Substituir os ?(argumentos) pelo conteúdo das caixas de texto
				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);
				// Executar a query e de acordo com o resultado liberar os recursos da tela
				// principal
				ResultSet rs = pst.executeQuery();
				// Validação (autenticação de usuário)
				// rs.next() -> existência de login e senha correspondente
				if (rs.next()) {
					String perfil = rs.getString(5);
					//System.out.println(perfil);
					if(perfil.equals("admin")) {
						Principal Principal = new Principal();
						Principal.setVisible(true);
						//Habitiltar recursos
						Principal.btnRelatorio.setEnabled(true);
						Principal.BtnUsuarios.setEnabled(true);
						Principal.panelUsuario.setBackground(Color.BLUE);
						//setar o nome do usuario na tela principal
						Principal.lblUsuario.setText("usuario: " + rs.getString(2) + "login: " + rs.getString(5));
					}else {
						Principal Principal = new Principal();
						Principal.setVisible(true);
						//encerrar conexão
						con.close();
						//fechartela de login
						this.dispose();
					}
					
					
				
				} else {
					JOptionPane.showMessageDialog(null, "Login e/ou senha inválido(s)");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}// fim do construtor
