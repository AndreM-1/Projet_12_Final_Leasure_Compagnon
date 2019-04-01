
package com.leasurecompagnon.ws.batch.generated.catalogueservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-04-01T10:25:16.270+02:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getListActiviteFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class GetListActiviteFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7687847810254946135L;
	private GetListActiviteFault getListActiviteFault;

    public GetListActiviteFault_Exception() {
        super();
    }

    public GetListActiviteFault_Exception(String message) {
        super(message);
    }

    public GetListActiviteFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetListActiviteFault_Exception(String message, GetListActiviteFault getListActiviteFault) {
        super(message);
        this.getListActiviteFault = getListActiviteFault;
    }

    public GetListActiviteFault_Exception(String message, GetListActiviteFault getListActiviteFault, java.lang.Throwable cause) {
        super(message, cause);
        this.getListActiviteFault = getListActiviteFault;
    }

    public GetListActiviteFault getFaultInfo() {
        return this.getListActiviteFault;
    }
}