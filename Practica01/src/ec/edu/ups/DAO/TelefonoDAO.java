package ec.edu.ups.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import ec.edu.ups.Controlador.ConexionBD;
import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Modelo.Telefono;

public class TelefonoDAO {
	UsuarioDao usudao;
	ConexionBD conexion;
	Connection con = null;

	public TelefonoDAO() {

	}

	public void insertarTelefono(Telefono telefono){

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


	public ArrayList<Telefono> listarTelefonos(String cedula){

		ArrayList<Telefono> telefonos= new ArrayList<Telefono>();  
		try {
			Persona usuarioactual = Persona.getInstance();
			cedula= usuarioactual.getCedula();

			con = ConexionBD.getConnection();
			PreparedStatement ps= con.prepareStatement("SELECT tel_codigo,tel_tipo,tel_numero,tel_operadora FROM telefono WHERE usu_cedula = '" + cedula + "'"    );	
			ResultSet resultado =ps.executeQuery();
			//ResultSet resultado = conexion.consultar("SELECT tel_codigo,tel_tipo,tel_numero,tel_operadora FROM telefono "  );

			while (resultado.next()) { 
				System.out.println("aquimao");
				Telefono telefonoac = new Telefono();
				int codigo = resultado.getInt("tel_codigo");
				String tipo = resultado.getString("tel_tipo");
				String numero=resultado.getString("tel_numero");
				String operadora = resultado.getString("tel_operadora");	
				telefonoac.setCodigo(codigo);
				telefonoac.setTipo(tipo);
				telefonoac.setNumero(numero);
				telefonoac.setOperadora(operadora);
				telefonos.add(telefonoac);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("asdasdasd");

		}
		return telefonos;

	}




public boolean eliminar(Telefono telefono) throws SQLException {
	boolean rowEliminar = false;
	con = ConexionBD.getConnection();
	PreparedStatement ps= con.prepareStatement("DELETE FROM articulos WHERE ID=?"   );	
	rowEliminar = ps.executeUpdate() > 0;
	con.close();
	return rowEliminar;
}

}




