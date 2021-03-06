
package com.leasurecompagnon.appliweb.model.exception;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-07T16:08:15.389+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getDureeFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class GetDureeFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8265660603948410389L;
	private GetDureeFault getDureeFault;

    public GetDureeFault_Exception() {
        super();
    }

    public GetDureeFault_Exception(String message) {
        super(message);
    }

    public GetDureeFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetDureeFault_Exception(String message, GetDureeFault getDureeFault) {
        super(message);
        this.getDureeFault = getDureeFault;
    }

    public GetDureeFault_Exception(String message, GetDureeFault getDureeFault, java.lang.Throwable cause) {
        super(message, cause);
        this.getDureeFault = getDureeFault;
    }

    public GetDureeFault getFaultInfo() {
        return this.getDureeFault;
    }
}
