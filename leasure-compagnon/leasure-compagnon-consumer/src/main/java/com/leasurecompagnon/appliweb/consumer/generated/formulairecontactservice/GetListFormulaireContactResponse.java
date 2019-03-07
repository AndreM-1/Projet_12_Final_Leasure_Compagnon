
package com.leasurecompagnon.appliweb.consumer.generated.formulairecontactservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.leasurecompagnon.appliweb.model.bean.formulairecontact.FormulaireContact;


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
 *         &lt;element name="formulaireContact" type="{http://www.example.org/beans/}FormulaireContact" maxOccurs="unbounded"/&gt;
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
    "formulaireContact"
})
@XmlRootElement(name = "getListFormulaireContactResponse")
public class GetListFormulaireContactResponse {

    @XmlElement(required = true)
    protected List<FormulaireContact> formulaireContact;

    /**
     * Gets the value of the formulaireContact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the formulaireContact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFormulaireContact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FormulaireContact }
     * 
     * 
     */
    public List<FormulaireContact> getFormulaireContact() {
        if (formulaireContact == null) {
            formulaireContact = new ArrayList<FormulaireContact>();
        }
        return this.formulaireContact;
    }

}
