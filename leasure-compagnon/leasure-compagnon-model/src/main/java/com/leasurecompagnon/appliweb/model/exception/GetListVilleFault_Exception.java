
package com.leasurecompagnon.appliweb.model.exception;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-07T16:08:15.448+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getListVilleFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class GetListVilleFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8137830342376966451L;
	private GetListVilleFault getListVilleFault;

    public GetListVilleFault_Exception() {
        super();
    }

    public GetListVilleFault_Exception(String message) {
        super(message);
    }

    public GetListVilleFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetListVilleFault_Exception(String message, GetListVilleFault getListVilleFault) {
        super(message);
        this.getListVilleFault = getListVilleFault;
    }

    public GetListVilleFault_Exception(String message, GetListVilleFault getListVilleFault, java.lang.Throwable cause) {
        super(message, cause);
        this.getListVilleFault = getListVilleFault;
    }

    public GetListVilleFault getFaultInfo() {
        return this.getListVilleFault;
    }
}
