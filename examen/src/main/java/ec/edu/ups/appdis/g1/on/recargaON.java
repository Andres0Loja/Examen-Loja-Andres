package ec.edu.ups.appdis.g1.on;

import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JOptionPane;
import javax.xml.namespace.QName;

import ec.edu.ups.appdis.g1.dao.CuentaDAO;
import ec.edu.ups.appdis.g1.dao.PersonaDAO;
import ec.edu.ups.appdis.g1.dao.TransaccionDAO;
import ec.edu.ups.appdis.g1.lojaandressrijee.AceptarFactura;
import ec.edu.ups.appdis.g1.lojaandressrijee.AceptarFacturaService;
import ec.edu.ups.appdis.g1.lojaandressrijee.Datos;
import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Transaccion;
import ec.edu.ups.appdis.g1.modelo.tempRecarga;
import ec.edu.ups.appdis.g1.operadora.AceptarRecarga;
import ec.edu.ups.appdis.g1.operadora.AceptarRecargaService;

public class recargaON {
	private static final QName SERVICE_NAME = new QName("http://operadora.g1.appdis.ups.edu.ec/", "AceptarRecargaService");
	private static final QName SERVICE_NAME2 = new QName("http://LojaAndresSRIJEE.g1.appdis.ups.edu.ec/", "AceptarFacturaService");
	@Inject
	private CuentaDAO daoCuenta;
	@Inject
	private PersonaDAO daoPersona;
	@Inject
	private TransaccionDAO daoTransaccion;
	Date date=new Date();
    public String numero(tempRecarga datos) throws Exception {
    	facturalo(datos);
    	String mensaje=null;
    	URL wsdlURL = AceptarRecargaService.WSDL_LOCATION;
    	AceptarRecargaService ss = new AceptarRecargaService(wsdlURL, SERVICE_NAME);
        AceptarRecarga port = ss.getAceptarRecargaPort();  
        int _deposito__return = port.deposito();
        if(_deposito__return<3) {
        	solicitar(datos);
        	System.out.println("Generado"+_deposito__return);
        	return mensaje="Se realizo la recarga";
        }else {
        	System.out.println("No generado"+_deposito__return);
        	return mensaje="No realizo la recarga";
        }
    }
	public void solicitar(tempRecarga datos) throws Exception {
		List<Persona> listPer=daoPersona.buscarPersona(datos.getIngreso());
		List<Cuenta>listCue=daoCuenta.buscarCuenta(Integer.parseInt(datos.getIngreso()));
		/*if(listPer.size()!=0 ) {
			Cuenta c=new Cuenta();
			int cuen=listPer.get(0).getCuenta().get(0).getIdCuenta();
			c.setIdCuenta(cuen);
			c.setMonto(datos.getValor());
			daoCuenta.updateJPA(c);
			
			
			
			
		}else */
		if(listCue.size()!=0) {
			Cuenta c=new Cuenta();
			int num=Integer.parseInt(datos.getIngreso());
			c.setIdCuenta(num);
			c.setPersona(null);
			double numd=datos.getValor();
			c.setMonto(numd);
			c.setPersona(listCue.get(0).getPersona());
			daoCuenta.updateJPA(c);
			Transaccion t=new Transaccion();
			t.setCelular(datos.getCelular());
			t.setFecha(date);
			t.setValor(datos.getValor()+"");
			daoTransaccion.insertJPA(t);
			
		}else {
			System.out.println("No encontrado");
		}
	}

	public void facturalo(tempRecarga datos) {
		URL wsdlURL = AceptarFacturaService.WSDL_LOCATION;
		AceptarFacturaService ss = new AceptarFacturaService(wsdlURL, SERVICE_NAME2);
        AceptarFactura port = ss.getAceptarFacturaPort();
        Datos d=new Datos();
        d.setCelular(datos.getCelular());
        d.setFactura("1");
        d.setValor(datos.getValor()+"");
        java.lang.String _facturalo__return = port.facturalo(d);
        System.out.println(_facturalo__return);
	}
}
