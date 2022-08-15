package view;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;
	// atribuir o modificador publico para manipular estes objetos de outra classe
	public JButton btnUsuarios;
	public JButton btnRelatorios;
	public JPanel panelUsuario;
	public JLabel lblUsuario;
	private JLabel lblUsurio;

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
		addWindowListener(new WindowAdapter() {
			//evento ativar janela
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
		        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		        lblData.setText(formatador.format(data));
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/favicon.png")));
		setTitle("Lojinha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUsuarios = new JButton("");
		btnUsuarios.setEnabled(false);
		btnUsuarios.addActionListener(new ActionListener() {
			//evento clicar no bot�o
			public void actionPerformed(ActionEvent e) {
				// Link para o jDialog
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setToolTipText("Usu\u00E1rios");
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/users.png")));
		btnUsuarios.setBounds(20, 23, 128, 128);
		contentPane.add(btnUsuarios);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedores fornecedores = new Fornecedores();
				fornecedores.setVisible(true);
			}
		});
		btnNewButton_1.setToolTipText("Fornecedores");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon(Principal.class.getResource("/img/supliers.png")));
		btnNewButton_1.setBounds(172, 23, 128, 128);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnNewButton_1_1.setToolTipText("Clientes");
		btnNewButton_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1.setIcon(new ImageIcon(Principal.class.getResource("/img/clientes.png")));
		btnNewButton_1_1.setBounds(472, 23, 128, 128);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos produtos = new Produtos();
				produtos.setVisible(true);
			}
		});
		btnNewButton_2.setToolTipText("Produtos");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setIcon(new ImageIcon(Principal.class.getResource("/img/products.png")));
		btnNewButton_2.setBounds(323, 23, 128, 128);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vendas vendas = new Vendas();
				vendas.setVisible(true);
			}
		});
		btnNewButton_3.setToolTipText("PDV");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setIcon(new ImageIcon(Principal.class.getResource("/img/cashbox.png")));
		btnNewButton_3.setBounds(20, 177, 128, 128);
		contentPane.add(btnNewButton_3);
		
		btnRelatorios = new JButton("");
		btnRelatorios.setEnabled(false);
		btnRelatorios.setToolTipText("Relat\u00F3rios");
		btnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorios.setIcon(new ImageIcon(Principal.class.getResource("/img/report.png")));
		btnRelatorios.setBounds(172, 177, 128, 128);
		contentPane.add(btnRelatorios);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setToolTipText("Ferramentas");
		btnNewButton_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2_1.setIcon(new ImageIcon(Principal.class.getResource("/img/tools.png")));
		btnNewButton_2_1.setBounds(323, 177, 128, 128);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setToolTipText("Sobre");
		btnNewButton_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_1.setIcon(new ImageIcon(Principal.class.getResource("/img/about.png")));
		btnNewButton_1_1_1.setBounds(472, 177, 128, 128);
		contentPane.add(btnNewButton_1_1_1);
		
		panelUsuario = new JPanel();
		panelUsuario.setBackground(SystemColor.textHighlight);
		panelUsuario.setBounds(0, 388, 624, 53);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(null);
		
		lblData = new JLabel("");
		lblData.setForeground(SystemColor.window);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(334, 11, 280, 31);
		panelUsuario.add(lblData);
		
		lblUsuario = new JLabel("");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(66, 28, 203, 14);
		panelUsuario.add(lblUsuario);
		
		lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setForeground(Color.WHITE);
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsurio.setBounds(10, 28, 62, 14);
		panelUsuario.add(lblUsurio);
	}
}
