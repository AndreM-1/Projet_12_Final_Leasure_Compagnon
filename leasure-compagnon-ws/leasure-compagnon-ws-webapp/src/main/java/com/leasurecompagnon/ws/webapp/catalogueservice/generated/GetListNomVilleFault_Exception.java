
package com.leasurecompagnon.ws.webapp.catalogueservice.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-02-26T11:50:23.371+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getListNomVilleFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class GetListNomVilleFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6121606019504261450L;
	private GetListNomVilleFault getListNomVilleFault;

    public GetListNomVilleFault_Exception() {
        super();
    }

    public GetListNomVilleFault_Exception(String message) {
        super(message);
    }

    public GetListNomVilleFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetListNomVilleFault_Exception(String message, GetListNomVilleFault getListNomVilleFault) {
        super(message);
        this.getListNomVilleFault = getListNomVilleFault;
    }

    public GetListNomVilleFault_Exception(String message, GetListNomVilleFault getListNomVilleFault, java.lang.Throwable cause) {
        super(message, cause);
        this.getListNomVilleFault = getListNomVilleFault;
    }

    public GetListNomVilleFault getFaultInfo() {
        return this.getListNomVilleFault;
    }
}
