package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.DAO;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fornecedores extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPesquisarFornecedor;
	private JTextField txtForId;
	private JTextField txtForCNPJ;
	private JTextField txtForIE;
	private JTextField txtForIM;
	private JTextField txtForRazao;
	private JTextField txtForFantasia;
	private JTextField txtForSite;
	private JTextField txtForFone;
	private JTextField txtForContato;
	private JTextField txtForEmail;
	private JTextField txtForCep;
	private JTextField txtForEndereco;
	private JTextField txtForNumero;
	private JTextField txtForComplemento;
	private JTextField txtForBairro;
	private JTextField txtForCidade;
	private JTable tblFornecedores;
	private JComboBox cboForUF;

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
		setTitle("Fornecedores");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedores.class.getResource("/img/favicon.png")));
		setModal(true);
		setBounds(100, 100, 731, 505);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fornecedor");
		lblNewLabel.setBounds(24, 16, 68, 14);
		getContentPane().add(lblNewLabel);
		
		txtPesquisarFornecedor = new JTextField();
		txtPesquisarFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//evento digitação
				pesquisarFornecedorTabela();
			}
		});
		txtPesquisarFornecedor.setBounds(97, 15, 181, 20);
		getContentPane().add(txtPesquisarFornecedor);
		txtPesquisarFornecedor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(24, 139, 24, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtForId = new JTextField();
		txtForId.setBounds(52, 136, 33, 20);
		getContentPane().add(txtForId);
		txtForId.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CNPJ");
		lblNewLabel_3.setBounds(197, 139, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtForCNPJ = new JTextField();
		txtForCNPJ.setBounds(243, 136, 112, 20);
		getContentPane().add(txtForCNPJ);
		txtForCNPJ.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("IE");
		lblNewLabel_4.setBounds(382, 139, 15, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtForIE = new JTextField();
		txtForIE.setBounds(409, 136, 112, 20);
		getContentPane().add(txtForIE);
		txtForIE.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("IM");
		lblNewLabel_4_1.setBounds(547, 139, 15, 14);
		getContentPane().add(lblNewLabel_4_1);
		
		txtForIM = new JTextField();
		txtForIM.setColumns(10);
		txtForIM.setBounds(572, 136, 112, 20);
		getContentPane().add(txtForIM);
		
		JLabel lblNewLabel_5 = new JLabel("Raz\u00E3o Social");
		lblNewLabel_5.setBounds(24, 182, 81, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtForRazao = new JTextField();
		txtForRazao.setBounds(108, 179, 245, 20);
		getContentPane().add(txtForRazao);
		txtForRazao.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nome de fantasia");
		lblNewLabel_6.setBounds(371, 182, 107, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtForFantasia = new JTextField();
		txtForFantasia.setBounds(480, 179, 204, 20);
		getContentPane().add(txtForFantasia);
		txtForFantasia.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Site");
		lblNewLabel_7.setBounds(24, 223, 33, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtForSite = new JTextField();
		txtForSite.setBounds(63, 220, 187, 20);
		getContentPane().add(txtForSite);
		txtForSite.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Fone");
		lblNewLabel_8.setBounds(266, 223, 46, 14);
		getContentPane().add(lblNewLabel_8);
		
		txtForFone = new JTextField();
		txtForFone.setBounds(311, 220, 107, 20);
		getContentPane().add(txtForFone);
		txtForFone.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Contato");
		lblNewLabel_9.setBounds(441, 223, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		txtForContato = new JTextField();
		txtForContato.setBounds(505, 220, 179, 20);
		getContentPane().add(txtForContato);
		txtForContato.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("E-mail");
		lblNewLabel_10.setBounds(24, 266, 46, 14);
		getContentPane().add(lblNewLabel_10);
		
		txtForEmail = new JTextField();
		txtForEmail.setBounds(71, 263, 179, 20);
		getContentPane().add(txtForEmail);
		txtForEmail.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("CEP");
		lblNewLabel_11.setBounds(281, 266, 46, 14);
		getContentPane().add(lblNewLabel_11);
		
		txtForCep = new JTextField();
		txtForCep.setBounds(316, 263, 81, 20);
		getContentPane().add(txtForCep);
		txtForCep.setColumns(10);
		
		JButton btnBuscarCep = new JButton("Buscar CEP");
		btnBuscarCep.setBounds(414, 260, 107, 23);
		getContentPane().add(btnBuscarCep);
		
		JLabel lblNewLabel_12 = new JLabel("Endere\u00E7o");
		lblNewLabel_12.setBounds(24, 306, 59, 14);
		getContentPane().add(lblNewLabel_12);
		
		txtForEndereco = new JTextField();
		txtForEndereco.setBounds(94, 303, 218, 20);
		getContentPane().add(txtForEndereco);
		txtForEndereco.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("N\u00FAmero");
		lblNewLabel_13.setBounds(338, 306, 46, 14);
		getContentPane().add(lblNewLabel_13);
		
		txtForNumero = new JTextField();
		txtForNumero.setBounds(394, 303, 72, 20);
		getContentPane().add(txtForNumero);
		txtForNumero.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Complemento");
		lblNewLabel_14.setBounds(495, 306, 87, 14);
		getContentPane().add(lblNewLabel_14);
		
		txtForComplemento = new JTextField();
		txtForComplemento.setBounds(585, 303, 99, 20);
		getContentPane().add(txtForComplemento);
		txtForComplemento.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Bairro");
		lblNewLabel_15.setBounds(24, 350, 46, 14);
		getContentPane().add(lblNewLabel_15);
		
		txtForBairro = new JTextField();
		txtForBairro.setBounds(71, 347, 200, 20);
		getContentPane().add(txtForBairro);
		txtForBairro.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Cidade");
		lblNewLabel_16.setBounds(294, 350, 46, 14);
		getContentPane().add(lblNewLabel_16);
		
		txtForCidade = new JTextField();
		txtForCidade.setBounds(349, 347, 200, 20);
		getContentPane().add(txtForCidade);
		txtForCidade.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("UF");
		lblNewLabel_17.setBounds(572, 350, 24, 14);
		getContentPane().add(lblNewLabel_17);
		
		cboForUF = new JComboBox();
		cboForUF.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboForUF.setBounds(603, 346, 81, 22);
		getContentPane().add(cboForUF);
		
		JLabel lblNewLabel_18 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_18.setBounds(31, 407, 74, 14);
		getContentPane().add(lblNewLabel_18);
		
		JTextArea txtForObs = new JTextArea();
		txtForObs.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtForObs.setBounds(128, 394, 313, 41);
		getContentPane().add(txtForObs);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/create.png")));
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setBounds(495, 391, 64, 64);
		getContentPane().add(btnAdicionar);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/update.png")));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setBounds(560, 391, 64, 64);
		getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/delete.png")));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setBounds(623, 391, 64, 64);
		getContentPane().add(btnExcluir);
		
		JButton btnPesquisar = new JButton("Buscar");
		btnPesquisar.setBounds(91, 134, 81, 23);
		getContentPane().add(btnPesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 46, 660, 70);
		getContentPane().add(scrollPane);
		
		tblFornecedores = new JTable();
		tblFornecedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//evento clicar com o mouse na tabela
				setarCaixasTexto();
			}
		});
		scrollPane.setViewportView(tblFornecedores);

	}// fim do construtor
	
	// Criar objeto para acessar o banco
	DAO dao = new DAO();
	
	/**
	 * Método responsável pela pesquisa avançada do fornecedor
	 * usando o nome de fantasia e a biblioteca rs2xml
	 */
	private void pesquisarFornecedorTabela() {
		String readT = "select idfor as ID,fantasia as fornecedor,fone,contato from fornecedores where fantasia like ?";
		try {
			// Estabelecer a conexão
			Connection con = dao.conectar();
			// Preparar a execução da query
			PreparedStatement pst = con.prepareStatement(readT);
			// Setar o argumento (fantasia)
			// Substituir o ? pelo conteúdo da caixa de texto
			pst.setString(1, txtPesquisarFornecedor.getText() + "%");
			ResultSet rs = pst.executeQuery();
			//uso da biblioteca rs2xml para "popular" a tabela
			tblFornecedores.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	/**
	 * Método responsável por setar as caixas de texto
	 * de acordo com os campos da tabela (mouse click)
	 */
	private void setarCaixasTexto() {
		//criar uma variável para receber a linha da tabela
		int setar = tblFornecedores.getSelectedRow();
		txtForId.setText(tblFornecedores.getModel().getValueAt(setar, 0).toString());
		//txtForFantasia.setText(tblFornecedores.getModel().getValueAt(setar, 1).toString());
	}
	
	// demais métodos do CRUD
	
	/**
	 * Limpar campos
	 */
	private void limparCamposFornecedor() {
		//limpar a tabela
		((DefaultTableModel) tblFornecedores.getModel()).setRowCount(0);
	}
}
