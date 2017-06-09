
package com.xhsmart.ssmcxf.client_ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.xhsmart.ssmcxf.client_ws package. 
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

    private final static QName _SaveIks_QNAME = new QName("http://ws.ssmcxf.xhsmart.com/", "saveIks");
    private final static QName _SaveIksResponse_QNAME = new QName("http://ws.ssmcxf.xhsmart.com/", "saveIksResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.xhsmart.ssmcxf.client_ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaveIks }
     * 
     */
    public SaveIks createSaveIks() {
        return new SaveIks();
    }

    /**
     * Create an instance of {@link SaveIksResponse }
     * 
     */
    public SaveIksResponse createSaveIksResponse() {
        return new SaveIksResponse();
    }

    /**
     * Create an instance of {@link Ik }
     * 
     */
    public Ik createIk() {
        return new Ik();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveIks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ssmcxf.xhsmart.com/", name = "saveIks")
    public JAXBElement<SaveIks> createSaveIks(SaveIks value) {
        return new JAXBElement<SaveIks>(_SaveIks_QNAME, SaveIks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveIksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ssmcxf.xhsmart.com/", name = "saveIksResponse")
    public JAXBElement<SaveIksResponse> createSaveIksResponse(SaveIksResponse value) {
        return new JAXBElement<SaveIksResponse>(_SaveIksResponse_QNAME, SaveIksResponse.class, null, value);
    }

}
