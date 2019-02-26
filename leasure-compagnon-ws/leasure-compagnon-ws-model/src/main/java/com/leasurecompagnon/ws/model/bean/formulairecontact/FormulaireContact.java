
package com.leasurecompagnon.ws.model.bean.formulairecontact;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;


/**
 * <p>Classe Java pour FormulaireContact complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="FormulaireContact"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nomNa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adresseMailNa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="objet" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="utilisateur" type="{http://www.example.org/beans/}Utilisateur" minOccurs="0"/&gt;
 *         &lt;element name="dateFormContact" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FormulaireContact", propOrder = {
    "id",
    "nomNa",
    "adresseMailNa",
    "objet",
    "message",
    "utilisateur",
    "dateFormContact"
})
public class FormulaireContact {

    protected int id;
    protected String nomNa;
    protected String adresseMailNa;
    @XmlElement(required = true)
    protected String objet;
    @XmlElement(required = true)
    protected String message;
    protected Utilisateur utilisateur;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateFormContact;

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
     * Obtient la valeur de la propriété utilisateur.
     * 
     * @return
     *     possible object is
     *     {@link Utilisateur }
     *     
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Définit la valeur de la propriété utilisateur.
     * 
     * @param value
     *     allowed object is
     *     {@link Utilisateur }
     *     
     */
    public void setUtilisateur(Utilisateur value) {
        this.utilisateur = value;
    }

    /**
     * Obtient la valeur de la propriété dateFormContact.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFormContact() {
        return dateFormContact;
    }

    /**
     * Définit la valeur de la propriété dateFormContact.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFormContact(XMLGregorianCalendar value) {
        this.dateFormContact = value;
    }

}
