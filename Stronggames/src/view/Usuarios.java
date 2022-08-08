package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;

public class Usuarios extends JDialog {
	private JTextField txtUsuId;
	private JTextField txtUsuNome;
	private JTextField txtUsuLogin;
	private JPasswordField txtUsuSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios dialog = new Usuarios();
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
	public Usuarios() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/logo.png")));
		setTitle("Strongames - Usuarios");
		setModal(true);
		setBounds(100, 100, 401, 306);
		getContentPane().setLayout(null);

		txtUsuId = new JTextField();
		txtUsuId.setBounds(66, 30, 122, 20);
		getContentPane().add(txtUsuId);
		txtUsuId.setColumns(10);

		txtUsuNome = new JTextField();
		txtUsuNome.setBounds(66, 71, 238, 20);
		getContentPane().add(txtUsuNome);
		txtUsuNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 74, 46, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setBounds(10, 33, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtUsuLogin = new JTextField();
		txtUsuLogin.setBounds(66, 113, 122, 20);
		getContentPane().add(txtUsuLogin);
		txtUsuLogin.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setBounds(10, 116, 46, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setBounds(10, 147, 46, 14);
		getContentPane().add(lblNewLabel_3);

		txtUsuSenha = new JPasswordField();
		txtUsuSenha.setBounds(66, 144, 238, 20);
		getContentPane().add(txtUsuSenha);

		cboUsuPerfil = new JComboBox();
		cboUsuPerfil.setModel(new DefaultComboBoxModel(new String[] { "", "Admin", "User" }));
		cboUsuPerfil.setBounds(254, 112, 106, 22);
		getContentPane().add(cboUsuPerfil);

		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.setBounds(198, 116, 46, 14);
		getContentPane().add(lblNewLabel_4);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarUsuarios();
			}
		});
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/pesquisa.png")));
		btnPesquisar.setToolTipText("pesquisa");
		btnPesquisar.setBounds(198, 12, 48, 48);
		getContentPane().add(btnPesquisar);

		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/add.png")));
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setBounds(166, 190, 64, 64);
		getContentPane().add(btnAdicionar);

		JButton btnAlterar = new JButton("");
		btnAlterar.setBorderPainted(false);
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/alterar.png")));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setBounds(240, 190, 64, 64);
		getContentPane().add(btnAlterar);

		JButton btnExcluir = new JButton("");
		btnExcluir.setBorderPainted(false);
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setToolTipText("excluir");
		btnExcluir.setIcon(new ImageIcon(Usuarios.class.getResource("/img/delete.png")));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setBounds(296, 190, 64, 64);
		getContentPane().add(btnExcluir);

		// validaçaõ com o us da biblioteca Atxy2K
		// txtUsuId
		RestrictedTextField ValidarId = new RestrictedTextField(txtUsuId);
		ValidarId.setOnlyNums(true);
		ValidarId.setLimit(4);
		// txtUsusNome
		RestrictedTextField ValidarNome = new RestrictedTextField(txtUsuNome);
		ValidarNome.setLimit(50);
		// txtUsuLogin
		RestrictedTextField ValidarSenha = new RestrictedTextField(txtUsuSenha);
		ValidarSenha.setLimit(255);
	}// FIm do construtor

	DAO dao = new DAO();
	private JComboBox cboUsuPerfil;

	/**
	 * metodo responsavel pela pesquisa do usuario
	 */

	private void pesquisarUsuarios() {
		// variação

		if (txtUsuId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o ID do Usuario");
			txtUsuId.requestFocus();
		} else {
			// logica principal
			// Query(instruçaõ SQL)
			String read = "select * from usuarios where idus = ?";
			// tratar exceções sempre que lidar com o banco
			try {
				// Estabelecer conecxão
				Connection con = dao.conectar();
				// preparar a execução da query
				PreparedStatement pst = con.prepareStatement(read);
				// setar o argumento (id)
				pst.setString(1, txtUsuId.getText());
				// Executar a query e exibir o resultado no formulario
				ResultSet rs = pst.executeQuery();
				// validação(existencia de usuario)
				// rs.next() -> existencia do usuario
				if (rs.next()) {
					// prencher(setar) os campos do formulario
					txtUsuNome.setText(rs.getString(2));
					txtUsuLogin.setText(rs.getString(3));
					cboUsuPerfil.setSelectedItem(rs.getString(5));
					txtUsuSenha.setText(rs.getString(4));
				} else {
					JOptionPane.showMessageDialog(null, "Usuario não Cadastrado");
				}
				// Nunca se esqueca de setar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Método responssavel por adicionar um novo usuario no banco
	 */

	private void adicionarUsuario() {
		// validação
		// Validação da da senha(captura segura)
		 String capturaSenha = new String(txtUsuSenha.getPassword());
		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Nome do Usuario");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Login do Usuario");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o Perfil do Usuario");
			cboUsuPerfil.requestFocus();
		} else if (txtUsuSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Digite a Senha do Usuario");
			txtUsuSenha.requestFocus();
		} else {
			// login principal
			String create = "insert into usuario (usuario,login,senha,perfil)" + "values(?,?,md5(?)?)";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execusão do query
				PreparedStatement pst = con.prepareStatement(create);
				// Subistituir os ???? pelo conteudo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboUsuPerfil.getSelectedItem().toString());
				// executar a query = inserir o ususario no banco
				pst.executeUpdate();
				// encerrar conexão
				con.close(); 
				JOptionPane.showMessageDialog(null, "Usuario Adicionado com Sucesso");
			}catch(SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso .\nEscolha outro login");
				txtUsuLogin.setText(null);
			}
			catch (Exception e) {
			System.out.println(e);
			}
		}
	

	private void limparcampo() {
		txtUsuNome.setText(null);
		txtUsuLogin.setText(null);
		txtUsuSenha.setText(null);
		cboUsuPerfil.setSelectedItem(null);
	}
}// fim do código
