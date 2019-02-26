
package com.leasurecompagnon.ws.model.bean.catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.leasurecompagnon.ws.model.bean.utilisateur.Utilisateur;


/**
 * <p>Classe Java pour Activite complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Activite"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nomActivite" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lienHoraireOuverture" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dateDemandeAjout" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="dateModerationAdmin" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dateMiseEnLigne" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="listTypeActivite" type="{http://www.example.org/beans/}TypeActivite" maxOccurs="unbounded"/&gt;
 *         &lt;element name="duree" type="{http://www.example.org/beans/}Duree"/&gt;
 *         &lt;element name="saison" type="{http://www.example.org/beans/}Saison"/&gt;
 *         &lt;element name="statutActivite" type="{http://www.example.org/beans/}StatutActiviteAvis"/&gt;
 *         &lt;element name="coordonnee" type="{http://www.example.org/beans/}CoordonneeGPS" minOccurs="0"/&gt;
 *         &lt;element name="listPhotoActivite" type="{http://www.example.org/beans/}Photo" maxOccurs="unbounded"/&gt;
 *         &lt;element name="utilisateur" type="{http://www.example.org/beans/}Utilisateur"/&gt;
 *         &lt;element name="ville" type="{http://www.example.org/beans/}Ville"/&gt;
 *         &lt;element name="listAvis" type="{http://www.example.org/beans/}Avis" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Activite", propOrder = {
    "id",
    "nomActivite",
    "description",
    "adresse",
    "lienHoraireOuverture",
    "dateDemandeAjout",
    "dateModerationAdmin",
    "dateMiseEnLigne",
    "listTypeActivite",
    "duree",
    "saison",
    "statutActivite",
    "coordonnee",
    "listPhotoActivite",
    "utilisateur",
    "ville",
    "listAvis"
})
public class Activite {

    protected int id;
    @XmlElement(required = true)
    protected String nomActivite;
    @XmlElement(required = true)
    protected String description;
    protected String adresse;
    protected String lienHoraireOuverture;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDemandeAjout;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateModerationAdmin;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateMiseEnLigne;
    @XmlElement(required = true)
    protected List<TypeActivite> listTypeActivite;
    @XmlElement(required = true)
    protected Duree duree;
    @XmlElement(required = true)
    protected Saison saison;
    @XmlElement(required = true)
    protected StatutActiviteAvis statutActivite;
    protected CoordonneeGPS coordonnee;
    @XmlElement(required = true)
    protected List<Photo> listPhotoActivite;
    @XmlElement(required = true)
    protected Utilisateur utilisateur;
    @XmlElement(required = true)
    protected Ville ville;
    protected List<Avis> listAvis;

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
     * Obtient la valeur de la propriété nomActivite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomActivite() {
        return nomActivite;
    }

    /**
     * Définit la valeur de la propriété nomActivite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomActivite(String value) {
        this.nomActivite = value;
    }

    /**
     * Obtient la valeur de la propriété description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la valeur de la propriété description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtient la valeur de la propriété adresse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Définit la valeur de la propriété adresse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse(String value) {
        this.adresse = value;
    }

    /**
     * Obtient la valeur de la propriété lienHoraireOuverture.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLienHoraireOuverture() {
        return lienHoraireOuverture;
    }

    /**
     * Définit la valeur de la propriété lienHoraireOuverture.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLienHoraireOuverture(String value) {
        this.lienHoraireOuverture = value;
    }

    /**
     * Obtient la valeur de la propriété dateDemandeAjout.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDemandeAjout() {
        return dateDemandeAjout;
    }

    /**
     * Définit la valeur de la propriété dateDemandeAjout.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDemandeAjout(XMLGregorianCalendar value) {
        this.dateDemandeAjout = value;
    }

    /**
     * Obtient la valeur de la propriété dateModerationAdmin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateModerationAdmin() {
        return dateModerationAdmin;
    }

    /**
     * Définit la valeur de la propriété dateModerationAdmin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateModerationAdmin(XMLGregorianCalendar value) {
        this.dateModerationAdmin = value;
    }

    /**
     * Obtient la valeur de la propriété dateMiseEnLigne.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateMiseEnLigne() {
        return dateMiseEnLigne;
    }

    /**
     * Définit la valeur de la propriété dateMiseEnLigne.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateMiseEnLigne(XMLGregorianCalendar value) {
        this.dateMiseEnLigne = value;
    }

    /**
     * Gets the value of the listTypeActivite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listTypeActivite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListTypeActivite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeActivite }
     * 
     * 
     */
    public List<TypeActivite> getListTypeActivite() {
        if (listTypeActivite == null) {
            listTypeActivite = new ArrayList<TypeActivite>();
        }
        return this.listTypeActivite;
    }

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

    /**
     * Obtient la valeur de la propriété saison.
     * 
     * @return
     *     possible object is
     *     {@link Saison }
     *     
     */
    public Saison getSaison() {
        return saison;
    }

    /**
     * Définit la valeur de la propriété saison.
     * 
     * @param value
     *     allowed object is
     *     {@link Saison }
     *     
     */
    public void setSaison(Saison value) {
        this.saison = value;
    }

    /**
     * Obtient la valeur de la propriété statutActivite.
     * 
     * @return
     *     possible object is
     *     {@link StatutActiviteAvis }
     *     
     */
    public StatutActiviteAvis getStatutActivite() {
        return statutActivite;
    }

    /**
     * Définit la valeur de la propriété statutActivite.
     * 
     * @param value
     *     allowed object is
     *     {@link StatutActiviteAvis }
     *     
     */
    public void setStatutActivite(StatutActiviteAvis value) {
        this.statutActivite = value;
    }

    /**
     * Obtient la valeur de la propriété coordonnee.
     * 
     * @return
     *     possible object is
     *     {@link CoordonneeGPS }
     *     
     */
    public CoordonneeGPS getCoordonnee() {
        return coordonnee;
    }

    /**
     * Définit la valeur de la propriété coordonnee.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordonneeGPS }
     *     
     */
    public void setCoordonnee(CoordonneeGPS value) {
        this.coordonnee = value;
    }

    /**
     * Gets the value of the listPhotoActivite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listPhotoActivite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListPhotoActivite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Photo }
     * 
     * 
     */
    public List<Photo> getListPhotoActivite() {
        if (listPhotoActivite == null) {
            listPhotoActivite = new ArrayList<Photo>();
        }
        return this.listPhotoActivite;
    }

    /**
     * Obtient la valeur de la propriété utilisateur.
     * 
     * @return
     *     possible object is
     *     {@link Utilisateur }
     *     
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Définit la valeur de la propriété utilisateur.
     * 
     * @param value
     *     allowed object is
     *     {@link Utilisateur }
     *     
     */
    public void setUtilisateur(Utilisateur value) {
        this.utilisateur = value;
    }

    /**
     * Obtient la valeur de la propriété ville.
     * 
     * @return
     *     possible object is
     *     {@link Ville }
     *     
     */
    public Ville getVille() {
        return ville;
    }

    /**
     * Définit la valeur de la propriété ville.
     * 
     * @param value
     *     allowed object is
     *     {@link Ville }
     *     
     */
    public void setVille(Ville value) {
        this.ville = value;
    }

    /**
     * Gets the value of the listAvis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listAvis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListAvis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Avis }
     * 
     * 
     */
    public List<Avis> getListAvis() {
        if (listAvis == null) {
            listAvis = new ArrayList<Avis>();
        }
        return this.listAvis;
    }

}
