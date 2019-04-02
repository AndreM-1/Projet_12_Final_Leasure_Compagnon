package com.leasurecompagnon.ws.webapp.utilisateurservice.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;

/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-04-02T08:59:10.306+02:00
 * Generated source version: 3.2.5
 *
 */
@WebService(targetNamespace = "http://www.example.org/UtilisateurService/", name = "UtilisateurService")
@XmlSeeAlso({ObjectFactory.class, com.leasurecompagnon.ws.model.bean.objectfactory.ObjectFactory.class})
public interface UtilisateurService {

    @WebMethod
    @RequestWrapper(localName = "creerCompteUtilisateur", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.CreerCompteUtilisateur")
    @ResponseWrapper(localName = "creerCompteUtilisateurResponse", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.CreerCompteUtilisateurResponse")
    @WebResult(name = "utilisateur", targetNamespace = "")
    public Utilisateur creerCompteUtilisateur(
        @WebParam(name = "civilite", targetNamespace = "")
        java.lang.String civilite,
        @WebParam(name = "nom", targetNamespace = "")
        java.lang.String nom,
        @WebParam(name = "prenom", targetNamespace = "")
        java.lang.String prenom,
        @WebParam(name = "pseudo", targetNamespace = "")
        java.lang.String pseudo,
        @WebParam(name = "adresseMail", targetNamespace = "")
        java.lang.String adresseMail,
        @WebParam(name = "motDePasse", targetNamespace = "")
        java.lang.String motDePasse,
        @WebParam(name = "confirmationMotDePasse", targetNamespace = "")
        java.lang.String confirmationMotDePasse,
        @WebParam(name = "conditionsUtilisation", targetNamespace = "")
        boolean conditionsUtilisation
    ) throws CreerCompteUtilisateurFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListUtilisateur", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.GetListUtilisateur")
    @ResponseWrapper(localName = "getListUtilisateurResponse", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.GetListUtilisateurResponse")
    @WebResult(name = "utilisateur", targetNamespace = "")
    public java.util.List<Utilisateur> getListUtilisateur(
        @WebParam(name = "optEnvoiMailInformatif", targetNamespace = "")
        java.lang.String optEnvoiMailInformatif
    ) throws GetListUtilisateurFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "updatePhotoUtilisateur", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.UpdatePhotoUtilisateur")
    @ResponseWrapper(localName = "updatePhotoUtilisateurResponse", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.UpdatePhotoUtilisateurResponse")
    public void updatePhotoUtilisateur(
        @WebParam(name = "nomPhoto", targetNamespace = "")
        java.lang.String nomPhoto,
        @WebParam(name = "utilisateurId", targetNamespace = "")
        int utilisateurId
    ) throws UpdatePhotoUtilisateurFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "updateMdpUtilisateur", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.UpdateMdpUtilisateur")
    @ResponseWrapper(localName = "updateMdpUtilisateurResponse", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.UpdateMdpUtilisateurResponse")
    public void updateMdpUtilisateur(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "actuelMdp", targetNamespace = "")
        java.lang.String actuelMdp,
        @WebParam(name = "nouveauMdp", targetNamespace = "")
        java.lang.String nouveauMdp,
        @WebParam(name = "confirmationNouveauMdp", targetNamespace = "")
        java.lang.String confirmationNouveauMdp
    ) throws UpdateMdpUtilisateurFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getUtilisateur", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.GetUtilisateur")
    @ResponseWrapper(localName = "getUtilisateurResponse", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.GetUtilisateurResponse")
    @WebResult(name = "utilisateur", targetNamespace = "")
    public Utilisateur getUtilisateur(
        @WebParam(name = "utilisateurId", targetNamespace = "")
        int utilisateurId
    ) throws GetUtilisateurFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "authentifierUtilisateur", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.AuthentifierUtilisateur")
    @ResponseWrapper(localName = "authentifierUtilisateurResponse", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.AuthentifierUtilisateurResponse")
    @WebResult(name = "utilisateur", targetNamespace = "")
    public Utilisateur authentifierUtilisateur(
        @WebParam(name = "adresseMail", targetNamespace = "")
        java.lang.String adresseMail,
        @WebParam(name = "motDePasse", targetNamespace = "")
        java.lang.String motDePasse
    ) throws AuthentifierUtilisateurFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "updateCoordUtilisateur", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.UpdateCoordUtilisateur")
    @ResponseWrapper(localName = "updateCoordUtilisateurResponse", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.UpdateCoordUtilisateurResponse")
    public void updateCoordUtilisateur(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "civilite", targetNamespace = "")
        java.lang.String civilite,
        @WebParam(name = "nom", targetNamespace = "")
        java.lang.String nom,
        @WebParam(name = "prenom", targetNamespace = "")
        java.lang.String prenom,
        @WebParam(name = "pseudo", targetNamespace = "")
        java.lang.String pseudo,
        @WebParam(name = "adresseMail", targetNamespace = "")
        java.lang.String adresseMail,
        @WebParam(name = "telephone", targetNamespace = "")
        java.lang.String telephone,
        @WebParam(name = "dateNaissance", targetNamespace = "")
        javax.xml.datatype.XMLGregorianCalendar dateNaissance,
        @WebParam(name = "adresse", targetNamespace = "")
        java.lang.String adresse,
        @WebParam(name = "codePostal", targetNamespace = "")
        java.lang.String codePostal,
        @WebParam(name = "ville", targetNamespace = "")
        java.lang.String ville,
        @WebParam(name = "pays", targetNamespace = "")
        java.lang.String pays
    ) throws UpdateCoordUtilisateurFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "updateParametresUtilisateur", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.UpdateParametresUtilisateur")
    @ResponseWrapper(localName = "updateParametresUtilisateurResponse", targetNamespace = "http://www.example.org/UtilisateurService/", className = "org.example.utilisateurservice.UpdateParametresUtilisateurResponse")
    public void updateParametresUtilisateur(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "envoiMailInformatif", targetNamespace = "")
        boolean envoiMailInformatif
    ) throws UpdateParametresUtilisateurFault_Exception;
}
