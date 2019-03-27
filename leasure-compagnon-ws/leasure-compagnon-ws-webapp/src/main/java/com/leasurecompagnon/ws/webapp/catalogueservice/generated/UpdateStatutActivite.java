
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
 *         &lt;element name="activiteId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="statutActiviteId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="dateAModifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "activiteId",
    "statutActiviteId",
    "dateAModifier"
})
@XmlRootElement(name = "updateStatutActivite")
public class UpdateStatutActivite {

    protected int activiteId;
    protected int statutActiviteId;
    @XmlElement(required = true)
    protected String dateAModifier;

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

    /**
     * Obtient la valeur de la propriété statutActiviteId.
     * 
     */
    public int getStatutActiviteId() {
        return statutActiviteId;
    }

    /**
     * Définit la valeur de la propriété statutActiviteId.
     * 
     */
    public void setStatutActiviteId(int value) {
        this.statutActiviteId = value;
    }

    /**
     * Obtient la valeur de la propriété dateAModifier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateAModifier() {
        return dateAModifier;
    }

    /**
     * Définit la valeur de la propriété dateAModifier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateAModifier(String value) {
        this.dateAModifier = value;
    }

}
