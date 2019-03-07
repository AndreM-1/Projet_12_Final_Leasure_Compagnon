
package com.leasurecompagnon.appliweb.consumer.generated.catalogueservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Saison;


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
 *         &lt;element name="saison" type="{http://www.example.org/beans/}Saison"/&gt;
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
    "saison"
})
@XmlRootElement(name = "getSaisonResponse")
public class GetSaisonResponse {

    @XmlElement(required = true)
    protected Saison saison;

    /**
     * Obtient la valeur de la propriété saison.
     * 
     * @return
     *     possible object is
     *     {@link Saison }
     *     
     */
    public Saison getSaison() {
        return saison;
    }

    /**
     * Définit la valeur de la propriété saison.
     * 
     * @param value
     *     allowed object is
     *     {@link Saison }
     *     
     */
    public void setSaison(Saison value) {
        this.saison = value;
    }

}
