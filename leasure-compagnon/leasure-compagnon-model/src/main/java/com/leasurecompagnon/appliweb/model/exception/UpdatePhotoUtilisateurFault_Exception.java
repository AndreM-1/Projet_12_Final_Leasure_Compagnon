
package com.leasurecompagnon.appliweb.model.exception;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-07T16:08:17.279+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "updatePhotoUtilisateurFault", targetNamespace = "http://www.example.org/UtilisateurService/")
public class UpdatePhotoUtilisateurFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -182532872333707087L;
	private UpdatePhotoUtilisateurFault updatePhotoUtilisateurFault;

    public UpdatePhotoUtilisateurFault_Exception() {
        super();
    }

    public UpdatePhotoUtilisateurFault_Exception(String message) {
        super(message);
    }

    public UpdatePhotoUtilisateurFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public UpdatePhotoUtilisateurFault_Exception(String message, UpdatePhotoUtilisateurFault updatePhotoUtilisateurFault) {
        super(message);
        this.updatePhotoUtilisateurFault = updatePhotoUtilisateurFault;
    }

    public UpdatePhotoUtilisateurFault_Exception(String message, UpdatePhotoUtilisateurFault updatePhotoUtilisateurFault, java.lang.Throwable cause) {
        super(message, cause);
        this.updatePhotoUtilisateurFault = updatePhotoUtilisateurFault;
    }

    public UpdatePhotoUtilisateurFault getFaultInfo() {
        return this.updatePhotoUtilisateurFault;
    }
}