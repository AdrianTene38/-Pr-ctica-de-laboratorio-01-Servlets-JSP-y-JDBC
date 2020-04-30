package ec.edu.ups.Modelo;

import java.io.Serializable;

public class Telefono implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigo;
	private String numero;
	private String tipo;
	private String operadora;
	
	public Telefono(){
		
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
 
}
