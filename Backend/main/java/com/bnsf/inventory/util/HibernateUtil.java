package com.bnsf.inventory.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.bnsf.inventory.beans.InventoryItem;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private static SessionFactory getSessionFactory(String filename) {
		if(HibernateUtil.sessionFactory == null){
			
			try {
			Configuration c = new Configuration().configure(filename);
			c.addAnnotatedClass(InventoryItem.class);
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
			HibernateUtil.sessionFactory = c.buildSessionFactory(sr);
			
			}
		    catch (Exception e) {
		        e.printStackTrace();
		        sessionFactory.close();
		    }
		}
		
		return HibernateUtil.sessionFactory;
	}

	public static Session getSession() {
		return getSessionFactory("hibernate.cfg.xml").openSession();
	}

}
