package com.bnsf.inventory.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bnsf.inventory.beans.InventoryItem;
import com.bnsf.inventory.util.HibernateUtil;
import com.bnsf.inventory.wrapper.InventoryWrapper;

public interface InventoryDao {
	
	public List<InventoryItem> getAllInventory();	
	public void updateInventory(InventoryWrapper WrappedNewItem);	
	public void deleteInventory(String pk);	
	public void createInventory(InventoryWrapper WrappedNewItem);

}
