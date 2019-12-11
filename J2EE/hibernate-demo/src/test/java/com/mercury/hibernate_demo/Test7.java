package com.mercury.hibernate_demo;

import org.hibernate.Session;

import com.mercury.hibernate_demo.bean.Sample;
import com.mercury.hibernate_demo.util.HibernateUtil;

public class Test7 {

	public static void main(String[] args) {
		// difference status of an object to session
		
		// transient: object is newly created and not associated with
		// session yet.
		Sample kevin = new Sample("kevin", 21);
		
		Session s1 = HibernateUtil.getSession();
		
		// persistent: object either loaded in session from DB or added to
		// session which will be saved in DB later.
		s1.save(kevin); 
		
		// detached: object will be detached automatically after session
		// is closed.
		s1.close();
		
		// how to manually detach object from session?
		s1.evict(kevin);
		// or:
		s1.clear();
	}

}
