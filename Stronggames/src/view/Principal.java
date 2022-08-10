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
	private JButton BtnUsuarios;
	private JButton btnRelatorio;

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
		setBounds(100, 100, 577, 399);
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
		BtnUsuarios.setBounds(10, 11, 128, 128);
		getContentPane().add(BtnUsuarios);
		
		JButton BtnRelatorios = new JButton("");
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
		
		JButton btnNewButton_2 = new JButton("");
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
		
		JButton btnNewButton_3 = new JButton("");
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
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagamento pagamento = new Pagamento();
				pagamento.setVisible(true);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(Principal.class.getResource("/img/pagamento.png")));
		btnNewButton_4.setToolTipText("Pagamento");
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setBounds(10, 150, 128, 128);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ferramentas ferramentas = new Ferramentas();
				ferramentas.setVisible(true);
				
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(Principal.class.getResource("/img/configuracoes.png")));
		btnNewButton_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_5.setToolTipText("Ferramentas");
		btnNewButton_5.setBounds(288, 150, 128, 128);
		getContentPane().add(btnNewButton_5);
		
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
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setContentAreaFilled(false);
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setIcon(new ImageIcon(Principal.class.getResource("/img/sobre (2).png")));
		btnNewButton_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7.setToolTipText("Sobre");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(426, 150, 128, 128);
		getContentPane().add(btnNewButton_7);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(0, 289, 561, 71);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Strong Games");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(74, 11, 117, 33);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/img/lojalogo.png")));
		lblNewLabel_1.setToolTipText("StrongGames");
		lblNewLabel_1.setBounds(0, 0, 64, 71);
		panel.add(lblNewLabel_1);

	}
}
