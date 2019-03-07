
package com.leasurecompagnon.appliweb.consumer.generated.catalogueservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Duree;


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
 *         &lt;element name="duree" type="{http://www.example.org/beans/}Duree"/&gt;
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
    "duree"
})
@XmlRootElement(name = "getDureeResponse")
public class GetDureeResponse {

    @XmlElement(required = true)
    protected Duree duree;

    /**
     * Obtient la valeur de la propriété duree.
     * 
     * @return
     *     possible object is
     *     {@link Duree }
     *     
     */
    public Duree getDuree() {
        return duree;
    }

    /**
     * Définit la valeur de la propriété duree.
     * 
     * @param value
     *     allowed object is
     *     {@link Duree }
     *     
     */
    public void setDuree(Duree value) {
        this.duree = value;
    }

}
