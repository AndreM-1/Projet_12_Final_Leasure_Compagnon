package com.leasurecompagnon.ws.batch.generated.catalogueservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.leasurecompagnon.ws.model.bean.catalogue.Activite;

/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-04-01T10:25:16.885+02:00
 * Generated source version: 3.2.5
 *
 */
@WebService(targetNamespace = "http://www.example.org/CatalogueService/", name = "CatalogueService")
@XmlSeeAlso({ObjectFactory.class, com.leasurecompagnon.ws.model.bean.objectfactory.ObjectFactory.class})
public interface CatalogueService {

    @WebMethod
    @RequestWrapper(localName = "getListActivite", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListActivite")
    @ResponseWrapper(localName = "getListActiviteResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListActiviteResponse")
    @WebResult(name = "activite", targetNamespace = "")
    public java.util.List<Activite> getListActivite(
        @WebParam(name = "nbActivite", targetNamespace = "")
        int nbActivite,
        @WebParam(name = "statutActivite", targetNamespace = "")
        java.lang.String statutActivite
    ) throws GetListActiviteFault_Exception;


    @WebMethod
    @RequestWrapper(localName = "deleteActivite", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.DeleteActivite")
    @ResponseWrapper(localName = "deleteActiviteResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.DeleteActiviteResponse")
    public void deleteActivite(
        @WebParam(name = "activiteId", targetNamespace = "")
        int activiteId
    ) throws DeleteActiviteFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "updateStatutActivite", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.UpdateStatutActivite")
    @ResponseWrapper(localName = "updateStatutActiviteResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.UpdateStatutActiviteResponse")
    public void updateStatutActivite(
        @WebParam(name = "activiteId", targetNamespace = "")
        int activiteId,
        @WebParam(name = "statutActiviteId", targetNamespace = "")
        int statutActiviteId,
        @WebParam(name = "dateAModifier", targetNamespace = "")
        java.lang.String dateAModifier
    ) throws UpdateStatutActiviteFault_Exception; 
}