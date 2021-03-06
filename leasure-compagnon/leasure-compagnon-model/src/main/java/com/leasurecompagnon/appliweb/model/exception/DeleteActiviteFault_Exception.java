
package com.leasurecompagnon.appliweb.model.exception;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-27T13:49:10.703+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "deleteActiviteFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class DeleteActiviteFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3835268575124598032L;
	private DeleteActiviteFault deleteActiviteFault;

    public DeleteActiviteFault_Exception() {
        super();
    }

    public DeleteActiviteFault_Exception(String message) {
        super(message);
    }

    public DeleteActiviteFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public DeleteActiviteFault_Exception(String message, DeleteActiviteFault deleteActiviteFault) {
        super(message);
        this.deleteActiviteFault = deleteActiviteFault;
    }

    public DeleteActiviteFault_Exception(String message, DeleteActiviteFault deleteActiviteFault, java.lang.Throwable cause) {
        super(message, cause);
        this.deleteActiviteFault = deleteActiviteFault;
    }

    public DeleteActiviteFault getFaultInfo() {
        return this.deleteActiviteFault;
    }
}
