package ec.edu.ups.appdis.g1.lojaandressrijee;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2021-02-05T12:47:59.825-05:00
 * Generated source version: 2.7.18
 * 
 */
@WebService(targetNamespace = "http://LojaAndresSRIJEE.g1.appdis.ups.edu.ec/", name = "AceptarFactura")
@XmlSeeAlso({ObjectFactory.class})
public interface AceptarFactura {

    @WebMethod
    @RequestWrapper(localName = "facturalo", targetNamespace = "http://LojaAndresSRIJEE.g1.appdis.ups.edu.ec/", className = "ec.edu.ups.appdis.g1.lojaandressrijee.Facturalo")
    @ResponseWrapper(localName = "facturaloResponse", targetNamespace = "http://LojaAndresSRIJEE.g1.appdis.ups.edu.ec/", className = "ec.edu.ups.appdis.g1.lojaandressrijee.FacturaloResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String facturalo(
        @WebParam(name = "arg0", targetNamespace = "")
        ec.edu.ups.appdis.g1.lojaandressrijee.Datos arg0
    );
}