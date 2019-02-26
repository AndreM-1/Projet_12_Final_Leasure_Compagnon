
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
 *         &lt;element name="utilisateurId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="statutActivite" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "utilisateurId",
    "statutActivite"
})
@XmlRootElement(name = "getListActiviteUtilisateur")
public class GetListActiviteUtilisateur {

    protected int utilisateurId;
    @XmlElement(required = true)
    protected String statutActivite;

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
     * Obtient la valeur de la propriété statutActivite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatutActivite() {
        return statutActivite;
    }

    /**
     * Définit la valeur de la propriété statutActivite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatutActivite(String value) {
        this.statutActivite = value;
    }

}
