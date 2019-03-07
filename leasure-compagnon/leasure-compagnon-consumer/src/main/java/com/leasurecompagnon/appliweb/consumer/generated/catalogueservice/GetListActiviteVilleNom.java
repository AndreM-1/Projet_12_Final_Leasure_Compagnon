
package com.leasurecompagnon.appliweb.consumer.generated.catalogueservice;

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
 *         &lt;element name="nomVille" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "nomVille",
    "statutActivite"
})
@XmlRootElement(name = "getListActiviteVilleNom")
public class GetListActiviteVilleNom {

    @XmlElement(required = true)
    protected String nomVille;
    @XmlElement(required = true)
    protected String statutActivite;

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
