package com.groupe1.adaming.exception;

/*Class: ExceptionAucunCompteTrouveDepuisClient
 * Exception personnalisee pour la methode public Collection<Compte> getComptes(Long idClient) de la DAO client
 * Package: com.groupe1.adaming.exception
 * Author: Philippe
 * Version: 1.0.0
 * Date: 01/07/16
 */
@SuppressWarnings("serial")
public class ExceptionAucunCompteTrouveDepuisClient extends Exception{

	public ExceptionAucunCompteTrouveDepuisClient(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
