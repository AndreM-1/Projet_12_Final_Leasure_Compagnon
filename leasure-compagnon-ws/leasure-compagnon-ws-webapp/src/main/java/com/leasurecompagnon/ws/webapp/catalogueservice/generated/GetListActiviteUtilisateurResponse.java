
package com.leasurecompagnon.ws.webapp.catalogueservice.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.leasurecompagnon.ws.model.bean.catalogue.Activite;


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
 *         &lt;element name="activite" type="{http://www.example.org/beans/}Activite" maxOccurs="unbounded"/&gt;
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
@XmlRootElement(name = "getListActiviteUtilisateurResponse")
public class GetListActiviteUtilisateurResponse {

    @XmlElement(required = true)
    protected List<Activite> activite;

    /**
     * Gets the value of the activite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Activite }
     * 
     * 
     */
    public List<Activite> getActivite() {
        if (activite == null) {
            activite = new ArrayList<Activite>();
        }
        return this.activite;
    }

}
