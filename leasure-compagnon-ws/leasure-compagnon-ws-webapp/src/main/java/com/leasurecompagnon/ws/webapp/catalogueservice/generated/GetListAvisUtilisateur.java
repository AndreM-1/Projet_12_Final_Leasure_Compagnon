
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
 *         &lt;element name="statutAvis" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "statutAvis"
})
@XmlRootElement(name = "getListAvisUtilisateur")
public class GetListAvisUtilisateur {

    protected int utilisateurId;
    @XmlElement(required = true)
    protected String statutAvis;

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
     * Obtient la valeur de la propriété statutAvis.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatutAvis() {
        return statutAvis;
    }

    /**
     * Définit la valeur de la propriété statutAvis.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatutAvis(String value) {
        this.statutAvis = value;
    }

}
