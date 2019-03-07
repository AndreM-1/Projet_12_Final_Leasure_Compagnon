
package com.leasurecompagnon.appliweb.consumer.generated.catalogueservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Activite;


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
 *         &lt;element name="activite" type="{http://www.example.org/beans/}Activite"/&gt;
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
    "activite"
})
@XmlRootElement(name = "ajoutActivite")
public class AjoutActivite {

    @XmlElement(required = true)
    protected Activite activite;

    /**
     * Obtient la valeur de la propriété activite.
     * 
     * @return
     *     possible object is
     *     {@link Activite }
     *     
     */
    public Activite getActivite() {
        return activite;
    }

    /**
     * Définit la valeur de la propriété activite.
     * 
     * @param value
     *     allowed object is
     *     {@link Activite }
     *     
     */
    public void setActivite(Activite value) {
        this.activite = value;
    }

}
