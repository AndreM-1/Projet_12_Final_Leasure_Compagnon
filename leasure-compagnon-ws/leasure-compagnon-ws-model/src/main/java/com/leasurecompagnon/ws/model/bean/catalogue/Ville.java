
package com.leasurecompagnon.ws.model.bean.catalogue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Ville complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Ville"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nomVille" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codePostal" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nbHabitant" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="coordonnee" type="{http://www.example.org/beans/}CoordonneeGPS"/&gt;
 *         &lt;element name="photoVille" type="{http://www.example.org/beans/}Photo"/&gt;
 *         &lt;element name="departement" type="{http://www.example.org/beans/}Departement"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ville", propOrder = {
    "id",
    "nomVille",
    "codePostal",
    "description",
    "nbHabitant",
    "coordonnee",
    "photoVille",
    "departement"
})
public class Ville {

    protected int id;
    @XmlElement(required = true)
    protected String nomVille;
    @XmlElement(required = true)
    protected String codePostal;
    @XmlElement(required = true)
    protected String description;
    protected int nbHabitant;
    @XmlElement(required = true)
    protected CoordonneeGPS coordonnee;
    @XmlElement(required = true)
    protected Photo photoVille;
    @XmlElement(required = true)
    protected Departement departement;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété nomVille.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomVille() {
        return nomVille;
    }

    /**
     * Définit la valeur de la propriété nomVille.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomVille(String value) {
        this.nomVille = value;
    }

    /**
     * Obtient la valeur de la propriété codePostal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Définit la valeur de la propriété codePostal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePostal(String value) {
        this.codePostal = value;
    }

    /**
     * Obtient la valeur de la propriété description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la valeur de la propriété description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtient la valeur de la propriété nbHabitant.
     * 
     */
    public int getNbHabitant() {
        return nbHabitant;
    }

    /**
     * Définit la valeur de la propriété nbHabitant.
     * 
     */
    public void setNbHabitant(int value) {
        this.nbHabitant = value;
    }

    /**
     * Obtient la valeur de la propriété coordonnee.
     * 
     * @return
     *     possible object is
     *     {@link CoordonneeGPS }
     *     
     */
    public CoordonneeGPS getCoordonnee() {
        return coordonnee;
    }

    /**
     * Définit la valeur de la propriété coordonnee.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordonneeGPS }
     *     
     */
    public void setCoordonnee(CoordonneeGPS value) {
        this.coordonnee = value;
    }

    /**
     * Obtient la valeur de la propriété photoVille.
     * 
     * @return
     *     possible object is
     *     {@link Photo }
     *     
     */
    public Photo getPhotoVille() {
        return photoVille;
    }

    /**
     * Définit la valeur de la propriété photoVille.
     * 
     * @param value
     *     allowed object is
     *     {@link Photo }
     *     
     */
    public void setPhotoVille(Photo value) {
        this.photoVille = value;
    }

    /**
     * Obtient la valeur de la propriété departement.
     * 
     * @return
     *     possible object is
     *     {@link Departement }
     *     
     */
    public Departement getDepartement() {
        return departement;
    }

    /**
     * Définit la valeur de la propriété departement.
     * 
     * @param value
     *     allowed object is
     *     {@link Departement }
     *     
     */
    public void setDepartement(Departement value) {
        this.departement = value;
    }

}
