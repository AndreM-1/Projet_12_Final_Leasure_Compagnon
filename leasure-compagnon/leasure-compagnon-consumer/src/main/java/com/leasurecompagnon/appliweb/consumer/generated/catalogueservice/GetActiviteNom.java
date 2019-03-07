
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
 *         &lt;element name="nomActivite" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "nomActivite"
})
@XmlRootElement(name = "getActiviteNom")
public class GetActiviteNom {

    @XmlElement(required = true)
    protected String nomActivite;

    /**
     * Obtient la valeur de la propriété nomActivite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomActivite() {
        return nomActivite;
    }

    /**
     * Définit la valeur de la propriété nomActivite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomActivite(String value) {
        this.nomActivite = value;
    }

}
