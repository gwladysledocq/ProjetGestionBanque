package com.groupe1.adaming.Singleton;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Singleton {

	private static SessionFactory sf;

	static{
		sf = new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getSf() {
		return sf;
	}

	public static void setSf(SessionFactory sf) {
		Singleton.sf = sf;
	}
	
}
