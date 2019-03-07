
package com.leasurecompagnon.appliweb.model.exception;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-07T16:08:15.705+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getListActiviteUtilisateurFault", targetNamespace = "http://www.example.org/CatalogueService/")
public class GetListActiviteUtilisateurFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1295580511518187074L;
	private GetListActiviteUtilisateurFault getListActiviteUtilisateurFault;

    public GetListActiviteUtilisateurFault_Exception() {
        super();
    }

    public GetListActiviteUtilisateurFault_Exception(String message) {
        super(message);
    }

    public GetListActiviteUtilisateurFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetListActiviteUtilisateurFault_Exception(String message, GetListActiviteUtilisateurFault getListActiviteUtilisateurFault) {
        super(message);
        this.getListActiviteUtilisateurFault = getListActiviteUtilisateurFault;
    }

    public GetListActiviteUtilisateurFault_Exception(String message, GetListActiviteUtilisateurFault getListActiviteUtilisateurFault, java.lang.Throwable cause) {
        super(message, cause);
        this.getListActiviteUtilisateurFault = getListActiviteUtilisateurFault;
    }

    public GetListActiviteUtilisateurFault getFaultInfo() {
        return this.getListActiviteUtilisateurFault;
    }
}