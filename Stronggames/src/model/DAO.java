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
	 * metodo responsavel pela conecxão
	 * @return con / null
	 */
	
	public Connection conectar() {
	//objeto adicionado para conexão
		Connection con = null;
		//tratamento de exceções
		try {
			//uso dos drivers
			Class.forName(driver);
			//extabelecimento de conexão
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}

