
package com.leasurecompagnon.ws.model.bean.objectfactory;

import javax.xml.bind.annotation.XmlRegistry;

import com.leasurecompagnon.ws.model.bean.catalogue.Activite;
import com.leasurecompagnon.ws.model.bean.catalogue.Avis;
import com.leasurecompagnon.ws.model.bean.catalogue.CoordonneeGPS;
import com.leasurecompagnon.ws.model.bean.catalogue.Departement;
import com.leasurecompagnon.ws.model.bean.catalogue.Duree;
import com.leasurecompagnon.ws.model.bean.catalogue.Pays;
import com.leasurecompagnon.ws.model.bean.catalogue.Photo;
import com.leasurecompagnon.ws.model.bean.catalogue.Region;
import com.leasurecompagnon.ws.model.bean.catalogue.Saison;
import com.leasurecompagnon.ws.model.bean.catalogue.StatutActiviteAvis;
import com.leasurecompagnon.ws.model.bean.catalogue.TypeActivite;
import com.leasurecompagnon.ws.model.bean.catalogue.Ville;
import com.leasurecompagnon.ws.model.bean.formulairecontact.FormulaireContact;
import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.beans package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.beans
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StatutActiviteAvis }
     * 
     */
    public StatutActiviteAvis createStatutActiviteAvis() {
        return new StatutActiviteAvis();
    }

    /**
     * Create an instance of {@link Saison }
     * 
     */
    public Saison createSaison() {
        return new Saison();
    }

    /**
     * Create an instance of {@link Duree }
     * 
     */
    public Duree createDuree() {
        return new Duree();
    }

    /**
     * Create an instance of {@link TypeActivite }
     * 
     */
    public TypeActivite createTypeActivite() {
        return new TypeActivite();
    }

    /**
     * Create an instance of {@link Pays }
     * 
     */
    public Pays createPays() {
        return new Pays();
    }

    /**
     * Create an instance of {@link Region }
     * 
     */
    public Region createRegion() {
        return new Region();
    }

    /**
     * Create an instance of {@link Departement }
     * 
     */
    public Departement createDepartement() {
        return new Departement();
    }

    /**
     * Create an instance of {@link Ville }
     * 
     */
    public Ville createVille() {
        return new Ville();
    }

    /**
     * Create an instance of {@link CoordonneeGPS }
     * 
     */
    public CoordonneeGPS createCoordonneeGPS() {
        return new CoordonneeGPS();
    }

    /**
     * Create an instance of {@link Photo }
     * 
     */
    public Photo createPhoto() {
        return new Photo();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
    }

    /**
     * Create an instance of {@link FormulaireContact }
     * 
     */
    public FormulaireContact createFormulaireContact() {
        return new FormulaireContact();
    }

    /**
     * Create an instance of {@link Avis }
     * 
     */
    public Avis createAvis() {
        return new Avis();
    }

    /**
     * Create an instance of {@link Activite }
     * 
     */
    public Activite createActivite() {
        return new Activite();
    }

}
