package com.mercury.hibernate_demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static final SessionFactory FACTORY
		= new Configuration().configure().buildSessionFactory();
				
	// every thread will be provided with a new session.
	// within each thread, we will use same session.
	// ThreadLocal!
	
	private static final ThreadLocal<Session> SESSION
		= new ThreadLocal<Session>() {
			@Override
			protected Session initialValue() {
				return FACTORY.openSession();
			}
	};
	
	public static Session getSession() {
		return SESSION.get();
	}
	
}












