
package com.leasurecompagnon.ws.webapp.catalogueservice.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-02-26T11:50:23.583+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getListNomActiviteFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class GetListNomActiviteFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2754200314402650591L;
	private GetListNomActiviteFault getListNomActiviteFault;

    public GetListNomActiviteFault_Exception() {
        super();
    }

    public GetListNomActiviteFault_Exception(String message) {
        super(message);
    }

    public GetListNomActiviteFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetListNomActiviteFault_Exception(String message, GetListNomActiviteFault getListNomActiviteFault) {
        super(message);
        this.getListNomActiviteFault = getListNomActiviteFault;
    }

    public GetListNomActiviteFault_Exception(String message, GetListNomActiviteFault getListNomActiviteFault, java.lang.Throwable cause) {
        super(message, cause);
        this.getListNomActiviteFault = getListNomActiviteFault;
    }

    public GetListNomActiviteFault getFaultInfo() {
        return this.getListNomActiviteFault;
    }
}
