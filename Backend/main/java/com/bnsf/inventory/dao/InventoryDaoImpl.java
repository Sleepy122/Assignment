package com.bnsf.inventory.dao;
import java.util.List;
import org.hibernate.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bnsf.inventory.beans.*;
import com.bnsf.inventory.util.HibernateUtil;
import com.bnsf.inventory.wrapper.InventoryWrapper;

@Transactional
@Repository
public class InventoryDaoImpl implements InventoryDao {	
	public List<InventoryItem> getAllInventory() {
		Session s = HibernateUtil.getSession();
		Query q = s.createQuery("from InventoryItem");
		List<InventoryItem> items = q.list();
		s.close();
		return items;
	}
	
	public void updateInventory(InventoryItem wrappedNewItem) {
		//creating an instance of inventory item from my wrapper class
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(wrappedNewItem);
		tx.commit();
		s.close();
		
	}
	
	public void deleteInventory(String pk) {
		 int newPk = Integer.parseInt(pk);
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from InventoryItem I where I.Identifier2 = :var");
		q.setParameter("var", newPk);
		List<InventoryItem> results = q.list();
		System.out.println(results.get(0).toString());
		InventoryItem item = (InventoryItem) results.get(0);		
		s.delete(item);
		tx.commit();
		s.close();
		
	}
	
	public void createInventory(InventoryItem wrappedNewItem) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(wrappedNewItem);
		tx.commit();
		s.close();
	}

}
