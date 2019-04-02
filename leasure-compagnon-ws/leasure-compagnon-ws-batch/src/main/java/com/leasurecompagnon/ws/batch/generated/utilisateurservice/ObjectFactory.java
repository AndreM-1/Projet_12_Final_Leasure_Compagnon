
package com.leasurecompagnon.ws.batch.generated.utilisateurservice;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.utilisateurservice package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.utilisateurservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetListUtilisateur }
     * 
     */
    public GetListUtilisateur createGetListUtilisateur() {
        return new GetListUtilisateur();
    }

    /**
     * Create an instance of {@link GetListUtilisateurResponse }
     * 
     */
    public GetListUtilisateurResponse createGetListUtilisateurResponse() {
        return new GetListUtilisateurResponse();
    }

    /**
     * Create an instance of {@link GetListUtilisateurFault }
     * 
     */
    public GetListUtilisateurFault createGetListUtilisateurFault() {
        return new GetListUtilisateurFault();
    }

}
