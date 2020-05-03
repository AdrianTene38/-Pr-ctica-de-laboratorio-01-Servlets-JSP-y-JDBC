package ec.edu.ups.Modelo;

import java.io.Serializable;

public class Telefono implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigo;
	private String numero;
	private String tipo;
	private String operadora;
	private String cedula;
	private static Telefono instance;
	public Telefono(int codigo, String numero, String tipo, String operadora, String cedula) {
		super();
		this.codigo = codigo;
		this.numero = numero;
		this.tipo = tipo;
		this.operadora = operadora;
		this.cedula = cedula;
	}
	
	
	
	



	public Telefono(){
		
	}
	
	
	
	public Telefono(int codigo, String numero, String tipo, String operadora) {
		// TODO Auto-generated constructor stub
	
		this.codigo = codigo;
		this.numero = numero;
		this.tipo = tipo;
		this.operadora = operadora;
	}







	public String getCedula() {
		return cedula;
	}



	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static Telefono getInstance() {
		if (instance == null)
			instance = new Telefono();
		return instance;
	}

}
