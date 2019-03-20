
package com.leasurecompagnon.ws.webapp.catalogueservice.generated;

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
 *         &lt;element name="commentaire" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="appreciation" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="utilisateurId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="activiteId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "commentaire",
    "appreciation",
    "utilisateurId",
    "activiteId"
})
@XmlRootElement(name = "ajoutAvis")
public class AjoutAvis {

    @XmlElement(required = true)
    protected String commentaire;
    @XmlElement(required = true)
    protected String appreciation;
    protected int utilisateurId;
    protected int activiteId;

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

    /**
     * Obtient la valeur de la propriété activiteId.
     * 
     */
    public int getActiviteId() {
        return activiteId;
    }

    /**
     * Définit la valeur de la propriété activiteId.
     * 
     */
    public void setActiviteId(int value) {
        this.activiteId = value;
    }

}
