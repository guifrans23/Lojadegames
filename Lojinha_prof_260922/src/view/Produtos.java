package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import com.toedter.calendar.JDateChooser;

import model.DAO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import java.awt.Panel;
import javax.swing.JSeparator;
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
	private JTable tblFornecedor;

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
		setBounds(100, 100, 843, 614);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Produtos.class.getResource("/img/barcode.png")));
		lblNewLabel.setToolTipText("Barcode");
		lblNewLabel.setBounds(10, 11, 64, 45);
		getContentPane().add(lblNewLabel);
		
		JTextArea txtBarcode = new JTextArea();
		txtBarcode.setBounds(96, 27, 290, 22);
		getContentPane().add(txtBarcode);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setBounds(20, 77, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea txtxCodigo = new JTextArea();
		txtxCodigo.setBounds(66, 72, 239, 22);
		getContentPane().add(txtxCodigo);
		
		JButton btnPesquisar = new JButton("Buscar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarProdutoCodigo();
			}
		});
		btnPesquisar.setBounds(315, 73, 89, 23);
		getContentPane().add(btnPesquisar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fornecedores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		panel.setBounds(426, 27, 391, 263);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 72, 347, 180);
		panel.add(scrollPane);
		
		tblFornecedor = new JTable();
		scrollPane.setViewportView(tblFornecedor);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Produtos.class.getResource("/img/search.png")));
		lblNewLabel_2.setBounds(133, 11, 32, 32);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(177, 26, 46, 14);
		panel.add(lblNewLabel_3);
		
		JTextArea txtFornecedor = new JTextArea();
		txtFornecedor.setBounds(10, 21, 113, 22);
		panel.add(txtFornecedor);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setBorderPainted(false);
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setIcon(new ImageIcon(Produtos.class.getResource("/img/boxupdate.png")));
		btnAlterar.setBounds(607, 473, 75, 75);
		getContentPane().add(btnAlterar);
		
		JButton BtnExcluir = new JButton("");
		BtnExcluir.setContentAreaFilled(false);
		BtnExcluir.setBorderPainted(false);
		BtnExcluir.setIcon(new ImageIcon(Produtos.class.getResource("/img/boxdel.png")));
		BtnExcluir.setBounds(692, 473, 75, 75);
		getContentPane().add(BtnExcluir);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setIcon(new ImageIcon(Produtos.class.getResource("/img/boxadd.png")));
		btnAdicionar.setBounds(519, 473, 75, 75);
		getContentPane().add(btnAdicionar);
		
		JLabel lblNewLabel_4 = new JLabel("Produto");
		lblNewLabel_4.setBounds(10, 122, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_5.setBounds(10, 159, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		JTextArea txtProduto = new JTextArea();
		txtProduto.setBounds(66, 117, 338, 22);
		getContentPane().add(txtProduto);
		
		JEditorPane txtAreaDesc = new JEditorPane();
		txtAreaDesc.setBounds(66, 159, 340, 130);
		getContentPane().add(txtAreaDesc);
		
		JLabel lblNewLabel_6 = new JLabel("Entrada");
		lblNewLabel_6.setBounds(426, 345, 46, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Validade");
		lblNewLabel_7.setBounds(604, 345, 64, 14);
		getContentPane().add(lblNewLabel_7);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(486, 339, 108, 20);
		getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(660, 339, 108, 20);
		getContentPane().add(dateChooser_1);
		
		JLabel lblNewLabel_8 = new JLabel("Custo");
		lblNewLabel_8.setBounds(426, 387, 46, 14);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("lucro(%)");
		lblNewLabel_9.setBounds(604, 387, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		JTextArea txtCusto = new JTextArea();
		txtCusto.setBounds(470, 384, 130, 22);
		getContentPane().add(txtCusto);
		
		JTextArea txtLucro = new JTextArea();
		txtLucro.setBounds(667, 382, 124, 22);
		getContentPane().add(txtLucro);
		
		JLabel lblNewLabel_10 = new JLabel("estoque");
		lblNewLabel_10.setBounds(10, 387, 64, 14);
		getContentPane().add(lblNewLabel_10);
		
		JLabel aa = new JLabel("estoque Minimo");
		aa.setBounds(170, 387, 146, 14);
		getContentPane().add(aa);
		
		JTextArea txtEstoque = new JTextArea();
		txtEstoque.setBounds(52, 382, 108, 22);
		getContentPane().add(txtEstoque);
		
		JTextArea txtEstoqueMin = new JTextArea();
		txtEstoqueMin.setBounds(250, 382, 136, 22);
		getContentPane().add(txtEstoqueMin);
		
		JLabel lblNewLabel_12 = new JLabel("fabricante");
		lblNewLabel_12.setBounds(10, 345, 75, 14);
		getContentPane().add(lblNewLabel_12);
		
		JTextArea txtFabricante = new JTextArea();
		txtFabricante.setBounds(66, 340, 338, 22);
		getContentPane().add(txtFabricante);
		
		JLabel lblNewLabel_13 = new JLabel("Local");
		lblNewLabel_13.setBounds(170, 438, 46, 14);
		getContentPane().add(lblNewLabel_13);
		
		JTextArea TxtLocal = new JTextArea();
		TxtLocal.setBounds(212, 433, 239, 22);
		getContentPane().add(TxtLocal);
		
		JLabel lblNewLabel_14 = new JLabel("Unidade");
		lblNewLabel_14.setBounds(10, 438, 46, 14);
		getContentPane().add(lblNewLabel_14);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(198, 518, 1, 2);
		getContentPane().add(separator);
		
		JComboBox cboUnidade = new JComboBox();
		cboUnidade.setModel(new DefaultComboBoxModel(new String[] {"", "UN", "CX", "KG", "M", "P\u00C7"}));
		cboUnidade.setBounds(61, 434, 99, 22);
		getContentPane().add(cboUnidade);

	} //fim do Construtor
	
	//Criar objeto para acessar o Banco
	DAO dao = new DAO();
	
	
	private void pesquisarProdutoCodigo() {
		String read = "select * from produtos where codigo = ?";
		try {
			// Estabelecer a conexão
			Connection con = dao.conectar();
			// Preparar a execução da query
			PreparedStatement pst = con.prepareStatement(read);
			// Setar o argumento (id)
			// Substituir o ? pelo conteúdo da caixa de texto
			pst.setString(1, txtIdFor.getText());
			// Executar a query e exibir o resultado no formulario
			ResultSet rs = pst.executeQuery();
			// Validação (existência de usuário)
			// rs.next() -> existência de usuário
		} catch (Exception e) {
			
		}
	
	}
}
