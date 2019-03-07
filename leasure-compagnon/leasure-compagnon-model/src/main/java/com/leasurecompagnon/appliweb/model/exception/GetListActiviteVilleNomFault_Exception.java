
package com.leasurecompagnon.appliweb.model.exception;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-07T16:08:15.425+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getListActiviteVilleNomFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class GetListActiviteVilleNomFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6689842439184206095L;
	private GetListActiviteVilleNomFault getListActiviteVilleNomFault;

    public GetListActiviteVilleNomFault_Exception() {
        super();
    }

    public GetListActiviteVilleNomFault_Exception(String message) {
        super(message);
    }

    public GetListActiviteVilleNomFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetListActiviteVilleNomFault_Exception(String message, GetListActiviteVilleNomFault getListActiviteVilleNomFault) {
        super(message);
        this.getListActiviteVilleNomFault = getListActiviteVilleNomFault;
    }

    public GetListActiviteVilleNomFault_Exception(String message, GetListActiviteVilleNomFault getListActiviteVilleNomFault, java.lang.Throwable cause) {
        super(message, cause);
        this.getListActiviteVilleNomFault = getListActiviteVilleNomFault;
    }

    public GetListActiviteVilleNomFault getFaultInfo() {
        return this.getListActiviteVilleNomFault;
    }
}