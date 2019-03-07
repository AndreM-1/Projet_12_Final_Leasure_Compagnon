
package com.leasurecompagnon.appliweb.consumer.generated.catalogueservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.leasurecompagnon.appliweb.model.bean.catalogue.TypeActivite;


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
 *         &lt;element name="typeActivite" type="{http://www.example.org/beans/}TypeActivite"/&gt;
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
    "typeActivite"
})
@XmlRootElement(name = "getTypeActiviteResponse")
public class GetTypeActiviteResponse {

    @XmlElement(required = true)
    protected TypeActivite typeActivite;

    /**
     * Obtient la valeur de la propriété typeActivite.
     * 
     * @return
     *     possible object is
     *     {@link TypeActivite }
     *     
     */
    public TypeActivite getTypeActivite() {
        return typeActivite;
    }

    /**
     * Définit la valeur de la propriété typeActivite.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeActivite }
     *     
     */
    public void setTypeActivite(TypeActivite value) {
        this.typeActivite = value;
    }

}
