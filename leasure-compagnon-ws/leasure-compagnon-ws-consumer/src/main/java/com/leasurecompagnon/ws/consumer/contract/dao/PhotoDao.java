package com.leasurecompagnon.ws.consumer.contract.dao;

import java.util.List;

import com.leasurecompagnon.ws.model.bean.catalogue.Photo;
import com.leasurecompagnon.ws.model.exception.FunctionalException;
import com.leasurecompagnon.ws.model.exception.NotFoundException;

/**
 * Interface PhotoDao
 * @author André Monnier
 *
 */
public interface PhotoDao {

	/**
	 * Méthode permettant de renvoyer la photo d'une ville en fonction de son identifiant.
	 * @param villeId : L'identifiant de la ville.
	 * @return Un objet de type {@link Photo}
	 * @throws NotFoundException
	 */
	Photo getPhotoVille(int villeId) throws NotFoundException;
	
	/**
	 * Méthode permettant de renvoyer la photo de profil d'un utilisateur en fonction de son identifiant.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @return Un objet de type {@link Photo}
	 * @throws NotFoundException
	 */
	Photo getPhotoUtilisateur(int utilisateurId) throws NotFoundException;
	
	/**
	 * Méthode permettant de renvoyer la liste des photos d'une activité en fonction de son identifiant.
	 * @param activiteId : L'identifiant de l'activité.
	 * @return List
	 * @throws NotFoundException
	 */
	List<Photo> getListPhotoActivite(int activiteId) throws NotFoundException;

	/**
	 * Méthode qui permet d'ajouter une photo en base de données pour un utilisateur qui n'a pas de photos de profil.
	 * @param nomPhoto : Le nom de la photo.
	 * @param provenancePhoto : La provenance de la photo.
	 * @param typePhoto : Le type de de la photo.
	 * @param utilisateurId : L'identifiant de l'utilisateur.
	 * @throws FunctionalException
	 */
	void insertPhotoUtilisateur(String nomPhoto, String provenancePhoto, String typePhoto, int utilisateurId) throws FunctionalException;

}