package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;

public class Pagamento extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagamento dialog = new Pagamento();
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
	public Pagamento() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pagamento.class.getResource("/img/logo.png")));
		setTitle("Strongames - Pagamento");
		setModal(true);
		setBounds(100, 100, 450, 300);

	}

}
