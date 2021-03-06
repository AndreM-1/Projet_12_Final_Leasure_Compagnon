
package com.leasurecompagnon.appliweb.model.exception;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-07T16:08:15.675+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getListActiviteRechercheFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class GetListActiviteRechercheFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3928302166217102626L;
	private GetListActiviteRechercheFault getListActiviteRechercheFault;

    public GetListActiviteRechercheFault_Exception() {
        super();
    }

    public GetListActiviteRechercheFault_Exception(String message) {
        super(message);
    }

    public GetListActiviteRechercheFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetListActiviteRechercheFault_Exception(String message, GetListActiviteRechercheFault getListActiviteRechercheFault) {
        super(message);
        this.getListActiviteRechercheFault = getListActiviteRechercheFault;
    }

    public GetListActiviteRechercheFault_Exception(String message, GetListActiviteRechercheFault getListActiviteRechercheFault, java.lang.Throwable cause) {
        super(message, cause);
        this.getListActiviteRechercheFault = getListActiviteRechercheFault;
    }

    public GetListActiviteRechercheFault getFaultInfo() {
        return this.getListActiviteRechercheFault;
    }
}
