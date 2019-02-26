
package com.leasurecompagnon.ws.webapp.formulairecontactservice.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nomNa" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="adresseMailNa" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="objet" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="utilisateurId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nomNa",
    "adresseMailNa",
    "objet",
    "message",
    "utilisateurId"
})
@XmlRootElement(name = "envoiFormulaireContact")
public class EnvoiFormulaireContact {

    @XmlElement(required = true)
    protected String nomNa;
    @XmlElement(required = true)
    protected String adresseMailNa;
    @XmlElement(required = true)
    protected String objet;
    @XmlElement(required = true)
    protected String message;
    protected int utilisateurId;

    /**
     * Obtient la valeur de la propriété nomNa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomNa() {
        return nomNa;
    }

    /**
     * Définit la valeur de la propriété nomNa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomNa(String value) {
        this.nomNa = value;
    }

    /**
     * Obtient la valeur de la propriété adresseMailNa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresseMailNa() {
        return adresseMailNa;
    }

    /**
     * Définit la valeur de la propriété adresseMailNa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresseMailNa(String value) {
        this.adresseMailNa = value;
    }

    /**
     * Obtient la valeur de la propriété objet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjet() {
        return objet;
    }

    /**
     * Définit la valeur de la propriété objet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjet(String value) {
        this.objet = value;
    }

    /**
     * Obtient la valeur de la propriété message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Définit la valeur de la propriété message.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Obtient la valeur de la propriété utilisateurId.
     * 
     */
    public int getUtilisateurId() {
        return utilisateurId;
    }

    /**
     * Définit la valeur de la propriété utilisateurId.
     * 
     */
    public void setUtilisateurId(int value) {
        this.utilisateurId = value;
    }

}
