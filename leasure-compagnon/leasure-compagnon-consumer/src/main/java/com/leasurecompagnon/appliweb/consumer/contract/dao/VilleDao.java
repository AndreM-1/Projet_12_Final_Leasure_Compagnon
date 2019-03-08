package com.leasurecompagnon.appliweb.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.appliweb.model.bean.catalogue.Ville;
import com.leasurecompagnon.appliweb.model.exception.GetListNomVilleFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListVilleFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetListVilleRechercheFault_Exception;
import com.leasurecompagnon.appliweb.model.exception.GetVilleFault_Exception;

/**
 * Interface VilleDao
 * @author André Monnier
 *
 */
public interface VilleDao {

	/**
	 * Méthode permettant de renvoyer une liste de villes à partir d'une chaîne de caractères recherchée.
	 * @param nomRecherche : La chaîne de caractères recherchée.
	 * @return List
	 * @throws GetListVilleRechercheFault_Exception
	 */
	List<Ville> getListVilleRecherche(String nomRecherche) throws GetListVilleRechercheFault_Exception;

	/**
	 * Méthode permettant de renvoyer la liste des noms de l'ensemble des villes.
	 * @return List
	 * @throws GetListNomVilleFault_Exception
	 */
	List<String> getListNomVille() throws GetListNomVilleFault_Exception;

	/**
	 * Méthode permettant de renvoyer un objet de type {@link Ville} en fonction de son identifiant.
	 * @param villeId  : L'identifiant de la ville.
	 * @return Un objet de type {@link Ville}
	 * @throws GetVilleFault_Exception
	 */
	Ville getVille(int villeId) throws GetVilleFault_Exception;

	/**
	 * Méthode permettant de renvoyer la liste des villes.
	 * @param nbVille : Le nombre de villes à renvoyer. nbVille = -1 veut dire sélection de toutes les villes.
	 * @return List
	 * @throws GetListVilleFault_Exception
	 */
	List<Ville> getListVille(int nbVille) throws GetListVilleFault_Exception;

}