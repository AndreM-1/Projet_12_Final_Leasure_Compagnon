
package com.leasurecompagnon.appliweb.model.exception;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-07T16:08:15.473+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getSaisonFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class GetSaisonFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2227046989493576525L;
	private GetSaisonFault getSaisonFault;

    public GetSaisonFault_Exception() {
        super();
    }

    public GetSaisonFault_Exception(String message) {
        super(message);
    }

    public GetSaisonFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetSaisonFault_Exception(String message, GetSaisonFault getSaisonFault) {
        super(message);
        this.getSaisonFault = getSaisonFault;
    }

    public GetSaisonFault_Exception(String message, GetSaisonFault getSaisonFault, java.lang.Throwable cause) {
        super(message, cause);
        this.getSaisonFault = getSaisonFault;
    }

    public GetSaisonFault getFaultInfo() {
        return this.getSaisonFault;
    }
}
