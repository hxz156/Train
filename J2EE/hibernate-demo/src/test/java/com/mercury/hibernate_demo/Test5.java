package com.mercury.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mercury.hibernate_demo.bean.Sample;

public class Test5 {

	public static void main(String[] args) {
		// cache
		// 1st level cache
		// cache on session, 第二次就不会 load.
		SessionFactory factory = 
				new Configuration().configure().buildSessionFactory();
		Session s1 = factory.openSession();
		Sample bob1 = (Sample)s1.get(Sample.class, "bob");
		// since bob is already loaded in session, Hibernate will not
		// load again from DB:
		Sample bob2 = (Sample)s1.get(Sample.class, "bob");
		
		System.out.println("**************************");
		Session s2 = factory.openSession();
		Sample bob3 = (Sample)s2.get(Sample.class, "bob");
		
		System.out.println(bob1 == bob3); // false.
		
		// 2nd level cache
		// session factory level cache
		// 2nd level cache is not natively supported in Hibernate
		// we need to use 3rd party lib e.g. EHCache to implement 2nd
		// level session factory cache.
	}

}
