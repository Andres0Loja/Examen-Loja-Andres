package vista;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

import ec.edu.ups.appdis.g1.modelo.tempRecarga;
import ec.edu.ups.appdis.g1.on.recargaON;

@Named
@RequestScoped
public class RecargaBean {
	@Inject
	private recargaON ro;
	private String ingreso;
	private String celular;
	private String monto;
	private String mensaje;

	public RecargaBean() {
		init();
	}

	public void init() {
		ingreso = new String();
		monto = new String();
		celular = new String();
		mensaje= new String();
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getIngreso() {
		return ingreso;
	}

	public void setIngreso(String ingreso) {
		this.ingreso = ingreso;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void recarga() {
		tempRecarga temp=new tempRecarga();
		temp.setIngreso(ingreso);
		temp.setValor(Double.parseDouble(monto));
		temp.setCelular(celular);
		try {
			//ro.solicitar(temp);
			mensaje=ro.numero(temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
