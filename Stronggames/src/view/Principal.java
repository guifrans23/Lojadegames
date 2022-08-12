package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class Principal extends JFrame {
	public JButton BtnUsuarios;
	public JButton btnRelatorio;
	public JPanel panelUsuario;
	public JLabel lblUsuario;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_4;
	private JButton BtnRelatorios;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

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
		setResizable(false);
		setTitle("Stronggames - Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/logo.png")));
		setBounds(100, 100, 577, 414);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		BtnUsuarios = new JButton("");
		BtnUsuarios.setEnabled(false);
		BtnUsuarios.setBorderPainted(false);
		BtnUsuarios.setContentAreaFilled(false);
		BtnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		BtnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/user.png")));
		BtnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnUsuarios.setToolTipText("Usuario");
		BtnUsuarios.setBounds(10, 0, 128, 128);
		getContentPane().add(BtnUsuarios);
		
		BtnRelatorios = new JButton("");
		BtnRelatorios.setBorderPainted(false);
		BtnRelatorios.setContentAreaFilled(false);
		BtnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedores fornecedores = new Fornecedores();
				fornecedores.setVisible(true);
			}
		});
		BtnRelatorios.setIcon(new ImageIcon(Principal.class.getResource("/img/fornecedores.png")));
		BtnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnRelatorios.setToolTipText("Fornecedores");
		BtnRelatorios.setBounds(148, 11, 128, 128);
		getContentPane().add(BtnRelatorios);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos produtos = new Produtos();
				produtos.setVisible(true);
			}
		});
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setIcon(new ImageIcon(Principal.class.getResource("/img/produtos.png")));
		btnNewButton_2.setToolTipText("Produtos");
		btnNewButton_2.setBounds(288, 11, 128, 128);
		getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Principal.class.getResource("/img/clientes.png")));
		btnNewButton_3.setToolTipText("Clientes");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBounds(426, 11, 128, 128);
		getContentPane().add(btnNewButton_3);
		
		btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagamento pagamento = new Pagamento();
				pagamento.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/img/pagamento.png")));
		btnNewButton.setToolTipText("Pagamento");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(10, 150, 128, 128);
		getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ferramentas ferramentas = new Ferramentas();
				ferramentas.setVisible(true);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Principal.class.getResource("/img/configuracoes.png")));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setToolTipText("Ferramentas");
		btnNewButton_1.setBounds(288, 150, 128, 128);
		getContentPane().add(btnNewButton_1);
		
		btnRelatorio = new JButton("");
		btnRelatorio.setEnabled(false);
		btnRelatorio.setContentAreaFilled(false);
		btnRelatorio.setBorderPainted(false);
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio relatorio = new Relatorio();
				relatorio.setVisible(true);
			}
		});
		btnRelatorio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorio.setIcon(new ImageIcon(Principal.class.getResource("/img/Relatorio.png")));
		btnRelatorio.setToolTipText("Relatorio");
		btnRelatorio.setBounds(148, 150, 128, 128);
		getContentPane().add(btnRelatorio);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setIcon(new ImageIcon(Principal.class.getResource("/img/sobre (2).png")));
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setToolTipText("Sobre");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(426, 150, 128, 128);
		getContentPane().add(btnNewButton_4);
		
		panelUsuario = new JPanel();
		panelUsuario.setBackground(new Color(204, 0, 0));
		panelUsuario.setBounds(0, 304, 561, 71);
		getContentPane().add(panelUsuario);
		panelUsuario.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Strong Games");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(74, 11, 117, 33);
		panelUsuario.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/img/lojalogo.png")));
		lblNewLabel_1.setToolTipText("StrongGames");
		lblNewLabel_1.setBounds(0, 0, 64, 71);
		panelUsuario.add(lblNewLabel_1);
		
		lblUsuario = new JLabel("");
		lblUsuario.setToolTipText("usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(201, 11, 135, 14);
		panelUsuario.add(lblUsuario);

	}
}
