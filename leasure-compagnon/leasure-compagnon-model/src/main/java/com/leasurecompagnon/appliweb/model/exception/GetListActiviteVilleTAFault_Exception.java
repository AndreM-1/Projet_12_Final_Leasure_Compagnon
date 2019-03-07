
package com.leasurecompagnon.appliweb.model.exception;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-07T16:08:15.660+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getListActiviteVilleTAFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class GetListActiviteVilleTAFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7891524762394720004L;
	private GetListActiviteVilleTAFault getListActiviteVilleTAFault;

    public GetListActiviteVilleTAFault_Exception() {
        super();
    }

    public GetListActiviteVilleTAFault_Exception(String message) {
        super(message);
    }

    public GetListActiviteVilleTAFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetListActiviteVilleTAFault_Exception(String message, GetListActiviteVilleTAFault getListActiviteVilleTAFault) {
        super(message);
        this.getListActiviteVilleTAFault = getListActiviteVilleTAFault;
    }

    public GetListActiviteVilleTAFault_Exception(String message, GetListActiviteVilleTAFault getListActiviteVilleTAFault, java.lang.Throwable cause) {
        super(message, cause);
        this.getListActiviteVilleTAFault = getListActiviteVilleTAFault;
    }

    public GetListActiviteVilleTAFault getFaultInfo() {
        return this.getListActiviteVilleTAFault;
    }
}