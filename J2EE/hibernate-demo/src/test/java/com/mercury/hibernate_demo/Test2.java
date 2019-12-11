package com.mercury.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mercury.hibernate_demo.util.HibernateUtil;

public class Test2 {

	public static void main(String[] args) {
		SessionFactory factory = 
				new Configuration().configure().buildSessionFactory();
		Session s1 = factory.openSession();
		Session s2 = factory.openSession();
		System.out.println(s1 == s2); // false
		// every time of factory.open will create a new Session.
		
		Session s3 = HibernateUtil.getSession();
		Session s4 = HibernateUtil.getSession();
		System.out.println(s3 == s4); // true, because they are in the same session
		
		// ask session factory to return a session for current thread.
		Session s5 = factory.getCurrentSession();
		Session s6 = factory.getCurrentSession();
		System.out.println(s5 == s6); // true
		
		// close session to save resources.
		// closed session can't be re-opened/reused
		s1.close();
	}

}













