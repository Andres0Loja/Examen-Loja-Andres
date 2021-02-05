
package ec.edu.ups.appdis.g1.lojaandressrijee;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.edu.ups.appdis.g1.lojaandressrijee package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FacturaloResponse_QNAME = new QName("http://LojaAndresSRIJEE.g1.appdis.ups.edu.ec/", "facturaloResponse");
    private final static QName _Facturalo_QNAME = new QName("http://LojaAndresSRIJEE.g1.appdis.ups.edu.ec/", "facturalo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.edu.ups.appdis.g1.lojaandressrijee
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FacturaloResponse }
     * 
     */
    public FacturaloResponse createFacturaloResponse() {
        return new FacturaloResponse();
    }

    /**
     * Create an instance of {@link Facturalo }
     * 
     */
    public Facturalo createFacturalo() {
        return new Facturalo();
    }

    /**
     * Create an instance of {@link Datos }
     * 
     */
    public Datos createDatos() {
        return new Datos();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FacturaloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://LojaAndresSRIJEE.g1.appdis.ups.edu.ec/", name = "facturaloResponse")
    public JAXBElement<FacturaloResponse> createFacturaloResponse(FacturaloResponse value) {
        return new JAXBElement<FacturaloResponse>(_FacturaloResponse_QNAME, FacturaloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Facturalo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://LojaAndresSRIJEE.g1.appdis.ups.edu.ec/", name = "facturalo")
    public JAXBElement<Facturalo> createFacturalo(Facturalo value) {
        return new JAXBElement<Facturalo>(_Facturalo_QNAME, Facturalo.class, null, value);
    }

}
