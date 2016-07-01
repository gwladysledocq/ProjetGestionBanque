package com.groupe1.adaming.test;

import java.util.Collection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.groupe1.adaming.daoBanque.BanqueDaoImp;
import com.groupe1.adaming.daoBanque.IBanqueDao;
import com.groupe1.adaming.entities.Banque;
import com.groupe1.adaming.entities.BanqueBnp;
import com.groupe1.adaming.entities.BanqueCic;
import com.groupe1.adaming.entities.BanqueLcl;
import com.groupe1.adaming.metierBanque.IBanqueMetier;

public class DriverBanque {

private static IBanqueMetier metier;
private static ClassPathXmlApplicationContext applicationContext;
	
	public static void main(String[] args) {
		
applicationContext = new ClassPathXmlApplicationContext("app.xml");
metier = (IBanqueMetier) applicationContext.getBean("metierBanque");
		

		Banque banque1 = metier.addBanque(new BanqueCic("agence1", "adresse1", "code1"));
		Banque banque2 = metier.addBanque(new BanqueLcl("agence2", "adresse2", "code2"));
		Banque banque3 = metier.addBanque(new BanqueBnp("agence3", "adresse3", "code3"));
		Collection<Banque> tabBanque1 = metier.getBanques();

	}

}
