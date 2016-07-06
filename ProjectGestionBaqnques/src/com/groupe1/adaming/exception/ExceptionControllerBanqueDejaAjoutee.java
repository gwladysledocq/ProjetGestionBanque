package com.groupe1.adaming.exception;

import com.groupe1.adaming.entities.Banque;

/*Class: ExceptionControllerBanqueDejaAjoutee
 * Exception personnalisee pour la methode public Banque addBanque(Banque banque) du controller Banque
 * Package: com.groupe1.adaming.exception
 * Author: Philippe
 * Version: 1.0.0
 * Date: 05/07/16
 */
@SuppressWarnings("serial")
public class ExceptionControllerBanqueDejaAjoutee extends Exception {

	public ExceptionControllerBanqueDejaAjoutee(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
