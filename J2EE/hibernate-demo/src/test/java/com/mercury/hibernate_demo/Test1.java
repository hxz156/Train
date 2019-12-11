package com.mercury.hibernate_demo;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mercury.hibernate_demo.bean.Sample;

public class Test1 {
	// 利用 hibernate 去往数据库添加成员。
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s1 = factory.openSession();
		
		// open a transaction
		Transaction tx = s1.beginTransaction();
		
		try {
			Sample zion = new Sample("zion", 23);
			s1.save(zion);
			
			Sample mike = new Sample("mikeeeeee", 23);
			// save mike in session.
			s1.save(mike);
			
			// flush session.
//			s1.flush();
			
			// 有了 commit, 会自动 flush, 所以不需要自己写。
			tx.commit();
		} catch (Exception e) {
			// 所有的操作都不做：(比如插入两次，sql里面有，就会失败。导致 try 里面的
			// zion 也插入失败，虽然 zion 没有。)
			tx.rollback();
		}
	}
}
