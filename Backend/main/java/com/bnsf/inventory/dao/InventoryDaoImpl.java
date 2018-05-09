package com.bnsf.inventory.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
		for(int i = 0;i<items.size();i++) {
		//System.out.print(items.get(i).toString()+"_____________________________________________________________________________________________");
		}
		s.close();
		return items;
	}
	
	public void updateInventory(InventoryWrapper WrappedNewItem) {
		//creating an instance of inventory item from my wrapper class
		InventoryItem newItem = new InventoryItem(WrappedNewItem.eqpInit,WrappedNewItem.eqpNumb,WrappedNewItem.stn333,WrappedNewItem.stnSt,WrappedNewItem.dest333,WrappedNewItem.destSt,
				WrappedNewItem.etnTs,WrappedNewItem.eqpLgth,WrappedNewItem.eqpWdth,WrappedNewItem.eqpWeight,WrappedNewItem.ecsId,WrappedNewItem.ecsPrcsd, WrappedNewItem.statCd);
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from InventoryItem I where I.Identifier2 = :var");
		q.setParameter("var", Integer.parseInt(WrappedNewItem.identifier2));
		List<InventoryItem> results = q.list();
		InventoryItem item = (InventoryItem) results.get(0);
		s.delete(item);
		s.persist(newItem);
		tx.commit();
		s.close();
		
	}
	
	public void deleteInventory(String pk) {
		int newPk=-5;
		System.out.print(pk+"_____________________________________________________________________________________________");
		newPk = Integer.parseInt(pk);
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from InventoryItem I where I.Identifier2 = :var");
		q.setParameter("var", newPk);
		List<InventoryItem> results = q.list();
		System.out.println("*****");
		System.out.println(results.get(0).toString());
		InventoryItem item = (InventoryItem) results.get(0);		
		s.delete(item);
		tx.commit();
		s.close();
		
	}
	
	public void createInventory(InventoryWrapper WrappedNewItem) {
		Session s = HibernateUtil.getSession();
		//creating an instance of inventory item from my wrapper class
		InventoryItem newItem = new InventoryItem(WrappedNewItem.eqpInit,WrappedNewItem.eqpNumb,WrappedNewItem.stn333,WrappedNewItem.stnSt,WrappedNewItem.dest333,WrappedNewItem.destSt,
				WrappedNewItem.etnTs,WrappedNewItem.eqpLgth,WrappedNewItem.eqpWdth,WrappedNewItem.eqpWeight,WrappedNewItem.ecsId,WrappedNewItem.ecsPrcsd, WrappedNewItem.statCd);
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(newItem);
		tx.commit();
		s.close();
	}
	
	public void testing(InventoryItem thing) {
		Session s = HibernateUtil.getSession();
		
		System.out.print(thing.toString()+"_____________________________________________________________________________");
		Transaction tx = s.beginTransaction();
		s.save(thing);
		tx.commit();
		s.close();
	}

}
