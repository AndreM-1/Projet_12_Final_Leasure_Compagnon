
package com.leasurecompagnon.ws.model.bean.catalogue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour CoordonneeGPS complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="CoordonneeGPS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoordonneeGPS", propOrder = {
    "id",
    "latitude",
    "longitude"
})
public class CoordonneeGPS {

    protected int id;
    protected double latitude;
    protected double longitude;

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
     * Obtient la valeur de la propriété latitude.
     * 
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Définit la valeur de la propriété latitude.
     * 
     */
    public void setLatitude(double value) {
        this.latitude = value;
    }

    /**
     * Obtient la valeur de la propriété longitude.
     * 
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Définit la valeur de la propriété longitude.
     * 
     */
    public void setLongitude(double value) {
        this.longitude = value;
    }

}
