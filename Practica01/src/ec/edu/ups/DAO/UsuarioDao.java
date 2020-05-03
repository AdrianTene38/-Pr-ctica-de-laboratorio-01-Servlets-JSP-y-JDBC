package ec.edu.ups.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ec.edu.ups.Controlador.ConexionBD;
import ec.edu.ups.Modelo.Persona;


public class UsuarioDao {
	private String cadena="";



	public UsuarioDao() {

	}
	public void insertarPersona(Persona persona){
		Connection con = null;
		String sql= "INSERT INTO Usuario (usu_cedula, usu_nombre, usu_apellido,usu_correo,usu_contra)"
				+ "VALUES (?,?,?,?,?);";
		try {
			con = ConexionBD.getConnection();
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, persona.getCedula());
			ps.setString(2, persona.getNombre());
			ps.setString(3, persona.getApellido());
			ps.setString(4, persona.getCorreo());
			ps.setString(5, persona.getContra());
			ps.executeUpdate();
			con.close();
			System.out.println("entra");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 public String login(String correo, String contra)throws SQLException {
		 try {
	         ConexionBD conexion = new ConexionBD();
	         ResultSet resultado = conexion.consultar("SELECT usu_cedula FROM usuario WHERE usu_correo = '" + correo + "' and usu_contra = '" + contra + "'" );
	         resultado.last();
	         if (resultado.getRow() > 0){
	             // usuarioactual = new Usuario(resultado.getInt("idusuario"),usuario,resultado.getString("titular"),resultado.getString("identificacion"),resultado.getString("tipo_usuario"));
	             Persona usuarioactual = Persona.getInstance();
	             // System.out.println("ID: "+resultado.getString("idusuario"));
	              cadena=resultado.getString("usu_cedula");                                  
	             usuarioactual.setCedula(resultado.getString("usu_cedula"));
	              System.out.println(cadena);
	             return cadena;
	        }
	   } catch (SQLException e) {
	            e.printStackTrace();
	            cadena="";
	            return cadena;
	        }
		  cadena="";
	      return cadena;
	   }
}