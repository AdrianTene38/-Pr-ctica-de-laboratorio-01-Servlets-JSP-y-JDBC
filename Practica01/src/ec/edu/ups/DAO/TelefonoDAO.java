package ec.edu.ups.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import ec.edu.ups.Controlador.ConexionBD;
import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Modelo.Telefono;

public class TelefonoDAO {
	UsuarioDao usudao;
	private PreparedStatement psentencia = null;
	ConexionBD conexion;
	Connection con = null;
	//con es conexion	private Conexion con;
	private Connection connection;

	Telefono telefono;
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




	public void eliminar(int numero) throws Exception{
		System.out.println("PREVIAAAA");	

		PreparedStatement ps = null;
		telefono=Telefono.getInstance();
		try {
			if (numero!= 0) {
				numero=telefono.getCodigo();
				System.out.println("LLEGA A ELIMINAR"+numero);
				con = 	ConexionBD.getConnection();
				String sql = "DELETE FROM Telefono WHERE tel_codigo="+ numero +";";
				ps = con.prepareStatement(sql);;
				ps.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	} 
	public Telefono obtenerPorId(int id) throws SQLException  {
		Telefono telactual = new Telefono();
		System.out.println("ven por qui por favor");
		try {
			con = ConexionBD.getConnection();

			PreparedStatement ps= con.prepareStatement("SELECT tel_codigo,tel_numero,tel_tipo,tel_operadora FROM telefono WHERE tel_codigo = '"  + id + "'"   );	
			ResultSet res =ps.executeQuery();
			if (res.next()) {
				telactual = new Telefono(res.getInt("tel_codigo"), res.getString("tel_numero"), res.getString("tel_tipo"),
						res.getString("tel_operadora"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		con.close();
		return telactual;
	}


	public boolean actualizar(Telefono telefono,int codigo) {
		System.out.println("entraactualiza"+telefono.getCodigo());
		Persona usuarioactual = Persona.getInstance();

		codigo=telefono.getCodigo();
		boolean rpta = false;
		PreparedStatement ps = null;
		try {

			con = ConexionBD.getConnection();
			String sql = "UPDATE Telefono SET tel_codigo=?,tel_numero=?,tel_tipo=?, tel_operadora=?  WHERE tel_codigo="+ codigo+";"; 
			ps = con.prepareStatement(sql);
			ps.setInt(1,telefono.getCodigo());
			ps.setString(2,telefono.getNumero());
			ps.setString(3,telefono.getTipo());
			ps.setString(4,telefono.getOperadora());
			rpta = ps.executeUpdate() > 0;
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rpta;

	} 

	public boolean actualizar1(Telefono telefono) throws SQLException {
		boolean rowActualizar = false;
		con = ConexionBD.getConnection();
		String sql = "UPDATE Telefono SET tel_codigo=?,tel_numero=?,tel_tipo=?, tel_operadora=? WHERE tel_codigo=?;";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, telefono.getCodigo());
		statement.setString(2, telefono.getNumero());
		statement.setString(3, telefono.getTipo());
		statement.setString(4, telefono.getOperadora());		
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.close();
		return rowActualizar;
	}



	public ArrayList<Telefono> Busca(int codigo){
		ArrayList<Telefono> telefonos= new ArrayList<Telefono>();  
		try {

			con = ConexionBD.getConnection();
			PreparedStatement ps= con.prepareStatement("SELECT tel_codigo,tel_tipo,tel_numero,tel_operadora FROM telefono WHERE tel_codigo = '" + codigo + "'"    );	
			ResultSet resultado =ps.executeQuery();
			//ResultSet resultado = conexion.consultar("SELECT tel_codigo,tel_tipo,tel_numero,tel_operadora FROM telefono "  );

			while (resultado.next()) { 
				Telefono telefonoac = new Telefono();
				int codigo1 = resultado.getInt("tel_codigo");
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

		}
		return telefonos;

	}





	public ArrayList<Telefono> BuscaTel(String cedula){
		ArrayList<Telefono> telefonos= new ArrayList<Telefono>();  
		try {

			con = ConexionBD.getConnection();
			PreparedStatement ps= con.prepareStatement("SELECT tel_numero,tel_tipo,tel_operadora FROM telefono WHERE usu_cedula = '" + cedula + "'"    );	
			ResultSet resultado =ps.executeQuery();
			//ResultSet resultado = conexion.consultar("SELECT tel_codigo,tel_tipo,tel_numero,tel_operadora FROM telefono "  );
			while (resultado.next()) { 
				Telefono telefonoac = new Telefono();	
				String tipo = resultado.getString("tel_tipo");
				String numero=resultado.getString("tel_numero");
				String operadora = resultado.getString("tel_operadora");	
				telefonoac.setTipo(tipo);
				telefonoac.setNumero(numero);
				telefonoac.setOperadora(operadora);
				telefonos.add(telefonoac);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return telefonos;
	}

	public ArrayList<Persona> BuscaUsu(String cedula){
		ArrayList<Persona> personas= new ArrayList<Persona>();  
		try {

			con = ConexionBD.getConnection();
			PreparedStatement ps= con.prepareStatement("SELECT usu_nombre,usu_apellido FROM Usuario WHERE usu_cedula = '" + cedula + "'"    );	
			ResultSet resultado =ps.executeQuery();
			//ResultSet resultado = conexion.consultar("SELECT tel_codigo,tel_tipo,tel_numero,tel_operadora FROM telefono "  );
			while (resultado.next()) { 
				Persona persona = new Persona();	
				String nombre = resultado.getString("usu_nombre");
				String apellido=resultado.getString("usu_apellido");
				persona.setNombre(nombre);
				persona.setApellido(apellido);
				
				personas.add(persona);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return personas;
	}
	
	
	
	
}








