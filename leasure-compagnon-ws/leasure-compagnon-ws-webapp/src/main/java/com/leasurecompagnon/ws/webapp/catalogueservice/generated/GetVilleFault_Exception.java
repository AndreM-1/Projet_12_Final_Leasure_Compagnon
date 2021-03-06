
package com.leasurecompagnon.ws.webapp.catalogueservice.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-02-26T11:50:23.242+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getVilleFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class GetVilleFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 684388777446740722L;
	private GetVilleFault getVilleFault;

    public GetVilleFault_Exception() {
        super();
    }

    public GetVilleFault_Exception(String message) {
        super(message);
    }

    public GetVilleFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetVilleFault_Exception(String message, GetVilleFault getVilleFault) {
        super(message);
        this.getVilleFault = getVilleFault;
    }

    public GetVilleFault_Exception(String message, GetVilleFault getVilleFault, java.lang.Throwable cause) {
        super(message, cause);
        this.getVilleFault = getVilleFault;
    }

    public GetVilleFault getFaultInfo() {
        return this.getVilleFault;
    }
}
