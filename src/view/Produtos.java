package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import com.toedter.calendar.JDateChooser;

import model.DAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Produtos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtBarcode;
	private JTextField txtCodigo;
	private JTextField txtFornecedor;
	private JTextField txtIdFor;
	private JTable tblFornecedor;
	private JTextField txtProduto;
	private JTextField txtFabricante;
	private JTextField txtEstoque;
	private JTextField txtEstoqueMin;
	private JTextField txtLocal;
	private JTextField txtCusto;
	private JTextField txtLucro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produtos dialog = new Produtos();
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
	public Produtos() {
		setModal(true);
		setTitle("Produtos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Produtos.class.getResource("/img/favicon.png")));
		setBounds(100, 100, 800, 496);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Produtos.class.getResource("/img/barcode.png")));
		lblNewLabel.setBounds(10, 11, 64, 45);
		getContentPane().add(lblNewLabel);

		txtBarcode = new JTextField();
		txtBarcode.setBounds(84, 25, 227, 20);
		getContentPane().add(txtBarcode);
		txtBarcode.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setBounds(28, 79, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(84, 76, 111, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarProdutoCodigo();
			}
		});
		btnPesquisar.setBounds(211, 74, 100, 23);
		getContentPane().add(btnPesquisar);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(349, 25, 394, 152);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtFornecedor = new JTextField();
		txtFornecedor.setBounds(20, 30, 144, 20);
		panel.add(txtFornecedor);
		txtFornecedor.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Produtos.class.getResource("/img/pesquisar.png")));
		lblNewLabel_2.setBounds(174, 22, 32, 32);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(236, 33, 46, 14);
		panel.add(lblNewLabel_3);

		txtIdFor = new JTextField();
		txtIdFor.setBounds(267, 30, 86, 20);
		panel.add(txtIdFor);
		txtIdFor.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 63, 352, 78);
		panel.add(scrollPane);

		tblFornecedor = new JTable();
		scrollPane.setViewportView(tblFornecedor);

		JLabel lblNewLabel_4 = new JLabel("Produto");
		lblNewLabel_4.setBounds(28, 134, 46, 14);
		getContentPane().add(lblNewLabel_4);

		txtProduto = new JTextField();
		txtProduto.setBounds(84, 131, 227, 20);
		getContentPane().add(txtProduto);
		txtProduto.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_5.setBounds(20, 201, 64, 14);
		getContentPane().add(lblNewLabel_5);

		JTextArea txtAreaDesc = new JTextArea();
		txtAreaDesc.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAreaDesc.setBounds(84, 186, 227, 73);
		getContentPane().add(txtAreaDesc);

		JButton btnAdicionar = new JButton("");
		btnAdicionar.setIcon(new ImageIcon(Produtos.class.getResource("/img/boxadd.png")));
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setBounds(488, 355, 64, 64);
		getContentPane().add(btnAdicionar);

		JButton btnAlterar = new JButton("");
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setIcon(new ImageIcon(Produtos.class.getResource("/img/boxupdate.png")));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setBounds(580, 355, 64, 64);
		getContentPane().add(btnAlterar);

		JButton btnExcluir = new JButton("");
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setIcon(new ImageIcon(Produtos.class.getResource("/img/boxdel.png")));
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setBounds(669, 355, 64, 64);
		getContentPane().add(btnExcluir);

		JLabel lblNewLabel_6 = new JLabel("Fabricante");
		lblNewLabel_6.setBounds(13, 294, 64, 14);
		getContentPane().add(lblNewLabel_6);

		txtFabricante = new JTextField();
		txtFabricante.setBounds(84, 291, 227, 20);
		getContentPane().add(txtFabricante);
		txtFabricante.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Estoque");
		lblNewLabel_7.setBounds(23, 344, 51, 14);
		getContentPane().add(lblNewLabel_7);

		txtEstoque = new JTextField();
		txtEstoque.setBounds(84, 341, 46, 20);
		getContentPane().add(txtEstoque);
		txtEstoque.setColumns(10);

		JLabel lblNewLabel_7_1 = new JLabel("Estoque m\u00EDnimo");
		lblNewLabel_7_1.setBounds(164, 344, 91, 14);
		getContentPane().add(lblNewLabel_7_1);

		txtEstoqueMin = new JTextField();
		txtEstoqueMin.setColumns(10);
		txtEstoqueMin.setBounds(265, 341, 46, 20);
		getContentPane().add(txtEstoqueMin);

		JLabel lblNewLabel_8 = new JLabel("Unidade");
		lblNewLabel_8.setBounds(20, 403, 46, 14);
		getContentPane().add(lblNewLabel_8);

		cboUnidade = new JComboBox();
		cboUnidade.setModel(new DefaultComboBoxModel(new String[] { "", "UN", "CX", "P\u00C7", "KG", "PCT", "M" }));
		cboUnidade.setBounds(85, 399, 68, 22);
		getContentPane().add(cboUnidade);

		JLabel lblNewLabel_9 = new JLabel("Local");
		lblNewLabel_9.setBounds(175, 402, 46, 14);
		getContentPane().add(lblNewLabel_9);

		txtLocal = new JTextField();
		txtLocal.setBounds(223, 399, 161, 20);
		getContentPane().add(txtLocal);
		txtLocal.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Entrada");
		lblNewLabel_10.setBounds(349, 198, 64, 14);
		getContentPane().add(lblNewLabel_10);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(403, 195, 131, 20);
		getContentPane().add(dateChooser);

		JLabel lblNewLabel_11 = new JLabel("Validade");
		lblNewLabel_11.setBounds(557, 198, 51, 14);
		getContentPane().add(lblNewLabel_11);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(612, 195, 131, 20);
		getContentPane().add(dateChooser_1);

		JLabel lblNewLabel_12 = new JLabel("Custo");
		lblNewLabel_12.setBounds(349, 260, 51, 14);
		getContentPane().add(lblNewLabel_12);

		txtCusto = new JTextField();
		txtCusto.setBounds(403, 257, 131, 20);
		getContentPane().add(txtCusto);
		txtCusto.setColumns(10);

		JLabel lblNewLabel_12_1 = new JLabel("Lucro(%)");
		lblNewLabel_12_1.setBounds(557, 260, 51, 14);
		getContentPane().add(lblNewLabel_12_1);

		txtLucro = new JTextField();
		txtLucro.setBounds(618, 257, 64, 20);
		getContentPane().add(txtLucro);
		txtLucro.setColumns(10);

	}// fim do construtor

	// Criar objeto para acessar o banco
	DAO dao = new DAO();
	private JComboBox cboUnidade;

	// pesquisar produto por código
	private void pesquisarProdutoCodigo() {
		String read = "select * from produtos where codigo = ?";
		try {			
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, txtCodigo.getText());			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtBarcode.setText(rs.getString(2));
				txtProduto.setText(rs.getString(3));
				//...
			} else {
				JOptionPane.showMessageDialog(null, "Produto não cadastrado");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
