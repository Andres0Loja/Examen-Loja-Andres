package ec.edu.ups.appdis.g1.operadora;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class AceptarRecarga {
	@WebMethod
	public int deposito() {
		Random r = new Random();
		int valorDado = r.nextInt(6)+1;
		return valorDado;
	}
}
