package com.epes.anudip.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernatUtil {
	
	private static SessionFactory sf;
	
	static {
		try {
		sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		catch(Throwable ex) {
            System.err.println("SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sf;
	}

}
