package ec.edu.ups.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class ConexionBD {
	private Connection jdbcConnection;
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/agenda_telefonica";
		String user = "root";
		String pass = "Adrian1998";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("conecta");
			return con;

		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->" + ex.getMessage());
			return null;
		}
	}
	/**
	 * cerrar base de datos
	 * @param con
	 */
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
	public ResultSet consultar(String sql) {
		ResultSet resultado;
		try {
			java.sql.Statement sentencia = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			resultado = sentencia.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}        return resultado;
	}


	public Connection getJdbcConnection() {
		return jdbcConnection;
	}  

}