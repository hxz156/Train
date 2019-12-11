package com.mercury.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.hibernate_demo.bean.Sample;
import com.mercury.hibernate_demo.util.HibernateUtil;

public class Test4 {

	public static void main(String[] args) {

		Session s1 = HibernateUtil.getSession();
		
		Transaction tx = s1.beginTransaction();
		try {
			// ==============================================================
			// delete
//			Sample mike = (Sample)s1.get(Sample.class, "mike");
			// mike is in session s1.
//			s1.delete(mike);
			
			// ==============================================================
			// edit
			Sample bob = (Sample)s1.get(Sample.class, "bob");
			// bob is in session s1.
			bob.setAge(99); // update bob's age.
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		

	}

}
