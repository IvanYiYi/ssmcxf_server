
package com.xhsmart.ssmcxf.client_ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CXFService", targetNamespace = "http://ws.ssmcxf.xhsmart.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CXFService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "saveIks", targetNamespace = "http://ws.ssmcxf.xhsmart.com/", className = "com.xhsmart.ssmcxf.client_ws.SaveIks")
    @ResponseWrapper(localName = "saveIksResponse", targetNamespace = "http://ws.ssmcxf.xhsmart.com/", className = "com.xhsmart.ssmcxf.client_ws.SaveIksResponse")
    public String saveIks(
        @WebParam(name = "arg0", targetNamespace = "")
        List<Ik> arg0);

}
