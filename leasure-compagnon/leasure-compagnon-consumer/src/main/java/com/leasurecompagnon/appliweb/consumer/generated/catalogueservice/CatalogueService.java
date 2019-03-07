package com.leasurecompagnon.appliweb.consumer.generated.catalogueservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Activite;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Avis;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Departement;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Duree;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Pays;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Region;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Saison;
import com.leasurecompagnon.appliweb.model.bean.catalogue.TypeActivite;
import com.leasurecompagnon.appliweb.model.bean.catalogue.Ville;
import com.leasurecompagnon.appliweb.model.exception.AjoutActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetActiviteNomFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetDureeFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteRechercheFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteVilleFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteVilleNomFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListActiviteVilleTAFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListAvisUtilisateurFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListDepartementFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListDureeFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListNomActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListNomVilleFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListPaysFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListRegionFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListSaisonFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListTypeActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListVilleFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListVilleRechercheFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetSaisonFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetTypeActiviteFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetVilleFault_Exception;

/**
 * This class was generated by Apache CXF 3.2.5
 * 2019-03-07T16:08:15.754+01:00
 * Generated source version: 3.2.5
 *
 */
@WebService(targetNamespace = "http://www.example.org/CatalogueService/", name = "CatalogueService")
@XmlSeeAlso({ObjectFactory.class, com.leasurecompagnon.appliweb.model.bean.objectfactory.ObjectFactory.class})
public interface CatalogueService {

    @WebMethod
    @RequestWrapper(localName = "getListPays", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListPays")
    @ResponseWrapper(localName = "getListPaysResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListPaysResponse")
    @WebResult(name = "pays", targetNamespace = "")
    public java.util.List<Pays> getListPays() throws GetListPaysFault_Exception;

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
    @RequestWrapper(localName = "ajoutActivite", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.AjoutActivite")
    @ResponseWrapper(localName = "ajoutActiviteResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.AjoutActiviteResponse")
    public void ajoutActivite(
        @WebParam(name = "activite", targetNamespace = "")
        Activite activite
    ) throws AjoutActiviteFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getActiviteNom", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetActiviteNom")
    @ResponseWrapper(localName = "getActiviteNomResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetActiviteNomResponse")
    @WebResult(name = "activite", targetNamespace = "")
    public Activite getActiviteNom(
        @WebParam(name = "nomActivite", targetNamespace = "")
        java.lang.String nomActivite
    ) throws GetActiviteNomFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListSaison", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListSaison")
    @ResponseWrapper(localName = "getListSaisonResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListSaisonResponse")
    @WebResult(name = "saison", targetNamespace = "")
    public java.util.List<Saison> getListSaison() throws GetListSaisonFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListAvisUtilisateur", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListAvisUtilisateur")
    @ResponseWrapper(localName = "getListAvisUtilisateurResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListAvisUtilisateurResponse")
    @WebResult(name = "avis", targetNamespace = "")
    public java.util.List<Avis> getListAvisUtilisateur(
        @WebParam(name = "utilisateurId", targetNamespace = "")
        int utilisateurId,
        @WebParam(name = "statutAvis", targetNamespace = "")
        java.lang.String statutAvis
    ) throws GetListAvisUtilisateurFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getDuree", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetDuree")
    @ResponseWrapper(localName = "getDureeResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetDureeResponse")
    @WebResult(name = "duree", targetNamespace = "")
    public Duree getDuree(
        @WebParam(name = "dureeId", targetNamespace = "")
        int dureeId
    ) throws GetDureeFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListDepartement", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListDepartement")
    @ResponseWrapper(localName = "getListDepartementResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListDepartementResponse")
    @WebResult(name = "departement", targetNamespace = "")
    public java.util.List<Departement> getListDepartement() throws GetListDepartementFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListNomActivite", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListNomActivite")
    @ResponseWrapper(localName = "getListNomActiviteResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListNomActiviteResponse")
    @WebResult(name = "nomActivite", targetNamespace = "")
    public java.util.List<java.lang.String> getListNomActivite() throws GetListNomActiviteFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListActiviteVilleNom", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListActiviteVilleNom")
    @ResponseWrapper(localName = "getListActiviteVilleNomResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListActiviteVilleNomResponse")
    @WebResult(name = "activite", targetNamespace = "")
    public java.util.List<Activite> getListActiviteVilleNom(
        @WebParam(name = "nomVille", targetNamespace = "")
        java.lang.String nomVille,
        @WebParam(name = "statutActivite", targetNamespace = "")
        java.lang.String statutActivite
    ) throws GetListActiviteVilleNomFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListVille", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListVille")
    @ResponseWrapper(localName = "getListVilleResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListVilleResponse")
    @WebResult(name = "ville", targetNamespace = "")
    public java.util.List<Ville> getListVille(
        @WebParam(name = "nbVille", targetNamespace = "")
        int nbVille
    ) throws GetListVilleFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getVille", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetVille")
    @ResponseWrapper(localName = "getVilleResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetVilleResponse")
    @WebResult(name = "ville", targetNamespace = "")
    public Ville getVille(
        @WebParam(name = "villeId", targetNamespace = "")
        int villeId
    ) throws GetVilleFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getSaison", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetSaison")
    @ResponseWrapper(localName = "getSaisonResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetSaisonResponse")
    @WebResult(name = "saison", targetNamespace = "")
    public Saison getSaison(
        @WebParam(name = "saisonId", targetNamespace = "")
        int saisonId
    ) throws GetSaisonFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getActivite", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetActivite")
    @ResponseWrapper(localName = "getActiviteResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetActiviteResponse")
    @WebResult(name = "activite", targetNamespace = "")
    public Activite getActivite(
        @WebParam(name = "activiteId", targetNamespace = "")
        int activiteId
    ) throws GetActiviteFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListDuree", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListDuree")
    @ResponseWrapper(localName = "getListDureeResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListDureeResponse")
    @WebResult(name = "duree", targetNamespace = "")
    public java.util.List<Duree> getListDuree() throws GetListDureeFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListNomVille", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListNomVille")
    @ResponseWrapper(localName = "getListNomVilleResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListNomVilleResponse")
    @WebResult(name = "nomVille", targetNamespace = "")
    public java.util.List<java.lang.String> getListNomVille() throws GetListNomVilleFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getTypeActivite", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetTypeActivite")
    @ResponseWrapper(localName = "getTypeActiviteResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetTypeActiviteResponse")
    @WebResult(name = "typeActivite", targetNamespace = "")
    public TypeActivite getTypeActivite(
        @WebParam(name = "typeActiviteId", targetNamespace = "")
        int typeActiviteId
    ) throws GetTypeActiviteFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListActiviteVille", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListActiviteVille")
    @ResponseWrapper(localName = "getListActiviteVilleResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListActiviteVilleResponse")
    @WebResult(name = "activite", targetNamespace = "")
    public java.util.List<Activite> getListActiviteVille(
        @WebParam(name = "villeId", targetNamespace = "")
        int villeId,
        @WebParam(name = "statutActivite", targetNamespace = "")
        java.lang.String statutActivite
    ) throws GetListActiviteVilleFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListRegion", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListRegion")
    @ResponseWrapper(localName = "getListRegionResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListRegionResponse")
    @WebResult(name = "region", targetNamespace = "")
    public java.util.List<Region> getListRegion() throws GetListRegionFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListTypeActivite", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListTypeActivite")
    @ResponseWrapper(localName = "getListTypeActiviteResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListTypeActiviteResponse")
    @WebResult(name = "typeActivite", targetNamespace = "")
    public java.util.List<TypeActivite> getListTypeActivite() throws GetListTypeActiviteFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListActiviteVilleTA", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListActiviteVilleTA")
    @ResponseWrapper(localName = "getListActiviteVilleTAResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListActiviteVilleTAResponse")
    @WebResult(name = "activite", targetNamespace = "")
    public java.util.List<Activite> getListActiviteVilleTA(
        @WebParam(name = "villeId", targetNamespace = "")
        int villeId,
        @WebParam(name = "typeActiviteId", targetNamespace = "")
        int typeActiviteId,
        @WebParam(name = "statutActivite", targetNamespace = "")
        java.lang.String statutActivite
    ) throws GetListActiviteVilleTAFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListActiviteRecherche", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListActiviteRecherche")
    @ResponseWrapper(localName = "getListActiviteRechercheResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListActiviteRechercheResponse")
    @WebResult(name = "activite", targetNamespace = "")
    public java.util.List<Activite> getListActiviteRecherche(
        @WebParam(name = "nomRecherche", targetNamespace = "")
        java.lang.String nomRecherche,
        @WebParam(name = "statutActivite", targetNamespace = "")
        java.lang.String statutActivite
    ) throws GetListActiviteRechercheFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListVilleRecherche", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListVilleRecherche")
    @ResponseWrapper(localName = "getListVilleRechercheResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListVilleRechercheResponse")
    @WebResult(name = "ville", targetNamespace = "")
    public java.util.List<Ville> getListVilleRecherche(
        @WebParam(name = "nomRecherche", targetNamespace = "")
        java.lang.String nomRecherche
    ) throws GetListVilleRechercheFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "getListActiviteUtilisateur", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListActiviteUtilisateur")
    @ResponseWrapper(localName = "getListActiviteUtilisateurResponse", targetNamespace = "http://www.example.org/CatalogueService/", className = "org.example.catalogueservice.GetListActiviteUtilisateurResponse")
    @WebResult(name = "activite", targetNamespace = "")
    public java.util.List<Activite> getListActiviteUtilisateur(
        @WebParam(name = "utilisateurId", targetNamespace = "")
        int utilisateurId,
        @WebParam(name = "statutActivite", targetNamespace = "")
        java.lang.String statutActivite
    ) throws GetListActiviteUtilisateurFault_Exception;
}
