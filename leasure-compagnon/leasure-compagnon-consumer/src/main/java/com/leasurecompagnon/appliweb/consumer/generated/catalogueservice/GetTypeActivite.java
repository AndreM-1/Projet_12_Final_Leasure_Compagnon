
package com.leasurecompagnon.appliweb.consumer.generated.catalogueservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="typeActiviteId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "typeActiviteId"
})
@XmlRootElement(name = "getTypeActivite")
public class GetTypeActivite {

    protected int typeActiviteId;

    /**
     * Obtient la valeur de la propriété typeActiviteId.
     * 
     */
    public int getTypeActiviteId() {
        return typeActiviteId;
    }

    /**
     * Définit la valeur de la propriété typeActiviteId.
     * 
     */
    public void setTypeActiviteId(int value) {
        this.typeActiviteId = value;
    }

}
