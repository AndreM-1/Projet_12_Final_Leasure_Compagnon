
package com.leasurecompagnon.ws.webapp.catalogueservice.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="avisId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="statutAvisId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "avisId",
    "statutAvisId"
})
@XmlRootElement(name = "updateStatutAvis")
public class UpdateStatutAvis {

    protected int avisId;
    protected int statutAvisId;

    /**
     * Obtient la valeur de la propriété avisId.
     * 
     */
    public int getAvisId() {
        return avisId;
    }

    /**
     * Définit la valeur de la propriété avisId.
     * 
     */
    public void setAvisId(int value) {
        this.avisId = value;
    }

    /**
     * Obtient la valeur de la propriété statutAvisId.
     * 
     */
    public int getStatutAvisId() {
        return statutAvisId;
    }

    /**
     * Définit la valeur de la propriété statutAvisId.
     * 
     */
    public void setStatutAvisId(int value) {
        this.statutAvisId = value;
    }

}
