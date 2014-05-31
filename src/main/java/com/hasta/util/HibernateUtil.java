package com.hasta.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	public static synchronized SessionFactory getSessionfactory() {
		return sessionFactory;
	}

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		// TODO Auto-generated method stub
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.err.println("sessionFactory Oluşturulamadı. Hata:"+e);
			e.printStackTrace();
			return null;
		}
	}
}