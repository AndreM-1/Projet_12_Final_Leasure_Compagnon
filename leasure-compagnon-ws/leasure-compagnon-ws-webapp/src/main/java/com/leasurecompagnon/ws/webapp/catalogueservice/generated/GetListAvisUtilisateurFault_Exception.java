
package com.leasurecompagnon.ws.webapp.catalogueservice.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-02-26T11:50:23.463+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getListAvisUtilisateurFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class GetListAvisUtilisateurFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4047099367855766589L;
	private GetListAvisUtilisateurFault getListAvisUtilisateurFault;

    public GetListAvisUtilisateurFault_Exception() {
        super();
    }

    public GetListAvisUtilisateurFault_Exception(String message) {
        super(message);
    }

    public GetListAvisUtilisateurFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetListAvisUtilisateurFault_Exception(String message, GetListAvisUtilisateurFault getListAvisUtilisateurFault) {
        super(message);
        this.getListAvisUtilisateurFault = getListAvisUtilisateurFault;
    }

    public GetListAvisUtilisateurFault_Exception(String message, GetListAvisUtilisateurFault getListAvisUtilisateurFault, java.lang.Throwable cause) {
        super(message, cause);
        this.getListAvisUtilisateurFault = getListAvisUtilisateurFault;
    }

    public GetListAvisUtilisateurFault getFaultInfo() {
        return this.getListAvisUtilisateurFault;
    }
}
