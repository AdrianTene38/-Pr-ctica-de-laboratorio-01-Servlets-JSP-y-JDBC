package ec.edu.ups.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conexion = null;
		String url = "jdbc:mysql://localhost:3306/agenda_telefonica";
		String user = "root";
		String pass = "Adrian1998";
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("SE CONECTO");
		} catch (ClassNotFoundException e) {
			System.out.println("Imposible cargar el driver: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Imposible conectar: " + e.getMessage());
		}
	}

}
