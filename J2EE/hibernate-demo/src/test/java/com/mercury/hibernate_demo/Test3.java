package com.mercury.hibernate_demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.mercury.hibernate_demo.bean.Sample;
import com.mercury.hibernate_demo.util.HibernateUtil;

public class Test3 {

	public static void main(String[] args) {
		// how to read data from DB?
		
		// 1. read single object by id using load()
		// load() is lazy!
		// Hibernate will not generate SQL to load data from DB until the
		// object will be used.
		// load() will first create a proxy object as placeholder
		// for actual object which will be loaded later from DB.
		// load() will throw ObjectNotFoundException if the entity to load
		// doesn't exist in DB.
		Session s1 = HibernateUtil.getSession();
//		Sample mike = (Sample)s1.load(Sample.class, "mike");
//		
//		// this will invoke mike.toString(), then the above code would work.
//		System.out.println(mike);
//		System.out.println(mike.getClass());
		
		// ==============================================================
		// (key)
		// 2. read single object using get()
		// get() is eager!
		// Hibernate will eagerly generate SQL statement to 
		// get the object from DB even object is not used.
		// get() will return null if entity can't be found in DB.
		Sample bob = (Sample)s1.get(Sample.class, "bob");
		System.out.println(bob);
		System.out.println(bob.getClass());
		
		// ==============================================================
		// 3. read data if we don't have id
		// get all samples with age >= 22
		
		Criteria ct = s1.createCriteria(Sample.class);
		
		// ge == greater than or equal to
		Criterion c1 = Restrictions.ge("age", 22);
		
		// 名字中包含 i:
		Criterion c2 = Restrictions.like("name", "%i%");
		
		
		List<Sample> samplesOver22 = ct.add(c1).add(c2).list();
		System.out.println(samplesOver22);
		
	}

}











