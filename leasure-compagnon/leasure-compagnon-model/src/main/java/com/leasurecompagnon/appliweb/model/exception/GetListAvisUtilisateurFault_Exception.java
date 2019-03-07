
package com.leasurecompagnon.appliweb.model.exception;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-07T16:08:15.358+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getListAvisUtilisateurFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class GetListAvisUtilisateurFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 216972300150573436L;
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