package ec.edu.ups.appdis.g1.LojaAndresSRIJEE;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.appdis.g1.molar.datos;

@WebService
public class AceptarFactura {
	@WebMethod
	public String facturalo (datos m) {
		String facturas="Cedula "+m.getCelular()+"Numero factura "+m.getFactura()+"valor"+m.getFactura();
		return facturas;
	}
}
