
package com.leasurecompagnon.ws.model.bean.catalogue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;


/**
 * <p>Classe Java pour Avis complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Avis"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="commentaire" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="appreciation" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="datePosteAvis" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="dateModerationAdminAvis" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dateMiseEnLigneAvis" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="utilisateur" type="{http://www.example.org/beans/}Utilisateur"/&gt;
 *         &lt;element name="statutAvis" type="{http://www.example.org/beans/}StatutActiviteAvis"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Avis", propOrder = {
    "id",
    "commentaire",
    "appreciation",
    "datePosteAvis",
    "dateModerationAdminAvis",
    "dateMiseEnLigneAvis",
    "utilisateur",
    "statutAvis"
})
public class Avis {

    protected int id;
    @XmlElement(required = true)
    protected String commentaire;
    @XmlElement(required = true)
    protected String appreciation;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datePosteAvis;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateModerationAdminAvis;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateMiseEnLigneAvis;
    @XmlElement(required = true)
    protected Utilisateur utilisateur;
    @XmlElement(required = true)
    protected StatutActiviteAvis statutAvis;

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
     * Obtient la valeur de la propriété commentaire.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * Définit la valeur de la propriété commentaire.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentaire(String value) {
        this.commentaire = value;
    }

    /**
     * Obtient la valeur de la propriété appreciation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppreciation() {
        return appreciation;
    }

    /**
     * Définit la valeur de la propriété appreciation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppreciation(String value) {
        this.appreciation = value;
    }

    /**
     * Obtient la valeur de la propriété datePosteAvis.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatePosteAvis() {
        return datePosteAvis;
    }

    /**
     * Définit la valeur de la propriété datePosteAvis.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatePosteAvis(XMLGregorianCalendar value) {
        this.datePosteAvis = value;
    }

    /**
     * Obtient la valeur de la propriété dateModerationAdminAvis.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateModerationAdminAvis() {
        return dateModerationAdminAvis;
    }

    /**
     * Définit la valeur de la propriété dateModerationAdminAvis.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateModerationAdminAvis(XMLGregorianCalendar value) {
        this.dateModerationAdminAvis = value;
    }

    /**
     * Obtient la valeur de la propriété dateMiseEnLigneAvis.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateMiseEnLigneAvis() {
        return dateMiseEnLigneAvis;
    }

    /**
     * Définit la valeur de la propriété dateMiseEnLigneAvis.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateMiseEnLigneAvis(XMLGregorianCalendar value) {
        this.dateMiseEnLigneAvis = value;
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
     * Obtient la valeur de la propriété statutAvis.
     * 
     * @return
     *     possible object is
     *     {@link StatutActiviteAvis }
     *     
     */
    public StatutActiviteAvis getStatutAvis() {
        return statutAvis;
    }

    /**
     * Définit la valeur de la propriété statutAvis.
     * 
     * @param value
     *     allowed object is
     *     {@link StatutActiviteAvis }
     *     
     */
    public void setStatutAvis(StatutActiviteAvis value) {
        this.statutAvis = value;
    }

}
