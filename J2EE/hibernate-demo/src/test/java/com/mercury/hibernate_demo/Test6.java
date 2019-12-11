package com.mercury.hibernate_demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mercury.hibernate_demo.bean.Sample;
import com.mercury.hibernate_demo.util.HibernateUtil;

public class Test6 {

	public static void main(String[] args) {
		// query level cache
		// based on 2nd level cache.
		
		
		// HQL: hibernate query language
		String hq1 = "from Sample";
		Session s1 = HibernateUtil.getSession();
		Query query = s1.createQuery(hq1);
		query.setCacheable(true);
		List<Sample> list1 = query.list();
		// 拿到所有的 Sample
		System.out.println(list1);

		// 没有 cache,又重新执行 select, 
		// 加上：<property name="hibernate.cache.use_query_cache">true</property>
		// 就拥有了 cache.
		List<Sample> list2 = query.list();
		System.out.println(list2);
	}

}
