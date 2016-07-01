package com.groupe1.adaming.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.groupe1.adaming.entities.Groupe;
import com.groupe1.adaming.metierGroupe.IGroupeMetier;

public class DriverGroupe {

	private static IGroupeMetier metier;
	private static ClassPathXmlApplicationContext applicationContext;
	
	public static void main(String[] args) {

		applicationContext = new ClassPathXmlApplicationContext("app.xml");
		metier = (IGroupeMetier) applicationContext.getBean("metierGroupe");
		
		metier.addGroupe(new Groupe("groupe1"));
		
	}

}
