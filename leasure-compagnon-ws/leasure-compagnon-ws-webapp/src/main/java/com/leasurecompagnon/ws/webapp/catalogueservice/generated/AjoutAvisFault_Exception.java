
package com.leasurecompagnon.ws.webapp.catalogueservice.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-20T16:31:04.654+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "ajoutAvisFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class AjoutAvisFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6807955476609619794L;
	private AjoutAvisFault ajoutAvisFault;

    public AjoutAvisFault_Exception() {
        super();
    }

    public AjoutAvisFault_Exception(String message) {
        super(message);
    }

    public AjoutAvisFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public AjoutAvisFault_Exception(String message, AjoutAvisFault ajoutAvisFault) {
        super(message);
        this.ajoutAvisFault = ajoutAvisFault;
    }

    public AjoutAvisFault_Exception(String message, AjoutAvisFault ajoutAvisFault, java.lang.Throwable cause) {
        super(message, cause);
        this.ajoutAvisFault = ajoutAvisFault;
    }

    public AjoutAvisFault getFaultInfo() {
        return this.ajoutAvisFault;
    }
}
