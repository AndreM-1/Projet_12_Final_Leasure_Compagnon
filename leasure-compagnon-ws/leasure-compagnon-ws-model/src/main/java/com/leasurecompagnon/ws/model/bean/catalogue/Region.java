
package com.leasurecompagnon.ws.model.bean.catalogue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Region complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Region"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nomRegion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pays" type="{http://www.example.org/beans/}Pays"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Region", propOrder = {
    "id",
    "nomRegion",
    "pays"
})
public class Region {

    protected int id;
    @XmlElement(required = true)
    protected String nomRegion;
    @XmlElement(required = true)
    protected Pays pays;

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
     * Obtient la valeur de la propriété nomRegion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomRegion() {
        return nomRegion;
    }

    /**
     * Définit la valeur de la propriété nomRegion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomRegion(String value) {
        this.nomRegion = value;
    }

    /**
     * Obtient la valeur de la propriété pays.
     * 
     * @return
     *     possible object is
     *     {@link Pays }
     *     
     */
    public Pays getPays() {
        return pays;
    }

    /**
     * Définit la valeur de la propriété pays.
     * 
     * @param value
     *     allowed object is
     *     {@link Pays }
     *     
     */
    public void setPays(Pays value) {
        this.pays = value;
    }

}
