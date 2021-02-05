package ec.edu.ups.appdis.g1.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	private String cedula;
	private String nombre;
	private String celular;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
	private List<Cuenta> cuenta=new ArrayList<Cuenta>();
	
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
	public List<Cuenta> getCuenta() {
		return cuenta;
	}
	public void setCuenta(List<Cuenta> cuenta) {
		this.cuenta = cuenta;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}
