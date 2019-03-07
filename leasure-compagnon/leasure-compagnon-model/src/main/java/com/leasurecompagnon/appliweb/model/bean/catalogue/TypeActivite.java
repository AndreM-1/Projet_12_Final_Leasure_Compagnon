
package com.leasurecompagnon.appliweb.model.bean.catalogue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour TypeActivite complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="TypeActivite"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="typeActivite" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypeActivite", propOrder = {
    "id",
    "typeActivite"
})
public class TypeActivite {

    protected int id;
    @XmlElement(required = true)
    protected String typeActivite;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété typeActivite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeActivite() {
        return typeActivite;
    }

    /**
     * Définit la valeur de la propriété typeActivite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeActivite(String value) {
        this.typeActivite = value;
    }

}
