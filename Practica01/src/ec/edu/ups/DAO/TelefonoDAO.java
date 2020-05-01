package ec.edu.ups.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ec.edu.ups.Controlador.ConexionBD;
import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Modelo.Telefono;

public class TelefonoDAO {
	UsuarioDao usudao;
	public TelefonoDAO() {
	
	}
	
	public void insertarTelefono(Telefono telefono){
		Connection con = null;
		String sql= "INSERT INTO Telefono (tel_codigo,tel_numero,tel_tipo,tel_operadora,usu_cedula)"
				+ "VALUES (?,?,?,?,?);";
		try {
			con = ConexionBD.getConnection();
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, telefono.getCodigo());
			ps.setString(2, telefono.getNumero());
			ps.setString(3, telefono.getTipo());
			ps.setString(4, telefono.getOperadora());
			ps.setString(5, telefono.getCedula());
			ps.executeUpdate();
			con.close();
			System.out.println("entratelefono");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}