
package com.leasurecompagnon.appliweb.model.exception;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-07T16:08:16.388+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "getListFormulaireContactFault", targetNamespace = "http://www.example.org/FormulaireContactService/")
public class GetListFormulaireContactFault_Exception extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5009665842310111541L;
	private GetListFormulaireContactFault getListFormulaireContactFault;

    public GetListFormulaireContactFault_Exception() {
        super();
    }

    public GetListFormulaireContactFault_Exception(String message) {
        super(message);
    }

    public GetListFormulaireContactFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetListFormulaireContactFault_Exception(String message, GetListFormulaireContactFault getListFormulaireContactFault) {
        super(message);
        this.getListFormulaireContactFault = getListFormulaireContactFault;
    }

    public GetListFormulaireContactFault_Exception(String message, GetListFormulaireContactFault getListFormulaireContactFault, java.lang.Throwable cause) {
        super(message, cause);
        this.getListFormulaireContactFault = getListFormulaireContactFault;
    }

    public GetListFormulaireContactFault getFaultInfo() {
        return this.getListFormulaireContactFault;
    }
}