package ec.edu.ups.Modelo;

import java.io.Serializable;

public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cedula ;
	private String nombre;
	private String apellido;
	private String correo;
	private String contra;
	private static Persona instance;

	public Persona(String cedula, String nombre, String apellido, String correo, String contra) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contra = contra;
	}




	public Persona() {
		// TODO Auto-generated constructor stub
	}




	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static Persona getInstance() {
		if (instance == null)
			instance = new Persona();
		return instance;
	}
}
