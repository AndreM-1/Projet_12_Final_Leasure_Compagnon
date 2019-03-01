package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Ville;
import com.leasurecompagnon.ws.model.exception.NotFoundException;
import com.leasurecompagnon.ws.model.exception.TechnicalException;

/**
 * Interface VilleDao
 * @author André Monnier
 *
 */
public interface VilleDao {

	/**
	 * Méthode permettant de renvoyer la liste des villes. 
	 * @param nbVille : Le nombre de villes à renvoyer. nbVille = -1 veut dire sélection de toutes les villes.
	 * @return List
	 * @throws TechnicalException
	 */
	List<Ville> getListVille(int nbVille) throws TechnicalException;

	/**
	 * Méthode permettant de renvoyer un objet de type {@link Ville} en fonction de son identifiant.
	 * @param villeId : L'identifiant de la ville.
	 * @return Un objet de type {@link Ville}
	 * @throws NotFoundException
	 */
	Ville getVille(int villeId) throws NotFoundException;

	/**
	 * Méthode permettant de renvoyer la liste des noms de l'ensemble des villes.
	 * @return List
	 * @throws TechnicalException
	 */
	List<String> getListNomVille() throws TechnicalException;

	/**
	 * Méthode permettant de renvoyer une liste de villes à partir d'une chaîne de caractères recherchée.
	 * @param nomRecherche : La chaîne de caractères recherchée.
	 * @return List
	 * @throws NotFoundException
	 */
	List<Ville> getListVilleRecherche(String nomRecherche) throws NotFoundException;

}