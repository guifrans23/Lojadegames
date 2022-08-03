/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class modelo -conecxao com o banco de dados
 * @author Guilherme.afranca1
 *
 */
public class DAO {
// Parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://10.26.49.136:3306/lojagames";
	private String user = "root";
	private String password = "123@senac";
	/**
	 * metodo responsavel pela conecx�o
	 * @return con / null
	 */
	
	public Connection conectar() {
	//objeto adicionado para conex�o
		Connection con = null;
		//tratamento de exce��es
		try {
			//uso dos drivers
			Class.forName(driver);
			//extabelecimento de conex�o
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}

