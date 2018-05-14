package com.bnsf.inventory.dao;
import java.util.List;
import com.bnsf.inventory.beans.InventoryItem;

public interface InventoryDao {
	
	public List<InventoryItem> getAllInventory();	
	public void updateInventory(InventoryItem WrappedNewItem);	
	public void deleteInventory(String pk);	
	public void createInventory(InventoryItem WrappedNewItem);

}
