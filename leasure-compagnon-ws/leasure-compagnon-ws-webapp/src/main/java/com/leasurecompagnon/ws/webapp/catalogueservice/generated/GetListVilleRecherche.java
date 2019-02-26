
package com.leasurecompagnon.ws.webapp.catalogueservice.generated;

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
 *         &lt;element name="nomRecherche" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "nomRecherche"
})
@XmlRootElement(name = "getListVilleRecherche")
public class GetListVilleRecherche {

    @XmlElement(required = true)
    protected String nomRecherche;

    /**
     * Obtient la valeur de la propriété nomRecherche.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomRecherche() {
        return nomRecherche;
    }

    /**
     * Définit la valeur de la propriété nomRecherche.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomRecherche(String value) {
        this.nomRecherche = value;
    }

}
