
package com.leasurecompagnon.ws.webapp.utilisateurservice.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-02-26T11:50:24.897+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "updateCoordUtilisateurFault", targetNamespace = "http://www.example.org/UtilisateurService/")
public class UpdateCoordUtilisateurFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3202565539597166798L;
	private UpdateCoordUtilisateurFault updateCoordUtilisateurFault;

    public UpdateCoordUtilisateurFault_Exception() {
        super();
    }

    public UpdateCoordUtilisateurFault_Exception(String message) {
        super(message);
    }

    public UpdateCoordUtilisateurFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public UpdateCoordUtilisateurFault_Exception(String message, UpdateCoordUtilisateurFault updateCoordUtilisateurFault) {
        super(message);
        this.updateCoordUtilisateurFault = updateCoordUtilisateurFault;
    }

    public UpdateCoordUtilisateurFault_Exception(String message, UpdateCoordUtilisateurFault updateCoordUtilisateurFault, java.lang.Throwable cause) {
        super(message, cause);
        this.updateCoordUtilisateurFault = updateCoordUtilisateurFault;
    }

    public UpdateCoordUtilisateurFault getFaultInfo() {
        return this.updateCoordUtilisateurFault;
    }
}
